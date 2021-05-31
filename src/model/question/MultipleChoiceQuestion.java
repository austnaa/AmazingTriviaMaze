/**
 * Amazing Trivia Maze
 * TCSS 360 Spring 2021
 */
package model.question;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Multiple choice trivia questions.
 * @author Daniel Jiang
 * @version Spring 2021
 */
public class MultipleChoiceQuestion extends Question {
    /**
     * The second option for the multiple choice question.
     */
    protected String myOptionB;

    /**
     * The third option for the multiple choice question.
     */
    protected String myOptionC;

    /**
     * The fourth option for the multiple choice question.
     */
    protected String myOptionD;

    /**
     * Constructor for the multiple choice trivia questions.
     * @param theQuestion The question prompt.
     * @param theAnswer The answer.
     * @param theOptionB The second option.
     * @param theOptionC The third option.
     * @param theOptionD The fourth option.
     */
    public MultipleChoiceQuestion(final String theQuestion, final String theAnswer, final String theOptionB, final String theOptionC, final String theOptionD) {
        super(theQuestion, theAnswer);
        myOptionB = Objects.requireNonNull(theOptionB);
        myOptionC = Objects.requireNonNull(theOptionC);
        myOptionD = Objects.requireNonNull(theOptionD);
    }

    /**
     * Returns an ArrayList of the options that aren't the answer.
     * @return ArrayList of the options that aren't the answer.
     */
    public ArrayList<String> getOptionsOnly() {
        ArrayList<String> optionsOnly = new ArrayList<String>();
        optionsOnly.add(myOptionB);
        optionsOnly.add(myOptionC);
        optionsOnly.add(myOptionD);
        return optionsOnly;
    }

    /**
     * Returns an ArrayList of all the possible options.
     * @return An ArrayList of all the possible options.
     */
    public ArrayList<String> getAllOptions() {
        ArrayList<String> allOptions = new ArrayList<String>();
        allOptions.add(myAnswer);
        allOptions.add(myOptionB);
        allOptions.add(myOptionC);
        allOptions.add(myOptionD);
        return allOptions;
    }

    /**
     * Creates a String representation of multiple choice questions.
     * @return The String representation of multiple choice questions.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\nOptionB: " + myOptionB);
        sb.append("\nOptionC: " + myOptionC);
        sb.append("\nOptionD: " + myOptionD + "\n");
        return sb.toString();
    }
}