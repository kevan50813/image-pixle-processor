package image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ReadImage {

    private int width;
    private int height;
    public BufferedImage image = null;

    public Color[] colours;
    public int totalPixles;

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

    public Color[] getColours() {
        return colours;
    }

    public void setColours(Color[] colours) {
        this.colours = colours;
    }

    public int getTotalPixles() {
        return totalPixles;
    }

    public void setTotalPixles(int totalPixles) {
        this.totalPixles = totalPixles;
    }


    public ReadImage(File file){
        try{
            image = ImageIO.read(file);
            this.width = image.getWidth();
            this.height = image.getHeight();
            this.totalPixles = width * height;
            getRGBPixles(image);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getRGBPixles(BufferedImage image){
        colours = new Color[totalPixles];
        int pixel= 0;

        for(int x =0; x<width;  x++){
            for (int y =0;y<height;y++){
                colours[pixel] = new Color(image.getRGB(x,y));
                pixel++;
            }
        }
    }
}
