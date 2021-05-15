/**
 * Amazing Trivial Maze 
 * TCSS 360 Spring 2021
 */

package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

/**
 * A utility class that provides functionality for creating a 2D matrix of Room objects
 * based of off a given text file.
 * 
 * @author Austn Attaway
 * @version May 14, 2021
 */
public class MazeBuilder {
    
    // main method for testing purposes
    public static void main(String[] args) {
        
        String path = System.getProperty("user.dir") + "/assets/map1.txt";
        Room[][] maze = MazeBuilder.buildMaze(path);
        System.out.println(maze[0][0].toString());
        System.out.println(maze[3][3].toString());
    }
    
    /**
     * Private default constructor to inhibit its use.
     */
    private MazeBuilder() {
        
    }
    
    
    /**
     * Given a file name of a text file that contains the map generation information,
     * returns a matrix of Room objects that represents the maze. 
     * 
     * The given file's first line should contain two integers which represent the number
     * of rows and columns the matrix will have.
     * 
     * The given file's next lines will be a matrix of character sequences that are oriented
     * similarly to how the maze will be built. 
     * 
     * Each character sequence may have an '@' character
     * at the beginning that represents that room is the start room, or a '$' symbol to 
     * represent the end room.
     * 
     * Following any special symbols are 4 characters, all either 'Y' or 'N' which represent 
     * whether a door is located at the north, south, west, and east sides respectively. 
     * 
     * @param theFileName the name of the file that contains the map generation information
     * @throws NullPointerException if theFileName is null
     */
    public static Room[][] buildMaze(final String theFileName) throws NullPointerException {
        
        Objects.requireNonNull(theFileName);
        
        final Scanner fileScanner = getScanner(theFileName);
        
        final int numRows = fileScanner.nextInt();
        final int numCols = fileScanner.nextInt();
        final Room[][] resultMaze = new Room[numRows][numCols];
        
        // go line by line filling in the maze corresponding to each group of characters
        for (int i = 0; i < numRows; i++) {
            
            for (int j = 0; j < numCols; j++) {
                
                final String roomString = fileScanner.next();
                resultMaze[i][j] = buildRoom(roomString);
                
            }
        }
        
        fileScanner.close();
 
        return resultMaze;
      
    }  
    
    
    /**
     * Returns a Scanner object that contains the contents of the file 
     * specified by the given filename.
     * 
     * @param theFileName the name of the file
     * @return the Scanner object that contains the contents of the file
     * @throws NullPointerException if theFileName is null
     */
    private static Scanner getScanner(final String theFileName) 
            throws NullPointerException {
        
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File(theFileName));
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
        return fileScanner;
    }
    
    
    /**
     * Returns a new Room that is built according to the given room String input.
     * 
     * @param theRoomString the input string that contains Y or N values.\ 
     * @return the Room that corresponds to the given room string input
     * @throws NullPointerException if theRoomString is null
     * @throws IllegalArgumentException if theRoomString length is less than 4
     */
    private static Room buildRoom(String theRoomString) {
        Objects.requireNonNull(theRoomString);
        if (theRoomString.length() < 4) {
            throw new IllegalArgumentException("theRoomString must be at least length 4");
        }
        
        // if the length of the room string is 5, we know that there is an extra character at
        // the beginning that tells us it is a special room (start or end room)
        boolean isStartRoom = false;
        boolean isEndRoom = false;
        if (theRoomString.length() == 5) {
            isStartRoom = theRoomString.charAt(0) == '@';
            isEndRoom   = theRoomString.charAt(0) == '$';
            theRoomString = theRoomString.substring(1);
        }
        
        final Door northDoor = theRoomString.charAt(0) == 'Y' ? new Door(Door.TYPE.NORTH) : null;
        final Door southDoor = theRoomString.charAt(1) == 'Y' ? new Door(Door.TYPE.SOUTH) : null;
        final Door westDoor = theRoomString.charAt(2) == 'Y'  ? new Door(Door.TYPE.WEST) : null;
        final Door eastDoor = theRoomString.charAt(3) == 'Y'  ? new Door(Door.TYPE.EAST) : null;
        
        final Room newRoom = new Room(isStartRoom, isEndRoom, 
                northDoor, southDoor, westDoor, eastDoor);
        
        return newRoom;
    }
}
