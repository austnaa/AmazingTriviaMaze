/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */

package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

import model.question.Question;
import model.question.QuestionManagerInterface;

/**
 * A utility class that provides functionality for creating a 2D matrix of Room objects
 * based of off a given text file.
 * 
 * @author Austn Attaway
 * @version Spring 2021
 */
public class MazeBuilder {
    
    /**
     * Private default constructor to inhibit instantiation.
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
     * whether or not a door is located at the north, south, west, and east sides respectively. 
     * 
     * @param theFileName the name of the file that contains the map generation information
     * @throws NullPointerException if theFileName is null
     * @throws NullPointerException if theQuestionManager is null
     * @throws FileNotFoundException if theFileName is not found
     */
    public static Room[][] buildMaze(final String theFileName, final QuestionManagerInterface theQuestionManager) 
            throws NullPointerException, FileNotFoundException {
        
        Objects.requireNonNull(theFileName, "theFileName can not be null"); 
        Objects.requireNonNull(theQuestionManager, "theQuestionManager can not be null");
        
        final String filePath = System.getProperty("user.dir") + "/assets/" + theFileName;
        final Scanner fileScanner = new Scanner(new File(filePath));
        
        final int numRows = fileScanner.nextInt();
        final int numCols = fileScanner.nextInt();
        final Room[][] resultMaze = new Room[numRows][numCols];
        
        // go line by line filling in the maze corresponding to each group of characters
        for (int i = 0; i < numRows; i++) {
            
            for (int j = 0; j < numCols; j++) {
                
                final String roomString = fileScanner.next();
                resultMaze[i][j] = buildRoom(roomString, theQuestionManager, resultMaze, i, j);
                
            }
        }
        fileScanner.close();
        return resultMaze;
    }  
        
    //NOTE: this method could be private but is public for testing purposes.
    /**
     * Returns a new Room that is built according to the given room String input.
     * 
     * @param theRoomString the input string that contains Y or N values.
     * @param theQuestionManager the QuestionManager that supplies random questions.
     * @param theMaze the 2D array of rooms that have been created up until theRow and theCol.
     * @param theRow the row the returned room will be located at in theMaze
     * @param theCol the columns the returned room will be located at in theMaze.
     * 
     * @return the Room that corresponds to the given room string input
     * 
     * @throws NullPointerException if theRoomString is null
     * @throws NullPointerException if theQuestionManager is null
     * @throws NullPointerException if theMaze is null
     * @throws IllegalArgumentException if theRoomString length is less than 4
     * @throws IllegalArgumentException if theRow is less than 0
     * @throws IllegalArgumentException if theCol is less than 0
     */
    public static Room buildRoom(String theRoomString, final QuestionManagerInterface theQuestionManager,
            final Room[][] theMaze, final int theRow, final int theCol) {
        
        Objects.requireNonNull(theRoomString, "theRoomString can not be null");
        Objects.requireNonNull(theQuestionManager, "theQuestionManager can not be null");
        Objects.requireNonNull(theMaze, "theMaze can not be null");
        if (theRoomString.length() < 4) {
            throw new IllegalArgumentException("theRoomString must be at least length 4");
        }
        if (theRow < 0) {
            throw new IllegalArgumentException("theRow can not be less than 0");
        }
        if (theCol < 0) {
            throw new IllegalArgumentException("theCol can not be less than 0");
        }
        
        // if the length of the room string is 5, we know that there is an extra character at
        // the beginning that tells us it is a special room (start or end room)
        boolean isEndRoom = false;
        if (theRoomString.length() == 5) {
            isEndRoom   = theRoomString.charAt(0) == '$';
            theRoomString = theRoomString.substring(1);
        }  
        
        // the north door will share a question with the room above it
        Door northDoor = null;
        if (theRoomString.charAt(0) == 'Y' && theRow > 0) {
            final Question question = theMaze[theRow - 1][theCol].getSouthDoor().getQuestion();
            northDoor = new Door(Door.DoorType.NORTH, question);
        } 
        
        // the west door will share a question with the room to the left of it
        Door westDoor = null;
        if (theRoomString.charAt(2) == 'Y' && theCol > 0) {
            final Question question = theMaze[theRow][theCol - 1].getEastDoor().getQuestion();
            westDoor = new Door(Door.DoorType.WEST, question);
        }
        
        // we know that the doors to the south and east have not been created yet, so create them.
        final Door southDoor = theRoomString.charAt(1) == 'Y' ? 
                new Door(Door.DoorType.SOUTH, theQuestionManager.getRandomQuestion()) : null;
        
        final Door eastDoor = theRoomString.charAt(3) == 'Y'  ? 
                new Door(Door.DoorType.EAST, theQuestionManager.getRandomQuestion()) : null;
        
                
        final Room newRoom = new Room(isEndRoom, 
                northDoor, southDoor, westDoor, eastDoor); 
        return newRoom;
    }
}