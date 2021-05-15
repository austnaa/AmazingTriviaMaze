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
    private static final int MAX_X = 550;
    
    /** The maximum allowed y position of the player. */
    private static final int MAX_Y = 500;
   
    /**
     * The value for the player's speed. Represents how many pixels the 
     * player will move each game tick.
     */
    private static final int MOVE_SPEED = 4;

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
    
    private BufferedImage spriteSheet = null;
    
    
    /**
     * The velocity of the player along the y axis. 
     */
    private int myVelocityY;
    
     
    /**
     * The current image of the player shown on the screen.
     */
    private BufferedImage myPlayerImage;
    
    
    private SpriteSheet mySpriteSheet;
    
    private int myTickCount;
    
    
    private int mySpriteRow;
    private int mySpriteCol;
    
    
    
    
    
    
   // moving up -> row 1
   // moving down -> row 2
   // moving left -> row 3
   // moving down -> row 4
   // stopping up -> row 1, column 1
   // stopping down -> row 2, column 1
   // stopping left -> row 3, column 1
   // stopping right -> row 3, column 1
    
    
    
    
    
    
    
    /**
     * Constructs a new Player with default values.
     */
    public Player() {  
        
        super();
        loadImage();
        
        myX = START_X;
        myY = START_Y;
        myVelocityX = NO_SPEED;
        myVelocityY = NO_SPEED;
        myTickCount = 0;
        mySpriteRow = SpriteSheet.DOWN_MOVEMENT_ROW;
        mySpriteCol = SpriteSheet.NO_MOVEMENT_COL;
        
        mySpriteSheet = new SpriteSheet(spriteSheet);
        myPlayerImage = mySpriteSheet.grabImage(mySpriteCol, mySpriteRow);
    }

    public void loadImage() {
        BufferedImageLoader loader = new BufferedImageLoader();
        try {
          final String path = System.getProperty("user.dir") + "/assets/sprite_sheet.png";
          spriteSheet = loader.loadImage(path);
          
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    
    /**
     * Updates this Player's game state after one tick.
     */
    public void updatePlayerTick() {
        this.myTickCount++;
        if (myTickCount > 999999) {
            myTickCount = 0;
        }
        this.myX += myVelocityX; 
        this.myY += myVelocityY;
        
        // ensures the x and y position of the player
        // stays within the bounds
        myX = Math.max(Math.min(myX,  MAX_X), MIN_X);
        myY = Math.max(Math.min(myY, MAX_Y), MIN_Y);
        
        
        updatePlayerImage();
    }
        
    
    /**
     * Updates the Player's sprite image depending on the game tick and 
     * the direction the character is moving.
     */
    public void updatePlayerImage() {
        if (myVelocityX != NO_SPEED || myVelocityY != NO_SPEED) {
            // TODO DIVISOR WORTH SAVING AS GLOBAL?
            mySpriteCol = myTickCount / 4 % SpriteSheet.NUM_COLS + 1;
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
        
        if (myVelocityX == 0 && myVelocityY == 0) {
            //myPlayerImage = mySpriteSheet.grabImage(SpriteSheet.NO_MOVEMENT_COL, mySpriteRow);
            mySpriteCol = SpriteSheet.NO_MOVEMENT_COL;
        }
        
        myPlayerImage = mySpriteSheet.grabImage(mySpriteCol, mySpriteRow);
        // stopped moving, so update the image to the stationary position  
        
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
    
}