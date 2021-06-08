/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package model;

import java.awt.image.BufferedImage;
import java.util.Objects;

import view.GameFrame;
import view.SpriteSheet;

/**
 * Provides state and functionality for a player sprite including movement and animation.
 * 
 * Reference: https://www.youtube.com/watch?v=Yem67dViGSw
 * 
 * @author Austn Attaway
 * @author Chau Vu
 * @author Daniel Jiang
 * @version Spring 2021
 */
public class Player {
    
    /** The minimum allowed x position of the player. */
    public static final int MIN_X = 0;
    
    /** The minimum allowed y position of the player. */
    public static final int MIN_Y = 25;
    
    /** The maximum allowed x position of the player. */
    public static final int MAX_X = 512;
    
    /** The maximum allowed y position of the player. */
    public static final int MAX_Y = 475;
    
    /**
     * The value for the player's speed.
     * Represents how many pixels the player will move each game tick.
     */
    public static final int MOVE_SPEED = 4;
    
    /** The number of brains the player starts with. */
    public static final int START_BRAINS = 5;
    
    /** The maximum number of brains a player can have. */
    public static final int MAX_BRAINS = 10; 

    /** The initial x and y speed of the player. */
    private static final int NO_SPEED = 0;
    
    /** The initial x position of the player. */
    private static final int START_X = GameFrame.FRAME_WIDTH / 2 - 65;
    
    /** The initial y position of the player. */
    private static final int START_Y = GameFrame.FRAME_HEIGHT / 2 - 100;
     
    /**
     * A value used to delay animations.
     * Larger values will result in larger delays.
     */
    private static final int ANIMATION_DELAY = 4;

    /** This player's x current x position. */
    private int myX;
    
    /** This player's x current x position. */
    private int myY;
       
    /** The velocity of the player along the x axis. */
    private int myVelocityX;
    
    /** The velocity of the player along the y axis. */
    private int myVelocityY;
    
    /** The sprite sheet for this player. */
    private SpriteSheet mySpriteSheet;
    
    /** The current image of the player shown on the screen. */
    private BufferedImage myPlayerImage;
 
    /** The row the current player image is located at in the sprite sheet. */
    private int mySpriteRow;
    
    /** The column the current player image is located at in the sprite sheet. */
    private int mySpriteCol;
     
    /** The number of ticks elapsed, used for changing images in animations. */
    private int myTickCount;
    
    /** The number of brains(incorrect answers) remaining. */
    private int myBrainsRemaining;
     
    /**
     * Constructs a new player with default values.
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
        
        myBrainsRemaining = START_BRAINS;
    }

    /**
     * Updates the player's game state.
     * Should be called after each game tick.
     */
    public void updatePlayerTick() {
        // Updates the tick count (for use in animation).
        myTickCount++;
        if (myTickCount > Integer.MAX_VALUE) {
            myTickCount = 0;
        }
        
        myX += myVelocityX; 
        myY += myVelocityY;
        
        // Ensures the x and y position of the player
        // stays within the bounds.
        myX = Math.max(Math.min(myX,  MAX_X), MIN_X);
        myY = Math.max(Math.min(myY, MAX_Y), MIN_Y);
        
        updatePlayerImage();
    }    
    
    /**
     * Returns the x position of the player.
     * @return The x position of the player.
     */
    public int getXPosition() {
        return myX;
    }   
    
    /**
     * Returns the y position of the player.
     * @return The y position of the player.
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
     * Halts the player's movement along the x axis.
     */
    public void stopMovingX() {
        myVelocityX = NO_SPEED;
    }
    
    /**
     * Halts the player's movement along the y axis.
     */
    public void stopMovingY() {
        myVelocityY = NO_SPEED;
    }
      
    /**
     * Gets the image of the player.
     * @return The image of the player.
     */
    public BufferedImage getImage() {
        return myPlayerImage;
    }
 
    /**
     * Returns the number of brains this player has remaining.
     * @return the number of brains this player has remaining.
     */
    public int getBrainsremaining() {
        return myBrainsRemaining;
    }

    /**
     * Sets the remaining brains to the number of brains if the sum is less than the max number of brains.
     * @param theNumBrains The number of brains of the player.
     */
    public void setBrains(final int theNumBrains) {
        myBrainsRemaining = Math.min(MAX_BRAINS, theNumBrains);   
    }

    /**
     * Updates the player's sprite image depending on the game tick and 
     * the direction the character is moving.
     */
    private void updatePlayerImage() {
        if (myVelocityX != NO_SPEED || myVelocityY != NO_SPEED) {
            mySpriteCol = myTickCount / ANIMATION_DELAY % SpriteSheet.NUM_COLS + 1;
        }

        // Moving left.
        if (myVelocityX < NO_SPEED) {
            mySpriteRow = SpriteSheet.LEFT_MOVEMENT_ROW; 
        }
        // Moving right.
        else if (myVelocityX > NO_SPEED) {
            mySpriteRow = SpriteSheet.RIGHT_MOVEMENT_ROW;
        }
        
        // Moving up.
        if (myVelocityY < NO_SPEED) {
            mySpriteRow = SpriteSheet.UP_MOVEMENT_ROW;
        }
        // Moving down.
        else if (myVelocityY > NO_SPEED) {
            mySpriteRow = SpriteSheet.DOWN_MOVEMENT_ROW;
        } 
        
        // Moving down right.
        if ( myVelocityY > NO_SPEED && myVelocityX > NO_SPEED) {
            mySpriteRow = SpriteSheet.DOWN_RIGHT_MOVEMENT_ROW;
        }
        
        // Moving down left.
        if ( myVelocityY > NO_SPEED && myVelocityX < NO_SPEED ) {
            mySpriteRow = SpriteSheet.DOWN_LEFT_MOVEMENT_ROW;
        }

        // Moving up right.
        if ( myVelocityY < NO_SPEED && myVelocityX > NO_SPEED) {
            mySpriteRow = SpriteSheet.UP_RIGHT_MOVEMENT_ROW;
        }
        
        // Moving up left.
        if ( myVelocityY < NO_SPEED && myVelocityX < NO_SPEED ) {
            mySpriteRow = SpriteSheet.UP_LEFT_MOVEMENT_ROW;
        }
        
        // Stopped moving, so update the image to the stationary position.
        if (myVelocityX == 0 && myVelocityY == 0) {
            // myPlayerImage = mySpriteSheet.grabImage(SpriteSheet.NO_MOVEMENT_COL, mySpriteRow);
            mySpriteCol = SpriteSheet.NO_MOVEMENT_COL;
        }
        
        myPlayerImage = mySpriteSheet.grabImage(mySpriteCol, mySpriteRow);    
    }

    /**
     * Updates the player's current position as the players interact with the door to move rooms.
     * @param theDoorType The door position in its room (North/South/East/West).
     * @throws NullPointerException If the door type is null.
     */
    public void moveRooms(final Door.DoorType theDoorType) {
        Objects.requireNonNull(theDoorType, "theDoorType cannot be null");      
        if (theDoorType == Door.DoorType.NORTH) {
            myX = MAX_X / 2;
            myY = MAX_Y;
        }
        
        if (theDoorType == Door.DoorType.SOUTH) {
            myX = MAX_X / 2;
            myY = MIN_Y;
        }
        
        if (theDoorType == Door.DoorType.EAST) {
            myX = MIN_X;
            myY = MAX_Y / 2; 
        }
        
        if (theDoorType == Door.DoorType.WEST) {
            myX = MAX_X;
            myY = MAX_Y / 2;
        }
    }
}