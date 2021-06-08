/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package view;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Objects;

import model.Player;

/**
 * The class contains a method that grabs the specific image from 
 * an item sheet.
 * 
 * References: https://www.youtube.com/watch?v=jedilHUPO7c
 *             https://www.baeldung.com/java-resize-image
 * 
 * @author Chau Vu
 * @version Spring 2021
 */
public class ItemSheet extends SheetLoader {

    /** A constant variable 1 for the brain image location. */
    public static final int BRAIN_IMAGE = 1;
    
    /** The name of the sprite sheet image located in the assets folder. */
    private static final String FILE_NAME = "item_sheet.png";
    
    /** The starting x location for drawing the brains. */
    private static final int X_LOCATION = 450;
    
    /** The starting y location for drawing the brains. */
    private static final int Y_LOCATION = 10;
     
    /** The brains image. */
    private BufferedImage myBrainsImage;
    
    /**
     * Creates a new item sheet instance with the given item sheet image.
     */
    public ItemSheet() {
        super(FILE_NAME);
        setUpImages();
    }
    
    /**
     * Draws the list of brains. 
     * @param theGraphics The graphics used for drawing.
     * @param thePlayer The player's state for drawing the brains.
     * @throws NullPointerException If the graphics are null.
     * @throws NullPointerException If the player is null.
     */
    public void drawBrainsList(final Graphics2D theGraphics, final Player thePlayer) {
        Objects.requireNonNull(theGraphics, "theGraphics can not be null");
        Objects.requireNonNull(thePlayer, "thePlayer can not be null");
        int xLocation = X_LOCATION;
        for (int i = 0; i < thePlayer.getBrainsremaining(); i++) {
            theGraphics.drawImage(myBrainsImage, xLocation, Y_LOCATION, null);
            xLocation += 32;
        }      
    }
    
    /**
     * Grab the images from the item sheet.
     */
    private void setUpImages() {
        myBrainsImage = this.grabIcon(1, 1);
    }
}