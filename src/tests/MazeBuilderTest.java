/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */

package tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import model.Door;
import model.MazeBuilder;
import model.Room;
import tests.mock_objects.QuestionManagerMock;

/**
 * JUnit test class for the model.MazeBuilder class.
 * 
 * @author Austn Attaway
 * @version Spring 2021
 */
public class MazeBuilderTest {
    
    /** A String used when creating rooms when you don't want any doors. */ 
    private static final String ROOM_TEXT = "NNNN";
    
    /** The file name for a map with a 1x1 maze with a single room with no doors. */
    private static final String MAP_TEXT_1x1_NO_DOORS = "test_map1.txt";
    
    /** The file name for a map with a 1x1 maze with a single room with no doors. */
    private static final String MAP_TEXT_1x1_ALL_DOORS = "test_map2.txt";
    
    /** The file name for a map with a 2x2 maze with varying rooms. */
    private static final String MAP_TEXT_2x2 = "test_map3.txt";
    
    /**
     * A Mock QuestionManager used for testing.
     */
    private QuestionManagerMock myQuestionManagerMock;
    
    /**
     * An instantiated empty maze used for testing.
     */
    private Room[][] myNullMaze;
    
    /**
     * Sets up the test fixtures before each test.
     */
    @Before
    public void setUp() { 
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
        MazeBuilder.buildMaze(null, myQuestionManagerMock);
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
        MazeBuilder.buildMaze("notafilename", myQuestionManagerMock);
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
        MazeBuilder.buildRoom(ROOM_TEXT, null, null, 0, 0);
    }
    
    /**
     * Tests to ensure that the MazeManager buildMaze method throws a NullPointerException
     * given a Maze that is null.
     */
    @Test(expected = NullPointerException.class)
    public void testBuildRoomNullMaze() {
        MazeBuilder.buildRoom(ROOM_TEXT, myQuestionManagerMock, null, 0, 0);
    }
    
    /**
     * Tests to ensure that the MazeManager buildMaze method throws an IllegalArgumentException
     * given an invalid room string.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testBuildRoomInvalidRoomStringLength() {
        MazeBuilder.buildRoom("", myQuestionManagerMock, myNullMaze, 0, 0);
    }
    
    /**
     * Tests to ensure that the MazeManager buildMaze method throws an IllegalArgumentException
     * given a negative row value.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testBuildRoomNegativeRow() {
        MazeBuilder.buildRoom(ROOM_TEXT, myQuestionManagerMock, myNullMaze, -1, 0);
    }
    
    /**
     * Tests to ensure that the MazeManager buildMaze method throws an IllegalArgumentException
     * given a negative column value.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testBuildRoomNegativeCol() {
        MazeBuilder.buildRoom(ROOM_TEXT, myQuestionManagerMock, myNullMaze, 0, -1);
    }
    
    // ***** test functionality of buildMaze method ******
    /**
     * Tests the buildMaze method with the test_map1.txt file that builds 
     * a 1x1 maze with no doors
     */
    @Test
    public void testBuildMaze1x1NoDoors() throws FileNotFoundException {
        final Room[][] resultMaze = MazeBuilder.buildMaze(MAP_TEXT_1x1_NO_DOORS, myQuestionManagerMock);
        boolean result = true;

        // check for the expected size
        if (resultMaze.length != 1 || resultMaze[0].length != 1) {
            result = false;
        }
        
        // check to ensure there aren't any doors on the room
        final Room room = resultMaze[0][0];
        if (room.hasNorthDoor() || room.hasSouthDoor() ||
                room.hasEastDoor() || room.hasWestDoor() || room.isEndRoom()) {
            result = false;
        }

        assertTrue("buildMaze method failed to build a 1x1 maze with a single room with no doors.", result);
    }
    
    /**
     * Tests the buildMaze method with the test_map2.txt file that builds 
     * a 1x1 maze with all doors
     */
    @Test
    public void testBuildMaze1x1AllDoors() throws FileNotFoundException {
        final Room[][] resultMaze = MazeBuilder.buildMaze(MAP_TEXT_1x1_ALL_DOORS, myQuestionManagerMock);
        boolean result = true;

        // check for the expected size
        if (resultMaze.length != 1 || resultMaze[0].length != 1) {
            result = false;
        }
        
        // check to ensure there aren't any doors on the room
        final Room room = resultMaze[0][0];
        if (!(room.hasNorthDoor() || room.hasSouthDoor() ||
                room.hasEastDoor() || room.hasWestDoor() || room.isEndRoom())) {
            result = false;
        }

        assertTrue("buildMaze method failed to build a 1x1 maze with a "
                + "single room with all doors.", result);
    }
    
    /**
     * Tests the buildMaze method with the test_map3.txt file that builds 
     * a 2x2 maze with various different connecting rooms.
     */
    @Test
    public void testBuildMaze2x2() throws FileNotFoundException {
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
        assertTrue("buildRoom failed to build a 2x2 maze", result);          
    }
    
 
    // ***** test functionality of buildRoom method ******
    
    /**
     * Tests the buildRoom method trying to build a room that has no doors.
     */
    @Test
    public void testBuildRoomNoDoors() {
        final String noDoorString = "NNNN";
        final Room[][] tempMaze = new Room[1][1];
        final Room resultRoom = MazeBuilder.buildRoom(noDoorString, 
                myQuestionManagerMock, tempMaze, 0, 0);
         
        boolean result = true;
        // check to ensure there aren't any doors in the room
        if (resultRoom.hasNorthDoor() || resultRoom.hasSouthDoor() ||
                resultRoom.hasEastDoor() || resultRoom.hasWestDoor() || resultRoom.isEndRoom()) {
            result = false;
        }
        
        assertTrue("buildRoom failed to build a room with no doors", result);
    }
    
    /**
     * Tests the buildRoom method trying to build
     * a room that has only south and east doors. 
     */
    @Test
    public void testBuildRoomSouthEastDoors() {
        final String southEastRoomString = "NYNY";
        final Room[][] tempMaze = new Room[1][1];
        final Room resultRoom = MazeBuilder.buildRoom(southEastRoomString, 
                myQuestionManagerMock, tempMaze, 0, 0);
         
        boolean result = true;
        if (resultRoom.hasNorthDoor() || !resultRoom.hasSouthDoor() ||
                !resultRoom.hasEastDoor() || resultRoom.hasWestDoor() || resultRoom.isEndRoom()) {
            result = false;
        }
        
        assertTrue("buildRoom failed to build a room with east and south doors.", result);
    }
    
    /**
     * Tests the buildRoom method trying to build
     * a room that has a west door that shares a question with 
     * its leftmost neighbor. 
     */
    @Test
    public void testBuildRoomWestDoor() {
        final String westDoorRoomString = "NNYN";
        
        // create the room that will be to the west of the door we want to create        
        final Room westRoom = new Room(false, null, null, null,
                new Door(Door.TYPE.EAST, myQuestionManagerMock.getRandomQuestion()));
        
        final Room[][] tempMaze = new Room[1][2];
        tempMaze[0][0] = westRoom;
        
        final Room resultRoom = MazeBuilder.buildRoom(westDoorRoomString, 
                myQuestionManagerMock, tempMaze, 0, 1);
         
        boolean result = true;
        if (resultRoom.hasNorthDoor() || resultRoom.hasSouthDoor() ||
                resultRoom.hasEastDoor() || !resultRoom.hasWestDoor()) {
            result = false;
        }

        // make sure the two rooms share the same question 
        if (result && !resultRoom.getWestDoor().getQuestion().equals(westRoom.getEastDoor().getQuestion())) {
            result = false;
        }
        
        
        assertTrue("buildRoom failed to build a room with a west door.", result);
    }
    
    
    /**
     * Tests the buildRoom method trying to build
     * a room that has a north door that shares a question with 
     * its northern neighbor. 
     */
    @Test
    public void testBuildRoomNorthDoor() {
        final String northDoorRoomString = "YNNN";
        
        // create the northern room
        final Room northRoom = new Room(false, null, 
                new Door(Door.TYPE.SOUTH, myQuestionManagerMock.getRandomQuestion()), null, null);
        
        final Room[][] tempMaze = new Room[2][1];
        tempMaze[0][0] = northRoom;
        
        final Room resultRoom = MazeBuilder.buildRoom(northDoorRoomString, 
                myQuestionManagerMock, tempMaze, 1, 0);
       
        boolean result = true;
        if (!resultRoom.hasNorthDoor() || resultRoom.hasSouthDoor() ||
                resultRoom.hasEastDoor() || resultRoom.hasWestDoor()) {
            result = false;
        }

        // make sure the two rooms share the same question 
        if (result && !resultRoom.getNorthDoor().getQuestion().equals(northRoom.getSouthDoor().getQuestion())) {
            result = false;
        }
        
        assertTrue("buildRoom failed to build a room with a north door.", result);
    }
    
    /**
     * Tests the buildRoom method trying to build 
     * a room that has all doors. 
     */
    @Test
    public void testBuildRoomAllDoors() {
        final String allDoorRoomString = "YYYY";
        
        // create the northern room and western room that will share questions with the resultRoom
        final Room northRoom = new Room(false, null, 
                new Door(Door.TYPE.SOUTH, myQuestionManagerMock.getRandomQuestion()), null, null);
        // create the room that will be to the west of the door we want to create        
        final Room westRoom = new Room(false, null, null, null,
                new Door(Door.TYPE.EAST, myQuestionManagerMock.getRandomQuestion()));
        
        final Room[][] tempMaze = new Room[2][2];
        tempMaze[0][1] = northRoom;
        tempMaze[1][0] = westRoom;
        
        final Room resultRoom = MazeBuilder.buildRoom(allDoorRoomString, 
                myQuestionManagerMock, tempMaze, 1, 1);
        

        // ensure the result room has all doors
        boolean result = true;
        if (!resultRoom.hasNorthDoor() || !resultRoom.hasSouthDoor() ||
                !resultRoom.hasEastDoor() || !resultRoom.hasWestDoor()) {
            result = false;
        }
        
        // ensure result room shares north question
        if (result && !resultRoom.getNorthDoor().getQuestion().equals(northRoom.getSouthDoor().getQuestion())) {
            result = false;
        }
        
        // ensure result room shares west question
        if (result && !resultRoom.getWestDoor().getQuestion().equals(westRoom.getEastDoor().getQuestion())) {
            result = false;
        }
        
        assertTrue("buildRoom failed to build a room with all doors.", result);
        
    }
    
    /**
     * Tests the buildRoom method trying to build 
     * an end room.
     */
    @Test
    public void testBuildIsEndRoom() {
        final String endRoomString = "$NNNN";
        final Room[][] tempMaze = new Room[1][1];
        final Room resultRoom = MazeBuilder.buildRoom(endRoomString, 
                myQuestionManagerMock, tempMaze, 0, 0);
         
        boolean result = resultRoom.isEndRoom();
        assertTrue("buildRoom failed to build an end room", result);
    }
    
    /**
     * Tests the buildRoom method trying to build 
     * an end room.
     */
    @Test
    public void testBuildIsNotEndRoom() {
        final String noEndRoomString = "NNNN";
        final Room[][] tempMaze = new Room[1][1];
        final Room resultRoom = MazeBuilder.buildRoom(noEndRoomString, 
                myQuestionManagerMock, tempMaze, 0, 0);
         
        boolean result = !resultRoom.isEndRoom();
        assertTrue("buildRoom failed by building an end room when it shouldn't have.", result);
    }
    
}