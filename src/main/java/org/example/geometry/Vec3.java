package org.example.geometry;

import java.util.Objects;

public class Vec3 {

    double x, y, z;

    public Vec3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vec3() {
        this(0, 0, 0);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Vec3 opposite() {
        return new Vec3(-x, -y, -z);
    }

    public Vec3 sum(Vec3 v) {
        return new Vec3(x + v.x, y + v.y, z + v.z);
    }

    public Vec3 subtraction(Vec3 v) {
        return new Vec3(x - v.x, y - v.y, z - v.z);
    }

    public Vec3 multiplicationByScalar(double scalar) {
        return new Vec3(x * scalar, y * scalar, z * scalar);
    }

    public double length() {
        return Math.sqrt(lengthSquared());
    }

    private double lengthSquared() {
        return x * x + y * y + z * z;
    }

    public Vec3 multiplication(Vec3 v) {
        return new Vec3(x * v.x, y * v.y, z * v.z);
    }

    public Vec3 divisionByScalar(double scalar) {
        return new Vec3(x / scalar, y / scalar, z / scalar);
    }

    public double dot(Vec3 v) {
        return x * v.x + y * v.y + z * v.z;
    }

    public Vec3 cross(Vec3 v) {
        double resultX = y * v.z - z * v.y;
        double resultY = z * v.x - x * v.z;
        double resultZ = x * v.y - y * v.x;

        return new Vec3(resultX, resultY, resultZ);
    }

    public Vec3 unitVector() {
        double length = length();
        return new Vec3(x / length, y / length, z / length);
    }

    @Override
    public String toString() {
        return String.format("(%3.2f, %3.2f, %3.2f)", this.x, this.y, this.z);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vec3 vec3 = (Vec3) o;
        return Double.compare(x, vec3.x) == 0 && Double.compare(y, vec3.y) == 0 && Double.compare(z, vec3.z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
