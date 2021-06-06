/**
 * Amazing Trivia Maze
 * TCSS 360 Spring 2021
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Door;
import model.Room;
import model.question.Option;
import model.question.TrueFalseQuestion;

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
    
    /** The room. */
    private Room myRoom;
    
    /** The question text. */
    private String myQuestionText;
    
    /** The answer option. */
    private Option myAnswer;
    
    /** The incorrect option. */
    private Option myIncorrectOption;
    
    /** True/False question. */
    private TrueFalseQuestion myTrueFalseQuestion;
    
    /**
     * Set up for the test class.
     */
    @Before
    public void setUp() {
        myHasBeenVisited = false;
        
        myQuestionText = "Question";
        myTrueFalseQuestion = new TrueFalseQuestion(myQuestionText, myAnswer, myIncorrectOption);
        
        myNorthDoor = new Door(Door.TYPE.NORTH, myTrueFalseQuestion);
        mySouthDoor = new Door(Door.TYPE.SOUTH, myTrueFalseQuestion);
        myWestDoor = new Door(Door.TYPE.WEST, myTrueFalseQuestion);
        myEastDoor = new Door(Door.TYPE.EAST, myTrueFalseQuestion);
        
        myRoom = new Room(false, myNorthDoor, mySouthDoor, myWestDoor, myEastDoor);
    }
    
//	/**
//	 * Tests a null North door.
//	 */
//	@Test(expected = NullPointerException.class)
//	public void testNullNorthDoor() {
//		myRoom = new Room(false, null, mySouthDoor, myWestDoor, myEastDoor);
//	}

    @Test
    public void testRoom() {
        fail("Not yet implemented");
    }

    @Test
    public void testInteract() {
        fail("Not yet implemented");
    }

    @Test
    public void testHasNorthDoor() {
        fail("Not yet implemented");
    }

    @Test
    public void testHasSouthDoor() {
        fail("Not yet implemented");
    }

    @Test
    public void testHasWestDoor() {
        fail("Not yet implemented");
    }

    @Test
    public void testHasEastDoor() {
        fail("Not yet implemented");
    }

    @Test
    public void testSetVisited() {
        fail("Not yet implemented");
    }

    @Test
    public void testIsVisited() {
        fail("Not yet implemented");
    }

    @Test
    public void testIsEndRoom() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetSouthDoor() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetEastDoor() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetNorthDoor() {
        fail("Not yet implemented");
    }

    @Test
    public void testGetWestDoor() {
        fail("Not yet implemented");
    }

    @Test
    public void testToString() {
        fail("Not yet implemented");
    }

}