package org.example.geometry;

public class Triangle {
    private Vec3 v0;
    private Vec3 v1;
    private Vec3 v2;

    public Triangle(Vec3 v0, Vec3 v1, Vec3 v2) {
        this.v0 = v0;
        this.v1 = v1;
        this.v2 = v2;
    }

    public boolean intersect(Ray ray) {
        Vec3 e1 = v1.subtraction(v0);
        Vec3 e2 = v2.subtraction(v0);
        Vec3 h = ray.getDirection().cross(e2);
        double a = e1.dot(h);

        if (a > -1e-6 && a < 1e-6) {
            return false;
        }

        double f = 1.0 / a;
        Vec3 s = ray.getOrigin().subtraction(v0);
        double u = f * s.dot(h);

        if (u < 0.0 || u > 1.0) {
            return false;
        }

        Vec3 q = s.cross(e1);
        double v = f * ray.getDirection().dot(q);
        if (v < 0.0 || u + v > 1.0) {
            return false;
        }
        
        double t = f * e2.dot(q);
        

        return t > 1e-6;
    }

}
