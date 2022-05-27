import image.ImageProcessor;
import image.ReadImage;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File f = new File("/home/kevan/Documents/Projects/Java/image-pixle-processor/images/test1.png");
        ImageProcessor ip= new ImageProcessor(f);
        ip.getMetaData();
    }
}
