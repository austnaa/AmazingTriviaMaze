package view;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class BackgroundSheet extends SheetLoader {
    
    /** The name of the sprite sheet image located in the assets folder. */
    private static final String FILE_NAME = "background_sheet.png";
    
    public BackgroundSheet() {
        super(FILE_NAME);
    }
    
    
    /**
     * Draws the background of the panel
     * @param theGraphics the graphics object used to paint.
     */
    public void drawBackground(final Graphics2D theGraphics) {
        // top row components
        final BufferedImage upperLeftCorner = this.grabImage(1, 1);
        final BufferedImage upperWall = this.grabImage(2, 1);
        final BufferedImage upperDoor = this.grabImage(3, 1);
        final BufferedImage upperRightCorner = this.grabImage(4, 1);
        
        // middle row components
        final BufferedImage leftWall = this.grabImage(1, 2);
        final BufferedImage leftDoor = this.grabImage(2, 2);
        final BufferedImage rightWall = this.grabImage(3, 2);
        final BufferedImage rightDoor = this.grabImage(4, 2);
        final BufferedImage floorTile = this.grabImage(1, 5);
        
        // lower row components
        final BufferedImage lowerLeftCorner = this.grabImage(1, 3);
        final BufferedImage lowerWall = this.grabImage(2, 3);
        final BufferedImage lowerDoor = this.grabImage(3, 3);
        final BufferedImage lowerRightCorner = this.grabImage(4, 3);
        

        int row = 0;
        int col = 0;
        final int increment = IMAGE_DIMENSION * IMAGE_SCALAR;
        
        // draw the upper row
        theGraphics.drawImage(upperLeftCorner, col, row, null);
        col += increment;
        theGraphics.drawImage(upperWall, col, row, null);
        col += increment;
        theGraphics.drawImage(upperDoor, col, row, null);
        col += increment;
        theGraphics.drawImage(upperWall, col, row, null);
        col += increment;
        theGraphics.drawImage(upperRightCorner, col, row, null);
        
        
        row += increment;
        col = 0;
        
        // draw the middle row 
        theGraphics.drawImage(leftWall, col, row, null);
        col += increment;
        theGraphics.drawImage(floorTile, col, row, null);
        col += increment;
        theGraphics.drawImage(floorTile, col, row, null);
        col += increment;
        theGraphics.drawImage(floorTile, col, row, null);
        col += increment;
        theGraphics.drawImage(rightWall, col, row, null);
       
        col = 0;
        row += increment;
        
        // draw the door row
        theGraphics.drawImage(leftDoor, col, row, null);
        col += increment;
        theGraphics.drawImage(floorTile, col, row, null);
        col += increment;
        theGraphics.drawImage(floorTile, col, row, null);
        col += increment;
        theGraphics.drawImage(floorTile, col, row, null);
        col += increment;
        theGraphics.drawImage(rightDoor, col, row, null);
        
        col = 0; 
        row += increment;
        
        // draw the middle row
        theGraphics.drawImage(leftWall, col, row, null);
        col += increment;
        theGraphics.drawImage(floorTile, col, row, null);
        col += increment;
        theGraphics.drawImage(floorTile, col, row, null);
        col += increment;
        theGraphics.drawImage(floorTile, col, row, null);
        col += increment;
        theGraphics.drawImage(rightWall, col, row, null);
        
        col = 0;
        row += increment;
        
        // draw the bottom row
        theGraphics.drawImage(lowerLeftCorner, col, row, null);
        col += increment;
        theGraphics.drawImage(lowerWall, col, row, null);
        col += increment;
        theGraphics.drawImage(lowerDoor, col, row, null);
        col += increment;
        theGraphics.drawImage(lowerWall, col, row, null);
        col += increment;
        theGraphics.drawImage(lowerRightCorner, col, row, null);
        
    }
    
    /**
     * Draws the background of the panel
     * @param theGraphics the graphics object used to paint.
     */
    public void drawBottomWallTransparent(final Graphics2D theGraphics) {
        // lower row components
        final BufferedImage lowerLeftCornerTransparent = this.grabImage(1, 4);
        final BufferedImage lowerWallTransparent = this.grabImage(2, 4);
        final BufferedImage lowerDoorTransparent = this.grabImage(3, 4);
        final BufferedImage lowerRightCornerTransparent = this.grabImage(4, 4);

        int increment = IMAGE_DIMENSION * IMAGE_SCALAR;
        int col = 0;
        int row = 4*increment;
        
        // draw the bottom row
        theGraphics.drawImage(lowerLeftCornerTransparent, col, row, null);
        col += increment;
        theGraphics.drawImage(lowerWallTransparent, col, row, null);
        col += increment;
        theGraphics.drawImage(lowerDoorTransparent, col, row, null);
        col += increment;
        theGraphics.drawImage(lowerWallTransparent, col, row, null);
        col += increment;
        theGraphics.drawImage(lowerRightCornerTransparent, col, row, null);
    }
    

}








