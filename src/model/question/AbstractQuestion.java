/**
 * Amazing Trivial Maze 
 * TCSS 360 Spring 2021
 */

package model.question;

import java.util.Objects;

/**
 * An abstract class that provides some functionality for Question objects. 
 * 
 * @author Austn Attaway
 * @version Spring 2021
 * Updated: May 19, 2021
 */
public abstract class AbstractQuestion implements Question {

    /**
     * The String representation of this Question's prompt.
     */
    private String myPrompt;
    
    
    /**
     * Abstract constructor that sets default values for Questions.
     * @param thePrompt the String representation of the question being asked.
     * @throws NullPointerException if thePrompt is null.
     */
    protected AbstractQuestion(final String thePrompt) {
        myPrompt = Objects.requireNonNull(thePrompt, "thePrompt can not be null");
    }
    
    @Override
    public String getPrompt() {
        return myPrompt;
    }

//    public abstract Option[] getOptions();

}
