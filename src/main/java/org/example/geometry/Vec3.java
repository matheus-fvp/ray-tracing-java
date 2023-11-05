package org.example.geometry;

import java.util.Arrays;

public class Vec3 {

    private double[] e = new double[3];

    public Vec3() {
    }

    public Vec3(double x, double y, double z) {
        this.e[0] = x;
        this.e[1] = y;
        this.e[2] = z;
    }

    public double getX() {
        return this.e[0];
    }

    public double getY() {
        return this.e[1];
    }

    public double getZ() {
        return this.e[2];
    }

    public Vec3 opposite() {
        return new Vec3(-this.getX(), -this.getY(), -this.getZ());
    }

    public void sum(Vec3 v) {
        this.e[0] += v.getX();
        this.e[1] += v.getY();
        this.e[2] += v.getZ();
    }

    public void multiplicationByScalar(double scalar) {
        this.e[0] *= scalar;
        this.e[1] *= scalar;
        this.e[1] *= scalar;
    }

    public void divisionByScalar(double scalar) {
        this.e[0] /= scalar;
        this.e[1] /= scalar;
        this.e[1] /= scalar;
    }

    public double length() {
        return Math.sqrt(length_squared());
    }

    public double length_squared() {
        return e[0] * e[0] + e[1] * e[1] + e[2] * e[2];
    }

    public static Vec3 sum(Vec3 u, Vec3 v) {
        return new Vec3(u.getX() + v.getX(), u.getY() + v.getY(), u.getZ() + v.getZ());
    }

    public static Vec3 subtraction(Vec3 u, Vec3 v) {
        return new Vec3(u.getX() - v.getX(), u.getY() - v.getY(), u.getZ() - v.getZ());
    }

    public static Vec3 multiplication(Vec3 u, Vec3 v) {
        return new Vec3(u.getX() * v.getX(), u.getY() * v.getY(), u.getZ() * v.getZ());
    }

    public static Vec3 multiplicationByScalar(double scalar, Vec3 v) {
        return new Vec3(scalar*v.getX(), scalar*v.getY(), scalar*v.getZ());
    }

    public static Vec3 divisionByScalar(double scalar, Vec3 v) {
        return new Vec3(v.getX() / scalar, v.getY() / scalar, v.getZ() / scalar);
    }

    public static double dot(Vec3 u, Vec3 v) {
        return u.getX() * v.getX()
                + u.getY() * v.getY()
                + u.getZ() * v.getZ();
    }

    public static Vec3 cross(Vec3 u, Vec3 v) {
        return new Vec3(u.getY() * v.getZ() - u.getZ() * v.getY(),
                u.getZ() * v.getX() - u.getX() * v.getZ(),
                u.getX() * v.getY() - u.getY() * v.getX());
    }

    public static Vec3 unitVector(Vec3 v) {
        return new Vec3(v.getX()/v.length(), v.getY()/v.length(), v.getZ()/v.length());
    }

    @Override
    public String toString() {
        return "Vec3(" + this.e[0] + " " + this.e[1] + " " + this.e[2] + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vec3 vec3 = (Vec3) o;
        return Arrays.equals(e, vec3.e);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(e);
    }
}
