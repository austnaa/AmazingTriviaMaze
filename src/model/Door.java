/**
 * Amazing Trivial Maze 
 * TCSS 360 Spring 2021
 */

package model;

// TODO don't like this class comment.
/**
 * Contains state and behavior appropriate for a Door.
 * @author Austn Attaway
 * @version May 14, 2021
 */
public class Door {
    
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
        myX = 0;
        myY = 0;
        myIsLocked = true;
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
}
