/**
 * Amazing Trivial Maze 
 * TCSS 360 Spring 2021
 */

package view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Class contains a method 
 * that loads in a buffered image.
 * @author Chau Vu
 * @version Spring 2021
 * Updated: May 15, 2021
 */
// reference: https://www.youtube.com/watch?v=jedilHUPO7c&t=1s
public class BufferedImageLoader {
    
    /**
     * instantiated myImage.
     * this is where the image will be loaded to.
     */
    //private BufferedImage myImage;
    
    /**
     * @param thePath - path of spritesheet
     * @return
     */
    public static BufferedImage loadImage(final String thePath) {
        BufferedImage resultImage = null;
        try {
            resultImage = ImageIO.read(new File(thePath));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return resultImage;
    }  
}
