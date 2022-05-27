package image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

public class ImageProcessor {
    public ReadImage ri;

    public ImageProcessor(File f){
        ri = new ReadImage(f);
    }

    public void getMetaData(){
        HashMap<Integer, int[]>  pixels = ri.getRGBPixles(ri.getImage());
        int total = pixels.size();
        int redPixels = 0;
        int greenPixels = 0;
        int bluePixels = 0;
        for (Integer i : pixels.keySet()) {
            if(pixels.get(i)[0] >= pixels.get(i)[1] && pixels.get(i)[0] >= pixels.get(i)[2]){
                redPixels += 1;
            }
            if(pixels.get(i)[1] >= pixels.get(i)[0] && pixels.get(i)[1] >= pixels.get(i)[2]){
                greenPixels += 1;
            }
            if(pixels.get(i)[2] >= pixels.get(i)[1] && pixels.get(i)[2] >= pixels.get(i)[0]){
                bluePixels += 1;
            }

        }

        System.out.println("Total mostly red pixles :" + redPixels);
        System.out.println("Total mostly blue pixles :" + bluePixels);
        System.out.println("Total mostly green pixles :" + greenPixels);
    }
}
