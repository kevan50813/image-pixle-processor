package image;

import java.awt.*;
import java.io.File;
import java.util.*;

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
        }

        getAverge();
    }

    //add to a linkled list every time a new RGB vlaue is added, if not then increace a ounter by 1
    public void getAverge(){
        HashMap<int[], Integer> keyCountMap = new HashMap<>();
        for(int i = 0; i < pixleList.size(); i++)
        {
            if(!keyCountMap.containsKey(pixleList.get(i))){
                keyCountMap.put(pixleList.get(i), 1); // unique value or first occurrence
            }
            else{
                keyCountMap.put(pixleList.get(i), keyCountMap.get(pixleList.get(i)) + 1);
            }
        }
        System.out.println(keyCountMap);


    }
}
