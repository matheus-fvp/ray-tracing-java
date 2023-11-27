# Ray Tracing in Java

Project developed for the computer graphics discipline, which aims to implement the Ray Tracing algorithm
# Geometry Library

This is a simple Java library for basic geometric operations in three-dimensional space. The library includes three main classes:

1. **Vec3:** Represents a three-dimensional vector and provides various operations such as addition, subtraction, scalar multiplication, vector length calculation, dot product, cross product, and more.

2. **Ray:** Represents a ray in three-dimensional space defined by an origin and a direction. It includes a method for calculating a point along the ray at a given parameter value.

3. **Triangle:** Represents a triangle in three-dimensional space. It includes a method to check if a given ray intersects with the triangle.

## Classes

### Vec3

#### Constructors
- `Vec3(double x, double y, double z)`: Constructs a Vec3 with specified x, y, and z coordinates.
- `Vec3()`: Constructs a Vec3 with default coordinates (0, 0, 0).

#### Methods
- `opposite()`: Returns the opposite vector.
- `sum(Vec3 v)`: Performs vector addition.
- `subtraction(Vec3 v)`: Performs vector subtraction.
- `multiplicationByScalar(double scalar)`: Performs scalar multiplication.
- `length()`: Calculates the length of the vector.
- `multiplication(Vec3 v)`: Performs element-wise multiplication of two vectors.
- `divisionByScalar(double scalar)`: Performs scalar division.
- `dot(Vec3 v)`: Calculates the dot product of two vectors.
- `cross(Vec3 v)`: Calculates the cross product of two vectors.
- `unitVector()`: Returns the unit vector in the same direction.
- `toString()`: Returns a string representation of the vector.
- `equals(Object o)`: Checks if this vector is equal to another object.
- `hashCode()`: Computes the hash code of the vector.

### Ray

#### Constructors
- `Ray(Vec3 origin, Vec3 direction)`: Constructs a Ray with a given origin and direction.

#### Methods
- `getOrigin()`: Gets the origin of the ray.
- `getDirection()`: Gets the direction of the ray.
- `at(double t)`: Calculates the point along the ray at a given parameter t.
- `toString()`: Returns a string representation of the ray.

### Triangle

#### Constructors
- `Triangle(Vec3 v0, Vec3 v1, Vec3 v2)`: Constructs a Triangle with three vertices.

#### Methods
- `intersect(Ray ray)`: Checks if a given ray intersects with the triangle.

## Usage

To use the library, simply import the classes into your Java project and create instances of the Vec3, Ray, or Triangle classes. You can then perform various geometric operations using the provided methods.

```java
// Example Usage
Vec3 v1 = new Vec3(1, 2, 3);
Vec3 v2 = new Vec3(4, 5, 6);
Vec3 result = v1.sum(v2);
System.out.println(result); // Output: (5.00, 7.00, 9.00)

Ray ray = new Ray(new Vec3(0, 0, 0), new Vec3(1, 1, 1).unitVector());
Vec3 pointOnRay = ray.at(2.5);
System.out.println(pointOnRay); // Output: (2.50, 2.50, 2.50)

Triangle triangle = new Triangle(new Vec3(0, 0, 0), new Vec3(1, 0, 0), new Vec3(0, 1, 0));
Ray intersectingRay = new Ray(new Vec3(0.25, 0.25, 1), new Vec3(0, 0, -1).unitVector());
boolean isIntersecting = triangle.intersect(intersectingRay);
System.out.println(isIntersecting); // Output: true
