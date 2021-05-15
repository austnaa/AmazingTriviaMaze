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
     * Whether or not this door is currently locked.
     */
    private boolean myIsLocked;
    
    /**
     * Constructor that builds a door with default values.
     */
    public Door() {
        myIsLocked = true;
    }
    
    /**
     * Returns a string representation of a door.
     */
    public String toString() {
        return "I am a door";
    }
}
