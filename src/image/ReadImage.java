package image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

public class ReadImage {

    private int width;
    private int height;
    public BufferedImage image = null;

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ReadImage(File file){
        try{
            image = ImageIO.read(file);
            this.width = image.getWidth();
            this.height = image.getHeight();
            getRGBPixles(image);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public HashMap<Integer, int[]> getRGBPixles(BufferedImage image){
        int[] rgb = new int[4];
        HashMap<Integer, int[]> pixels = new HashMap<Integer, int[]>();
        for(int x =0;x< height;x++){
            for (int y=0; y < width; y++){

                int pixel = image.getRGB(y,x);
                Color  colour = new Color(pixel,true);

                int red = colour.getRed();
                int green = colour.getGreen();
                int blue = colour.getBlue();
                int alpha = colour.getAlpha();


                rgb[0] = red;
                rgb[1] = green;
                rgb[2] = blue;
                rgb[3] = alpha;
                pixels.put(pixel, rgb);
               /*
                for (Integer i : pixels.keySet()) {
                    System.out.println("key: " + i + " value: " + pixels.get(i)[0] + " " + pixels.get(i)[1] + " " + pixels.get(i)[2] + " " + pixels.get(i)[3]);
                }
                */
            }
        }
        return pixels;
    }
}
