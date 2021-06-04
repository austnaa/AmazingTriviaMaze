/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */

package tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import model.MazeBuilder;
import model.Room;
import model.question.QuestionManager;
import tests.mock_objects.QuestionManagerMock;

/**
 * JUnit test class for the model.MazeBuilder class.
 * 
 * @author Austn Attaway
 * @version Spring 2021
 */
public class MazeBuilderTest {
    
    private static final String MAP_TEXT_1x1_NO_DOORS = "test_map1.txt";
    private static final String MAP_TEXT_1x1_ALL_DOORS = "test_map2.txt";
    private static final String MAP_TEXT_2x2 = "test_map3.txt";
    
    private static final String ROOM_TEXT_1 = "YYYY";
    
    private QuestionManager myQuestionManager;
    private QuestionManagerMock myQuestionManagerMock;
    private Room[][] myNullMaze;
    
    /**
     * Sets up the test fixtures before each test.
     */
    @Before
    public void setUp() { 
        myQuestionManager = new QuestionManager();
        myQuestionManagerMock = new QuestionManagerMock();
        myNullMaze = new Room[1][1];
    }


    // ***** test for exceptions from the buildMaze method *****
    /**
     * Tests the MazeBuilder buildMaze method for a 
     * NullPointerException given a null fileName String
     */
    @Test(expected = NullPointerException.class)
    public void testBuildMazeNullFileName() throws NullPointerException, FileNotFoundException {
        MazeBuilder.buildMaze(null, myQuestionManager);
    }
    
    /**
     * Tests the MazeBuilder buildMaze method for a 
     * NullPointerException given a null QuestionManager
     */
    @Test(expected = NullPointerException.class)
    public void testBuildMazeNullQuestionManager() throws NullPointerException, FileNotFoundException {
        MazeBuilder.buildMaze(MAP_TEXT_1x1_NO_DOORS, null);
    }
    
    /**
     * Tests the MazeBuilder buildMaze method for a 
     * FileNotFoundException given a file name that does not exist
     */
    @Test(expected = FileNotFoundException.class)
    public void testBuildMazeFileNotFound() throws NullPointerException, FileNotFoundException {
        MazeBuilder.buildMaze("notafilename", myQuestionManager);
    }
    
    
    // ***** test for exceptions from the buildRoom method *****
    /**
     * Tests to ensure that the MazeManager buildMaze method throws a NullPointerException
     * given a room string that is null.
     */
    @Test(expected = NullPointerException.class)
    public void testBuildRoomNullRoomString() {
        MazeBuilder.buildRoom(null, null, null, 0, 0);
    }
    
    /**
     * Tests to ensure that the MazeManager buildMaze method throws a NullPointerException
     * given a QuestionManager that is null.
     */
    @Test(expected = NullPointerException.class)
    public void testBuildRoomNullQuestionManager() {
        MazeBuilder.buildRoom(ROOM_TEXT_1, null, null, 0, 0);
    }
    
    /**
     * Tests to ensure that the MazeManager buildMaze method throws a NullPointerException
     * given a Maze that is null.
     */
    @Test(expected = NullPointerException.class)
    public void testBuildRoomNullMaze() {
        MazeBuilder.buildRoom(ROOM_TEXT_1, myQuestionManager, null, 0, 0);
    }
    
    /**
     * Tests to ensure that the MazeManager buildMaze method throws an IllegalArgumentException
     * given an invalid room string.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testBuildRoomInvalidRoomStringLength() {
        MazeBuilder.buildRoom("", myQuestionManager, myNullMaze, 0, 0);
    }
    
    /**
     * Tests to ensure that the MazeManager buildMaze method throws an IllegalArgumentException
     * given a negative row value.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testBuildRoomNegativeRow() {
        MazeBuilder.buildRoom(ROOM_TEXT_1, myQuestionManager, myNullMaze, -1, 0);
    }
    
    /**
     * Tests to ensure that the MazeManager buildMaze method throws an IllegalArgumentException
     * given a negative column value.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testBuildRoomNegativeCol() {
        MazeBuilder.buildRoom(ROOM_TEXT_1, myQuestionManager, myNullMaze, 0, -1);
    }
    
    // ***** test functionality of buildMaze method ******
    /**
     * Tests the buildMaze method with the test_map1.txt file that builds 
     * a 1x1 maze with no doors
     */
    @Test
    public void testBuildRoom1x1NoDoors() throws FileNotFoundException {
        final Room[][] resultMaze = MazeBuilder.buildMaze(MAP_TEXT_1x1_NO_DOORS, myQuestionManagerMock);
        boolean result = true;

        // check for the expected size
        if (resultMaze.length != 1 || resultMaze[0].length != 1) {
            result = false;
        }
        
        // check to ensure there aren't any doors on the room
        final Room room = resultMaze[0][0];
        if (room.hasNorthDoor() || room.hasSouthDoor() ||
                room.hasEastDoor() || room.hasWestDoor() || room.isMyIsEndRoom()) {
            result = false;
        }

        assertTrue("buildRoom method failed to build a 1x1 room with no doors.", result);
    }
    
    /**
     * Tests the buildMaze method with the test_map2.txt file that builds 
     * a 1x1 maze with all doors
     */
    @Test
    public void testBuildRoom1x1AllDoors() throws FileNotFoundException {
        final Room[][] resultMaze = MazeBuilder.buildMaze(MAP_TEXT_1x1_ALL_DOORS, myQuestionManagerMock);
        boolean result = true;

        // check for the expected size
        if (resultMaze.length != 1 || resultMaze[0].length != 1) {
            result = false;
        }
        
        // check to ensure there aren't any doors on the room
        final Room room = resultMaze[0][0];
        if (!(room.hasNorthDoor() || room.hasSouthDoor() ||
                room.hasEastDoor() || room.hasWestDoor() || room.isMyIsEndRoom())) {
            result = false;
        }

        assertTrue("buildRoom method failed to build a 1x1 room with all doors.", result);
    }
    
    /**
     * Tests the buildMaze method with the test_map3.txt file that builds 
     * a 2x2 maze with various different connecting rooms.
     */
    @Test
    public void testBuildRoom2x2() throws FileNotFoundException {
        final Room[][] resultMaze = MazeBuilder.buildMaze(MAP_TEXT_2x2, myQuestionManagerMock);
        boolean result = true;
        
        // check maze for expected size
        if (resultMaze.length != 2 || resultMaze[0].length != 2) {
            result = false;
        }
        
        // check to ensure that each room is as expected
        // check the top left room (should have only a south and east door)
        Room tempRoom = resultMaze[0][0];
        if (!(!tempRoom.hasNorthDoor() && tempRoom.hasSouthDoor() &&
                tempRoom.hasEastDoor() && !tempRoom.hasWestDoor())) {
            result = false;
        }
        
        // check the top right room (should only have a east and west door)
        tempRoom = resultMaze[0][1];
        if (!(!tempRoom.hasNorthDoor() && !tempRoom.hasSouthDoor() &&
                tempRoom.hasEastDoor() && tempRoom.hasWestDoor())) {
            result = false;
        }
        
        // check the bottom left room (should have north, south, and east doors)
        tempRoom = resultMaze[1][0];
        if (!(tempRoom.hasNorthDoor() && tempRoom.hasSouthDoor() && 
                tempRoom.hasEastDoor() && !tempRoom.hasWestDoor())) {
            result = false;
        }
        
        // check bottom right room (only west and north doors
        tempRoom = resultMaze[1][1];
        if (!(!tempRoom.hasNorthDoor() && tempRoom.hasSouthDoor() && 
                !tempRoom.hasEastDoor() && tempRoom.hasWestDoor())) {
            result = false;
        }
        assertTrue("buildRoom failed to build a 2x2 room", result);          
    }
    
    
    
    
    
    
    
    // ***** test functionality of buildRoom method ******
    
    
    
    
    
    
    
    
    
    
    

}


/* METHODS TO BE TESTED: 
 * 
 * 1. buildMaze
 * -filenotfound from string DONE
 * -nullpointer from string DONE
 * -nullpointer questionmanager DONE
 * -check to ensure that a room matrix is built properly
 *          -1x1 room
 *          -2x2 rooms
 *          
 * 2. buildRoom
 * -theRoomString null DONE
 * -theMaze isnnull DONE
 * -theQmanager is null DONE
 * -theRoomString length < 4 DONE
 * -illegal args if theRow < 0 or theCol < 0
 * 
 * -test different room strings
 * -YYYY
 * -NNNN
 * -@YYYY
 * -$YYYY
 * -@YNYN
 * -$NYNY
 * 
 */













