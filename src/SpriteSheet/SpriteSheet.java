/**
 * Amazing Trivial Maze 
 * TCSS 360 Spring 2021
 */

package SpriteSheet;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Objects;

/**
 * Class contains a method that
 * grabs the specific image from 
 * a spritesheet.
 * 
 * @author Austn Attaway
 * @author Chau Vu
 * @version Spring 2021
 * Updated: May 15, 2021
 */
// references: https://www.youtube.com/watch?v=jedilHUPO7c&t=1s
//             https://www.baeldung.com/java-resize-image
public class SpriteSheet {
   
    /** The row that contains images for upwards sprite animation. */
    public static int UP_MOVEMENT_ROW = 1;
    
    /** The row that contains images for downwards sprite animation. */
    public static int DOWN_MOVEMENT_ROW = 2;
    
    /** The row that contains images for leftwards sprite animation. */
    public static int LEFT_MOVEMENT_ROW = 3;
    
    /** The row that contains images for rightwards sprite animation. */
    public static int RIGHT_MOVEMENT_ROW = 4;
    
    /** The column that contains images for a player that is standing still. */
    public static int NO_MOVEMENT_COL = 1;
    
    /** The number of images for an animation in a particular direction. */
    public static int NUM_COLS = 4;
    
    /** The number of rows of images. */
    public static int NUM_ROWS = 4;
    
    /** The width and height of the images in the sprite sheet in pixels. */
    private static final int IMAGE_DIMENSION = 32;
    
    /**
     * The amount the sprite image is scaled.
     */
    private static final int IMAGE_SCALAR = 4;
    
    /**
     * The image that contains all of the images for the sprite.
     */
    private BufferedImage mySpriteSheet;
    
    /**
     * Creates a new sprite sheet instance with the given sprite sheet image.
     * @param theSpriteSheet the sprite sheet image.
     * @throws NullPointerException if theSpriteSheet is null
     */
    public SpriteSheet(final BufferedImage theSpriteSheet) {
        this.mySpriteSheet = Objects.requireNonNull(theSpriteSheet);
    }
    
    /**
     * Grabbing and cropping the specified image from the sprite sheet.
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
}
