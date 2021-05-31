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
    protected String myQuestionPrompt;

    /**
     * The answer to the question.
     */
    protected String myAnswer;

    /**
     * If the question has been answered correctly already.
     */
    protected boolean myAnsweredAlready;

    /**
     * Constructor for the question abstract class.
     * @param theQuestion The question.
     */
    public Question(final String theQuestion, final String theAnswer) {
        myQuestionPrompt = Objects.requireNonNull(theQuestion);
        myAnswer = Objects.requireNonNull(theAnswer);
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
     * Gets the answer of the question.
     * @return The answer of the question.
     */
    public String getAnswer() {
        return myAnswer;
    }

    /**
     * Checks the user answer with the correct answer.
     * @param theUserAnswer The user answer.
     * @return If they answered correctly.
     */
    public boolean checkAnswer(final String theUserAnswer) {
        return myAnswer.compareToIgnoreCase(theUserAnswer) == 0;
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
        sb.append("\nQuestion: " + myQuestionPrompt);
        sb.append("\nIsAnswered: " + myAnsweredAlready);
        sb.append("\nAnswer: " + myAnswer);
        return sb.toString();
    }
}