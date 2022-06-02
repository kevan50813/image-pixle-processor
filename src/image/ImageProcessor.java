package image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class ImageProcessor {
    public ReadImage ri;
    private LinkedList<int[]> pixleList;

    public ImageProcessor(File f){
        pixleList = new LinkedList();
        ri = new ReadImage(f);
    }

    public void getMetaData(){
        int totalPixles = ri.getTotalPixles();
        Color[] colours = ri.getColours();
        int[] RGB = new int[2];
        for (int i = 0; i < totalPixles ; i++) {
            Color c = colours[i];
            int red = c.getRed();
            int green = c.getGreen();
            int blue = c.getBlue();
            System.out.println("RED: " + red + " GREEN: " + green + " BLUE " + blue);
            RGB[0] = red;
            RGB[1] = green;
            RGB[2] = blue;
            pixleList.add(RGB);
        }

        getAverge();
    }

    //add to a linkled list every time a new RGB vlaue is added, if not then increace a ounter by 1
    public void getAverge(){
        List<itager> distinctElements = pixleList.stream().distinct().collect(Collectors.toList());

    }
}
