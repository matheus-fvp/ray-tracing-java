package org.example;

import org.example.geometry.Ray;
import org.example.geometry.Triangle;
import org.example.geometry.Vec3;
import org.example.models.ObjLoader;
import org.example.models.ObjModel;
import org.example.models.Vertex;
import org.example.utils.ImageManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;


public class App 
{
    public static void main(String[] args) throws Exception
    {
        double aspectRatio = 16.0 / 9.0;
        int imWidth = 400;

        //calculate the image height, and ensure that it's at least 1
        int imHeight = (int)(imWidth / aspectRatio);
        imHeight = (imHeight < 1) ? 1 : imHeight;

        BufferedImage imagem = new BufferedImage(imWidth, imHeight, BufferedImage.TYPE_INT_RGB);

        //Camera
        double focalLenght = 1.0d;
        double viewportHeight = 2.0d;
        double viewportWidth = viewportHeight * (imWidth / (double)imHeight);
        Vec3 cameraCenter = new Vec3(0d, 0d, 0d);

        // Calculate the vectors across the horizontal and down the vertical viewport edges.
        Vec3 viewportU = new Vec3(viewportWidth, 0, 0);
        Vec3 viewportV = new Vec3(0, -viewportHeight, 0);

        // Calculate the horizontal and vertical delta vectors from pixel to pixel
        Vec3 pixelDeltaU = viewportU.divisionByScalar(imWidth);
        Vec3 pixelDeltaV = viewportV.divisionByScalar(imHeight);

        // Calculate the location of the upper left pixel.

        Vec3 viewportUpperLeft = cameraCenter.subtraction(new Vec3(0d, 0d, focalLenght));
        viewportUpperLeft = viewportUpperLeft.subtraction(viewportU.divisionByScalar(2.0d));
        viewportUpperLeft = viewportUpperLeft.subtraction(viewportV.divisionByScalar(2.0d));

        Vec3 pixel00_loc = viewportUpperLeft.sum(pixelDeltaU.sum(pixelDeltaV).multiplicationByScalar(0.5d));

        ObjModel objModel = ObjLoader.parseFile(new File("assets/seahorse.obj"));
        objModel.resizingObj(); //resize the obj

        Vec3 objCenter = ObjModel.calculateObjCenter(objModel); //calculate the center of mass
        Vec3 translationDirection = cameraCenter.subtraction(objCenter).unitVector();
        double translationDistance = 5.0;

        for (Vertex vertex : objModel.getVertices()) {
            Vec3 translatedPosition = vertex.getPoint().sum(translationDirection.multiplicationByScalar(translationDistance));
            vertex.setPoint(translatedPosition);
        }

        List<Triangle> triangles = objModel.getFaces();
        for(int j = 0; j < imHeight; ++j) {
            for(int i = 0; i < imWidth; ++i) {
                Vec3 pixelCenter = pixel00_loc.sum(pixelDeltaU.multiplicationByScalar(i));
                pixelCenter = pixelCenter.sum(pixelDeltaV.multiplicationByScalar(j));

                Vec3 rayDirection = pixelCenter.subtraction(cameraCenter).unitVector();
                Ray ray = new Ray(pixelCenter, rayDirection);

                for (Triangle triangle : triangles) {
                    boolean isIntersect = triangle.intersect(ray);
                    Color rayColor = rayColor(ray, triangle);
                    imagem.setRGB(i, j, rayColor.getRGB());
                    if (isIntersect) break;
                }
            }
        }

        ImageManager.saveImage(imagem, "assets/seahorse.png");
    }

    private static Color rayColor(Ray ray) {
        if(hit_sphere(new Vec3(0, 0, -1), 0.5, ray)) {
            return new Color(1.0f, 0, 0);
        }
        Vec3 unitDirection = ray.getDirection().unitVector();
        float a = (float) (0.5 * (unitDirection.getY() + 1.0));
        Color color1 = new Color(1.0f, 1.0f, 1.0f);
        Color color2 = new Color(0.5f, 0.7f, 1.0f);

        float r = (1-a) * color1.getRed() + a * color2.getRed();
        float g = (1-a) * color1.getGreen() + a * color2.getGreen();
        float b = (1-a) * color1.getBlue() + a * color2.getBlue();

        return new Color((int)r, (int)g, (int)b);
    }

    private static Color rayColor(Ray ray, Triangle t) {
        if(t.intersect(ray)) {
            return new Color(1.0f, 0, 0);
        }

        Vec3 unitDirection = ray.getDirection().unitVector();
        float a = (float) (0.5 * (unitDirection.getY() + 1.0));
        Color color1 = new Color(1.0f, 1.0f, 1.0f);
        Color color2 = new Color(0.5f, 0.7f, 1.0f);

        float r = (1-a) * color1.getRed() + a * color2.getRed();
        float g = (1-a) * color1.getGreen() + a * color2.getGreen();
        float b = (1-a) * color1.getBlue() + a * color2.getBlue();

        return new Color((int)r, (int)g, (int)b);
    }

    private static boolean hit_sphere(Vec3 center, double radius, Ray ray) {
        Vec3 oc = ray.getOrigin().subtraction(center);
        double a = ray.getDirection().dot(ray.getDirection());
        double b = 2.0 * oc.dot(ray.getDirection());
        double c = oc.dot(oc) - radius * radius;
        double discriminant = b*b - 4*a*c;
        return (discriminant >= 0);
    }

}