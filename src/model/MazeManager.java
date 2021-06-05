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
    
    /** A List of Room matrices that have not been used in the current program's execution. */
    private List<Room[][]> myUnusedMazes;
    
    /** A List of Room matrices that have been used in the current program's execution. */
    private List<Room[][]> myUsedMazes;
    
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
        
        myUnusedMazes = new ArrayList<Room[][]>();
        myUsedMazes = new ArrayList<Room[][]>();
        
        setupMazes();
        setNewMaze();
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
            
            myUnusedMazes.add(maze1);
            myUnusedMazes.add(maze2);
            myUnusedMazes.add(maze3);
            myUnusedMazes.add(maze4);
            
            // shuffle the full list of unused mazes so when we pull from 
            // the list later the order in which we use mazes is randomized
            Collections.shuffle(myUnusedMazes);
            
        } catch (NullPointerException exception) {
            System.out.println("a null pointer exception occurred while trying to create a maze");
        } catch (FileNotFoundException exception) {
            System.out.println("a map file was not found");
        }
    }
    
    /**
     * Sets this MazeManager's current maze to a new one. 
     */
    public void setNewMaze() {
        // get a maze from the unused list of mazes
        Room[][] resultMaze = myUnusedMazes.remove(myUnusedMazes.size() - 1);
        
        // add the maze to the used maze list
        myUsedMazes.add(resultMaze);
        
        // if the unused maze list is empty, transfer the mazes
        if (myUnusedMazes.size() == 0) {
            moveUsedMazesToUnused();
        }
        
        // TODO we may want to change this behavior to match the "start room" 
        // mechanic we have in out map.txt files OR change our map mazes to always 
        // start at (0, 0)
        myCurrentMaze = resultMaze;
        myMazeRow = 0;
        myMazeCol = 0;
        myCurrentRoom = myCurrentMaze[myMazeRow][myMazeCol];
        myCurrentRoom.setVisited();
    }
    
    // TODO can Enums be null? should we check for null?
    /**
     * Changes the current room to the correct room depending on the
     * type of door that is given. The given door is the type of door that
     * the player just moved through.
     * 
     * @param theDoorType the type of door the player moved through
     */
    public void moveRooms(final Door.TYPE theDoorType) {
        if (theDoorType == Door.TYPE.NORTH) {
            myMazeRow = Math.max(myMazeRow - 1, 0);
        } else if (theDoorType == Door.TYPE.SOUTH) {
            myMazeRow = Math.min(myMazeRow + 1, myCurrentMaze.length);
        } else if (theDoorType == Door.TYPE.WEST) {
            myMazeCol = Math.max(myMazeCol - 1, 0);
        } else if (theDoorType == Door.TYPE.EAST) {
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
     * Resets the UnusedMaze list so they can be asked. 
     */
    private void moveUsedMazesToUnused() {
        while (myUsedMazes.size() > 0) {
            myUnusedMazes.add(myUsedMazes.remove(0));
        }
    }
}