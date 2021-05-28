/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */

package model.question;

/**
 * Provides basic expected functionality for Question classes. 
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
    
    
    
    // These are only applicable to the MultipleChoiceQuestion and the TrueFalse question...
    /**
     * Returns the array of Option objects for this question. At least one of the options
     * will be the correct option. 
     * 
     * @return the array of Option objects for this question
     */
//    public Option[] getOptions();
    
    
    /**
     * Returns true if the currently selected answer option is the correct option, false otherwise. 
     * @return true if the currently selected answer option is the correct option, false otherwise.
     */
//    public boolean checkAnswer();
}