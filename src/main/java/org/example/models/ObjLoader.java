package org.example.models;

import org.example.geometry.Triangle;
import org.example.geometry.Vec3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class ObjLoader {

    /***
     * Read a obj from a file
     * @param file The file path where is the obj
     * */
    public static ObjModel parseFile(File file) throws Exception {
        BufferedReader input = new BufferedReader(new FileReader(file));

        ObjModel objModel = new ObjModel();

        String line;
        while ((line = input.readLine()) != null) {
            String[] parts = line.split(" ");
            switch (parts[0]) {
                case "mtllib":
                    break;
                case "v":
                    objModel.getVertices().add(parseVertex(parts));
                    break;
                case "vn":
                    objModel.getNormals().add(parseVertex(parts));
                    break;
                case "f":
                    objModel.getFaces().add(parseFace(parts, objModel.getVertices()));
                    break;
            }
        }
        input.close();

        return objModel;
    }

    private static Vertex parseVertex(String[] data) {
        Vec3 point = new Vec3(Double.parseDouble(data[1]), Double.parseDouble(data[2]), Double.parseDouble(data[3]));
        return new Vertex(point);
    }

    private static Triangle parseFace(String[] data, List<Vertex> vertices) {
        return new Triangle(
                parseTriangleVertex(data[1].split("/"), vertices),
                parseTriangleVertex(data[2].split("/"), vertices),
                parseTriangleVertex(data[3].split("/"), vertices)
        );
    }

    private static Vertex parseTriangleVertex(String[] data, List<Vertex> vertices) {
        Vertex vertex = null;
        if (!data[0].isEmpty()) {
            int vertexIndex = Integer.parseInt(data[0]) - 1;
            vertex = vertices.get(vertexIndex);
        }
        return vertex;
    }

}
