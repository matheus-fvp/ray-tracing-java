package org.example.models;

import java.util.Objects;

public class Vertex {

    private float x;
    private float y;
    private float z;

    public Vertex() {
    }

    public Vertex(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Float.compare(x, vertex.x) == 0 && Float.compare(y, vertex.y) == 0 && Float.compare(z, vertex.z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

}
