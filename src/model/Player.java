/**
 * Amazing Trivial Maze 
 * TCSS 360 Spring 2021
 */

package model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import SpriteSheet.BufferedImageLoader;
import SpriteSheet.SpriteSheet;


/**
 * Provides state and functionality for a Player sprite including movement and animation.
 * 
 * @author Austn Attaway
 * @author Chau Vu
 * @author Daniel Jiang
 * @version Spring 2021
 * Updated: April 15, 2021
 */
//Tutorial source: https://www.youtube.com/watch?v=Yem67dViGSw --- is this needed anymore?
public class Player {
    
    /** The initial x speed of the player. */
    private static final int NO_SPEED = 0;
    
    /** THe initial x position of the player. */
    private static final int START_X = 100;
    
    /** The initial y position of the player. */
    private static final int START_Y = 100;
    
    /** The minimum allowed x position of the player. */
    private static final int MIN_X = 25;
    
    /** The minimum allowed y position of the player. */
    private static final int MIN_Y = 25;
    
    /** The maximum allowed x position of the player. */
    private static final int MAX_X = 500;
    
    /** The maximum allowed y position of the player. */
    private static final int MAX_Y = 465;
   
    /**
     * The value for the player's speed. Represents how many pixels the 
     * player will move each game tick.
     */
    private static final int MOVE_SPEED = 4;
    
    /**
     * A value used to delay animations. Larger values will result in larger delays.
     */
    private static final int ANIMATION_DELAY = 4;

    // movement 
    /**
     * This Player's x current x position.
     */
    private int myX;
    
    /**
     * This Player's x current x position.
     */
    private int myY;
    
    /**
     * The velocity of the player along the x axis. 
     */
    private int myVelocityX;
    
    /**
     * The velocity of the player along the y axis. 
     */
    private int myVelocityY;
  
    // images
    /**
     * The sprite sheet image for this player.
     */
    private BufferedImage mySpriteSheetImage;
    
    /**
     * The SpriteSheet for this player.
     */
    private SpriteSheet mySpriteSheet;
    
    /**
     * The current image of the player shown on the screen.
     */
    private BufferedImage myPlayerImage;
    
    /**
     * The row the current player image is located at in the sprite sheet.
     */
    private int mySpriteRow;
    
    /**
     * The column the current player image is located at in the sprite sheet.
     */
    private int mySpriteCol;
     
    /**
     * The number of ticks elapsed, used for changing images in animations.
     */
    private int myTickCount;
     
    /**
     * Constructs a new Player with default values.
     */
    public Player() {  
        
        myX = START_X;
        myY = START_Y;
        myVelocityX = NO_SPEED;
        myVelocityY = NO_SPEED;
        myTickCount = 0;
        mySpriteRow = SpriteSheet.DOWN_MOVEMENT_ROW;
        mySpriteCol = SpriteSheet.NO_MOVEMENT_COL;
        
        loadSpriteSheetImage();
        
        mySpriteSheet = new SpriteSheet(mySpriteSheetImage);
        myPlayerImage = mySpriteSheet.grabImage(mySpriteCol, mySpriteRow);
    }

    /**
     * Updates this Player's game state. Should be called after each game tick.
     */
    public void updatePlayerTick() {
        // update the tick count (for use in animation)
        myTickCount++;
        if (myTickCount > Integer.MAX_VALUE) {
            myTickCount = 0;
        }
        
        myX += myVelocityX; 
        myY += myVelocityY;
        
        // ensures the x and y position of the player
        // stays within the bounds
        myX = Math.max(Math.min(myX,  MAX_X), MIN_X);
        myY = Math.max(Math.min(myY, MAX_Y), MIN_Y);
        
        updatePlayerImage();
    }    

    /**
     * Returns the x position of this player.
     * @return the x position
     */
    public int getXPosition() {
        return myX;
    }   
    
    /**
     * Returns the y position of this player.
     * @return the y position
     */
    public int getYPosition() {
        return myY;
    }
    
    /**
     * Sets the y axis velocity so the player will start moving upwards.  
     */
    public void moveUp() {
        myVelocityY = -MOVE_SPEED;
    }
    
    /**
     * Sets the y axis velocity so the player will start moving downwards.  
     */
    public void moveDown() {
        myVelocityY = MOVE_SPEED;
    }
    
    /**
     * Sets the x axis velocity so the player will start moving left.  
     */
    public void moveLeft() {
        myVelocityX = -MOVE_SPEED;
    }
    
    /**
     * Sets the x axis velocity so the player will start moving right.  
     */
    public void moveRight() {
        this.myVelocityX = MOVE_SPEED;
    }
    
    /**
     * Halts the Player's movement along the x axis.
     */
    public void stopMovingX() {
        myVelocityX = NO_SPEED;
    }
    
    /**
     * Halts the Player's movement along the y axis.
     */
    public void stopMovingY() {
        myVelocityY = NO_SPEED;
    }
      
    /**
     * return the image of the player.
     * @return
     */
    public BufferedImage getImage() {
        return myPlayerImage;
    }
    
    /**
     * Updates the Player's sprite image depending on the game tick and 
     * the direction the character is moving.
     */
    private void updatePlayerImage() {
        if (myVelocityX != NO_SPEED || myVelocityY != NO_SPEED) {
            mySpriteCol = myTickCount / ANIMATION_DELAY % SpriteSheet.NUM_COLS + 1;
        }

        // moving left
        if (myVelocityX < NO_SPEED) {
            mySpriteRow = SpriteSheet.LEFT_MOVEMENT_ROW; 
        }
        // moving right
        else if (myVelocityX > NO_SPEED) {
            mySpriteRow = SpriteSheet.RIGHT_MOVEMENT_ROW;
        }
        
        // moving up
        if (myVelocityY < NO_SPEED) {
            mySpriteRow = SpriteSheet.UP_MOVEMENT_ROW;
        }
        // moving down 
        else if (myVelocityY > NO_SPEED) {
            mySpriteRow = SpriteSheet.DOWN_MOVEMENT_ROW;
        } 
        
        // stopped moving, so update the image to the stationary position
        if (myVelocityX == 0 && myVelocityY == 0) {
            //myPlayerImage = mySpriteSheet.grabImage(SpriteSheet.NO_MOVEMENT_COL, mySpriteRow);
            mySpriteCol = SpriteSheet.NO_MOVEMENT_COL;
        }
        
        myPlayerImage = mySpriteSheet.grabImage(mySpriteCol, mySpriteRow);    
    }

    
    /**
     * Loads the sprite sheet image for future use.
     */
    private void loadSpriteSheetImage() {
        final String path = System.getProperty("user.dir") + "/assets/sprite_sheet.png";
        mySpriteSheetImage = BufferedImageLoader.loadImage(path);
    }
    
}