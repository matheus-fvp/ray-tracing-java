package org.example.models;

import java.util.Objects;

public class Face {

    private int v1;
    private int v2;
    private int v3;

    public Face() {
    }

    public Face(int v1, int v2, int v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public int getV1() {
        return v1;
    }

    public int getV2() {
        return v2;
    }

    public int getV3() {
        return v3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Face face = (Face) o;
        return v1 == face.v1 && v2 == face.v2 && v3 == face.v3;
    }

    @Override
    public int hashCode() {
        return Objects.hash(v1, v2, v3);
    }

}
