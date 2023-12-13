package org.example.geometry;

import java.util.Objects;

/**
 * Class representing a mathematical vector in 3 dimensions.
 * */
public class Vec3 {

    private double x, y, z;

    public Vec3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vec3() {
        this(0.0, 0.0, 0.0);
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

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    /**
     * Gets the opposite vector.
     * @return The opposite vector.
     */
    public Vec3 opposite() {
        return this.multiplicationByScalar(-1.0);
    }

    /**
     * Performs vector addition.
     * @param v The vector to add.
     * @return The result of the addition.
     */
    public Vec3 sum(Vec3 v) {
        return new Vec3(x + v.x, y + v.y, z + v.z);
    }

    /**
     * Performs vector subtraction.
     * @param v The vector to subtract.
     * @return The result of the subtraction.
     */
    public Vec3 subtraction(Vec3 v) {
        return new Vec3(x - v.x, y - v.y, z - v.z);
    }

    /**
     * Performs scalar multiplication.
     * @param scalar The scalar value to multiply.
     * @return The result of the multiplication.
     */
    public Vec3 multiplicationByScalar(double scalar) {
        return new Vec3(x * scalar, y * scalar, z * scalar);
    }

    /**
     * Calculates the length of the vector.
     * @return The length of the vector.
     */
    public double length() {
        return Math.sqrt(lengthSquared());
    }

    private double lengthSquared() {
        return x * x + y * y + z * z;
    }

    /**
     * Performs element-wise multiplication of two vectors.
     * @param v The vector to multiply with.
     * @return The result of the multiplication.
     */
    public Vec3 multiplication(Vec3 v) {
        return new Vec3(x * v.x, y * v.y, z * v.z);
    }

    /**
     * Performs scalar division.
     * @param scalar The scalar value to divide by.
     * @return The result of the division.
     */
    public Vec3 divisionByScalar(double scalar) {
        return new Vec3(x / scalar, y / scalar, z / scalar);
    }

    /**
     * Calculates the dot product of two vectors.
     * @param v The vector to dot with.
     * @return The dot product of the two vectors.
     */
    public double dot(Vec3 v) {
        return x * v.x + y * v.y + z * v.z;
    }

    /**
     * Calculates the cross product of two vectors.
     * @param v The vector to cross with.
     * @return The cross product of the two vectors.
     */
    public Vec3 cross(Vec3 v) {
        double resultX = y * v.z - z * v.y;
        double resultY = z * v.x - x * v.z;
        double resultZ = x * v.y - y * v.x;

        return new Vec3(resultX, resultY, resultZ);
    }

    /**
     * Returns the unit vector in the same direction as this vector.
     * @return The unit vector.
     */
    public Vec3 unitVector() {
        double length = length();
        return multiplicationByScalar(1.0 / length);
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
