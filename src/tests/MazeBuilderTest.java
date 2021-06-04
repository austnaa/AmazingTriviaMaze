package tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import model.MazeBuilder;
import model.Room;
import model.question.QuestionManager;

/**
 * JUnit test class for the model.MazeBuilder class.
 * 
 * @author Austn Attaway
 * @version Spring 2021
 */
public class MazeBuilderTest {
    
    private static final String MAP_TEXT_1 = "map1.txt";
    
    private static final String ROOM_TEXT_1 = "YYYY";
    
    private QuestionManager myQuestionManager;
    private Room[][] myNullMaze;
    
    /**
     * Sets up the test fixtures before each test.
     */
    @Before
    public void setUp() { 
        myQuestionManager = new QuestionManager();
        myNullMaze = new Room[1][1];
    }

   
    
    
    // test for exceptions from the buildMaze method
    
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
        MazeBuilder.buildMaze(MAP_TEXT_1, null);
    }
    
    /**
     * Tests the MazeBuilder buildMaze method for a 
     * FileNotFoundException given a file name that does not exist
     */
    @Test(expected = FileNotFoundException.class)
    public void testBuildMazeFileNotFound() throws NullPointerException, FileNotFoundException {
        MazeBuilder.buildMaze("notafilename", myQuestionManager);
    }
    
    
    // test for exceptions from the buildRoom method
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













