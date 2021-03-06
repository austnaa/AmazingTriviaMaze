/**
 * Amazing Trivia Maze 
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
 * @author Austn Attaway
 * @version Spring 2021
 */
public class SheetLoader {
    
    /**
     * The number of images for an animation in a particular direction.
     * NOTE: CHANGES TO THIS AFFECT PLAYER ANIMATION.
     */
    public static final int NUM_COLS = 4;
    
    /** The number of rows of images. */
    public static final int NUM_ROWS = 9;
    
    /** The width and height of the images in the sprite sheet in pixels. */
    public static final int IMAGE_DIMENSION = 32;
    
    /** The amount the sprite image is scaled. */
    public static final int IMAGE_SCALAR = 4;
    
    /** The image that contains the rows and columns of images. */
    private BufferedImage mySheet;
    
    /**
     * Constructs a new sheet loader object that operates on the image
     * specified by the given file name. 
     * @param theFileName The file name of the image.
     * @throws NullPointerException If the file name is null.
     */
    public SheetLoader(final String theFileName) {
        Objects.requireNonNull(theFileName, "theFileName can not be null");
        final String path = System.getProperty("user.dir") + "/assets/" + theFileName;
        mySheet = loadImage(path);
    }
    
    /**
     * Returns the given image scaled up to the given width and height.
     * 
     * LINK: https://www.baeldung.com/java-resize-image
     * 
     * @param theOriginalImage The image to be scaled.
     * @param theNewHeight The new height of the image.
     * @param theNewWidth The new width of the image.
     * @return The scaled image.
     * @throws NullPointerException If the original image is null.
     */
    public static BufferedImage resizeImage(final BufferedImage theOriginalImage, final int theNewHeight, final int theNewWidth) {
        Objects.requireNonNull(theOriginalImage);
        
        final BufferedImage resizedImage = new BufferedImage(theNewHeight, theNewWidth, BufferedImage.TYPE_INT_ARGB);
        final Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(theOriginalImage, 0, 0, theNewHeight, theNewWidth, null);
        graphics2D.dispose();
        return resizedImage;
    }
    
    /**
     * Returns the loaded image specified from the file path.
     * @param thePath The path of the image file.
     * @return The buffered iamge of the given image file.
     * @throws NullPointerException If the path of the image file is null.
     */
    public static BufferedImage loadImage(final String thePath) {
        Objects.requireNonNull(thePath, "thePath can not be null");
        BufferedImage resultImage = null;
        try {
            resultImage = ImageIO.read(new File(thePath));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return resultImage;
    }  
    
    /**
     * Grabs and crops the specified image from this sheet.
     * @param theColumn The column the image is located at.
     * @param theRow The row the image is located at.
     * @return The image.
     * @throws IllegalArgumentException If the column is less than 1 or greated than 4.
     * @throws IllegalArgumentException If the row is less than 1 or greater than 4.
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
        
        BufferedImage image = mySheet.getSubimage(imageX, imageY, IMAGE_DIMENSION, IMAGE_DIMENSION); 
        image = resizeImage(image, IMAGE_SCALAR * IMAGE_DIMENSION, IMAGE_SCALAR * IMAGE_DIMENSION);
        
        return image;
    }
    
    /**
     * Grabs and cropping the specified icon from this sheet.
     * @param theColumn The column the image is located at.
     * @param theRow The row the image is located at.
     * @return The image.
     * @throws IllegalArgumentException If the column is less than 1 or greated than 4.
     * @throws IllegalArgumentException If the row is less than 1 or greater than 4.
     */
    public BufferedImage grabIcon(final int theColumn, final int theRow) {
        if (theColumn < 1 || theColumn > NUM_COLS) {
            throw new IllegalArgumentException("theCols value is invalid");
        }
        if (theRow < 1 || theRow > NUM_ROWS) {
            throw new IllegalArgumentException("theRows value is invalid");
        }
        
        final int imageX = (theColumn * IMAGE_DIMENSION) - IMAGE_DIMENSION;
        final int imageY = (theRow * IMAGE_DIMENSION) - IMAGE_DIMENSION;
        
        BufferedImage image = mySheet.getSubimage(imageX, imageY, IMAGE_DIMENSION, IMAGE_DIMENSION); 

        return image;
    }
    
    /**
     * Grabs and cropping the specified image from this sheet.
     * @param theColumn The column the image is located at.
     * @param theRow The row the image is located at.
     * @return The image.
     * @throws IllegalArgumentException If the column is less than 1 or greated than 4.
     * @throws IllegalArgumentException If the row is less than 1 or greater than 4.
     */
    public BufferedImage grabPanelImage(final int theColumn, final int theRow) {
        if (theColumn < 1 || theColumn > NUM_COLS) {
            throw new IllegalArgumentException("theCols value is invalid");
        }
        
        if (theRow < 1 || theRow > NUM_ROWS) {
            throw new IllegalArgumentException("theRows value is invalid");
        }
        
        final int imageSize = 128;
        final int imageX = (theColumn * imageSize) - imageSize;
        final int imageY = (theRow * imageSize) - imageSize;
        
        BufferedImage image = mySheet.getSubimage(imageX, imageY, imageSize, imageSize); 
        image = resizeImage(image, GameFrame.FRAME_WIDTH, GameFrame.FRAME_HEIGHT);

        return image;
    }
}