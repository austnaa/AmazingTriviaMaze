/**
 * Amazing Trivia Maze
 * TCSS 360 Spring 2021
 */
package model.question;

import java.util.Objects;

import model.Player;
import view.question_view.AbstractQuestionPanel;
import view.question_view.FreeResponseQuestionPanel;
import view.question_view.MultipleChoiceQuestionPanel;
import view.question_view.QuestionFrame;
import view.question_view.TrueFalseQuestionPanel;

/**
 * Provides basic functionalities for all types of questions.
 * @author Daniel Jiang
 * @version Spring 2021
 */
public abstract class Question {
    
    /** An enumerated type that specifies the question type. */
    public enum QuestionType { MULTIPLE_CHOICE, TRUE_FALSE, FREE_RESPONSE };
    
    /** The question prompt. */
    private String myQuestionPrompt;

    /** If the question has been answered correctly already. */
    private boolean myAnsweredAlready;
    
    /** The type of question. */
    private QuestionType myType;

    /**
     * Sets up a Question with the given text (prompt) and question type.
     * @param theQuestionText The string representation of this question.
     * @param theType The type of question this is.
     * @throws NullPointerException If the question text is null.
     * @throws NullPointerException If the question type is null.
     */
    public Question(final String theQuestionText, final QuestionType theType) {
        myQuestionPrompt = Objects.requireNonNull(theQuestionText, "theQuestionText can not be null");
        myType = Objects.requireNonNull(theType, "theType can not be null");
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
     * Gets the question type. 
     * @return The question type.
     */
    public QuestionType getType() {
        return myType;
    }
    
    /**
     * Creates an appropriate frame and panel that pops up so this question can be answered.
     * @param thePlayer The player that is answering the question.
     * @throws NullPointerException If the player is null.
     */
    public void answerQuestion(final Player thePlayer) {
        Objects.requireNonNull(thePlayer, "thePlayer can not be null");
        AbstractQuestionPanel panel = null;
        
        if (this.getType() == QuestionType.MULTIPLE_CHOICE) {
            panel = new MultipleChoiceQuestionPanel(thePlayer, this);
        } else if (this.getType() == QuestionType.TRUE_FALSE) {
            panel = new TrueFalseQuestionPanel(thePlayer, this); 
        } else if (this.getType() == QuestionType.FREE_RESPONSE) {
          panel = new FreeResponseQuestionPanel(thePlayer, this);
        }
        
        if (panel != null) {
            final QuestionFrame frame = new QuestionFrame(panel);
            panel.setupFrame(frame);
        }
    }

    /**
     * Sets the question is/isn't answered already.
     * @param theAnsweredAlready The question is/isn't answered already.
     */
    public void setAnsweredAlready(final boolean theAnsweredAlready) {
        myAnsweredAlready = theAnsweredAlready;
    }
    
    /**
     * Creates a string representation of questions.
     * @return The string representation of questions.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Question: " + myQuestionPrompt + "\n");
        sb.append("IsAnswered: " + myAnsweredAlready + "\n");
        return sb.toString();
    }
}