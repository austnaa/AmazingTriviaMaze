/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */

package model.oldquestion;

import java.util.Objects;

import javax.swing.ButtonGroup;

import model.Player;
import view.oldquestion_view.MultipleChoiceQuestionPanel;
import view.oldquestion_view.QuestionFrame;

/**
 * Provides state and behavior for a multiple-choice single selection question.
 * @author Austn Attaway
 * @version Spring 2021
 */
public class MultipleChoiceQuestion extends AustnAbstractQuestion {
    
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
        
        // sets the state of this question to be answered
        if (result) {
            myIsAnswered = true;
        }
        return result;
    }
    
    
    
    public void answerQuestion(final Player thePlayer) {
        final MultipleChoiceQuestionPanel multipleChoiceQuestionPanel = new MultipleChoiceQuestionPanel(thePlayer, this); //thePlayer,
        final QuestionFrame questionFrame = new QuestionFrame(multipleChoiceQuestionPanel);
        multipleChoiceQuestionPanel.setupFrame(questionFrame);
        
//        questionFrame.dispose();
//        return myIsAnswered;
        
    }


    /**
     * Returns the array of Option objects that are available to pick from.
     * @return
     */
    public Option[] getOptions() {
        return myOptions;
    }
    
    
    @Override
    public AustnQuestion clone() {
        // TODO CHECK to make sure that myOptions does a deep copy...
        final MultipleChoiceQuestion copy = new MultipleChoiceQuestion(myPrompt, myOptions);
        return copy;
    }
}