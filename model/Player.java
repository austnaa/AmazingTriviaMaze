/**
 * Amazing Trivial Maze 
 * TCSS 360 Spring 2021
 */

package model;

/**
 * Contains state and behavior specific to the Player character.
 * 
 * @author Daniel Jiang
 * @author Austn Attaway
 * @version Spring 2021
 * Updated: May 14, 2021
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

    /**
     * The velocity of the player along the y axis. 
     */
    private int myVelocityY;
    
    /**
     * Constructs a new Player with default values.
     */
    public Player() {
        super();
        myX = START_X;
        myY = START_Y;
        myVelocityX = INITIAL_SPEED;
        myVelocityY = INITIAL_SPEED;
    }

    
    /**
     * Updates this Player's game state after one tick.
     */
    public void updatePlayerTick() {
        this.myX += myVelocityX; 
        this.myY += myVelocityY;
        
        // ensures the x and y position of the player
        // stays within the bounds
        myX = Math.max(Math.min(myX,  MAX_X), MIN_X);
        myY = Math.max(Math.min(myY, MAX_Y), MIN_Y);
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
    
}