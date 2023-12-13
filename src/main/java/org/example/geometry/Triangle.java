package org.example.geometry;

import org.example.models.Vertex;

/**
 * Class representing a triangle in 3D space.
 * */
public class Triangle {
    private static final double EPSILON = 0.0000001;

    private Vertex v0;
    private Vertex v1;
    private Vertex v2;

    public Triangle(Vertex v0, Vertex v1, Vertex v2) {
        this.v0 = v0;
        this.v1 = v1;
        this.v2 = v2;
    }

    /**
     * Checks if a given ray intersects with the triangle.
     * @param ray The ray to check for intersection.
     * @return True if the ray intersects with the triangle, false otherwise.
     */
    public boolean intersect(Ray ray) {
        Vec3 edge1 = v1.getPoint().subtraction(v0.getPoint());
        Vec3 edge2 = v2.getPoint().subtraction(v0.getPoint());
        Vec3 h = ray.getDirection().cross(edge2);
        double a = edge1.dot(h);

        if (a > -EPSILON && a < EPSILON) {
            return false;    // This ray is parallel to this triangle.
        }

        double f = 1.0 / a;
        Vec3 s = ray.getOrigin().subtraction(v0.getPoint());
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

    @Override
    public String toString() {
        return String.format("<%s, %s, %s>", v0, v1, v2);
    }
}