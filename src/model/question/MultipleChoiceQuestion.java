/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */

package model.question;

import java.util.Objects;

import javax.swing.ButtonGroup;

/**
 * Provides state and behavior for a multiple-choice single selection question.
 * @author Austn Attaway
 */
public class MultipleChoiceQuestion extends AbstractQuestion {
    
    /**
     * The ButtonGroup that contains the Option objects for this Question. Important for
     * ensuring that only one of the Options can be selected at once.
     */
    private ButtonGroup myButtonGroup;
    
    // TODO we may consider making the Option array a List.
    /**
     * The array of Option objects that represent the available answers for this question.
     */
    private Option[] myOptions;
    
    /**
     * Constructs a MultipleChoiceQuestion object with the given prompt and an array of options. 
     * At least one of the Options in theOptions should be marked as the correct option.
     * 
     * @param thePrompt the String that represents the question being asked.
     * @param theOptions the Options available to be picked when answering this question.
     * @throws NullPointerException if thePrompt is null
     * @throws NullPointerException if theOptions is null
     */
    public MultipleChoiceQuestion(final String thePrompt, final Option[] theOptions) {
        super(thePrompt);
        
        myButtonGroup = new ButtonGroup();
        myOptions = Objects.requireNonNull(theOptions, "theOptions can not be null");;
        
        // TODO check to make sure the option array is a desired length?
        // TODO check to make sure none of the Options are null?
        for (Option option : theOptions) {
            myButtonGroup.add(option);
        }
    }

    /**
     * Returns true if the currently selected option in the ButtonGroup
     * is the correct option, and false otherwise.
     */
//    @Override
    public boolean checkAnswer() {
        boolean result = false;
        for (Option tempOption : myOptions) {
            if (tempOption.isCorrectOption() && tempOption.isSelected()) {
                result = true;
                break;
            }
        }
        return result;
    }


//    @Override
    /**
     * Returns the array of Option objects that are available to pick from.
     * @return
     */
    public Option[] getOptions() {
        return myOptions;
    }
    
    
    
    public Question clone() {
        // TODO CHECK to make sure that myOptions does a deep copy...
        final MultipleChoiceQuestion copy = new MultipleChoiceQuestion(myPrompt, myOptions);
        return copy;
    }
}