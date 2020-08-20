package cn.errison.feature.demo.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.EmptyStackException;

public class Demo1 {

    public static BufferedImage readImage(String path) {
        BufferedImage bi = null;
        try {
            File f = new File(path);
            bi = ImageIO.read(f);
            System.out.println("image height " + bi.getHeight());
            System.out.println("image width " + bi.getWidth());
            System.out.println("image type " + bi.getType());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bi;
    }

    public static void writeImage(BufferedImage image, String path){
        try {
            File f = new File(path);
            ImageIO.write(image, "png", f);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        String fromFile = "D:\\images\\test.jpg";
        String toFile = "D:\\images\\test.png";
        BufferedImage image = readImage(fromFile);
        writeImage(image,toFile);
        readImage(toFile);
    }
}
