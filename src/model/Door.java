/**
 * Amazing Trivial Maze 
 * TCSS 360 Spring 2021
 */

package model;

import view.GameFrame;

// TODO don't like this class comment.
/**
 * Contains state and behavior appropriate for a Door.
 * @author Austn Attaway
 * @version May 14, 2021
 */
public class Door {
    
    /** The x position of a north door. */
    private static final int NORTH_X = GameFrame.FRAME_WIDTH / 2;
    
    /** The y position of a north door. */
    private static final int NORTH_Y = 0;
    
    /** The x position of a south door */
    private static final int SOUTH_X = GameFrame.FRAME_WIDTH / 2;
    
    /** The y position of a south door */
    private static final int SOUTH_Y = GameFrame.FRAME_HEIGHT - 128;
    
    /** The x position of a west door */
    private static final int WEST_X = 0;
    
    /** The y position of a west door */
    private static final int WEST_Y = GameFrame.FRAME_HEIGHT / 2;
    
    /** The x position of an east door */
    private static final int EAST_X = GameFrame.FRAME_WIDTH;
    
    /** The y position of an east door */
    private static final int EAST_Y = GameFrame.FRAME_HEIGHT / 2;
    
    /**
     * The possible types of a door
     */
    public enum TYPE { NORTH, SOUTH, EAST, WEST };
    
    /**
     * The type of this door.
     */
    private TYPE myType;
    
    /**
     * The x position of this door
     */
    private int myX;
    
    /**
     * The y position of this door
     */
    private int myY;
    
    /**
     * Whether or not this door is currently locked.
     */
    private boolean myIsLocked;
    
    /**
     * Constructor that builds a door with default values.
     */
    public Door(TYPE theType) {
        myType = theType;
        setXYPosition();
        myIsLocked = true;
    }
    
    /**
     * Interact with this door if the player is close enough.  
     */
    public void interact(final Player thePlayer) {
        final int xDiff = Math.abs(thePlayer.getXPosition() - myX);
        final int yDiff = Math.abs(thePlayer.getYPosition() - myY);
//        System.out.println(xDiff + " " + yDiff + " " + myType);
        
        if (xDiff < 150 && yDiff < 150) {
            System.out.println("Interacted with a " + myType + " door");
        }
    }
    
    /**
     * Returns whether or not this door is locked
     * @return whether or not this door is locked
     */
    public boolean isLocked() {
        return myIsLocked;
    }
    
    /**
     * Returns the x position of this door.
     * @return the x position of this door.
     */
    public int getX() {
        return myX;
    }
    
    /**
     * Returns the y position of this door.
     * @return the y position of this door.
     */
    public int getY() {
        return myY;
    }
    
    /**
     * Returns the type of this door.
     * @return the type of this door.
     */
    public TYPE getType() {
        return myType;
    }
    
    /**
     * Returns a String representation of a door.
     */
    public String toString() {
        return "I am a door, type: " + myType;
    }
    
    /**
     * Sets the x and y position depending on the type this door is.
     */
    private void setXYPosition() {
        switch (myType) {
            case NORTH: 
                myX = NORTH_X;
                myY = NORTH_Y;
                break;
            case SOUTH:
                myX = SOUTH_X;
                myY = SOUTH_Y;
                break;
            case WEST: 
                myX = WEST_X;
                myY = WEST_Y;
                break;
            case EAST: 
                myX = EAST_X;
                myY = EAST_Y;
                
                break;
        }
    }
}
