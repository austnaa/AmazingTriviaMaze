

package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class MazeBuilder {
    
    public static void main(String[] args) {
        Room[][] maze = MazeBuilder.buildMaze("./assets/map1.txt");
        System.out.println(maze[0][0].toString());
        System.out.println(maze[3][3].toString());
    }
    
    
    
    
    /**
     * Private default constructor to inhibit its use.
     */
    private MazeBuilder() {
        
    }
    
    
    
    /**
     * Given a Scanner that contains a mapX.txt text file, builds and
     * returns the matrix of rooms that represents the maze. 
     * 
     * @param theFileScanner the Scanner that contains the map file input
     */
    public static Room[][] buildMaze(final String theFileName) {
        
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
        
        return resultMaze;
      
    }  
    
    
    private static Scanner getScanner(final String theFileName) {
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File(theFileName));
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
        return fileScanner;
    }
    
    // TODO DOES NOT CHECK FOR START OR END ROOM
    /**
     * Returns a new Room that is built according to the given room string input.
     * 
     * TODO EXPLAIN HOW STRING SHOULD LOOK
     * 
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
        
        final Door northDoor = theRoomString.charAt(0) == 'Y' ? new Door() : null;
        final Door southDoor = theRoomString.charAt(1) == 'Y' ? new Door() : null;
        final Door westDoor = theRoomString.charAt(2) == 'Y'  ? new Door() : null;
        final Door eastDoor = theRoomString.charAt(3) == 'Y'  ? new Door() : null;
        
        final Room newRoom = new Room(isStartRoom, isEndRoom, 
                northDoor, southDoor, westDoor, eastDoor);
        
        return newRoom;
    }
 
    
    
    
}
