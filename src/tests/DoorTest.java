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
import model.question.Question;
import tests.mock_objects.QuestionMock;

/**
 * JUnit test class for the room class.  
 * @author Chau Vu
 * @version Spring 2021
 */
public class DoorTest {

    /** The North door of the room. */
    private Door myDoorNorth;
    
    /** The South door of the room. */
    private Door myDoorSouth;
    
    /** The West door of the room. */
    private Door myDoorWest;
    
    /** The East door of the room. */
    private Door myDoorEast;
    
    /** The player of the game. */
    private Player myPlayer;
    
    /** A child class that inherits the abstract question class. */
    private QuestionMock myQuestion;
    
    /**
     * The setup method before tests.
     */
    @Before
    public void setUp() {
        myPlayer = new Player();
        myQuestion = new QuestionMock("This is for testing", Question.QuestionType.TRUE_FALSE);;
        myDoorNorth = new Door(Door.DoorType.NORTH, myQuestion);
        myDoorSouth = new Door(Door.DoorType.SOUTH, myQuestion);
        myDoorWest = new Door(Door.DoorType.WEST, myQuestion);
        myDoorEast = new Door(Door.DoorType.EAST, myQuestion);
    }
    
    /**
     * Expects a null pointer exception if pass in a null door type.
     */
    @Test (expected = NullPointerException.class)
    public void testTypeNullDoor() {
        myDoorNorth = new Door(null, myQuestion);
    }
    
    /**
     * Expects a null pointer exception if pass in a null question.
     */
    @Test (expected = NullPointerException.class)
    public void testTypeNullQuestion() {
        myDoorNorth = new Door(Door.DoorType.NORTH, null);
    }
    
    /**
     * Expects a null pointer exception if pass in a null question and door type.
     */
    @Test (expected = NullPointerException.class)
    public void testTypeNullQuestionDoor() {
        myDoorNorth = new Door(null, null);
    }
    
    /**
     * Expects a null pointer exception if pass in a null player.
     */
    @Test (expected = NullPointerException.class)
    public void testInteractnullPlayer() {
        myDoorNorth.interact(null);
    }
    
    /**
     * Expects a null pointer exception if pass in a null player.
     */
    @Test (expected = NullPointerException.class)
    public void testIsCloseEnoughNull() {
        myDoorNorth.isCloseEnough(null);
    }
    
    /**
     * Tests if the player is not null.
     */
    @Test
    public void testPlayerNotNull() {
        assertNotNull(myPlayer);   
    }
    
    /**
     * Tests if the question is not null.
     */
    @Test
    public void testQuestioNotNul() {
        assertNotNull(myQuestion);
    }
    
    /**
     * Tests if the doors is not null.
     */
    @Test
    public void testDoorNotNull() {
        assertNotNull(myDoorNorth);
        assertNotNull(myDoorSouth);
        assertNotNull(myDoorWest);
        assertNotNull(myDoorEast);    
    }
    
    /**
     * Tests if the player is near the South door.
     */
    @Test
    public void testIsCloseEnoughSouth() {
        myPlayer.moveRooms(Door.DoorType.SOUTH);
        assertEquals("There's no door near", true, myDoorNorth.isCloseEnough(myPlayer));    
    }
    /**
     * Tests if the player is near the North door.
     */
    @Test
    public void testIsCloseEnougNorth() {
        myPlayer.moveRooms(Door.DoorType.NORTH);
        assertEquals("There's no door near", true, myDoorSouth.isCloseEnough(myPlayer));    
    }
    
    /**
     * Tests if the player is near the East door.
     */
    @Test
    public void testIsCloseEnoughEast() {
        myPlayer.moveRooms(Door.DoorType.EAST);
        assertEquals("There's no door near", true, myDoorWest.isCloseEnough(myPlayer));    
    }
    
    /**
     * Tests if the player is near the West door.
     */
    @Test
    public void testIsCloseEnoughWest() {
        myPlayer.moveRooms(Door.DoorType.WEST);
        assertEquals("There's no door near", true, myDoorEast.isCloseEnough(myPlayer));    
    }
    
    /**
     * Test the x position of the West door. 
     */
    @Test
    public void testSetXPositionWest() {
        myPlayer.moveRooms(Door.DoorType.WEST);
        assertEquals("Wrong location for door!", myDoorWest.getX(), Door.WEST_X);
    }
    
    /**
     * Test the x position of the East door.
     */
    @Test
    public void testSetXPositionEast() {
        myPlayer.moveRooms(Door.DoorType.EAST);
        assertEquals("Wrong location for door!", myDoorEast.getX(), Door.EAST_X);
    }
    
    /**
     * Test the x position of the South door.
     */
    @Test
    public void testSetXPositionSouth() {
        myPlayer.moveRooms(Door.DoorType.SOUTH);
        assertEquals("Wrong location for door!", myDoorSouth.getX(), Door.SOUTH_X);
    }
    
    /**
     * Test the x position of the North door.
     */
    @Test
    public void testSetXPositionNorth() {
        myPlayer.moveRooms(Door.DoorType.NORTH);
        assertEquals("Wrong location for door!", myDoorNorth.getX(), Door.NORTH_X);
    }
    
    /**
     * Test the y position of the West door.
     */
    @Test
    public void testSetYPositionWest() {
        myPlayer.moveRooms(Door.DoorType.WEST);
        assertEquals("Wrong location for door!", myDoorWest.getY(), Door.WEST_Y);
    }
    
    /**
     * Test the y position of the Eest door.
     */
    @Test
    public void testSetYPositionEast() {
        myPlayer.moveRooms(Door.DoorType.EAST);
        assertEquals("Wrong location for door!", myDoorEast.getY(), Door.EAST_Y);
    }
    
    /**
     * Test the y position of the South door.
     */
    @Test
    public void testSetYPositionSouth() {
        myPlayer.moveRooms(Door.DoorType.SOUTH);
        assertEquals("Wrong location for door!", myDoorSouth.getY(), Door.SOUTH_Y);
    }
    
    /**
     * Test the y position of the North door.
     */
    @Test
    public void testSetYPositionNorth() {
        myPlayer.moveRooms(Door.DoorType.NORTH);
        assertEquals("Wrong location for door!", myDoorNorth.getY(), Door.NORTH_Y);
    }
    
    /**
     * Tests the to string method of the door.
     */
    @Test
    public void testToString() {
        assertEquals("toString() not working properly", myDoorNorth.toString(), "I am a door, type: " + myDoorNorth.getType());
    }
    
    /**
     * Tests the getter method for the question.
     */
    @Test
    public void testGetQuestion() {
        assertEquals("get method for question is not working", myDoorNorth.getQuestion(), myQuestion);
    }
    
    /**
     * Tests if the door is locked.
     */
    @Test
    public void testIsLockedTrue() {
        assertEquals("MyDoor value isn't correct", myDoorNorth.isLocked(), true);
    }
    
    /**
     * Tests if the door is locked.
     */
    @Test
    public void testIsLockedFalse() {
        myQuestion.answerQuestion(myPlayer);
        assertEquals("MyDoor value isn't correct ", myDoorNorth.isLocked(), false);
    }
    
    /**
     * Tests the interact method when door is locked.
     */
    @Test
    public void testInteractDoorLocked() {
        myPlayer.moveRooms(Door.DoorType.SOUTH);
        myDoorNorth.interact(myPlayer);
        myQuestion.answerQuestion(myPlayer);
        assertEquals("MyQuestion isn't answered", myQuestion.getAnsweredAlready(), true);
        assertEquals("MyDoor value isn't correct", myDoorNorth.isLocked(), false);
    }
    
    /**
     * Tests the interact method when door is not close enough.
     */
    @Test
    public void testInteractDoorNull() {
        assertEquals("interact() isn't working", myDoorNorth.interact(myPlayer), null); 
    }
    
    /**
     * Tests the interact method when door is not locked.
     */
    @Test
    public void testInteractDoorNotLocked() {
        myQuestion.answerQuestion(myPlayer);    
        myPlayer.moveRooms(Door.DoorType.SOUTH);
        myDoorNorth.isCloseEnough(myPlayer);
        assertEquals("interact() isn't working", myDoorNorth, myDoorNorth.interact(myPlayer));
    }
}