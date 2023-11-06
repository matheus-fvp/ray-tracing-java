package org.example;

import org.example.geometry.Ray;
import org.example.geometry.Vec3;
import org.example.utils.ImageManager;

import java.awt.*;
import java.awt.image.BufferedImage;


public class App 
{
    public static void main( String[] args )
    {
        double aspectRatio = 16.0 / 9.0;
        int imWidth = 400;

        //calculate the image height, and ensure that it's at least 1
        int imHeight = (int) (imWidth / aspectRatio);
        imHeight = (imHeight < 1) ? 1 : imHeight;

        BufferedImage imagem = new BufferedImage(imWidth, imHeight, BufferedImage.TYPE_INT_RGB);

        //Camera
        double focalLenght = 1.0;
        double viewportHeight = 2.0;
        double viewportWidth = viewportHeight * (imWidth * 1.0 /imHeight);
        Vec3 cameraCenter = new Vec3(0, 0, 0);

        // Calculate the vectors across the horizontal and down the vertical viewport edges.
        Vec3 viewportU = new Vec3(viewportWidth, 0, 0);
        Vec3 viewportV = new Vec3(0, -viewportHeight, 0);

        // Calculate the horizontal and vertical delta vectors from pixel to pixel
        Vec3 pixelDeltaU = Vec3.divisionByScalar(imWidth, viewportU);
        Vec3 pixelDeltaV = Vec3.divisionByScalar(imHeight, viewportV);

        // Calculate the location of the upper left pixel.
        Vec3 viewportUpperLeft = Vec3.subtraction(cameraCenter, new Vec3(0, 0, focalLenght));
        viewportUpperLeft = Vec3.subtraction(viewportUpperLeft, Vec3.divisionByScalar(2, viewportU));
        viewportUpperLeft = Vec3.subtraction(viewportUpperLeft, Vec3.divisionByScalar(2, viewportV));

        Vec3 pixel00_loc = Vec3.sum(viewportUpperLeft,
                Vec3.multiplicationByScalar(0.5, Vec3.sum(pixelDeltaU, pixelDeltaV)));

        for(int j = 0; j < imHeight; ++j) {
            for(int i = 0; i < imWidth; ++i) {
                Vec3 pixelCenter = Vec3.sum(pixel00_loc, Vec3.multiplicationByScalar(i, pixelDeltaU));
                pixelCenter = Vec3.sum(pixelCenter, Vec3.multiplicationByScalar(j, pixelDeltaV));
                Vec3 rayDirection = Vec3.subtraction(pixelCenter, cameraCenter);
                Ray ray = new Ray(pixelCenter, rayDirection);

                Color rayColor = rayColor(ray);
                imagem.setRGB(i, j, rayColor(ray).getRGB());
            }
        }
        System.out.println(imHeight);

        ImageManager.saveImage(imagem, "ray.png");
    }

    private static Color rayColor(Ray ray) {
        if(hit_sphere(new Vec3(0, 0, -1), 0.5, ray)) {
            return new Color(1.0f, 0, 0);
        }
        Vec3 unitDirection = Vec3.unitVector(ray.getDirection());
        float a = (float) (0.5 * (unitDirection.getY() + 1.0));
        Color color1 = new Color(1.0f, 1.0f, 1.0f);
        Color color2 = new Color(0.5f, 0.7f, 1.0f);

        float r = (1-a) * color1.getRed() + a * color2.getRed();
        float g = (1-a) * color1.getGreen() + a * color2.getGreen();
        float b = (1-a) * color1.getBlue() + a * color2.getBlue();

        return new Color((int)r, (int)g, (int)b);
    }

    private static boolean hit_sphere(Vec3 center, double radius, Ray ray) {
        Vec3 oc = Vec3.subtraction(ray.getOrigin(), center);
        double a = Vec3.dot(ray.getDirection(), ray.getDirection());
        double b = 2.0 * Vec3.dot(oc, ray.getDirection());
        double c = Vec3.dot(oc, oc) - radius * radius;
        double discriminant = b*b - 4*a*c;
        return (discriminant >= 0);
    }
}
