/**
 * Amazing Trivial Maze 
 * TCSS 360 Spring 2021
 */

package model.question;

import java.util.Objects;

import javax.swing.ButtonGroup;

public class MultipleChoiceQuestion extends AbstractQuestion {
    
    /**
     * The ButtonGroup that contains the Option objects for this Question.
     */
    private ButtonGroup myButtonGroup;
    
    /**
     * The array of Option objects that represent the available answers for this question.
     */
    private Option[] myOptions;
    
    /**
     * Constructs a MultipleChoiceQuestion object with the given prompt and an array of options. 
     * The correct option MUST be the first option at index 0 in theOptions.
     * @param thePrompt the String that represents the question being asked.
     * @param theOptions the Options available to be picked when answering this question.
     * @throws NullPointerException if thePrompt is null
     * @throws NullPointerException if theOptions is null
     */
    public MultipleChoiceQuestion(final String thePrompt, final Option[] theOptions) {
        super(thePrompt);
        
        myButtonGroup = new ButtonGroup();
        myOptions = Objects.requireNonNull(theOptions, "theOptions can not be null");;
        
        // add each option from myOptions into the button group so 
        // only one can be selected at a time.
        for (Option option : theOptions) {
            myButtonGroup.add(option);
        }
    }

    /**
     * Returns true if the currently selected option is the correct option, false otherwise.
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
    public Option[] getOptions() {
        return myOptions;
    }
}
