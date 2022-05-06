import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ReadImage {
    public ReadImage(File file){
        try{
            BufferedImage bufferedImage = ImageIO.read(file);

        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public String getExtention(File file){
        try{
            String fName=file.getName();
            int lastIndex=fName.lastIndexOf(".");
            if (lastIndex > 0 && lastIndex < (fName.length() - 1)) {
                return fName.substring(lastIndex + 1).toLowerCase();
            }
            else{
                return "";
            }
        } catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }
}
