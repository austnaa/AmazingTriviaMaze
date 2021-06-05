/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package view;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import model.Player;
import model.Room;

/**
 * TODO
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
     * Grab the images from the PanelSheet.
     */
    private void setUpImages() {
       myWinImage = this.grabPanelImage(3, 1);
       myLoseImage = this.grabPanelImage(4, 1);
    }
    
    /**
     * Draws the Win panel based on room.
     * Draws the Lose panel based on brains.
     * @param theGraphics 
     * @param theRoom - the current room
     * @param thePlayer - the player
     */
    public void drawWinLosePanel(final Graphics2D theGraphics, final Room theRoom, final Player thePlayer) {
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
}