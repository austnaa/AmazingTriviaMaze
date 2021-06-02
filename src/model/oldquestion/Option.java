/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package model.oldquestion;

import java.util.Objects;

import javax.swing.JRadioButton;

/**
 * A JRadioButton that provides state and functionality for being either an incorrect 
 * or correct answer to a multiple choice question.
 * @author Austn Attaway
 * @version Spring 2021
 */
public class Option extends JRadioButton {
    
    /** An auto-generated serial version UID for object serialization. */
    private static final long serialVersionUID = 6937889941706117785L;

    /** Whether or not this option is correct. */
    private boolean myOptionCorrect;
    
    /** The text that represents this Option. */
    private String myText;
    
    /**
     * Constructs an option with the given and whether or not this option is correct. 
     * @param theText the text that will be displayed when end users are considering this option.
     * @param theOptionCorrect whether or not this option is correct.
     * @throws NullPointerException if theText is null
     */
    public Option(final String theText, final boolean theOptionCorrect) {
        myText = Objects.requireNonNull(theText, "theText can not be null");
        myOptionCorrect = theOptionCorrect;
    }
    
    /**
     * Returns the text that represents this option.
     * @return the text that represents this option.
     */
    public String getText() {
        return myText;
    }
    
    /**
     * Returns whether or not this option is correct.
     * @return whether or not this option is correct.
     */
    protected boolean isCorrectOption() {
        return myOptionCorrect;
    }
}