/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */

package model.oldquestion;

import java.util.Objects;

import model.Player;

/**
 * An abstract class that provides some functionality for Question objects. 
 * @author Austn Attaway
 * @version Spring 2021
 */
public abstract class AustnAbstractQuestion implements AustnQuestion {

    /**
     * The String representation of this Question's prompt.
     */
    protected String myPrompt;
    
    /**
     * Whether or not this Question has been answered.
     */
    protected boolean myIsAnswered;
    
    
    /**
     * Abstract constructor that sets default values for Questions.
     * @param thePrompt the String representation of the question being asked.
     * @throws NullPointerException if thePrompt is null.
     */
    protected AustnAbstractQuestion(final String thePrompt) {
        myPrompt = Objects.requireNonNull(thePrompt, "thePrompt can not be null");
        myIsAnswered = false;
    }
    
    @Override
    public String getPrompt() {
        return myPrompt;
    }
    
    @Override
    public boolean isAnswered() {
        return myIsAnswered;
    }
    
//    @Override
//    public void answerQuestion() {
//        // TODO: this should be implemented in child classes. 
//        // this method should set up the frame that allows user to answer question
//        // if the question is answered correctly, set myIsAnswered to true.
//        myIsAnswered = true;
//    }
    public abstract void answerQuestion(final Player thePlayer);
    
    @Override
    public abstract AustnQuestion clone();

}