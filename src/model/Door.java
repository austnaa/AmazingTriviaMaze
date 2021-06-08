/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package model;

import java.util.Objects;

import model.question.Question;

import view.GameFrame;

/**
 * Contains state and behavior for a Door.
 * @author Austn Attaway
 * @version Spring 2021
 */
public class Door {
    
    /** The x position of a north door. */
    public static final int NORTH_X = GameFrame.FRAME_WIDTH / 2;
    
    /** The y position of a north door. */
    public static final int NORTH_Y = 0;
    
    /** The x position of a south door */
    public static final int SOUTH_X = GameFrame.FRAME_WIDTH / 2;
    
    /** The y position of a south door */
    public static final int SOUTH_Y = GameFrame.FRAME_HEIGHT - 128;
    
    /** The x position of a west door */
    public static final int WEST_X = 0;
    
    /** The y position of a west door */
    public static final int WEST_Y = GameFrame.FRAME_HEIGHT / 2;
    
    /** The x position of an east door */
    public static final int EAST_X = GameFrame.FRAME_WIDTH;
    
    /** The y position of an east door */
    public static final int EAST_Y = GameFrame.FRAME_HEIGHT / 2;
    
    /** The possible types of a door */
    public enum DoorType { NORTH, SOUTH, EAST, WEST };
    
    /** The type of this door. */
    private DoorType myType;
    
    /**
     * The Question assigned to this door.
     * Used when the user needs to answer a question to unlock the door.
     */
    private Question myQuestion;
    
    /** The x position of this door. */
    private int myX;
    
    /** The y position of this door. */
    private int myY;
    
    /**
     * Constructor that builds a door with the given DoorType and Question.
     * @param theType The type of door.
     * @param theQuestion The question assigned to this door.
     * @throws NullPointerException If the door type is null.
     * @throws NullPointerException If the question is null.
     */
    public Door(final DoorType theType, final Question theQuestion) {
        myType = Objects.requireNonNull(theType, "theType cannot be null");
        myQuestion = Objects.requireNonNull(theQuestion, "theQuestion cannot be null");
        setXYPosition();
    }

    /**
     * Interacts with this door if the player is close enough. 
     * Creates the popup frame for the question if the question has not
     * been answered yet and the player within the vicinity.
     * @param thePlayer The player interacting with the door.
     * @return If this door was answered correctly, null otherwise.
     * @throws NullPointerException If the player is null.
     */
    public Door interact(final Player thePlayer) {
        Objects.requireNonNull(thePlayer, "thePlayer cannot be null");
        if (isCloseEnough(thePlayer)) {
            if (this.isLocked()) {
                // Creates the popup question frame.
                myQuestion.answerQuestion(thePlayer);  
            } else {
                return this;
            }
        }
        return null;
    }
    
    /**
     * Returns if the player is close enough to this door for interaction.
     * @param thePlayer The player interacting with the door.
     * @return If the player is close enough to the door for interaction.
     * @throws NullPointerException If the player is null.
     */
    public boolean isCloseEnough(final Player thePlayer) {
        Objects.requireNonNull(thePlayer, "thePlayer can not be null");
        final int closeEnoughDistance = 150;
        final int xDiff = Math.abs(thePlayer.getXPosition() - myX);
        final int yDiff = Math.abs(thePlayer.getYPosition() - myY);
        
        return xDiff < closeEnoughDistance && yDiff < closeEnoughDistance;
    }
    
    /**
     * Returns whether this door is locked or not.
     * @return Whether this door is locked or not.
     */
    public boolean isLocked() {
        return !myQuestion.getAnsweredAlready();
    }
    
    /**
     * Returns the x position of this door.
     * @return The x position of this door.
     */
    public int getX() {
        return myX;
    }
    
    /**
     * Returns the y position of this door.
     * @return The y position of this door.
     */
    public int getY() {
        return myY;
    }
    
    /**
     * Returns the type of this door.
     * @return The type of this door.
     */
    public DoorType getType() {
        return myType;
    }
    
    /**
     * Returns the question this door contains.
     * @return The question this door contains.
     */
    public Question getQuestion() {
        return myQuestion;
    }
    
    /**
     * Returns a string representation of a door.
     * @return A string representation of a door.
     */
    public String toString() {
        return "I am a door, type: " + myType;
    }
    
    /**
     * Sets the x and y position depending on the type of door.
     */
    private void setXYPosition() {
        switch (myType) {
            case NORTH: 
                myX = NORTH_X;
                myY = NORTH_Y;
                break;
            case SOUTH:
                myX = SOUTH_X;
                myY = SOUTH_Y;
                break;
            case WEST: 
                myX = WEST_X;
                myY = WEST_Y;
                break;
            case EAST: 
                myX = EAST_X;
                myY = EAST_Y;
                break;
        }
    }
}