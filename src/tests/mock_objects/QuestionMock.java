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
     * @param theQuestion - the question 
     * @param theType - the type of question
     */
    public QuestionMock(String theQuestion, QuestionType theType) {
        super(theQuestion, theType); 
    }
    
    /**
     * Overriding the answerQuestion method for testing purposes.
     */
    @Override
    public void answerQuestion(final Player thePlayer) {
        if (this.getType() == Question.QuestionType.TRUE_FALSE) {
            setAnsweredAlready(true);
        }
    }
}
