/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package model;

import java.util.Objects;

/**
 * Contains state and behavior appropriate for a particular Room within a maze.
 * @author Austn Attaway
 * @version Spring 2021
 */
public class Room {
    
    /** Whether or not this Room is the room the game ends in. */
    private boolean myIsEndRoom;
    
    /** Whether or not this Room has been visited yet. */
    private boolean myHasBeenVisited;

    /**
     * The Door that is located at to the North of the room.
     * Is null if the Door does not exist. 
     */
    private Door myNorthDoor;
    
    /**
     * The Door that is located to the South of the room.
     * Is null if the Door does not exist.
     */
    private Door mySouthDoor;
    
    /**
     * The Door that is located to the West of the room.
     * Is null if the Door does not exist.
     */
    private Door myWestDoor;
    
    /**
     * The Door that is located to the East of the room.
     * Is null if the Door does not exist.
     */
    private Door myEastDoor;
    
    /**
     * Private default constructor to inhibit its use.
     */
    private Room() {
        
    }
    
    /**
     * Constructor that builds a Room corresponding to the given input.
     * 
     * @param theRoomIsStart  whether or not this room is the starting room.
     * @param theRoomIsFinish whether or not this room is the finish room.
     * @param theNorthDoor    the Room located to the north (null if there isn't a door)
     * @param theSouthDoor    the Room located to the south (null if there isn't a door)
     * @param theWestDoor     the Room located to the east  (null if there isn't a door)
     * @param theEastDoor     the Room located to the west  (null if there isn't a door)
     */
    public Room(final boolean theRoomIsEnd,
            final Door theNorthDoor, final Door theSouthDoor,
            final Door theWestDoor, final Door theEastDoor) {
         
        myIsEndRoom = theRoomIsEnd;
        myHasBeenVisited = false;
        
        myNorthDoor = Objects.requireNonNull(theNorthDoor, "The North Door cannot be null!");
        mySouthDoor = Objects.requireNonNull(theSouthDoor, "The South Door cannot be null!");   
        myWestDoor = Objects.requireNonNull(theWestDoor, "The West Door cannot be null!");
        myEastDoor = Objects.requireNonNull(theEastDoor, "The East Door cannot be null!");
    }
    
    /**
     * Allows the given player to interact with this Room.
     * @throws NullPointerException if thePlayer is null
     */
    public Door interact(final Player thePlayer) {
        Objects.requireNonNull(thePlayer, "thePlayer can not be null");
        Door interactedDoor = null;
        // try and interact with all of the available doors
        
        if (myNorthDoor != null) {
            final Door temp = myNorthDoor.interact(thePlayer);
            if (temp != null) {
                interactedDoor = temp;
            }
        } 
        if (mySouthDoor != null) {
            final Door temp = mySouthDoor.interact(thePlayer);
            if (temp != null) {
                interactedDoor = temp;
            }
        }
        if (myWestDoor != null) {
            final Door temp = myWestDoor.interact(thePlayer);
            if (temp != null) {
                interactedDoor = temp;
            }
        }
        if (myEastDoor != null) {
            final Door temp = myEastDoor.interact(thePlayer);
            if (temp != null) {
                interactedDoor = temp;
            }
        }
        return interactedDoor;
    }
    
    /**
     * Returns whether or not this room has a north door.
     * @return whether or not this room has a north door.
     */
    public boolean hasNorthDoor() {
        return myNorthDoor != null;
    }
    
    /**
     * Returns whether or not this room has a south door.
     * @return whether or not this room has a south door.
     */
    public boolean hasSouthDoor() {
        return mySouthDoor != null;
    }
    
    /**
     * Returns whether or not this room has a west door.
     * @return whether or not this room has a west door.
     */
    public boolean hasWestDoor() {
        return myWestDoor != null;
    }
    
    /**
     * Returns whether or not this room has a east door.
     * @return whether or not this room has a east door.
     */
    public boolean hasEastDoor() {
        return myEastDoor != null;
    }
    
    /**
     * Update this Room's state to indicate it has been visited.
     */
    public void setVisited() {
        myHasBeenVisited = true;
    }
    
    /**
     * Returns whether or not this room has been visited.
     * @return whether or not this room has been visited.
     */
    public boolean isVisited() {
        return myHasBeenVisited;
    }
    /**
     * Returns whether or not this is the last room.
     * @return whether or not this is the last room.
     */
    public boolean isEndRoom() {
        return myIsEndRoom;
    }
    
    /**
     * Returns this Room's southern door. 
     * Will return null if this Room does not have a southern door.
     * 
     * @return this Room's southern door if it exists, null otherwise.
     */
    public Door getSouthDoor() {
        return mySouthDoor;
    }
    
    /**
     * Returns this Room's eastern door. 
     * Will return null if this Room does not have a eastern door.
     * 
     * @return this Room's western door if it exists, null otherwise.
     */
    public Door getEastDoor() {
        return myEastDoor;
    }
    
    /**
     * Returns this Room's northern door. 
     * Will return null if this Room does not have a northern door.
     * 
     * @return this Room's northern door if it exists, null otherwise.
     */
    public Door getNorthDoor() {
        return myNorthDoor;
    }
    
    /**
     * Returns this Room's western door. 
     * Will return null if this Room does not have a western door.
     * 
     * @return this Room's western door if it exists, null otherwise.
     */
    public Door getWestDoor() {
        return myWestDoor;
    }
   
   /**
    * Returns a String representation of this room.
    */
   @Override
   public String toString() {
       StringBuilder stringBuilder = new StringBuilder();
       stringBuilder.append("Room: ");
       stringBuilder.append(System.lineSeparator());
            
       // end room?
       stringBuilder.append("End room: " + myIsEndRoom);
       stringBuilder.append(System.lineSeparator());

       // doors
       stringBuilder.append("Door status:");
       stringBuilder.append(System.lineSeparator());
       
       stringBuilder.append("North: ");
       stringBuilder.append(myNorthDoor != null);
       stringBuilder.append(System.lineSeparator());
       
       stringBuilder.append("South: ");
       stringBuilder.append(mySouthDoor != null);
       stringBuilder.append(System.lineSeparator());
       
       stringBuilder.append("East: ");
       stringBuilder.append(myEastDoor != null);
       stringBuilder.append(System.lineSeparator());
       
       stringBuilder.append("West: ");
       stringBuilder.append(myWestDoor != null);
       stringBuilder.append(System.lineSeparator());
       
       
       return stringBuilder.toString();
   }
}