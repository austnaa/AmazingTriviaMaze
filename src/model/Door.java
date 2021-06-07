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
 * 
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
     * The Question assigned to this door. Is used when the user 
     * needs to answer a question to unlock the door.
     */
    private Question myQuestion;
    
    /** The x position of this door. */
    private int myX;
    
    /** The y position of this door. */
    private int myY;
    
    /**
     * Constructor that builds a door with the given DoorType and Question.
     *
     * @param theType the DoorType of this door.
     * @param theQuestion the Question required to answer to unlock this door.
     * @throws NullPointerException if theType is null
     * @throws NullPointerException if theQuestion is null
     */
    public Door(final DoorType theType, final Question theQuestion) {
        myType = Objects.requireNonNull(theType, "theType cannot be null");
        myQuestion = Objects.requireNonNull(theQuestion, "theQuestion cannot be null");
        setXYPosition();
    }

    /**
     * Interact with this door if the player is close enough. 
     * Creates the popup frame for the question
     * if the question is not answered and the player is close enough.
     * 
     * @param thePlayer the Player interacting with this door.
     * @return this door if the question was answered correctly, null otherwise.
     * @throws NullPointerException if thePlayer is null
     */
    public Door interact(final Player thePlayer) {
        Objects.requireNonNull(thePlayer, "thePlayer cannot be null");
        if (isCloseEnough(thePlayer)) {
            if (this.isLocked()) {
                // creates the popup question frame
                myQuestion.answerQuestion(thePlayer);  
            } else {
                return this;
            }
        }
        return null;
    }
    
    /**
     * Returns whether or not the given Player is close enough to this door for interaction.
     * 
     * @param thePlayer the Player trying to interact with this door.
     * @return whether or not the given Player is close enough to this door for interaction.
     * @throws NullPointerException if thePlayer is null
     */
    public boolean isCloseEnough(final Player thePlayer) {
        Objects.requireNonNull(thePlayer, "thePlayer can not be null");
        final int closeEnoughDistance = 150;
        final int xDiff = Math.abs(thePlayer.getXPosition() - myX);
        final int yDiff = Math.abs(thePlayer.getYPosition() - myY);
        
        return xDiff < closeEnoughDistance && closeEnoughDistance < 150;
    }
    
    /**
     * Returns whether or not this door is locked
     * @return whether or not this door is locked
     */
    public boolean isLocked() {
        return !myQuestion.getAnsweredAlready();
    }
    
    /**
     * Returns the x position of this door.
     * @return the x position of this door.
     */
    public int getX() {
        return myX;
    }
    
    /**
     * Returns the y position of this door.
     * @return the y position of this door.
     */
    public int getY() {
        return myY;
    }
    
    /**
     * Returns the type of this door.
     * @return the type of this door.
     */
    public DoorType getType() {
        return myType;
    }
    
    /**
     * Returns the Question this Door contains.
     * @return the Question this Door contains.
     */
    public Question getQuestion() {
        return myQuestion;
    }
    
    /**
     * Returns a String representation of a door.
     */
    public String toString() {
        return "I am a door, type: " + myType;
    }
    
    /**
     * Sets the x and y position depending on the type this door is.
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