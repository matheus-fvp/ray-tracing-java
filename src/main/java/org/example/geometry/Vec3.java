package org.example.geometry;

import java.util.Objects;

/**
 * Class representing a mathematical vector in 3 dimensions.
 * */
public class Vec3 {

    double x, y, z;

    /**
     * Constructs a Vec3 with specified x, y, and z coordinates.
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     * @param z The z-coordinate.
     */
    public Vec3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Constructs a Vec3 with default coordinates (0, 0, 0).
     * */
    public Vec3() {
        this(0, 0, 0);
    }

    /**
     * Gets the x-coordinate of the vector.
     * @return The x-coordinate.
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the y-coordinate of the vector.
     * @return The y-coordinate.
     */
    public double getY() {
        return y;
    }

    /**
     * Gets the z-coordinate of the vector.
     * @return The z-coordinate.
     */
    public double getZ() {
        return z;
    }

    /**
     * Gets the opposite vector.
     * @return The opposite vector.
     */
    public Vec3 opposite() {
        return new Vec3(-x, -y, -z);
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
        return new Vec3(x / length, y / length, z / length);
    }

    /**
     * Returns a string representation of the vector.
     * @return A string representation of the vector.
     */
    @Override
    public String toString() {
        return String.format("(%3.2f, %3.2f, %3.2f)", this.x, this.y, this.z);
    }

    /**
     * Checks if this vector is equal to another object.
     * @param o The object to compare.
     * @return True if the vectors are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vec3 vec3 = (Vec3) o;
        return Double.compare(x, vec3.x) == 0 && Double.compare(y, vec3.y) == 0 && Double.compare(z, vec3.z) == 0;
    }

    /**
     * Computes the hash code of the vector.
     * @return The hash code of the vector.
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
