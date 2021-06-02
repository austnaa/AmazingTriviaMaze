/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package model.oldquestion;

import java.util.Objects;

import model.Player;

/**
 * Provides state and functionality for a free response question. 
 * @author Austn Attaway
 * @version Spring 2021
 */
public class FreeResponseQuestion extends AustnAbstractQuestion {
    
    /** The string representation of a correct answer. */
    private String myCorrectAnswer;
    
    /**
     * TODO:
     * @param thePrompt 
     * @param theCorrectAnswer
     * @throws NullPointerException if thePrompt is null
     * @throws NullPointerException if theCorrectAnswer is null
     */
    public FreeResponseQuestion(final String thePrompt, final String theCorrectAnswer) {
        super(thePrompt);
        myCorrectAnswer = Objects.requireNonNull(theCorrectAnswer, "theCorrectAnswer can not be null");
    }
    
    /**
     * Compares the given text to the correct answer for this question. Returns
     * true if they are the same, and false otherwise.
     * 
     * @param theUsersAnswer the String the user typed into a textbox to answer this question
     * @return whether or not the correct answer for this question is the same as the given answer
     * @throws NullPointerException if theUsersAnswer is null
     */
    public boolean checkAnswer(final String theUsersAnswer) {
        Objects.requireNonNull(theUsersAnswer, "theUsersAnswer can not be null");
        // TODO: implement better string comparison to cut whitespace, etc.
        return theUsersAnswer.equalsIgnoreCase(myCorrectAnswer);
    }
    
    public void answerQuestion(final Player thePlayer) {
        super.myIsAnswered = true;
//        return true;
    }
    
    @Override
    public AustnQuestion clone() {
        final FreeResponseQuestion copy = new FreeResponseQuestion(super.myPrompt, myCorrectAnswer);
        return copy;
    }
}