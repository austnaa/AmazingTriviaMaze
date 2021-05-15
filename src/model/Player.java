/**
 * Amazing Trivial Maze 
 * TCSS 360 Spring 2021
 */

package model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import SpriteSheet.BufferedImageLoader;
import SpriteSheet.SpriteSheet;

/**
 * Contains state and behavior specific to the Player character.
 * 
 * @author Daniel Jiang
 * @author Austn Attaway
 * @author Chau Vu
 * @version Spring 2021
 * Updated: May 15, 2021
 * The class for the Player model.
 */
// Tutorial source: https://www.youtube.com/watch?v=Yem67dViGSw
// TODO - We can probably merge the PlayerActions into here.
public class Player {
    
    /** The initial x speed of the player. */
    private static final int INITIAL_SPEED = 0;
    
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
        myVelocityX = INITIAL_SPEED;
        myVelocityY = INITIAL_SPEED;
        myTickCount = 0;
        mySpriteRow = 1;
        mySpriteCol = 1;
        
        mySpriteSheet = new SpriteSheet(spriteSheet);
        myPlayerImage = mySpriteSheet.grabImage(1, 2, 32, 32);
//        myPlayerImage =  new BufferedImage(64, 64, myPlayerImage.getType());
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
        if (myVelocityX != INITIAL_SPEED || myVelocityY != INITIAL_SPEED) {
            mySpriteCol = myTickCount / 4 % 4 + 1;
        }

        // moving left -> row 3
        if (myVelocityX < 0) {
            mySpriteRow = 3; 
        }
        // moving right
        else if (myVelocityX > 0) {
            mySpriteRow = 4;
        }
        
        // moving up -> row 1
        if (myVelocityY < 0) {
            mySpriteRow = 1;
        }
        // moving down -> row 2
        else if (myVelocityY > 0) {
            mySpriteRow = 2;
        } 
        myPlayerImage = mySpriteSheet.grabImage(mySpriteCol, mySpriteRow, 32, 32);
        
        // stopped moving, so update the image to the stationary position  
        if (myVelocityX == 0 && myVelocityY == 0) {
            myPlayerImage = mySpriteSheet.grabImage(1, mySpriteRow, 32, 32);
        }
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
        myVelocityX = INITIAL_SPEED;
    }
    
    /**
     * Halts the Player's movement along the y axis.
     */
    public void stopMovingY() {
        myVelocityY = INITIAL_SPEED;
    }
      
    /**
     * return the image of the player.
     * @return
     */
    public BufferedImage getImage() {
        return myPlayerImage;
    }
    
}