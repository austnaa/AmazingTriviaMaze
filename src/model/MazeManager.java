package model;

import java.util.ArrayList;
import java.util.List;

public class MazeManager {
    
    private static final String MAZE_1 = "map1.txt";
    private static final String MAZE_2 = "map2.txt";
    
    private List<Room[][]> myUnusedMazes;
    
    private List<Room[][]> myUsedMazes;
    
    private Room[][] myCurrentMaze;
    
    private Room myCurrentRoom;
    
    private int myMazeRow;
    private int myMazeCol;
    
    // builds a list of mazes before the game starts
    // has a current maze
    
    
    public MazeManager() {
        
        myUnusedMazes = new ArrayList<Room[][]>();
        myUsedMazes = new ArrayList<Room[][]>();
        
        final Room[][] maze1 = MazeBuilder.buildMaze(MAZE_1);
        final Room[][] maze2 = MazeBuilder.buildMaze(MAZE_2);
        
        myUnusedMazes.add(maze1);
        myUnusedMazes.add(maze2);
        
        setNewMaze();
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
        
        myCurrentMaze = resultMaze;
        myMazeRow = 0;
        myMazeCol = 0;
        myCurrentRoom = myCurrentMaze[myMazeRow][myMazeCol];
    }
    
    
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