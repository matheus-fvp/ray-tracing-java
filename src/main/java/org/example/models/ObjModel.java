package org.example.models;

import org.example.geometry.Triangle;
import org.example.geometry.Vec3;

import java.util.ArrayList;
import java.util.List;

public class ObjModel {

    private List<Vertex> vertices = new ArrayList<>();
    private List<Vertex> normals = new ArrayList<>();
    private List<Triangle> faces = new ArrayList<>();

    public List<Vertex> getVertices() {
        return vertices;
    }

    public List<Vertex> getNormals() {
        return normals;
    }

    public List<Triangle> getFaces() {
        return faces;
    }

    public void resizingObj() {
        double minX = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE;

        double minY = Double.MAX_VALUE;
        double maxY = Double.MIN_VALUE;

        double minZ = Double.MAX_VALUE;
        double maxZ = Double.MIN_VALUE;

        for(Vertex v: vertices) {
            maxX = Math.max(maxX, v.getPoint().getX());
            minX = Math.min(minX, v.getPoint().getX());

            maxY = Math.max(maxY, v.getPoint().getX());
            minY = Math.min(minY, v.getPoint().getX());

            maxZ = Math.max(maxZ, v.getPoint().getX());
            minZ = Math.min(minZ, v.getPoint().getX());
        }

        double biggerDif = Math.max(Math.max(maxX - minX, maxY - minX), maxZ - minZ);
        for(Vertex v : vertices) {
            Vec3 point = v.getPoint();
            point.setX((point.getX() - minX) / biggerDif);
            point.setY((point.getY() - minX) / biggerDif);
            point.setZ((point.getZ() - minX) / biggerDif);
        }

    }

    public static Vec3 calculateObjCenter(ObjModel obj) {
        double sumX = 0d;
        double sumY = 0d;
        double sumZ = 0d;
        double size = obj.vertices.size();
        for(Vertex v : obj.vertices) {
            sumX += v.getPoint().getX();
            sumY += v.getPoint().getY();
            sumZ += v.getPoint().getZ();
        }

        return new Vec3(sumX / size, sumY / size, sumZ / size);
    }

}
