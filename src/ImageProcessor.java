import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageProcessor {

    private static final String JPG="jpg";
    private static final String JPEG="jpeg";
    private static final String PNG="png";
    private static final String GIF="gif";
    private static final String NOT_AN_IMAGE="The type of file you have passed is not a common image type";

    public ImageProcessor(File file){
        ReadImage r = new ReadImage(file);
    }
}
