package view;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class BackgroundSheet extends SheetLoader {
    
    /** The name of the sprite sheet image located in the assets folder. */
    private static final String FILE_NAME = "background_sheet.png";
    
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
     */
    public void drawBackground(final Graphics2D theGraphics) {
        
        int row = 0;
        int col = 0;
        final int increment = IMAGE_DIMENSION * IMAGE_SCALAR;
        
        // draw the upper row
        theGraphics.drawImage(myUpperLeftCornerImage, col, row, null);
        col += increment;
        theGraphics.drawImage(myUpperWallImage, col, row, null);
        col += increment;
        theGraphics.drawImage(myUpperDoorImage, col, row, null);
        col += increment;
        theGraphics.drawImage(myUpperWallImage, col, row, null);
        col += increment;
        theGraphics.drawImage(myUpperRightCornerImage, col, row, null);
        
        
        row += increment;
        col = 0;
        
        // draw the middle row 
        theGraphics.drawImage(myLeftWallImage, col, row, null);
        col += increment;
        theGraphics.drawImage(myFloorTileImage, col, row, null);
        col += increment;
        theGraphics.drawImage(myFloorTileImage, col, row, null);
        col += increment;
        theGraphics.drawImage(myFloorTileImage, col, row, null);
        col += increment;
        theGraphics.drawImage(myRightWallImage, col, row, null);
       
        col = 0;
        row += increment;
        
        // draw the door row
        theGraphics.drawImage(myLeftDoorImage, col, row, null);
        col += increment;
        theGraphics.drawImage(myFloorTileImage, col, row, null);
        col += increment;
        theGraphics.drawImage(myFloorTileImage, col, row, null);
        col += increment;
        theGraphics.drawImage(myFloorTileImage, col, row, null);
        col += increment;
        theGraphics.drawImage(myRightDoorImage, col, row, null);
        
        col = 0; 
        row += increment;
        
        // draw the middle row
        theGraphics.drawImage(myLeftWallImage, col, row, null);
        col += increment;
        theGraphics.drawImage(myFloorTileImage, col, row, null);
        col += increment;
        theGraphics.drawImage(myFloorTileImage, col, row, null);
        col += increment;
        theGraphics.drawImage(myFloorTileImage, col, row, null);
        col += increment;
        theGraphics.drawImage(myRightWallImage, col, row, null);
        
        col = 0;
        row += increment;
        

        
        // draw the bottom row
        theGraphics.drawImage(myLowerLeftCornerImage, col, row, null);
        col += increment;
        theGraphics.drawImage(myLowerWallImage, col, row, null);
        col += increment;
        theGraphics.drawImage(myLowerDoorImage, col, row, null);
        col += increment;
        theGraphics.drawImage(myLowerWallImage, col, row, null);
        col += increment;
        theGraphics.drawImage(myLowerRightCornerImage, col, row, null);
        
    }
    
    /**
     * Draws the background of the panel
     * @param theGraphics the graphics object used to paint.
     */
    public void drawBottomWallTransparent(final Graphics2D theGraphics) {

        int increment = IMAGE_DIMENSION * IMAGE_SCALAR;
        int col = 0;
        int row = 4*increment;
        
        // draw the bottom row
        theGraphics.drawImage(myLowerLeftCornerTransparentImage, col, row, null);
        col += increment;
        theGraphics.drawImage(myLowerWallTransparentImage, col, row, null);
        col += increment;
        theGraphics.drawImage(myLowerDoorTransparentImage, col, row, null);
        col += increment;
        theGraphics.drawImage(myLowerWallTransparentImage, col, row, null);
        col += increment;
        theGraphics.drawImage(myLowerRightCornerTransparentImage, col, row, null);
    }

}








