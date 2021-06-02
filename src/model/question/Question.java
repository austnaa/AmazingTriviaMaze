/**
 * Amazing Trivia Maze
 * TCSS 360 Spring 2021
 */
package model.question;

import java.util.Objects;

/**
 * Provides basic functionalities for all types of questions.
 * @author Daniel Jiang
 * @version Spring 2021
 */
public abstract class Question {
    /**
     * The question prompt.
     */
    public String myQuestionPrompt;

    /**
     * If the question has been answered correctly already.
     */
    public boolean myAnsweredAlready;

    /**
     * Constructor for the question abstract class.
     * @param theQuestion The question.
     */
    public Question(final String theQuestion) {
        myQuestionPrompt = Objects.requireNonNull(theQuestion);
        myAnsweredAlready = false;
    }

    /**
     * Gets the question prompt.
     * @return The question prompt.
     */
    public String getQuestionPrompt() {
        return myQuestionPrompt;
    }

    /**
     * Gets if the question was answered already.
     * @return If the question was answered already.
     */
    public boolean getAnsweredAlready() {
        return myAnsweredAlready;
    }

    /**
     * Sets the question is/isn't answered already.
     * @param theAnsweredAlready The question is/isn't answered already.
     */
    public void setAnsweredAlready(final boolean theAnsweredAlready) {
        myAnsweredAlready = theAnsweredAlready;
    }

    /**
     * Creates a String representation of questions.
     * @return The String representation of questions.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Question: " + myQuestionPrompt + "\n");
        sb.append("IsAnswered: " + myAnsweredAlready + "\n");
        return sb.toString();
    }
}