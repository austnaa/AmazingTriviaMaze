/**
 * Amazing Trivia Maze
 * TCSS 360 Spring 2021
 */
package model.question;

import java.util.Objects;

import model.Player;
import model.question.Question.QuestionType;
import view.oldquestion_view.AbstractQuestionPanel;
import view.oldquestion_view.MultipleChoiceQuestionPanel;
import view.oldquestion_view.QuestionFrame;

/**
 * Provides basic functionalities for all types of questions.
 * @author Daniel Jiang
 * @version Spring 2021
 */
public abstract class Question {
    
    /**
     * An enumerated type that specifies what type of question a question can be.
     */
    public enum QuestionType { MULTIPLE_CHOICE, TRUE_FALSE, FREE_RESPONSE };
    
    /** The question prompt. */
    private String myQuestionPrompt;

    /** If the question has been answered correctly already. */
    private boolean myAnsweredAlready;
    
    /**
     * The type of this question.
     */
    private QuestionType myType;

    /**
     * Constructor for the question abstract class.
     * @param theQuestion The question.
     */
    public Question(final String theQuestion, final QuestionType theType) {
        myQuestionPrompt = Objects.requireNonNull(theQuestion);
        myAnsweredAlready = false;
        myType = theType; // do we need to check for nulls?
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
     * Returns the type of Question this question is. 
     * @return the type of Question this question is.
     */
    public QuestionType getType() {
        return myType;
    }
    
    public void answerQuestion(final Player thePlayer) {
        Objects.requireNonNull(thePlayer, "thePlayer can not be null");
        
        
        AbstractQuestionPanel panel = null;
        
        if (this.getType() == QuestionType.MULTIPLE_CHOICE) {
            panel = new MultipleChoiceQuestionPanel(thePlayer, this);
        } else if (this.getType() == QuestionType.TRUE_FALSE) {
            // insert code to set the panel to a truefalsepanel
            System.out.println("open true false panel...");
        } else if (this.getType() == QuestionType.FREE_RESPONSE) {
            // insert code to set the panel to a free response panel
            System.out.println("open free response panel...");
        }
        
        if (panel != null) {
            QuestionFrame frame = new QuestionFrame(panel);
            panel.setupFrame(frame);
        }
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