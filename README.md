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

# ObjLoader Library

The `ObjLoader` library is designed to parse and process Wavefront OBJ files, commonly used to represent 3D models. It provides functionality to read an OBJ file, extract vertices, normals, and faces, and perform operations on the loaded 3D model.

## Classes

### ObjLoader
#### Methods
1. **`parseFile(File file): ObjModel`**
    - Reads an OBJ file and returns an `ObjModel` containing vertices, normals, and faces.
    - *Parameters:*
        - `file`: The file path where the OBJ file is located.
    - *Returns:* An `ObjModel` representing the 3D model.

2. **`parseVertex(String[] data): Vertex`**
    - Parses vertex data from a line in the OBJ file.
    - *Parameters:*
        - `data`: Array of strings representing vertex data.
    - *Returns:* A `Vertex` object.

3. **`parseFace(String[] data, List<Vertex> vertices): Triangle`**
    - Parses face data from a line in the OBJ file.
    - *Parameters:*
        - `data`: Array of strings representing face data.
        - `vertices`: List of vertices from the OBJ file.
    - *Returns:* A `Triangle` object representing a face.

4. **`parseTriangleVertex(String[] data, List<Vertex> vertices): Vertex`**
    - Parses a vertex of a triangle from face data in the OBJ file.
    - *Parameters:*
        - `data`: Array of strings representing face data.
        - `vertices`: List of vertices from the OBJ file.
    - *Returns:* A `Vertex` object.

### ObjModel

#### Fields
- **`vertices: List<Vertex>`**
    - List of vertices representing the 3D model.

- **`normals: List<Vertex>`**
    - List of normals representing the 3D model.

- **`faces: List<Triangle>`**
    - List of triangles representing the faces of the 3D model.

#### Methods
1. **`resizingObj(): void`**
    - Resizes the loaded 3D model to fit within a normalized bounding box.

2. **`calculateObjCenter(ObjModel obj): Vec3`**
    - Calculates the center of the 3D model.
    - *Parameters:*
        - `obj`: The `ObjModel` for which the center needs to be calculated.
    - *Returns:* A `Vec3` representing the center of the 3D model.

### Vertex

#### Fields
- **`point: Vec3`**
    - A 3D point representing the vertex coordinates.

---