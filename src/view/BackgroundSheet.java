/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package view;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Objects;

import model.Room;

/**
 * Manages drawing the background of the GamePanel.
 * 
 * @author Austn Attaway
 * @version Spring 2021
 */
public class BackgroundSheet extends SheetLoader {
    
    /** The name of the sprite sheet image located in the assets folder. */
    private static final String FILE_NAME = "background_sheet.png";
    
    /** The number of pixels wide each tile on the panel is. */
    private static final int INCREMENT = IMAGE_DIMENSION * IMAGE_SCALAR;
    
    /** The image tile of an upper left corner. */
    private BufferedImage myUpperLeftCornerImage;
    
    /** The image tile of an upper wall. */
    private BufferedImage myUpperWallImage;
    
    /** The image tile of an upper door that is locked. */
    private BufferedImage myUpperDoorLockedImage;
    
    /** The image tile of an upper door that unlocked. */
    private BufferedImage myUpperDoorUnlockedImage;
    
    /** The image tile of an upper right corner. */
    private BufferedImage myUpperRightCornerImage; 
    
    /** The image tile of a left wall. */
    private BufferedImage myLeftWallImage;
    
    /** The image tile of a left door that is locked. */
    private BufferedImage myLeftDoorLockedImage;
    
    /** The image tile of a left door that is unlocked. */
    private BufferedImage myLeftDoorUnlockedImage;
    
    /** The image tile of a right wall. */
    private BufferedImage myRightWallImage;
    
    /** The image tile of a right door that is locked. */
    private BufferedImage myRightDoorLockedImage;
    
    /** The image tile of a right door that is unlocked. */
    private BufferedImage myRightDoorUnlockedImage;
    
    /** The image tile of a floor tile. */
    private BufferedImage myFloorTileImage;
    
    /** The image tile of a lower left corner. */
    private BufferedImage myLowerLeftCornerImage;
    
    /** The image tile of a lower wall. */
    private BufferedImage myLowerWallImage;
    
    /** The image tile of a lower right corner. */
    private BufferedImage myLowerRightCornerImage;
    
    /** The image tile of a lower left corner that is transparent. */
    private BufferedImage myLowerLeftCornerTransparentImage;
    
    /** The image tile of a lower wall that is transparent. */
    private BufferedImage myLowerWallTransparentImage;
    
    /** The image tile of a lower door that is locked and transparent. */
    private BufferedImage myLowerDoorLockedTransparentImage;
    
    /** The image tile of a lower door that is locked and transparent. */
    private BufferedImage myLowerDoorUnlockedTransparentImage;
    
    /** The image tile of a lower right corner that is transparent. */
    private BufferedImage myLowerRightCornerTransparentImage;
    
    /**
     * Sets up a new BackgroundSheet.
     */
    public BackgroundSheet() {
        super(FILE_NAME);
        setupImages();
    }
    
    /**
     * Draws a bottom row of tiles that is transparent.
     * 
     * @param theGraphics the graphics object used for drawing.
     * @param theRoom the Room that is being drawn.
     * @throws NullPointerException if theGraphics is null
     * @throws NullPointerException if theRoom is null
     */
    public void drawBottomRowTransparent(final Graphics2D theGraphics, final Room theRoom) {
        Objects.requireNonNull(theGraphics, "theGraphics can not be null");
        Objects.requireNonNull(theRoom, "theRoom can not be null");

        final int row = 4 * INCREMENT;
        int col = 0;
        
        // draw the bottom row
        theGraphics.drawImage(myLowerLeftCornerTransparentImage, col, row, null);
        col += INCREMENT;
        theGraphics.drawImage(myLowerWallTransparentImage, col, row, null);
        col += INCREMENT;
        
        if (theRoom.hasSouthDoor()) {
            if (theRoom.getSouthDoor().isLocked()) {
                theGraphics.drawImage(myLowerDoorLockedTransparentImage, col, row, null);
            } else {
                theGraphics.drawImage(myLowerDoorUnlockedTransparentImage, col, row, null);
            }
        } else {
            theGraphics.drawImage(myLowerWallTransparentImage, col, row, null);
        }
        
        col += INCREMENT;
        theGraphics.drawImage(myLowerWallTransparentImage, col, row, null);
        col += INCREMENT;
        theGraphics.drawImage(myLowerRightCornerTransparentImage, col, row, null);
    }
    
    /**
     * Draws the background of the panel according to the given room
     * 
     * @param theGraphics the graphics object used to paint.
     * @param theRoom the room that is being drawn.
     * @throws NullPointerException if theGraphics is null
     * @throws NullPointerException if theRoom is null
     */
    public void drawBackground(final Graphics2D theGraphics, final Room theRoom) {
        Objects.requireNonNull(theGraphics, "theGraphics can not be null");
        Objects.requireNonNull(theRoom, "theRoom can not be null");
        drawTopRow(theGraphics, theRoom);
        drawGenericRow(theGraphics, 1);
        drawDoorRow(theGraphics, theRoom);
        drawGenericRow(theGraphics, 3);
        drawBottomRow(theGraphics, theRoom);
    }
 
    /**
     * Sets up the BufferedImages for this BackgroundSheet
     */
    private void setupImages() {
        myUpperLeftCornerImage = this.grabImage(1, 1);
        myUpperWallImage = this.grabImage(2, 1);
        myUpperDoorLockedImage = this.grabImage(3, 1);
        myUpperDoorUnlockedImage = this.grabImage(1, 6);
        myUpperRightCornerImage = this.grabImage(4, 1);
        
        myLeftWallImage = this.grabImage(1, 2);
        myLeftDoorLockedImage = this.grabImage(2, 2);
        myLeftDoorUnlockedImage = this.grabImage(3, 6);
        myRightWallImage = this.grabImage(3, 2);
        myRightDoorLockedImage = this.grabImage(4, 2);
        myRightDoorUnlockedImage = this.grabImage(2, 6);
        myFloorTileImage = this.grabImage(1, 5);
        
        myLowerLeftCornerImage = this.grabImage(1, 3);
        myLowerWallImage = this.grabImage(2, 3);
        myLowerRightCornerImage = this.grabImage(4, 3);
        
        myLowerLeftCornerTransparentImage = this.grabImage(1, 4);
        myLowerWallTransparentImage = this.grabImage(2, 4);
        myLowerDoorLockedTransparentImage = this.grabImage(3, 4);
        myLowerDoorUnlockedTransparentImage = this.grabImage(4, 6);
        myLowerRightCornerTransparentImage = this.grabImage(4, 4);
        
    }
    
    /**
     * Draws the top row of the game panel. Draws a door if the given room contains
     * a northern door, otherwise draws a wall in its place.
     * 
     * @param theGraphics the graphics object used to paint.
     * @param theRoom the room that is being drawn.
     * @throws NullPointerException if theGraphics is null
     * @throws NullPointerException if theRoom is null
     */
    private void drawTopRow(final Graphics2D theGraphics, final Room theRoom) {
        Objects.requireNonNull(theGraphics, "theGraphics can not be null");
        Objects.requireNonNull(theRoom, "theRoom can not be null");
        final int row = 0;
        int col = 0;
        
        theGraphics.drawImage(myUpperLeftCornerImage, col, row, null);
        col += INCREMENT;
        theGraphics.drawImage(myUpperWallImage, col, row, null);
        col += INCREMENT;
        
        // draw a top door if one exists
        if (theRoom.hasNorthDoor()) {
             if (theRoom.getNorthDoor().isLocked()) {
                 theGraphics.drawImage(myUpperDoorLockedImage, col, row, null); 
             } else {
                 theGraphics.drawImage(myUpperDoorUnlockedImage, col, row, null);
             }

        } else {
            theGraphics.drawImage(myUpperWallImage, col, row, null);
        }
        
        col += INCREMENT;
        theGraphics.drawImage(myUpperWallImage, col, row, null);
        col += INCREMENT;
        theGraphics.drawImage(myUpperRightCornerImage, col, row, null);
    }
    
    /**
     * Draws a generic row at the desired row that has a normal walls and blank floor tiles.
     * 
     * @param theGraphics the Graphics object used for painting
     * @param theRow the row the generic row should be painted at
     * @throws NullPointerException if theGraphics is null
     */
    private void drawGenericRow(final Graphics2D theGraphics, final int theRow) {
        Objects.requireNonNull(theGraphics, "theGraphics can not be null");
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
    
    /**
     * Draws a row of tiles that has doors on either side 
     * depending on the state of the given Room.
     * 
     * @param theGraphics the graphics object used for drawing.
     * @param theRoom the Room that is being drawn.
     * @throws NullPointerException if theGraphics is null
     * @throws NullPointerException if theRoom is null
     */
    private void drawDoorRow(final Graphics2D theGraphics, final Room theRoom) {
        Objects.requireNonNull(theGraphics, "theGraphics can not be null");
        Objects.requireNonNull(theRoom, "theRoom can not be null");
        int row = INCREMENT * 2;
        int col = 0;
        
        if (theRoom.hasWestDoor()) {
            if (theRoom.getWestDoor().isLocked()) {
                theGraphics.drawImage(myLeftDoorLockedImage, col, row, null);
            } else {
                theGraphics.drawImage(myLeftDoorUnlockedImage, col, row, null);
            }
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
            if (theRoom.getEastDoor().isLocked()) {
                theGraphics.drawImage(myRightDoorLockedImage, col, row, null);    
            } else {
                theGraphics.drawImage(myRightDoorUnlockedImage, col, row, null);
            }
            
        } else {
            theGraphics.drawImage(myRightWallImage, col, row, null);
        }
    }

    /**
     * Draws a bottom row of tiles that has a door if one exists in the given room. 
     * 
     * @param theGraphics the graphics object used for drawing.
     * @param theRoom the Room that is being drawn.
     * @throws NullPointerException if theGraphics is null
     * @throws NullPointerException if theRoom is null
     */
    private void drawBottomRow(final Graphics2D theGraphics, final Room theRoom) {
        Objects.requireNonNull(theGraphics, "theGraphics can not be null");
        Objects.requireNonNull(theRoom, "theRoom can not be null");
        final int row = 4 * INCREMENT;
        int col = 0;
        
        theGraphics.drawImage(myLowerLeftCornerImage, col, row, null);
        col += INCREMENT;
        theGraphics.drawImage(myLowerWallImage, col, row, null);
        col += INCREMENT;
        
        // draw floor background since the foreground will be drawn on top 
        theGraphics.drawImage(myFloorTileImage, col, row, null);     
        
        col += INCREMENT;
        theGraphics.drawImage(myLowerWallImage, col, row, null);
        col += INCREMENT;
        theGraphics.drawImage(myLowerRightCornerImage, col, row, null);
    }
    
}