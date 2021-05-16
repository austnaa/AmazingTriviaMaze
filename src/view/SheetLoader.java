/**
 * Amazing Trivial Maze 
 * TCSS 360 Spring 2021
 */

package view;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;

/**
 * Provides functionality for loading and getting images
 * from sprite and tile sheets.
 * 
 * 
 * @author Austn Attaway
 * @version Spring 2021
 * Updated: May 15, 202
 */
public class SheetLoader {
    
    /** The number of images for an animation in a particular direction.
     * NOTE: CHANGES TO THIS AFFECT PLAYER ANIMATION
     */
    public static int NUM_COLS = 4;
    
    /** The number of rows of images. */
    public static int NUM_ROWS = 5;
    
    /** The width and height of the images in the sprite sheet in pixels. */
    public static final int IMAGE_DIMENSION = 32;
    
    /**
     * The amount the sprite image is scaled.
     */
    public static final int IMAGE_SCALAR = 4;
    
    /**
     * The image that contains the rows and columns of images.
     */
    private BufferedImage mySpriteSheet;
    
    
    /**
     * Constructs a new SheetLoader object that operates on the image
     * specified by the given file name. 
     * 
     * @param theFileName the file name of the image.
     * @throws NullPointerException if theFileName is null
     */
    public SheetLoader(final String theFileName) {
        Objects.requireNonNull(theFileName);
        final String path = System.getProperty("user.dir") + "/assets/" + theFileName;
        mySpriteSheet = loadImage(path);
    }
    
    /**
     * Grabs and cropping the specified image from this sheet.
     * 
     * @param theColumn the column the image returned is located at
     * @param theRow    the row the image returned is located at
     * @param theWidth  the width of the image grabbed from the sprite sheet
     * @param theHeight the height of the image grabbed from the sprite sheet
     * @return the image 
     * @throws IllegalArgumentException if theColumn is less than 1 or greater than 4
     * @throws IllegalArgumentException if theRow is less than 1 or greater than 4
     */
    public BufferedImage grabImage(final int theColumn, final int theRow) {
        
        if (theColumn < 1 || theColumn > NUM_COLS) {
            throw new IllegalArgumentException("theCols value is invalid");
        }
        if (theRow < 1 || theRow > NUM_ROWS) {
            throw new IllegalArgumentException("theRows value is invalid");
        }
        
        final int imageX = (theColumn * IMAGE_DIMENSION) - IMAGE_DIMENSION;
        final int imageY = (theRow * IMAGE_DIMENSION) - IMAGE_DIMENSION;
        
        BufferedImage image = mySpriteSheet.getSubimage(imageX, imageY, IMAGE_DIMENSION, IMAGE_DIMENSION); 
        image = resizeImage(image, IMAGE_SCALAR * IMAGE_DIMENSION, IMAGE_SCALAR * IMAGE_DIMENSION);
        
        return image;
    }
    
    /**
     * Returns the given image scaled up to the given width and height. 
     * 
     * @param theOriginalImage the image to be scaled 
     * @param theNewHeight   the new width of the image
     * @param theNewWidth  the new width of the image
     * @return the scaled image
     * @throws NullPointerException if theOriginalImage is null
     */
    // LINK: https://www.baeldung.com/java-resize-image
    private BufferedImage resizeImage(final BufferedImage theOriginalImage, final int theNewHeight, final int theNewWidth) {
        Objects.requireNonNull(theOriginalImage);
        
        final BufferedImage resizedImage = new BufferedImage(theNewHeight, theNewWidth, BufferedImage.TYPE_INT_ARGB);
        final Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(theOriginalImage, 0, 0, theNewHeight, theNewWidth, null);
        graphics2D.dispose();
        return resizedImage;
    }
    
    private BufferedImage loadImage(final String thePath) {
        BufferedImage resultImage = null;
        try {
            resultImage = ImageIO.read(new File(thePath));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return resultImage;
    }

}
