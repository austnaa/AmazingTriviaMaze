/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package tests.mock_objects;

import model.Player;
import model.question.Question;

/**
 * A child class that inherits the abstract question class
 * for testing purposes.
 * @author Chau Vu
 * @version Spring 2021
 */
public class QuestionMock extends Question {
    
    /**
     * Dummy class constructor.
     * @param theQuestionText The question text.
     * @param theType The type of question.
     */
    public QuestionMock(String theQuestionText, QuestionType theType) {
        // Note we don't want null checking here because
        // it's supposed to be done in the super class.
        super(theQuestionText, theType); 
    }
    
    /**
     * Overrides the answer question method for testing purposes.
     * Will answer the question correctly if this question is a 
     * true/false question.
     */
    @Override
    public void answerQuestion(final Player thePlayer) {
        if (this.getType() == Question.QuestionType.TRUE_FALSE) {
            setAnsweredAlready(true);
        }
    }
    
    /**
     * Public set answered already method for testing purposes.
     */
    @Override
    public void setAnsweredAlready(final boolean theIsAnswered) {
        super.setAnsweredAlready(theIsAnswered);
    }
}