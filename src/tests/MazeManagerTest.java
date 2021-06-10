/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package tests;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import model.Door;
import model.MazeManager;
import model.Room;
import tests.mock_objects.QuestionManagerMock;

/**
 * A JUnit test class for the maze manager class.
 * @author Austn Attaway
 * @version Spring 2021
 */
public class MazeManagerTest {
    
    /** The mock question manager used for testing. */
    private QuestionManagerMock myQuestionManagerMock;
    
    /** The maze manager used for testing. */
    private MazeManager myMazeManager;
    
    /**
     * Sets up the test fixtures before each test.
     */
    @Before
    public void setUp() {
        myQuestionManagerMock = new QuestionManagerMock();
        myMazeManager = new MazeManager(myQuestionManagerMock);
    }
    
    /**
     * Tests the maze manager constructor to throw a
     * NullPointerException if the given
     * question manager interface is null.
     */
    @Test(expected = NullPointerException.class)
    public void testMazeManagerNullQuestionManager() {
        new MazeManager(null);
    }
    
    /**
     * Tests the maze manager constructor to populate
     * the maze list properly and set an initial maze.
     */
    @Test
    public void testMazeManager() {
        boolean result = true;
        
        // make sure that there are 4 mazes set by the constructor
        for (int i = 0; i < 3; i++) {
            if (myMazeManager.getCurrentMaze() == null) {
                result = false;
            }
            if (myMazeManager.getCurrentRoom() == null) {
                result = false;
            }
            myMazeManager.setNewMaze();
        }
       
        assertTrue("the MazeManager constructor did not work properly", result);
    }
    
    /**
     * Tests the set new maze method to ensure that it sets 
     * up to 3 new mazes (4 total unique mazes) before 
     * looping back on itself.
     */
    @Test
    public void testSetNewMaze4UniqueMazes() {
        Set<Room[][]> mazeSet = new HashSet<>();
        Room[][] tempMaze;
        
        for (int i = 0; i < 4; i++) {
            tempMaze = myMazeManager.getCurrentMaze();
            mazeSet.add(tempMaze);
            myMazeManager.setNewMaze();
        }
        
        assertEquals("setNewMaze failed to creat at least 4 unique mazes.",
                mazeSet.size(), 4);  
    }
    
    /**
     * Tests the maze manager to ensure that new mazes created after all 
     * mazes have been used will be new objects.
     */
    @Test
    public void testSetNewMaze100UniqueMazeObjects() {
        Set<Room[][]> mazeSet = new HashSet<>();
        Room[][] tempMaze;
        final int targetNumMazes = 13;
        
        for (int i = 0; i < targetNumMazes; i++) {
            tempMaze = myMazeManager.getCurrentMaze();
            mazeSet.add(tempMaze);
            myMazeManager.setNewMaze();
        }
        
        assertEquals("setNewMaze failed to creat at least 4 unique mazes.",
                mazeSet.size(), targetNumMazes);  
    }
    
    /**
     * Tests the move rooms method for a NullPointerException 
     * when a null door type is passed.
     */
    @Test(expected = NullPointerException.class)
    public void testMoveRoomsNullDoorType() {
        myMazeManager.moveRooms(null);
    }
    
    /**
     * Tests the move rooms method to ensure that 
     * it is possible to move North.
     */
    @Test
    public void testMoveRoomsNorth() {
        final Room expectedRoom = myMazeManager.getCurrentMaze()[0][0];
        
        // Move down so we are able to move back up and test that movement.
        myMazeManager.moveRooms(Door.DoorType.SOUTH);
        myMazeManager.moveRooms(Door.DoorType.NORTH);
        
        assertEquals("the moveRooms method failed to move the current room north",
                expectedRoom, myMazeManager.getCurrentRoom());
    }
    
    /**
     * Tests the move rooms method to ensure that it 
     * is possible to move South.
     */
    @Test
    public void testMoveRoomsSouth() {
        final Room expectedRoom = myMazeManager.getCurrentMaze()[1][0];
        
        myMazeManager.moveRooms(Door.DoorType.SOUTH);
        
        assertEquals("the moveRooms method failed to move the current room south",
                expectedRoom, myMazeManager.getCurrentRoom());
    }
    
    /**
     * Tests the move rooms method to ensure that it 
     * is possible to move West.
     */
    @Test
    public void testMoveRoomsWest() {
        final Room expectedRoom = myMazeManager.getCurrentMaze()[0][0];
        
        // Move East so we are able to go back to where we started and test moving West.
        myMazeManager.moveRooms(Door.DoorType.EAST);
        myMazeManager.moveRooms(Door.DoorType.WEST);
        
        assertEquals("the moveRooms method failed to move the current room west", expectedRoom, myMazeManager.getCurrentRoom());
        
    }
    
    /**
     * Tests the move rooms method to ensure that it 
     * is possible to move East.
     */
    @Test
    public void testMoveRoomsEast() {
        final Room expectedRoom = myMazeManager.getCurrentMaze()[0][1];
        
        myMazeManager.moveRooms(Door.DoorType.EAST);
        
        assertEquals("the moveRooms method failed to move the current room east",
                expectedRoom, myMazeManager.getCurrentRoom());
    }
     
    /**
     * Tests the move rooms method to ensure that it does
     * not allow us to move north when it will result in 
     * going out of bounds. 
     */
    @Test
    public void testMoveRoomsOutOfBoundsNorth() {
        final Room expectedRoom = myMazeManager.getCurrentRoom();
        myMazeManager.moveRooms(Door.DoorType.NORTH);
        assertEquals("the moveRooms method did not prohibit a northern out of bounds movement", 
                expectedRoom, myMazeManager.getCurrentRoom());
    }
    
    /**
     * Tests the move rooms method to ensure that it does
     * not allow us to move south when it will result in 
     * going out of bounds. 
     */     
    @Test
    public void testMoveRoomsOutOfBoundsSouth() {
        final int numRows = myMazeManager.getCurrentMaze().length;
        for (int i = 0; i < numRows - 1; i++) {
            myMazeManager.moveRooms(Door.DoorType.SOUTH);
        }
        
        final Room expectedRoom = myMazeManager.getCurrentRoom();
        myMazeManager.moveRooms(Door.DoorType.SOUTH);
        assertEquals("the moveRooms method did not prohibit a southern out of bounds movement", 
                expectedRoom, myMazeManager.getCurrentRoom());
    }
    
    /**
     * Tests the move rooms method to ensure that it does
     * not allow us to move west when it will result in 
     * going out of bounds. 
     */
    @Test
    public void testMoveRoomsOutOfBoundsWest() {
        final Room expectedRoom = myMazeManager.getCurrentRoom();
        myMazeManager.moveRooms(Door.DoorType.WEST);
        assertEquals("the moveRooms method did not prohibit a western out of bounds movement", 
                expectedRoom, myMazeManager.getCurrentRoom());
    }
    
    /**
     * Tests the move rooms method to ensure that it does
     * not allow us to move east when it will result in 
     * going out of bounds. 
     */
    @Test
    public void testMoveRoomsOutOfBoundsEast() {
        final int numCols = myMazeManager.getCurrentMaze()[0].length;
        for (int i = 0; i < numCols - 1; i++) {
            myMazeManager.moveRooms(Door.DoorType.EAST);
        }
        
        final Room expectedRoom = myMazeManager.getCurrentRoom();
        myMazeManager.moveRooms(Door.DoorType.EAST);
        assertEquals("the moveRooms method did not prohibit a eastern out of bounds movement", 
                expectedRoom, myMazeManager.getCurrentRoom());
    }
    
    /**
     * Test to ensure that moving to a room sets that room to be visited.
     */
    @Test
    public void testMoveRoomsSetCurrentRoomsVisited() {
        boolean result = true;

        // Check initial.
        if (!myMazeManager.getCurrentRoom().isVisited()) {
            result = false;            
        }
        
        // Check move East.
        myMazeManager.moveRooms(Door.DoorType.EAST);
        if (!myMazeManager.getCurrentRoom().isVisited()) {
            result = false;            
        }
        
        // Check move South.
        myMazeManager.moveRooms(Door.DoorType.SOUTH);
        if (!myMazeManager.getCurrentRoom().isVisited()) {
            result = false;            
        }
        
        // Check move West.
        myMazeManager.moveRooms(Door.DoorType.WEST);
        if (!myMazeManager.getCurrentRoom().isVisited()) {
            result = false;            
        }
        
        // Check move North (move the current room to a location where
        // moving North results in moving into a previously unvisited room).
        myMazeManager.moveRooms(Door.DoorType.SOUTH);
        myMazeManager.moveRooms(Door.DoorType.EAST);
        myMazeManager.moveRooms(Door.DoorType.EAST);
        myMazeManager.moveRooms(Door.DoorType.NORTH);
        if (!myMazeManager.getCurrentRoom().isVisited()) {
            result = false;            
        }
        
        assertTrue("the moveRooms method failed to set the rooms it moved to visited.",
                result);
    }
}