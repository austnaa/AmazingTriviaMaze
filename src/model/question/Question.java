/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */

package model.question;

/**
 * Provides basic expected functionality for Question classes. 
 * 
 * @author Austn Attaway
 * @version Spring 2021
 */
public interface Question extends Cloneable {
    
    /**
     * Returns the String representation of this Question's prompt.
     * @return the String representation of this Question's prompt.
     */
    public String getPrompt();
    
    /**
     * Returns a deep copy of this Question.
     * @return a deep copy of this Question.
     */
    public Question clone();
    
    /**
     * Returns whether or not this question is answered
     * @return whether or not this question is answered
     */
    public boolean isAnswered();
    
    /**
     * Invokes the appropriate entity used to answer questions and allows 
     * the user to answer this question. Sets this Question to be answered 
     * if the user answers the question correctly.
     */
    public void answerQuestion();
    

}