package org.example.geometry;

/**
 * Class representing a ray in 3D space.
 * */
public class Ray {

    private final Vec3 origin;
    private final Vec3 direction;


    public Ray(Vec3 origin, Vec3 direction) {
        this.origin = origin;
        this.direction = direction;
    }

    public Vec3 getOrigin() {
        return origin;
    }

    public Vec3 getDirection() {
        return direction;
    }

    /**
     * Calculates the point along the ray at a given parameter t.
     * @param t The parameter value.
     * @return The point along the ray at parameter t.
     */
    public Vec3 at(double t) {
        return origin.sum(direction.multiplicationByScalar(t));
    }

    @Override
    public String toString() {
        return String.format("%s + %s * t", this.origin, this.direction);
    }

}
