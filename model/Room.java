package model;

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
    
    // TODO NOT UPDATED TO SHOW IF IT IS A START OR END ROOM
    /**
     * Returns a String representation of this room.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("I am a room");
        stringBuilder.append(System.lineSeparator());
        
        stringBuilder.append("Start room: " + myIsStartRoom);
        stringBuilder.append(System.lineSeparator());
        
        stringBuilder.append("End room: " + myIsEndRoom);
        stringBuilder.append(System.lineSeparator());
        
        stringBuilder.append("My north door: ");
        stringBuilder.append(myNorthDoor);
        stringBuilder.append(System.lineSeparator());
        
        stringBuilder.append("My south door: ");
        stringBuilder.append(mySouthDoor);
        stringBuilder.append(System.lineSeparator());
        
        stringBuilder.append("My east door: ");
        stringBuilder.append(myEastDoor);
        stringBuilder.append(System.lineSeparator());
        
        stringBuilder.append("My west door: ");
        stringBuilder.append(myWestDoor);
        stringBuilder.append(System.lineSeparator());
        
        return stringBuilder.toString();
    }
}
