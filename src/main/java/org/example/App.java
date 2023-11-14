package org.example;

import org.example.geometry.Ray;
import org.example.geometry.Triangle;
import org.example.geometry.Vec3;
import org.example.utils.ImageManager;

import java.awt.*;
import java.awt.image.BufferedImage;


public class App 
{
    public static void main( String[] args )
    {
        double aspectRatio = 16.0 / 9.0;
        int imWidth = 600;

        //calculate the image height, and ensure that it's at least 1
        int imHeight = (int) (imWidth / aspectRatio);
        imHeight = (imHeight < 1) ? 1 : imHeight;

        BufferedImage imagem = new BufferedImage(imWidth, imHeight, BufferedImage.TYPE_INT_RGB);

        //Camera
        double focalLenght = 1.0;
        double viewportHeight = 2;
        double viewportWidth = viewportHeight * ((imWidth * 1.0) / imHeight);
        Vec3 cameraCenter = new Vec3(0, 0, 0);

        // Calculate the vectors across the horizontal and down the vertical viewport edges.
        Vec3 viewportU = new Vec3(viewportWidth, 0, 0);
        Vec3 viewportV = new Vec3(0, -viewportHeight, 0);

        // Calculate the horizontal and vertical delta vectors from pixel to pixel
        Vec3 pixelDeltaU = viewportU.divisionByScalar(imWidth);
        Vec3 pixelDeltaV = viewportV.divisionByScalar(imHeight);

        // Calculate the location of the upper left pixel.

        Vec3 viewportUpperLeft = cameraCenter.subtraction(new Vec3(0, 0, focalLenght));
        viewportUpperLeft = viewportUpperLeft.subtraction(viewportU.divisionByScalar(2));
        viewportUpperLeft = viewportUpperLeft.subtraction(viewportV.divisionByScalar(2));

        Vec3 pixel00_loc = viewportUpperLeft.sum(pixelDeltaU.sum(pixelDeltaV).multiplicationByScalar(0.5));

        Triangle t = new Triangle(new Vec3(0.5, 0, -1), new Vec3(0.5, -0.5, -1), new Vec3(0, 0.5, -1));
        for(int j = 0; j < imHeight; ++j) {
            for(int i = 0; i < imWidth; ++i) {
                Vec3 pixelCenter = pixel00_loc.sum(pixelDeltaU.multiplicationByScalar(i));
                pixelCenter = pixelCenter.sum(pixelDeltaV.multiplicationByScalar(j));

                Vec3 rayDirection = pixelCenter.subtraction(cameraCenter);
                Ray ray = new Ray(pixelCenter, rayDirection);

                Color rayColor = rayColor(ray, t);
                imagem.setRGB(i, j, rayColor.getRGB());
            }
        }
        System.out.println(imHeight);

        ImageManager.saveImage(imagem, "ray.png");
    }

    private static Color rayColor(Ray ray) {
        if(hit_sphere(new Vec3(0, 0, -1), 0.5, ray)) {
            return new Color(1.0f, 0, 0);
        }
        Vec3 unitDirection = ray.getDirection();
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
            System.out.println("hello");
            return new Color(1.0f, 0, 0);
        }

        Vec3 unitDirection = ray.getDirection();
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
