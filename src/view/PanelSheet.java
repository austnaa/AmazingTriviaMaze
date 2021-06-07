/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package view;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Objects;

import model.Player;
import model.Room;

/**
 * A class dedicated to loading images for the win and lose panels.
 * @author Chau Vu
 * @version Spring 2021
 */
public class PanelSheet extends SheetLoader {
    
    /** The name of the sprite sheet image located in the assets folder. */
    private static final String FILE_NAME = "panel_sheet.png";
    
    /** The win image shown when player reach the end room. */
    private BufferedImage myWinImage;
    
    /** The lose image shown when player lose all brains. */
    private BufferedImage myLoseImage;
    
    /**
     * Create a new panel sheet with the given sheet image.
     */
    public PanelSheet() {
        super(FILE_NAME);
        setUpImages();
    }
    
    /**
     * Draws the Win panel if the current room is the end room.
     * Draws the Lose panel if the number of brains remaining for the player is 0.
     * 
     * @param theGraphics the Graphics used to draw
     * @param theRoom - the current room 
     * @param thePlayer - the player
     * @throws NullPointerException if theGraphics is null
     * @throws NullPointerException if theRoom is null
     * @throws NullPointerException if thePlayer is null
     */
    public void drawWinLosePanel(final Graphics2D theGraphics, final Room theRoom, final Player thePlayer) {
        Objects.requireNonNull(theGraphics, "theGraphics can not be null");
        Objects.requireNonNull(theRoom, "theGraphics can not be null");
        Objects.requireNonNull(thePlayer, "theGraphics can not be null");
        if (theRoom.isEndRoom()) {
            theGraphics.drawImage(myWinImage, 0, 0, null);
            Sound.GAMEPLAY.stop();
            Sound.WIN.start();
        } else if (thePlayer.getBrainsremaining() == 0) {
            theGraphics.drawImage(myLoseImage, 0, 0, null);
            Sound.GAMEPLAY.stop();
            Sound.LOSE.start();
        }
    }
    
    /**
     * Grab the images from the PanelSheet.
     */
    private void setUpImages() {
       myWinImage = this.grabPanelImage(3, 1);
       myLoseImage = this.grabPanelImage(4, 1);
    } 
    
}