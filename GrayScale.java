import java.io.*;
import edu.duke.*;


public class GrayScale {
    
    private final int minVal = 0;
    private final int midVal = 128;
    private final int maxVal = 255;
    
    private ImageResource grayScale (ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(),inImage.getHeight());
        for (Pixel pixel : outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(),pixel.getY());
            int avg = (inPixel.getRed() + inPixel.getGreen() + inPixel.getBlue()) / 3;
            if (inPixel.getRed() == maxVal )    continue;
            pixel.setRed(avg);
            pixel.setGreen(avg);
            pixel.setBlue(avg);
        }
        return outImage;
    }
    
    public void selectAndGrayScale (){
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            ImageResource inImage = new ImageResource(f);
            ImageResource image = grayScale(inImage);
            String fname = inImage.getFileName();
            String newName = "gray-" + fname;
            image.setFileName(newName);
            image.draw();
            image.save();
        }
    }
    
    private ImageResource negative (ImageResource inImage){
        ImageResource outImage = new ImageResource(inImage.getWidth(),inImage.getHeight());
        for (Pixel pixel : outImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(),pixel.getY());
            int avg = (inPixel.getRed() + inPixel.getGreen() + inPixel.getBlue()) / 3;
            pixel.setRed(maxVal - inPixel.getRed());
            pixel.setGreen(maxVal - inPixel.getGreen());
            pixel.setBlue(maxVal - inPixel.getBlue());
        }
        return outImage;
    }
    
    public void selectAndNegative (){
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            ImageResource inImage = new ImageResource(f);
            ImageResource image = negative(inImage);
            String fname = inImage.getFileName();
            String newName = "negative-" + fname;
            image.setFileName(newName);
            image.draw();
            image.save();
        }
    }
}
