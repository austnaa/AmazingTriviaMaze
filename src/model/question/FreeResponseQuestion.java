/**
 * Amazing Trivia Maze
 * TCSS 360 Spring 2021
 */
package model.question;

import java.util.Objects;

/**
 * Free response trivia questions.
 * @author Daniel Jiang
 * @version Spring 2021
 */
public class FreeResponseQuestion extends Question {
    /**
     * The answer to the question.
     */
    private String myAnswer;

    /**
     * Constructor the the free response trivia questions.
     * @param theQuestion The question prompt.
     * @param theAnswer The answer.
     */
    public FreeResponseQuestion(final String theQuestion, final String theAnswer) {
        super(theQuestion);
        myAnswer = Objects.requireNonNull(theAnswer);
    }

    /**
     * Gets the answer of the question.
     * @return The answer of the question.
     */
    public String getAnswer() {
        return myAnswer;
    }

    /**
     * Creates a String representation of free response questions.
     * @return The String representation of free response questions.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Answer: " + myAnswer + "\n");
        return sb.toString();
    }
}