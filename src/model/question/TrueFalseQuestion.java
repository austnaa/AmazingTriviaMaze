/**
 * Amazing Trivia Maze
 * TCSS 360 Spring 2021
 */
package model.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.swing.ButtonGroup;

/**
 * True/false trivia questions.
 * @author Daniel Jiang
 * @version Spring 2021
 */
public class TrueFalseQuestion extends Question {

    /** The correct option. */
    private Option myAnswer;

    /** The incorrect option. */
    private Option myIncorrectAnswer;
    
    /** The ButtonGroup that contains this question's options. */
    private ButtonGroup myButtonGroup;

    /**
     * Constructor the the free response trivia questions.
     * @param theQuestion The question prompt.
     * @param theAnswer The answer.
     */
    public TrueFalseQuestion(final String theQuestion, final Option theAnswer, final Option theIncorrectAnswer) {
        super(theQuestion, QuestionType.TRUE_FALSE);
        myAnswer = Objects.requireNonNull(theAnswer);
        myIncorrectAnswer = Objects.requireNonNull(theIncorrectAnswer);
        
        myButtonGroup = new ButtonGroup();
        myButtonGroup.add(myAnswer);
        myButtonGroup.add(myIncorrectAnswer);
    }
    
    /**
     * Clears the options for this Question.
     */
    public void clearButtons() {
        myButtonGroup.clearSelection();
    }

    /**
     * Returns an ArrayList of all the possible options.
     * @return An ArrayList of all the possible options.
     */
    public List<Option> getAllOptions() {
        List<Option> allOptions = new ArrayList<Option>();
        allOptions.add(myAnswer);
        allOptions.add(myIncorrectAnswer);
        return allOptions;
    }

    /**
     * Gets the answer option.
     * @return The answer option.
     */
    public Option getAnswer() {
        return myAnswer;
    }
    
    // NOTE: this is duplicated code (also in the multiple choice question) and could be refactored.
    /**
     * Returns true if the currently selected option is the correct option.
     * Updates the state of this question to be answered.
     * 
     * @return whether or not this question was answered correctly.
     */
    public boolean checkAnswer() {
        boolean result = myAnswer.isSelected();
        myButtonGroup.clearSelection();
        if (result) {
            this.setAnsweredAlready(true);
        }
        return result;
    }
    
    /**
     * Creates a String representation of true/false questions.
     * @return The String representation of true/false questions.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(myAnswer);
        sb.append(myIncorrectAnswer);
        return sb.toString();
    }
}