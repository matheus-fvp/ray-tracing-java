package org.example.geometry;

import java.util.Objects;

public class Vec3 {

    private double x;
    private double y;
    private double z;

    public Vec3() {
    }

    public Vec3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public Vec3 opposite() {
        return new Vec3(-this.getX(), -this.getY(), -this.getZ());
    }

    public Vec3 sum(Vec3 v) {
        return new Vec3(this.getX() + v.getX(), this.getY() + v.getY(), this.getZ() + v.getZ());
    }

    public Vec3 multiplicationByScalar(double scalar) {
        return new Vec3(scalar * this.getX(), scalar * this.getY(), scalar * this.getZ());
    }

    public double length() {
        return Math.sqrt(length_squared());
    }

    public double length_squared() {
        return x * x + y * y + y * y;
    }

    public Vec3 subtraction(Vec3 v) {
        return new Vec3(this.getX() - v.getX(), this.getY() - v.getY(), this.getZ() - v.getZ());
    }

    public Vec3 multiplication(Vec3 v) {
        return new Vec3(this.getX() * v.getX(), this.getY() * v.getY(), this.getZ() * v.getZ());
    }

    public Vec3 divisionByScalar(double scalar) {
        return new Vec3(this.getX() / scalar, this.getY() / scalar, this.getZ() / scalar);
    }

    public double dot(Vec3 v) {
        return this.getX() * v.getX()
                + this.getY() * v.getY()
                + this.getZ() * v.getZ();
    }

    public Vec3 cross(Vec3 other) {
        double resultX = this.getY() * other.getZ() - this.getZ() * other.getY();
        double resultY = this.getZ() * other.getX() - this.getX() * other.getZ();
        double resultZ = this.getX() * other.getY() - this.getY() * other.getX();

        return new Vec3(resultX, resultY, resultZ);
    }

    public Vec3 unitVector() {
        return new Vec3(this.getX()/this.length(), this.getY()/this.length(), this.getZ()/this.length());
    }

    @Override
    public String toString() {
        return "Vec3(" + this.x + " " + this.y + " " + this.z + ")";
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
