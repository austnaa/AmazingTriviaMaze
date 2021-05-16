/**
 * Amazing Trivial Maze 
 * TCSS 360 Spring 2021
 */

package model;

// TODO don't like this class comment.
/**
 * Contains state and behavior appropriate for a particular Room.
 * 
 * @author Austn Attaway
 * @version May 14, 2021
 */
public class Room {
    
    /**
     * Whether or not this Room is the room the game starts in.
     */
    private boolean myIsStartRoom;
    
    /**
     * Whether or not this Room is the room the game ends in.
     */
    private boolean myIsEndRoom;
    
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
    public Room(final boolean theRoomIsStart, final boolean theRoomIsEnd,
            final Door theNorthDoor, final Door theSouthDoor,
            final Door theWestDoor, final Door theEastDoor) {
        
        myIsStartRoom = theRoomIsStart; 
        myIsEndRoom = theRoomIsEnd;
        
        myNorthDoor = theNorthDoor;
        mySouthDoor = theSouthDoor;   
        myWestDoor = theWestDoor;
        myEastDoor = theEastDoor;
        
    }
    
    /**
     * Interacts with this 
     */
    public Door interact(final Player thePlayer) {
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
     * Returns a String representation of this room.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Room: ");
        stringBuilder.append(System.lineSeparator());
        
        if (myIsStartRoom) {
            stringBuilder.append("Start room: true");
            stringBuilder.append(System.lineSeparator());
        } 
        if (myIsEndRoom) {
            stringBuilder.append("End room: true");
            stringBuilder.append(System.lineSeparator());
        }
        
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
