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
 * Multiple choice trivia questions.
 * @author Daniel Jiang
 * @version Spring 2021
 */
public class MultipleChoiceQuestion extends Question {
    
    /** The correct option. */
    private Option myAnswer;
    
    /** The second option for the multiple choice question. */
    private Option myOptionB;

    /** The third option for the multiple choice question. */
    private Option myOptionC;

    /** The fourth option for the multiple choice question. */
    private Option myOptionD;
    
    /**
     * The ButtonGroup that contains this questions's Options.
     */
    public ButtonGroup myButtonGroup;

    /**
     * Constructor for the multiple choice trivia questions.
     * @param theQuestion The question prompt.
     * @param theAnswer The answer.
     * @param theOptionB The second option.
     * @param theOptionC The third option.
     * @param theOptionD The fourth option.
     */
    public MultipleChoiceQuestion(final String theQuestion, final Option theAnswer, final Option theOptionB, final Option theOptionC, final Option theOptionD) {
        super(theQuestion, QuestionType.MULTIPLE_CHOICE);
        myAnswer = Objects.requireNonNull(theAnswer);
        myOptionB = Objects.requireNonNull(theOptionB);
        myOptionC = Objects.requireNonNull(theOptionC);
        myOptionD = Objects.requireNonNull(theOptionD);
        
        myButtonGroup = new ButtonGroup();
  
        myButtonGroup.add(myAnswer);
        myButtonGroup.add(myOptionB);
        myButtonGroup.add(myOptionC);
        myButtonGroup.add(myOptionD);
    }
    

    /**
     * Returns an ArrayList of the options that aren't the answer.
     * @return ArrayList of the options that aren't the answer.
     */
    public List<Option> getOptionsOnly() {
        List<Option> optionsOnly = new ArrayList<Option>();
        optionsOnly.add(myOptionB);
        optionsOnly.add(myOptionC);
        optionsOnly.add(myOptionD);
        return optionsOnly;
    }

    /**
     * Returns an ArrayList of all the possible options.
     * @return An ArrayList of all the possible options.
     */
    public List<Option> getAllOptions() {
        List<Option> allOptions = new ArrayList<Option>();
        allOptions.add(myAnswer);
        allOptions.add(myOptionB);
        allOptions.add(myOptionC);
        allOptions.add(myOptionD);
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
     * Creates a String representation of multiple choice questions.
     * @return The String representation of multiple choice questions.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(myAnswer);
        sb.append(myOptionB);
        sb.append(myOptionC);
        sb.append(myOptionD);
        return sb.toString();
    }
}