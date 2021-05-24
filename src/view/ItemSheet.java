/**
 * Amazing Trivial Maze 
 * TCSS 360 Spring 2021
 */

package view;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import model.Player;

/**
 * Class contains a method that
 * grabs the specific image from 
 * an item sheet.
 * 
 * @author Chau Vu
 * @version Spring 2021
 * Updated: May 15, 2021
 */
// references: https://www.youtube.com/watch?v=jedilHUPO7c&t=1s
//             https://www.baeldung.com/java-resize-image
public class ItemSheet extends SheetLoader {
    /**
     * a constant variable 1 for brain image location.
     */
    public static final int BRAIN_IMAGE = 1;
    
    /** The name of the sprite sheet image located in the assets folder. */
    private static final String FILE_NAME = "item_sheet.png";
     
    /**
     * The Brains Image.
     */
    private BufferedImage myBrainsImage;
    
    /**
     * Creates a new item sheet instance with the given item sheet image.
     */
    public ItemSheet() {
        super(FILE_NAME);
        setUpImages();
    }
    
    /**
     * Grab the images from the ItemSheet.
     */
    private void setUpImages() {
        myBrainsImage = this.grabIcon(1, 1);
    }
    
    /**
     * draws the list of brains. 
     * TODO: find the location for brains.
     * @param theGraphics
     * @param thePlayer
     */
    public void drawBrainsList(final Graphics2D theGraphics, final Player thePlayer) {
       int xLocation = 450;
       final int yLocation = 10;
       for (int i = 0; i < thePlayer.getBrainsList().size(); i++) {
           theGraphics.drawImage(myBrainsImage, xLocation, yLocation, null);
           xLocation += 32;
       }      
    }
}