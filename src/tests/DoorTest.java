package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import model.Door;
import model.Player;
import model.question.Question;

/**
 * JUnit test class for the Room class.  
 * @author Chau Vu
 * @version Spring 2021
 */
public class DoorTest {

    /**
     * The North Door of the Room.
     */
    private Door myDoorNorth;
    
    /**
     * The South Door of the Room.
     */
    private Door myDoorSouth;
    
    /**
     * The West Door of the Room.
     */
    private Door myDoorWest;
    
    /**
     * The East Door of the Room.
     */
    private Door myDoorEast;
    
    /**
     * The player of the game.
     */
    private Player myPlayer;

    /**
     * A child class that inherits abstract Question class.
     * For testing purposes
     * @author Chau Vu
     * @version Spring 2021
     */
    public class Dummy extends Question
    {
        /**
         * Dummy class constructor.
         * @param theQuestion - the question 
         * @param theType - the type of question
         */
        public Dummy(String theQuestion, QuestionType theType) {
            super(theQuestion, theType); 
        }
        /**
         * Overriding the answerQuestion method for testing purposes.
         */
        @Override
        public void answerQuestion(final Player thePlayer) {
            if (this.getType() == Question.QuestionType.TRUE_FALSE) {
                setAnsweredAlready(true);
            }
        }
    }
    
    /**
     * A child class that inherits abstract Question class.
     */
    private Dummy myQuestion;
    
    /**
     * Set up method before tests.
     */
    @Before
    public void setUp() {
<<<<<<< HEAD
        myPlayer = new Player();
        myQuestion = new Dummy("This is for testing", Question.QuestionType.TRUE_FALSE);;
        myDoorNorth = new Door(Door.TYPE.NORTH, myQuestion);
        myDoorSouth = new Door(Door.TYPE.SOUTH, myQuestion);
        myDoorWest = new Door(Door.TYPE.WEST, myQuestion);
        myDoorEast = new Door(Door.TYPE.EAST, myQuestion);
    }
    /**
     * Test if the player is not null.
     */
    @Test
    public void testPlayerNotNull() {
        assertNotNull(myPlayer);   
=======
>>>>>>> 0017fd2750813dc0a949bceb627f4145c33e5a6e
    }
    
    /**
     * Test if the question is not null.
     */
    @Test
    public void testQuestioNotNul() {
        assertNotNull(myQuestion);
    }
    
    /**
     * Test if the doors is not null.
     */
    @Test
    public void testDoorNotNull() {
        assertNotNull(myDoorNorth);
        assertNotNull(myDoorSouth);
        assertNotNull(myDoorWest);
        assertNotNull(myDoorEast);    
    }
    
    /**
     * Test if Player is near South door.
     */
    @Test
    public void testIsCloseEnoughSouth() {
        myPlayer.moveRooms(Door.TYPE.SOUTH);
        assertEquals("There's no door near", true, myDoorNorth.isCloseEnough(myPlayer));    
    }
    /**
     * Test if Player is near North door.
     */
    @Test
    public void testIsCloseEnougNorth() {
        myPlayer.moveRooms(Door.TYPE.NORTH);
        assertEquals("There's no door near", true, myDoorSouth.isCloseEnough(myPlayer));    
    }
    
    /**
     * Test if Player is near East door.
     */
    @Test
    public void testIsCloseEnoughEast() {
        myPlayer.moveRooms(Door.TYPE.EAST);
        assertEquals("There's no door near", true, myDoorWest.isCloseEnough(myPlayer));    
    }
    
    /**
     * Test if Player is near West door.
     */
    @Test
    public void testIsCloseEnoughWest() {
        myPlayer.moveRooms(Door.TYPE.WEST);
        assertEquals("There's no door near", true, myDoorEast.isCloseEnough(myPlayer));    
    }
    
    /**
     * Test the X position of the Door West. 
     */
    @Test
    public void testSetXPositionWest() {
        myPlayer.moveRooms(Door.TYPE.WEST);
        assertEquals("Wrong location for door!", myDoorWest.getX(), Door.WEST_X);
    }
    
    /**
     * Test the X position of the Door East
     */
    @Test
    public void testSetXPositionEast() {
        myPlayer.moveRooms(Door.TYPE.EAST);
        assertEquals("Wrong location for door!", myDoorEast.getX(), Door.EAST_X);
    }
    
    /**
     * Test the X position of the Door South. 
     */
    @Test
    public void testSetXPositionSouth() {
        myPlayer.moveRooms(Door.TYPE.SOUTH);
        assertEquals("Wrong location for door!", myDoorSouth.getX(), Door.SOUTH_X);
    }
    
    /**
     * Test the X position of the Door North. 
     */
    @Test
    public void testSetXPositionNorth() {
        myPlayer.moveRooms(Door.TYPE.NORTH);
        assertEquals("Wrong location for door!", myDoorNorth.getX(), Door.NORTH_X);
    }
    
    /**
     * Test the Y position of the Door West. 
     */
    @Test
    public void testSetYPositionWest() {
        myPlayer.moveRooms(Door.TYPE.WEST);
        assertEquals("Wrong location for door!", myDoorWest.getY(), Door.WEST_Y);
    }
    
    /**
     * Test the Y position of the Door East
     */
    @Test
    public void testSetYPositionEast() {
        myPlayer.moveRooms(Door.TYPE.EAST);
        assertEquals("Wrong location for door!", myDoorEast.getY(), Door.EAST_Y);
    }
    
    /**
     * Test the Y position of the Door South. 
     */
    @Test
    public void testSetYPositionSouth() {
        myPlayer.moveRooms(Door.TYPE.SOUTH);
        assertEquals("Wrong location for door!", myDoorSouth.getY(), Door.SOUTH_Y);
    }
    
    /**
     * Test the Y position of the Door North. 
     */
    @Test
    public void testSetYPositionNorth() {
        myPlayer.moveRooms(Door.TYPE.NORTH);
        assertEquals("Wrong location for door!", myDoorNorth.getY(), Door.NORTH_Y);
    }
    
    /**
     * Test toString method for Door class.
     */
    @Test
    public void testToString() {
        assertEquals("toString() not working properly", myDoorNorth.toString(), "I am a door, type: " + myDoorNorth.getType());
    }
    
    /**
     * Test the getter method for question.
     */
    @Test
    public void testGetQuestion() {
        assertEquals("get method for question is not working", myDoorNorth.getQuestion(), myQuestion);
    }
    
    /**
     * Test if the door is locked.
     */
    @Test
    public void testIsLockedTrue() {
        assertEquals("MyDoor value isn't correct", myDoorNorth.isLocked(), true);
    }
    
    /**
     * Test if the door is locked. 
     * False case.
     */
    @Test
    public void testIsLockedFalse() {
        myQuestion.answerQuestion(myPlayer);
        assertEquals("MyDoor value isn't correct ", myDoorNorth.isLocked(), false);
    }
    
    /**
     * Test interact method when door is locked.
     */
    @Test
    public void testInteractDoorLocked() {
        myPlayer.moveRooms(Door.TYPE.SOUTH);
        myDoorNorth.interact(myPlayer);
        myQuestion.answerQuestion(myPlayer);
        assertEquals("MyQuestion isn't answered", myQuestion.getAnsweredAlready(), true);
        assertEquals("MyDoor value isn't correct", myDoorNorth.isLocked(), false);
    }
    
    /**
     * Test interact method when door is not close enough.
     */
    @Test
    public void testInteractDoorNull() {
        assertEquals("interact() isn't working", myDoorNorth.interact(myPlayer), null); 
    }
    
    /**
     * Test interact method when door is not locked.
     */
    @Test
    public void testInteractDoorNotLocked() {
        myQuestion.answerQuestion(myPlayer);    
        myPlayer.moveRooms(Door.TYPE.SOUTH);
        myDoorNorth.isCloseEnough(myPlayer);
        assertEquals("interact() isn't working", myDoorNorth, myDoorNorth.interact(myPlayer));
    }
}
    
