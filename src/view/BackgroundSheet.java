/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */

package view;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import model.Room;

public class BackgroundSheet extends SheetLoader {
    
    /** The name of the sprite sheet image located in the assets folder. */
    private static final String FILE_NAME = "background_sheet.png";
    
    private static final int INCREMENT = IMAGE_DIMENSION * IMAGE_SCALAR;
    
    // TODO FINISH THESE JAVADOC LMAO
    /**
     * The image tile of the an upper left corner.
     */
    private BufferedImage myUpperLeftCornerImage;
    private BufferedImage myUpperWallImage;
    private BufferedImage myUpperDoorImage;
    private BufferedImage myUpperRightCornerImage; 
    
    private BufferedImage myLeftWallImage;
    private BufferedImage myLeftDoorImage;
    private BufferedImage myRightWallImage;
    private BufferedImage myRightDoorImage;
    private BufferedImage myFloorTileImage;
    
    private BufferedImage myLowerLeftCornerImage; 
    private BufferedImage myLowerWallImage;
    private BufferedImage myLowerDoorImage; 
    private BufferedImage myLowerRightCornerImage;
    
    private BufferedImage myLowerLeftCornerTransparentImage;
    private BufferedImage myLowerWallTransparentImage;
    private BufferedImage myLowerDoorTransparentImage; 
    private BufferedImage myLowerRightCornerTransparentImage;
    
    
    public BackgroundSheet() {
        super(FILE_NAME);
        setupImages();
    }
    
    private void setupImages() {
        myUpperLeftCornerImage = this.grabImage(1, 1);
        myUpperWallImage = this.grabImage(2, 1);
        myUpperDoorImage = this.grabImage(3, 1);
        myUpperRightCornerImage = this.grabImage(4, 1);
        
        myLeftWallImage = this.grabImage(1, 2);
        myLeftDoorImage = this.grabImage(2, 2);
        myRightWallImage = this.grabImage(3, 2);
        myRightDoorImage = this.grabImage(4, 2);
        myFloorTileImage = this.grabImage(1, 5);
        
        myLowerLeftCornerImage = this.grabImage(1, 3);
        myLowerWallImage = this.grabImage(2, 3);
        myLowerDoorImage = this.grabImage(3, 3);
        myLowerRightCornerImage = this.grabImage(4, 3);
        
        myLowerLeftCornerTransparentImage = this.grabImage(1, 4);
        myLowerWallTransparentImage = this.grabImage(2, 4);
        myLowerDoorTransparentImage = this.grabImage(3, 4);
        myLowerRightCornerTransparentImage = this.grabImage(4, 4);
        
    }
    
    /**
     * Draws the background of the panel according to the given room
     * @param theGraphics the graphics object used to paint.
     * @param theRoom the room that is being drawn.
     */
    public void drawBackground(final Graphics2D theGraphics, final Room theRoom) {   
        drawTopRow(theGraphics, theRoom);
        drawGenericRow(theGraphics, 1);
        drawDoorRow(theGraphics, theRoom);
        drawGenericRow(theGraphics, 3);
        drawBottomRow(theGraphics, theRoom);
    }
    
    /**
     * Draws the top row of the game panel. Draws a door if the given room contains
     * a northern door, otherwise draws a wall in its place.
     * @param theGraphics the graphics object used to paint.
     * @param theRoom the room that is being drawn.
     */
    private void drawTopRow(final Graphics2D theGraphics, final Room theRoom) {
        final int row = 0;
        int col = 0;
        
        theGraphics.drawImage(myUpperLeftCornerImage, col, row, null);
        col += INCREMENT;
        theGraphics.drawImage(myUpperWallImage, col, row, null);
        col += INCREMENT;
        
        // draw a top door if one exists
        if (theRoom.hasNorthDoor()) {
            theGraphics.drawImage(myUpperDoorImage, col, row, null);
        } else {
            theGraphics.drawImage(myUpperWallImage, col, row, null);
        }
        
        col += INCREMENT;
        theGraphics.drawImage(myUpperWallImage, col, row, null);
        col += INCREMENT;
        theGraphics.drawImage(myUpperRightCornerImage, col, row, null);
    }
    
    // TODO
    private void drawGenericRow(final Graphics2D theGraphics, final int theRow) {
        
        final int row = theRow * INCREMENT;
        int col = 0;
         
        theGraphics.drawImage(myLeftWallImage, col, row, null);
        col += INCREMENT;
        theGraphics.drawImage(myFloorTileImage, col, row, null);
        col += INCREMENT;
        theGraphics.drawImage(myFloorTileImage, col, row, null);
        col += INCREMENT;
        theGraphics.drawImage(myFloorTileImage, col, row, null);
        col += INCREMENT;
        theGraphics.drawImage(myRightWallImage, col, row, null);
    }
    
    // TODO
    private void drawDoorRow(final Graphics2D theGraphics, final Room theRoom) {
        int row = INCREMENT * 2;
        int col = 0;
        
        if (theRoom.hasWestDoor()) {
            theGraphics.drawImage(myLeftDoorImage, col, row, null);
        } else {
            theGraphics.drawImage(myLeftWallImage, col, row, null);
        }
        col += INCREMENT;
        
        theGraphics.drawImage(myFloorTileImage, col, row, null);
        col += INCREMENT;
        theGraphics.drawImage(myFloorTileImage, col, row, null);
        col += INCREMENT;
        theGraphics.drawImage(myFloorTileImage, col, row, null);
        col += INCREMENT;
        
        if (theRoom.hasEastDoor()) {
            theGraphics.drawImage(myRightDoorImage, col, row, null);
        } else {
            theGraphics.drawImage(myRightWallImage, col, row, null);
        }
    }

    // TODO
    private void drawBottomRow(final Graphics2D theGraphics, final Room theRoom) {
        final int row = 4 * INCREMENT;
        int col = 0;
        
        theGraphics.drawImage(myLowerLeftCornerImage, col, row, null);
        col += INCREMENT;
        theGraphics.drawImage(myLowerWallImage, col, row, null);
        col += INCREMENT;
        
        if (theRoom.hasSouthDoor()) {
            theGraphics.drawImage(myLowerDoorImage, col, row, null);
        } else {
            theGraphics.drawImage(myLowerWallImage, col, row, null);
        }
        
        col += INCREMENT;
        theGraphics.drawImage(myLowerWallImage, col, row, null);
        col += INCREMENT;
        theGraphics.drawImage(myLowerRightCornerImage, col, row, null);
    }
    
    /**
     * Draws a partially transparent bottom row. Meant to happen after the player has 
     * been painted so it acts as a foreground. Draws a door if theRoom contains a door. 
     * @param theGraphics the graphics object used to paint.
     * @param theRoom the room that is being drawn.
     */
    public void drawBottomRowTransparent(final Graphics2D theGraphics, final Room theRoom) {

        final int row = 4 * INCREMENT;
        int col = 0;
        
        // draw the bottom row
        theGraphics.drawImage(myLowerLeftCornerTransparentImage, col, row, null);
        col += INCREMENT;
        theGraphics.drawImage(myLowerWallTransparentImage, col, row, null);
        col += INCREMENT;
        
        if (theRoom.hasSouthDoor()) {
            theGraphics.drawImage(myLowerDoorTransparentImage, col, row, null);
        } else {
            theGraphics.drawImage(myLowerWallTransparentImage, col, row, null);
        }
        
        col += INCREMENT;
        theGraphics.drawImage(myLowerWallTransparentImage, col, row, null);
        col += INCREMENT;
        theGraphics.drawImage(myLowerRightCornerTransparentImage, col, row, null);
    }

}