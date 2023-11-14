package org.example.geometry;

public class Ray {

    private Vec3 origin;
    private Vec3 direction;

    public Ray() {
    }

    public Ray(Vec3 origin, Vec3 direction) {
        this.origin = origin;
        this.direction = direction.unitVector();
    }

    public Vec3 getOrigin() {
        return origin;
    }

    public Vec3 getDirection() {
        return direction;
    }

    public Vec3 at(double t) {
        return origin.sum(direction.multiplicationByScalar(t));
    }

}
