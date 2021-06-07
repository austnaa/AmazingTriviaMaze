/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */

package model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import model.question.QuestionManagerInterface;

/**
 * Builds and maintains the collection of possible mazes the game can pick 
 * from and the current maze that is being used in the current game.
 * 
 * @author Austn Attaway
 * @version Spring 2021
 */
public class MazeManager {
    
    /** The file name of maze 1. */
    private static final String MAZE_1 = "map1.txt";
    
    /** The file name of maze 2. */
    private static final String MAZE_2 = "map2.txt";
    
    /** The file name of maze 3. */
    private static final String MAZE_3 = "map3.txt";
    
    /** The file name of maze 4. */
    private static final String MAZE_4 = "map4.txt";
    
    /** A List of Room matrices that have been used in the current program's execution. */
    private List<Room[][]> myMazes;
    
    /** The current Maze the game is displaying. */
    private Room[][] myCurrentMaze;
    
    /** The room in the current maze the player is located in. */
    private Room myCurrentRoom;
    
    /** The 0-indexed row the current room is located at in the current maze. */
    private int myMazeRow;
    
    /** The 0-indexed column the current room is located at in the current maze. */
    private int myMazeCol;
    
    /** The QuestionManager for this MazeManager that contributes Questions. */
    private QuestionManagerInterface myQuestionManager;
    
    /**
     * Constructs a new MazeManager that contains all mazes available to be played 
     * and sets the first maze.
     * 
     * @param theQuestionManager the QuestionManager that provides Questions for the maze. 
     * @throws NullPointerException if theQuestionManager is null
     */
    public MazeManager(final QuestionManagerInterface theQuestionManager) {
        
        myQuestionManager = Objects.requireNonNull(theQuestionManager,
                "theQuestionManager can not be null");
        
        myMazes = new ArrayList<Room[][]>();
        
        setupMazes();
        setNewMaze();
    }
    
    /**
     * Sets this MazeManager's current maze to a new one. 
     */
    public void setNewMaze() {
        // get a maze from the unused list of mazes
        Room[][] resultMaze = myMazes.remove(myMazes.size() - 1);
         
        // if the unused maze list is empty, transfer the mazes
        if (myMazes.size() == 0) {
            setupMazes();
        }
        
        myCurrentMaze = resultMaze;
        myMazeRow = 0;
        myMazeCol = 0;
        myCurrentRoom = myCurrentMaze[myMazeRow][myMazeCol];
        myCurrentRoom.setVisited();
    }
    
    /**
     * Changes the current room to the correct room depending on the
     * type of door that is given. The given door is the type of door that
     * the player just moved through.
     * 
     * @param theDoorType the type of door the player moved through
     * @throws NullPointerException when theDoorType is null
     */
    public void moveRooms(final Door.DoorType theDoorType) {
        Objects.requireNonNull(theDoorType, "theDoorType can not be null");
        if (theDoorType == Door.DoorType.NORTH) {
            myMazeRow = Math.max(myMazeRow - 1, 0);
        } else if (theDoorType == Door.DoorType.SOUTH) {
            myMazeRow = Math.min(myMazeRow + 1, myCurrentMaze.length - 1);
        } else if (theDoorType == Door.DoorType.WEST) {
            myMazeCol = Math.max(myMazeCol - 1, 0);
        } else if (theDoorType == Door.DoorType.EAST) {
            myMazeCol = Math.min(myMazeCol + 1, myCurrentMaze[0].length - 1);
        }
        myCurrentRoom = myCurrentMaze[myMazeRow][myMazeCol];
        myCurrentRoom.setVisited();
    }
    
    /**
     * Returns this MazeManager's current maze.
     * @return his MazeManager's current maze.
     */
    public Room[][] getCurrentMaze() {
        return myCurrentMaze;
    }
    
    /**
     * Returns the current room the maze is on.
     * @return the current room the maze is on.
     */
    public Room getCurrentRoom() {
        return myCurrentRoom;
    }
    
    /**
     * Populates the list of unused mazes so they can be used in the current program. 
     * 
     * @throws NullPointerException if there is an issue with creating mazes.
     * @throws FileNotFoundException if there is an issue with creating the mazes.
     */
    private void setupMazes() {
        
        try {
            final Room[][] maze1 = MazeBuilder.buildMaze(MAZE_1, myQuestionManager);
            final Room[][] maze2 = MazeBuilder.buildMaze(MAZE_2, myQuestionManager);
            final Room[][] maze3 = MazeBuilder.buildMaze(MAZE_3, myQuestionManager);
            final Room[][] maze4 = MazeBuilder.buildMaze(MAZE_4, myQuestionManager);
            
            myMazes.add(maze1);
            myMazes.add(maze2);
            myMazes.add(maze3);
            myMazes.add(maze4);
            
            // shuffle the full list of unused mazes so when we pull from 
            // the list later the order in which we use mazes is randomized
            Collections.shuffle(myMazes);
            
        } catch (NullPointerException exception) {
            System.out.println("A null pointer exception occurred while trying to create a maze");
        } catch (FileNotFoundException exception) {
            System.out.println("A map file was not found");
        }
    }

}