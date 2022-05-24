package image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

public class ReadImage {
    public ReadImage(File file){
        try{
            BufferedImage image = ImageIO.read(file);
            HashMap<Integer,int[]> imagePixles = new HashMap<Integer,int[]>();
            readRGBPixles(image,imagePixles);
            for (int i : imagePixles.keySet()) {
                System.out.println("key: " + i + " value Red: " + imagePixles.get(i)[0]);
                System.out.println("key: " + i + " value Green: " + imagePixles.get(i)[1]);
                System.out.println("key: " + i + " value Blue: " + imagePixles.get(i)[2]);
                System.out.println("-----------------------------------------------------");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public HashMap<Integer, int[]> readRGBPixles(BufferedImage image, HashMap<Integer, int[]> imagePixles){
        int[] rgb = new int[3];
        for(int x =0;x<image.getWidth();x++){
            for (int y=0; y<image.getHeight();y++){
                int pixel = image.getRGB(x,y);
                Color  colour = new Color(pixel,true);
                int red = colour.getRed();
                int green = colour.getGreen();
                int blue = colour.getBlue();
                rgb[0] = red;
                rgb[1] = green;
                rgb[2] = blue;
                imagePixles.put(pixel,rgb);
            }
        }

        return imagePixles;
    }
}
