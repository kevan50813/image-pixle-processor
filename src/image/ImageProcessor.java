package image;

import java.awt.*;
import java.io.File;
import java.util.*;

public class ImageProcessor {
    public ReadImage ri;
    private final LinkedList<int[]> pixleList;
    private final LinkedList<int[]> redPixles;
    private final LinkedList<int[]> greenPixles;
    private final LinkedList<int[]> bluePixles;

    public ImageProcessor(File f){
        pixleList = new LinkedList<>();
        redPixles = new LinkedList<>();
        greenPixles = new LinkedList<>();
        bluePixles = new LinkedList<>();
        ri = new ReadImage(f);
    }

    public void getMetaData(){
        int totalPixles = ri.getTotalPixles();
        Color[] colours = ri.getColours();
        int[] RGB = new int[3];
        for (int i = 0; i < totalPixles ; i++) {
            Color c = colours[i];
            int red = c.getRed();
            int green = c.getGreen();
            int blue = c.getBlue();
            RGB[0] = red;
            RGB[1] = green;
            RGB[2] = blue;
            pixleList.add(RGB);
            if(red >= green && red >= blue){
                redPixles.add(RGB);
            }
            if(green > red && green > blue){
                greenPixles.add(RGB);
            }
            if(blue > red && blue > green){
                bluePixles.add(RGB);
            }
        }

        System.out.println("Average Red pixles: " + getAverge(pixleList.size(),redPixles.size()));
        System.out.println("Average Green pixles: " + getAverge(pixleList.size(),greenPixles.size()));
        System.out.println("Average Blue pixles: " +  getAverge(pixleList.size(),bluePixles.size()));

    }

    public double getAverge(int totalPixles , int RGBtoal){
        if(RGBtoal == 0){
            return 0.0;
        }
        double pixleAverage = (totalPixles / RGBtoal );
        return pixleAverage;
    }

}
