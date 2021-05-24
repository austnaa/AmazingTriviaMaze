/**
 * Amazing Trivial Maze 
 * TCSS 360 Spring 2021
 */

package model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Door.TYPE;
import view.BufferedImageLoader;
import view.GameFrame;
import view.ItemSheet;
import view.SpriteSheet;


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
    
    /**
     * the max number of brains a player can have.
     * TODO: decide on the maximum number of brains
     */
    private static final int MAX_BRAINS = 10; 
    
    /**
     * the number of brains the player starts with.
     * TODO: decide on the number of brains player starts with.
     */
    private static final int START_BRAINS = 5;

    /** The initial x speed of the player. */
    private static final int NO_SPEED = 0;
    
    /** THe initial x position of the player. */
    private static final int START_X = GameFrame.FRAME_WIDTH / 2;
    
    /** The initial y position of the player. */
    private static final int START_Y = GameFrame.FRAME_HEIGHT / 2;
    
    /** The minimum allowed x position of the player. */
    private static final int MIN_X = 0;
    
    /** The minimum allowed y position of the player. */
    private static final int MIN_Y = 25;
    
    /** The maximum allowed x position of the player. */
    private static final int MAX_X = 512;
    
    /** The maximum allowed y position of the player. */
    private static final int MAX_Y = 475;
   
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
  
    // brains location
    
    /**
     * TODO: create a list of brains image and put it in the top right.
     */  
    private List<BufferedImage> myBrainList;
    
    /**
     * The Brains current x position
     */
    private int myBrainX;
    
    /**
     * The Brains current y position
     */
    private int myBrainY;
    
    // images  
    /**
     * The SpriteSheet for this player.
     */
    private SpriteSheet mySpriteSheet;
    
    /**
     * The SpriteSheet myBrainSpriteSheet.
     */
    private ItemSheet myItemSheet;
     
    /**
     * The current image of the player shown on the screen.
     */
    private BufferedImage myPlayerImage;
    
    /**
     * The current image of the brains shown on the screen.
     */
    private BufferedImage myBrainImage;
    
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
     * The number of brains(incorrect answers) remaining.
     */
    private int myBrainsRemaining;
     
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
        
        mySpriteSheet = new SpriteSheet();
        myPlayerImage = mySpriteSheet.grabImage(mySpriteCol, mySpriteRow);
        
        myItemSheet = new ItemSheet();
        myBrainImage = myItemSheet.grabIcon(ItemSheet.BRAIN_IMAGE, ItemSheet.BRAIN_IMAGE);
        
        myBrainsRemaining = START_BRAINS;
        // TODO: put it in a method.
        myBrainList = new ArrayList<BufferedImage>();
        for (int i = 0; i < myBrainsRemaining; i++) {
            myBrainList.add(myBrainImage);
        }
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
     * return the image of the brains.
     * @return
     */
    public BufferedImage getBrainImage() {
        return myBrainImage;
    }
    
    /**
     * return the brains x location.
     */
    public int getBrainX() {
        return myBrainX;
    }
    
    /**
     * return the brains y location.
     */
    public int getBrainY() {
        return myBrainY;
    }
    
    /**
     * Returns myBrainsRemaining
     * @return
     */
    public int getBrainsremaining() {
        return myBrainsRemaining;
    }
    /**
     * Sets myBrainsRemaining to theNumBrains if the sum is less than Max_Brains.
     * @param theNumBrains
     */
    public void setBrains(final int theNumBrains) {
        myBrainsRemaining = Math.min(MAX_BRAINS, theNumBrains);   
    }
    
    /**
     * return the brains list.
     * @return
     */
    public List<BufferedImage> getBrainsList() {
        return myBrainList;
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
        
        // moving down right
        if ( myVelocityY > NO_SPEED && myVelocityX > NO_SPEED) {
            mySpriteRow = SpriteSheet.DOWN_RIGHT_MOVEMENT_ROW;
        }
        
        // moving down left
        if ( myVelocityY > NO_SPEED && myVelocityX < NO_SPEED ) {
            mySpriteRow = SpriteSheet.DOWN_LEFT_MOVEMENT_ROW;
        }

        // moving up right
        if ( myVelocityY < NO_SPEED && myVelocityX > NO_SPEED) {
            mySpriteRow = SpriteSheet.UP_RIGHT_MOVEMENT_ROW;
        }
        
        // moving up left
        if ( myVelocityY < NO_SPEED && myVelocityX < NO_SPEED ) {
            mySpriteRow = SpriteSheet.UP_LEFT_MOVEMENT_ROW;
        }
        
        // stopped moving, so update the image to the stationary position
        if (myVelocityX == 0 && myVelocityY == 0) {
            //myPlayerImage = mySpriteSheet.grabImage(SpriteSheet.NO_MOVEMENT_COL, mySpriteRow);
            mySpriteCol = SpriteSheet.NO_MOVEMENT_COL;
        }
        
        myPlayerImage = mySpriteSheet.grabImage(mySpriteCol, mySpriteRow);    
    }

    /**
     * Updates the Player's current position as the Players interact with the door to move rooms.
     * 
     * @param theDoorType - The door position N/E/W/S.
     */
    public void moveRooms(final Door.TYPE theDoorType) {
        if (theDoorType == Door.TYPE.NORTH) {
            myX = MAX_X / 2;
            myY = MAX_Y;
        }
        
        if (theDoorType == Door.TYPE.SOUTH) {
            myX = MAX_X / 2;
            myY = MIN_Y;
        }
        
        if (theDoorType == Door.TYPE.EAST) {
            myX = MIN_X;
            myY = MAX_Y / 2; 
        }
        
        if (theDoorType == Door.TYPE.WEST) {
            myX = MAX_X;
            myY = MAX_Y / 2;
        }
        
    }
    
}