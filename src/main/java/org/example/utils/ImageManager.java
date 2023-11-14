package org.example.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ImageManager {

    public static void saveGradient(int width, int height, String filePath) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();

        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                float r = (float) y / (width - 1);
                float g = (float) x / (height - 1);
                float b = 0.5f;
                Color color = new Color(r, g, b);
                image.setRGB(y, x, color.getRGB());
            }
        }

        saveImage(image, filePath+ ".png");
    }

    public static void saveCircle(int width, int height, String filePath) {

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(Color.BLUE);
        g2d.fillOval(50, 50, 300, 300);

        saveImage(image, filePath + ".png");
    }

    public static void saveSquare(int width, int height, String fileName) {

        BufferedImage imagem = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = imagem.createGraphics();
        g2d.setColor(Color.RED);
        g2d.fillRect(100, 100, 200, 200);

        saveImage(imagem, fileName + ".png");
    }

    public  static void saveImage(BufferedImage image, String fileName) {

        try {
            File file = new File(fileName);
            ImageIO.write(image, "PNG", file);
            System.out.println("Image saved success");
        }catch (IOException e) {
            System.err.println("Error to save the image: " + e.getMessage());
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("PathName: ");
        String pathFolder = scanner.nextLine();
        saveCircle(400, 400, pathFolder + "circle");
        saveGradient(400, 400, pathFolder  + "gradient");
        saveSquare(400, 400, pathFolder + "square");
        scanner.close();
    }

}
