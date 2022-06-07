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

        getAverge(pixleList.size(), redPixles.size(), greenPixles.size(), bluePixles.size());
    }

    //add to a linkled list every time a new RGB vlaue is added, if not then increace a ounter by 1
    public void getAverge(int totalPixles , int redTotal, int greenTotal,  int blueTotal){

        float redAverage = (redTotal / totalPixles);
        float greenAverage = (greenTotal / totalPixles);
        float blueAverage = (blueTotal / totalPixles);


        String redStr = String.format("%2.02f", redAverage);
        String greenStr = String.format("%2.02f", greenAverage);
        String blueStr = String.format("%2.02f", blueAverage);

        System.out.println("Average Primarily Red Pixels = " + redStr);
        System.out.println("Average Primarily Green Pixels = " + greenStr);
        System.out.println("Average Primarily Blue Pixels = " + blueStr);

    }
}
