/**
 * Amazing Trivia Maze
 * TCSS 360 Spring 2021
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Door;
import model.Player;
import model.Room;
import model.question.Option;
import model.question.Question;
import model.question.TrueFalseQuestion;
import tests.mock_objects.QuestionMock;

/**
 * Test class for maze rooms.
 * @author Daniel Jiang
 * @author Chau Vu
 * @version Spring 2021
 */
public class RoomTest {
    
    /** Whether or not the current room has been visited before. */
    private boolean myHasBeenVisited;
    
    /** The North door. */
    private Door myNorthDoor;
    
    /** The South door. */
    private Door mySouthDoor;
    
    /** The West door. */
    private Door myWestDoor;
    
    /** The East door. */
    private Door myEastDoor;
    
    /**
     * the Player of the game.
     */
    private Player myPlayer;
    /**
     * the interacted door.
     */
    private Door myInteractedDoor;
    
    /** The room. */
    private Room myRoom;
    
    /**
     * A child class that inherits abstract Question class.
     */
    private QuestionMock myQuestion;
    
    /**
     * Set up for the test class.
     */
    @Before
    public void setUp() {
        myPlayer = new Player();
        myInteractedDoor = null;
        myHasBeenVisited = false;
        myQuestion = new QuestionMock("This is for testing", Question.QuestionType.TRUE_FALSE);;
        myNorthDoor = new Door(Door.DoorType.NORTH, myQuestion);
        mySouthDoor = new Door(Door.DoorType.SOUTH, myQuestion);
        myWestDoor = new Door(Door.DoorType.WEST, myQuestion);
        myEastDoor = new Door(Door.DoorType.EAST, myQuestion);
        
        myRoom = new Room(false, myNorthDoor, mySouthDoor, myWestDoor, myEastDoor);
    }
    
    /**
     * Test if the true/false question object is not null.
     */
    @Test
    public void testQuestionNotNull() {
        assertNotNull(myQuestion);
    }
    
    /**
     * Test if the north door is not null.
     */
    @Test
    public void testNorthDoorNotNull() {
        assertNotNull(myNorthDoor);
    }

    /**
     * Test if the West door is not null.
     */
    @Test
    public void testWestDoorNotNull() {
        assertNotNull(myWestDoor);
    }
    
    /**
     * Test if the south door is not null.
     */
    @Test
    public void testSouthDoorNotNull() {
        assertNotNull(mySouthDoor);
    }
    
    /**
     * Test if the east door is not null.
     */
    @Test
    public void testEastDoorNotNull() {
        assertNotNull(myEastDoor);
    }
    
    /**
     * Test if the player is not null.
     */
    @Test
    public void testPlayerNotNull() {
        assertNotNull(myPlayer);
    }

    /**
     * expecting a null pointer exception when passing in a null player.
     */
    @Test (expected = NullPointerException.class)
    public void testInteractPlayerNotNull() {
        myNorthDoor.interact(null);
    }
    
    /**
     * Testing if the interact method returns the North door.
     */
    @Test
    public void testInteractNorthDoor() {
        myQuestion.answerQuestion(myPlayer);    
        myPlayer.moveRooms(Door.DoorType.SOUTH);
        myNorthDoor.isCloseEnough(myPlayer);;
        myInteractedDoor = myRoom.interact(myPlayer);
        assertNotNull(myInteractedDoor);
        assertEquals("Interact() method isn't working", myInteractedDoor, myRoom.interact(myPlayer));
    }
    
    /**
     * Testing if the interact method returns the South door.
     */
    @Test
    public void testInteractSouthDoor() {
        myQuestion.answerQuestion(myPlayer);    
        myPlayer.moveRooms(Door.DoorType.NORTH);
        mySouthDoor.isCloseEnough(myPlayer);;
        myInteractedDoor = myRoom.interact(myPlayer);
        assertNotNull(myInteractedDoor);
        assertEquals("Interact() method isn't working", myInteractedDoor, myRoom.interact(myPlayer));
    }
      
    /**
     * Testing if the interact method returns the West door.
     */
    @Test
    public void testInteractWestDoor() {
        myQuestion.answerQuestion(myPlayer);    
        myPlayer.moveRooms(Door.DoorType.EAST);
        myWestDoor.isCloseEnough(myPlayer);;
        myInteractedDoor = myRoom.interact(myPlayer);
        assertNotNull(myInteractedDoor);
        assertEquals("Interact() method isn't working", myInteractedDoor, myRoom.interact(myPlayer));
    }
    
    /**
     * Testing if the interact method returns the East door.
     */
    @Test
    public void testInteractEastDoor() {
        myQuestion.answerQuestion(myPlayer);    
        myPlayer.moveRooms(Door.DoorType.WEST);
        myEastDoor.isCloseEnough(myPlayer);;
        myInteractedDoor = myRoom.interact(myPlayer);
        assertNotNull(myInteractedDoor);
        assertEquals("Interact() method isn't working", myInteractedDoor, myRoom.interact(myPlayer));
    }
    
    /**
     * Testing if the interact method returns the East door.
     */
    @Test
    public void testInteractNullDoor() {
        assertNull(myInteractedDoor);
        assertEquals("Interact() method isn't working", myInteractedDoor, myRoom.interact(myPlayer));
    } 
    
    /**
     * Testing if the room has a north door.
     */
    @Test
    public void testHasNorthDoor() {
        assertEquals("hasNorthDoor() method isn't working", true, myRoom.hasNorthDoor());
    }

    /**
     * Testing if the room has a south door.
     */
    @Test
    public void testHasSouthDoor() {
        assertEquals("hasSouthDoor() method isn't working", true, myRoom.hasSouthDoor());
    }

    /**
     * Testing if the room has a west door.
     */
    @Test
    public void testHasWestDoor() {
        assertEquals("hasWestDoor() method isn't working", true, myRoom.hasWestDoor());
    }

    /**
     * Testing if the room has an east door.
     */
    @Test
    public void testHasEastDoor() {
        assertEquals("hasEastDoor() method isn't working", true, myRoom.hasEastDoor());
    }
    
    /**
     * Testing if the room has an North door.
     * false condition.
     */
    @Test
    public void testHasNorthDoorNull() {
        myRoom = new Room(false, null, mySouthDoor, myWestDoor, myEastDoor);
        assertEquals("hasNorthDoor() method isn't working", false, myRoom.hasNorthDoor());
    }
    
    /**
     * Testing if the room has an South door.
     * false condition.
     */
    @Test
    public void testHasSouthDoorNull() {
        myRoom = new Room(false, myNorthDoor, null, myWestDoor, myEastDoor);
        assertEquals("hasSouthDoor() method isn't working", false, myRoom.hasSouthDoor());
    }
    
    /**
     * Testing if the room has an East door.
     * false condition.
     */
    @Test
    public void testHasEastDoorNull() {
        myRoom = new Room(false, myNorthDoor, mySouthDoor, myWestDoor, null);
        assertEquals("hasEastDoor() method isn't working", false, myRoom.hasEastDoor());
    }
    
    /**
     * Testing if the room has an West door.
     * false condition.
     */
    @Test
    public void testHasWestDoorNull() {
        myRoom = new Room(false, myNorthDoor, mySouthDoor, null, myEastDoor);
        assertEquals("hasWestDoor() method isn't working", false, myRoom.hasWestDoor());
    }

    /**
     * Testing if the room is visited.
     */
    @Test
    public void testSetVisited() {
        myRoom.setVisited();
        assertEquals("setVisited() method isn't working", true, myRoom.isVisited());
        
    }
    
    /**
     * Testing if the room is visited.
     */
    @Test
    public void testIsVisited() {
        assertEquals("isVisited() method isn't working", false, myRoom.isVisited());
        
    }
    
    /**
     * Testing if this is the end room false.
     */
    @Test
    public void testIsNotEndRoom() {
        assertEquals("isEndRoom() method isn't working", false, myRoom.isEndRoom());
    }
    
    /**
     * Testing if this is the end room true.
     */
    @Test
    public void testIsEndRoom() {
        myRoom = new Room(true, myNorthDoor, mySouthDoor, null, myEastDoor);
        assertEquals("isEndRoom() method isn't working", true, myRoom.isEndRoom());
    }
    
    /**
     * Test getter method for South door.
     */
    @Test
    public void testGetSouthDoor() {
        assertEquals("getSouthDoor() method isn't working", mySouthDoor, myRoom.getSouthDoor());
    }

    /**
     * Test getter method for East door.
     */
    @Test
    public void testGetEastDoor() {
        assertEquals("getEastDoor() method isn't working", myEastDoor, myRoom.getEastDoor());
    }

    /**
     * Test getter method for North door.
     */
    @Test
    public void testGetNorthDoor() {
        assertEquals("getNorthDoor() method isn't working", myNorthDoor, myRoom.getNorthDoor());
    }

    /**
     * Test getter method for West door.
     */
    @Test
    public void testGetWestDoor() {
        assertEquals("getWestDoor() method isn't working", myWestDoor, myRoom.getWestDoor());
    }

    /**
     * Test the toString method for this class.
     */
    @Test
    public void testToString() {
        assertEquals("toString() isn't working", myRoom.toString(), "Room: \n"
                + "End room: false\n"
                + "Door status: \n"
                + "North: true\n"
                + "South: true\n"
                + "East: true\n"
                + "West: true\n");
    }

    /**
     * Test the toString method for this class.
     */
    @Test
    public void testToStringNullNorthDoor() {
        myRoom = new Room(false, null, mySouthDoor, myWestDoor, myEastDoor);
        assertEquals("toString() isn't working", myRoom.toString(), "Room: \n"
                + "End room: false\n"
                + "Door status: \n"
                + "North: false\n"
                + "South: true\n"
                + "East: true\n"
                + "West: true\n");
    }
    
    /**
     * Test the toString method for this class.
     */
    @Test
    public void testToStringNullSouthDoor() {
        myRoom = new Room(false, myNorthDoor, null, myWestDoor, myEastDoor);
        assertEquals("toString() isn't working", myRoom.toString(), "Room: \n"
                + "End room: false\n"
                + "Door status: \n"
                + "North: true\n"
                + "South: false\n"
                + "East: true\n"
                + "West: true\n");
    }
    
    /**
     * Test the toString method for this class.
     */
    @Test
    public void testToStringNullEastDoor() {
        myRoom = new Room(false, myNorthDoor, mySouthDoor, myWestDoor, null);
        assertEquals("toString() isn't working", myRoom.toString(), "Room: \n"
                + "End room: false\n"
                + "Door status: \n"
                + "North: true\n"
                + "South: true\n"
                + "East: false\n"
                + "West: true\n");
    }
    
    /**
     * Test the toString method for this class.
     */
    @Test
    public void testToStringNullWestDoor() {
        myRoom = new Room(false, myNorthDoor, mySouthDoor, null, myEastDoor);
        assertEquals("toString() isn't working", myRoom.toString(), "Room: \n"
                + "End room: false\n"
                + "Door status: \n"
                + "North: true\n"
                + "South: true\n"
                + "East: true\n"
                + "West: false\n");
    }
}