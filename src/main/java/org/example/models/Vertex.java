package org.example.models;

import org.example.geometry.Vec3;


public class Vertex {

    private Vec3 point;

    public Vertex() {
    }

    public Vertex(Vec3 point) {
        this.point = point;
    }

    public Vec3 getPoint() {
        return point;
    }

    @Override
    public String toString() {
        return String.format("<%s>", point);
    }
}
