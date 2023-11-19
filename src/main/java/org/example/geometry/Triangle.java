package org.example.geometry;

public class Triangle {
    private static final double EPSILON = 0.0000001;

    private Vec3 v0;
    private Vec3 v1;
    private Vec3 v2;

    public Triangle(Vec3 v0, Vec3 v1, Vec3 v2) {
        this.v0 = v0;
        this.v1 = v1;
        this.v2 = v2;
    }

    public boolean intersect(Ray ray) {
        Vec3 edge1 = v1.subtraction(v0);
        Vec3 edge2 = v2.subtraction(v0);
        Vec3 h = ray.getDirection().cross(edge2);
        double a = edge1.dot(h);

        if (a > -EPSILON && a < EPSILON) {
            return false;    // This ray is parallel to this triangle.
        }

        double f = 1.0 / a;
        Vec3 s = ray.getOrigin().subtraction(v0);
        double u = f * (s.dot(h));

        if (u < 0.0 || u > 1.0) {
            return false;
        }

        Vec3 q = s.cross(edge1);
        double v = f * ray.getDirection().dot(q);

        if (v < 0.0 || u + v > 1.0) {
            return false;
        }

        // At this stage we can compute t to find out where the intersection point is on the line.
        double t = f * edge2.dot(q);
        return t > EPSILON;
    }

}