package tests.mock_objects;

import model.Player;
import model.question.Question;

/**
 * A child class that inherits abstract Question class.
 * For testing purposes
 * @author Chau Vu
 * @version Spring 2021
 */
public class QuestionMock extends Question {
    
    /**
     * Dummy class constructor.
     * @param theQuestionText - the question 
     * @param theType - the type of question
     */
    public QuestionMock(String theQuestionText, QuestionType theType) {
        // note we don't want null checking here because it
        // is supposed to be done in the super class
        super(theQuestionText, theType); 
    }
    
    /**
     * Overriding the answerQuestion method for testing purposes.
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
     * Public getType method used for testing to ensure the getType method 
     * works properly without breaking encapsulation.
     */
    @Override
    public QuestionType getType() {
        return super.getType();
    }
    
    /**
     * Public setAnsweredAlready method for the superclass for testing purposes.
     */
    @Override
    public void setAnsweredAlready(final boolean theIsAnswered) {
        super.setAnsweredAlready(theIsAnswered);
    }
}
