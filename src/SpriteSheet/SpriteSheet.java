package SpriteSheet;

import java.awt.image.BufferedImage;

/**
 * Class contains a method that
 * grabs the specific image from 
 * a spritesheet.
 * @author Chau Vu
 * @version Spring 2021
 * Updated: May 15, 2021
 */
 // reference: https://www.youtube.com/watch?v=jedilHUPO7c&t=1s
public class SpriteSheet {
    
    private BufferedImage myImage;
    
    public SpriteSheet(BufferedImage theSpriteSheet) {
        this.myImage = theSpriteSheet;
    }
    
    /**
     * Grabbing and cropping our image from the sprite sheet
     * @param theColumn - column number
     * @param theRow - row number
     * @param theWidth - width
     * @param theHeight - height
     * @return BufferedImage
     */
    public BufferedImage grabImage(final int theColumn, final int theRow, final int theWidth, final int theHeight) {
        BufferedImage img = myImage.getSubimage((theColumn * 32) - 32, (theRow * 32) - 32, theWidth, theHeight); 
        return img;
    }
}
