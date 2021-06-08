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
    
    /** The ButtonGroup that contains the options. */
    private ButtonGroup myButtonGroup;

    /**
     * Constructor the the free response trivia questions.
     * @param theQuestion The question prompt that represents the question being asked
     * @param theAnswer the Option that represents the correct answer
     * @param theIncorrectAnswer the Option that represents the incorrect answer
     * @throws NullPointerException If the quesiton is null.
     * @throws NullPointerException If the answer is null.
     * @throws NullPointerException If the incorrect answer is null.
     * @throws IllegalArgumentException If the answer is not a valid option.
     * @throws IllegalArgumentException If the incorrect answer is not a valid option.
     */
    public TrueFalseQuestion(final String theQuestion, final Option theAnswer,
            final Option theIncorrectAnswer) {
        
        super(theQuestion, QuestionType.TRUE_FALSE);
        myAnswer = Objects.requireNonNull(theAnswer, "theAnswer can not be null");
        myIncorrectAnswer = Objects.requireNonNull(theIncorrectAnswer, 
                "theIncorrectAnswer can not be null");
        if (!myAnswer.isCorrectOption()) {
            throw new IllegalArgumentException("theAnswer must be a correct Option!");
        }
        if (myIncorrectAnswer.isCorrectOption()) {
            throw new IllegalArgumentException("theIncorrectAnswer must be an incorrect Option!");
        }
        
        // Adds the options to a button group so only one of them can be selected at a time.
        myButtonGroup = new ButtonGroup();
        myButtonGroup.add(myAnswer);
        myButtonGroup.add(myIncorrectAnswer);
    }
    
    /**
     * Clears the options.
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

    /**
     * Returns true if the currently selected option is the correct option.
     * Updates the state of this question to be answered.
     * @return If this question was answered correctly.
     */
    public boolean checkAnswer() {
        boolean result = myAnswer.isSelected();
        clearButtons();
        if (result) {
            this.setAnsweredAlready(true);
        }
        return result;
    }
    
    /**
     * Creates a string representation of true/false questions.
     * @return The string representation of true/false questions.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Correct answer: ");
        sb.append(myAnswer);
        sb.append(System.lineSeparator());
        sb.append("Incorrect answer: ");
        sb.append(myIncorrectAnswer);
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}