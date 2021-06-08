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
     * The door that is located at to the North of the room.
     * Is null if the door doesn't exist. 
     */
    private Door myNorthDoor;
    
    /**
     * The door that is located to the South of the room.
     * Is null if the door doesn't exist.
     */
    private Door mySouthDoor;
    
    /**
     * The door that is located to the West of the room.
     * Is null if the door doesn't exist.
     */
    private Door myWestDoor;
    
    /**
     * The door that is located to the East of the room.
     * Is null if the door doesn't exist.
     */
    private Door myEastDoor;
    
    /**
     * Private default constructor to inhibit its use.
     */
    private Room() {
        
    }
    
    /**
     * Constructor that builds a room corresponding to the given input.
     * @param theRoomIsStart  If this room is the starting room.
     * @param theRoomIsFinish If this room is the finish room.
     * @param theNorthDoor    The room located to the North (null if there isn't a door).
     * @param theSouthDoor    The room located to the South (null if there isn't a door).
     * @param theWestDoor     The room located to the East  (null if there isn't a door).
     * @param theEastDoor     The room located to the West  (null if there isn't a door).
     */
    public Room(final boolean theRoomIsEnd,
            final Door theNorthDoor, final Door theSouthDoor,
            final Door theWestDoor, final Door theEastDoor) {
         
        myIsEndRoom = theRoomIsEnd;
        myHasBeenVisited = false;

        myNorthDoor = theNorthDoor;
        mySouthDoor = theSouthDoor;
        myWestDoor = theWestDoor;
        myEastDoor = theEastDoor;
        
    }
    
    /**
     * Allows the given player to interact with this room.
     * @param thePlayer The player that interacts with the room.
     * @throws NullPointerException If the player is null.
     */
    public Door interact(final Player thePlayer) {
        Objects.requireNonNull(thePlayer, "thePlayer can not be null");
        Door interactedDoor = null;
        // Tries to interact with all of the available doors.
        
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
     * Returns if this room has a North door.
     * @return If this room has a North door.
     */
    public boolean hasNorthDoor() {
        return myNorthDoor != null;
    }
    
    /**
     * Returns if this room has a South door.
     * @return If this room has a South door.
     */
    public boolean hasSouthDoor() {
        return mySouthDoor != null;
    }
    
    /**
     * Returns if this room has a West door.
     * @return if this room has a West door.
     */
    public boolean hasWestDoor() {
        return myWestDoor != null;
    }
    
    /**
     * Returns if this room has a East door.
     * @return If this room has a East door.
     */
    public boolean hasEastDoor() {
        return myEastDoor != null;
    }
    
    /**
     * Update this room's state to indicate it has been visited.
     */
    public void setVisited() {
        myHasBeenVisited = true;
    }
    
    /**
     * Returns if this room has been visited.
     * @return If this room has been visited.
     */
    public boolean isVisited() {
        return myHasBeenVisited;
    }
    /**
     * Returns if this is the last room.
     * @return If this is the last room.
     */
    public boolean isEndRoom() {
        return myIsEndRoom;
    }
    
    /**
     * Returns this room's South door, null otherwise.
     * @return This room's South door, null otherwise.
     */
    public Door getSouthDoor() {
        return mySouthDoor;
    }
    
    /**
     * Returns this room's East door, null otherwise.
     * @return This room's East door, null otherwise.
     */
    public Door getEastDoor() {
        return myEastDoor;
    }
    
    /**
     * Returns this room's North door, null otherwise.
     * @return This room's North door, null otherwise.
     */
    public Door getNorthDoor() {
        return myNorthDoor;
    }
    
    /**
     * Returns this room's West door, null otherwise.
     * @return This room's West door, null otherwise.
     */
    public Door getWestDoor() {
        return myWestDoor;
    }
   
   /**
    * Returns a string representation of rooms.
    */
   @Override
   public String toString() {
       final String newLine = "\n";
       StringBuilder stringBuilder = new StringBuilder();
       stringBuilder.append("Room: ");
       stringBuilder.append(newLine);
            
       // End room.
       stringBuilder.append("End room: " + myIsEndRoom);
       stringBuilder.append(newLine);

       // Doors.
       stringBuilder.append("Door status: ");
       stringBuilder.append(newLine);
       
       stringBuilder.append("North: ");
       stringBuilder.append(myNorthDoor != null);
       stringBuilder.append(newLine);
       
       stringBuilder.append("South: ");
       stringBuilder.append(mySouthDoor != null);
       stringBuilder.append(newLine);
       
       stringBuilder.append("East: ");
       stringBuilder.append(myEastDoor != null);
       stringBuilder.append(newLine);
       
       stringBuilder.append("West: ");
       stringBuilder.append(myWestDoor != null);
       stringBuilder.append(newLine);
       
       return stringBuilder.toString();
   }
}