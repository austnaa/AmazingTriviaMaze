/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Objects;

import model.Room;

/**
 * Utility class providing functionality for drawing a mini-map on a panel.
 * @author Austn Attaway
 * @version Spring 2021
 */
public class MiniMap {
    
    /** The left x position the minimap starts at. */ 
    private static final int START_X = 40;
    
    /** The top y position the minimap starts at. */ 
    private static final int START_Y = 25;
    
    /** The offset distance in pixels between the rooms. */
    private static final int ROOM_OFFSET = 30;
    
    /** The width of each room painted. */
    private static final int ROOM_WIDTH = 20;
    
    /** The color of the rooms. */
    private static final Color ROOM_COLOR = Color.WHITE;
    
    /** The color of the room the player is currently in. */
    private static final Color CURR_ROOM_COLOR = Color.GREEN;
    
    /** The color of the connections (doors) between the rooms. */
    private static final Color DOOR_COLOR = Color.GRAY;
    
    /**
     * Private constructor to inhibit instantiation.
     */
    private MiniMap() {
        
    }
    
    /**
     * TODO
     * @param theGraphics
     * @param theMaze
     * @param theCurrentRoom
     * @throws NullPointerException if theGraphics is null
     * @throws NullPointerException if theMaze is null
     * @throws NullPointerException if theCurrentRoom is null
     */
    public static void drawMiniMap(final Graphics theGraphics, final Room[][] theMaze,
            final Room theCurrentRoom) {
        Objects.requireNonNull(theGraphics, "theGraphics can not be null");
        Objects.requireNonNull(theMaze, "theMaze can not be null");
        Objects.requireNonNull(theCurrentRoom, "theCurrentRoom can not be null");
                
        for (int i = 0; i < theMaze.length; i++) {
            for (int j = 0; j < theMaze[i].length; j++) {
                
                final Room tempRoom = theMaze[i][j];
                final int tempXPosition = START_X + (ROOM_OFFSET * j);
                final int tempYPosition = START_Y + (ROOM_OFFSET * i);
                
                if (tempRoom.isVisited()) { 
 
                    // Draw the connections to other rooms if the door exists and
                    // the adjacent room has been visited. By nature of the loop system
                    // that moves left to right, top to bottom, we only need to draw 
                    // south and east doors
                    
                    theGraphics.setColor(DOOR_COLOR);
                    if (tempRoom.hasSouthDoor() && theMaze[i + 1][j].isVisited()) {
                        theGraphics.fillRect(tempXPosition + 8, tempYPosition, ROOM_WIDTH / 4, ROOM_OFFSET);            
                    } 
                    if (tempRoom.hasEastDoor() && theMaze[i][j + 1].isVisited()) {
                        theGraphics.fillRect(tempXPosition, tempYPosition + 8, ROOM_OFFSET, ROOM_WIDTH / 4);
                    }
                    
                    // draw the room after the walls to the room color is in the foreground
                    theGraphics.setColor(ROOM_COLOR);
                    if (tempRoom.equals(theCurrentRoom)) {
                        theGraphics.setColor(CURR_ROOM_COLOR);
                    }
                    theGraphics.fillOval(tempXPosition, tempYPosition, ROOM_WIDTH, ROOM_WIDTH);
                }   
            }    
        }        
    }
}