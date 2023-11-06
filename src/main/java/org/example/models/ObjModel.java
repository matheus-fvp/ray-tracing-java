package org.example.models;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjModel {

    private List<Vertex> vertices = new ArrayList<>();
    private List<Face> faces = new ArrayList<>();

    public List<Vertex> getVertices() {
        return vertices;
    }

    public List<Face> getFaces() {
        return faces;
    }

    public void loadModel(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("v ")) {
                    String[] parts = line.split(" ");
                    float x = Float.parseFloat(parts[1]);
                    float y = Float.parseFloat(parts[2]);
                    float z = Float.parseFloat(parts[3]);
                    vertices.add(new Vertex(x, y, z));
                } else if (line.startsWith("f ")) {
                    String[] parts = line.split(" ");
                    int v1 = Integer.parseInt(parts[1]);
                    int v2 = Integer.parseInt(parts[2]);
                    int v3 = Integer.parseInt(parts[3]);
                    faces.add(new Face(v1, v2, v3));
                }
            }
        } catch (IOException e) {
            System.out.println("Error to load the model: " + e.getMessage());
        }
    }

    public void saveModel(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Vertex vertex : vertices) {
                writer.write(String.format("v %.8f %.8f %.8f\n", vertex.getX(), vertex.getY(), vertex.getZ()));
            }

            for (Face face : faces) {
                writer.write(String.format("f %d %d %d\n", face.getV1(), face.getV2(), face.getV3()));
            }
        } catch (IOException e) {
            System.out.println("Error to save Model: " + e.getMessage());
        }
    }

}
