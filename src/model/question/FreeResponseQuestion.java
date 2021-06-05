/**
 * Amazing Trivia Maze
 * TCSS 360 Spring 2021
 */

package model.question;

import java.util.Objects;

/**
 * A class providing state and functionality for a free response question.
 * 
 * @author Daniel Jiang
 * @version Spring 2021
 */
public class FreeResponseQuestion extends Question {
    
    /** The answer to the question. */
    private String myAnswer;

    /**
     * Constructor the the free response trivia questions.
     * 
     * @param theQuestion The string representation of the question being asked.
     * @param theAnswer the String representation to the answer of this question
     * @throws NullPointerException if theQuestion is null
     * @throws NullPointerException if theAnswer is null
     */
    public FreeResponseQuestion(final String theQuestion, final String theAnswer) {
        super(theQuestion, QuestionType.FREE_RESPONSE);
        myAnswer = Objects.requireNonNull(theAnswer, "theAnswer can not be null.");
    }

    /**
     * Gets the String representation of the answer of the question.
     * @return The answer of the question.
     */
    public String getAnswer() {
        return myAnswer;
    }
    
    /**
     * Returns whether or not this question was answered correctly.
     * Updates the state of this question if the question is answered correctly.
     * 
     * @param theUsersAnswer the String representation of what the user answered.
     * @return whether or not the given answer is the correct answer 
     * @throws NullPointerException if theUsersAnswer is null
     */
    public boolean checkAnswer(final String theUsersAnswer) {
        Objects.requireNonNull(theUsersAnswer, "theUsersAnswer can not be null");
        final boolean result = myAnswer.equalsIgnoreCase(theUsersAnswer.trim());
        if (result) {
            this.setAnsweredAlready(true);
        }
        return result;
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