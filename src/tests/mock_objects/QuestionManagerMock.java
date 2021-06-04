/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */

package tests.mock_objects;

import model.question.Question;
import model.question.QuestionManagerInterface;
import model.question.TriviaQuestions;

/**
 * A mock QuestionManager meant for testing.
 * @author Austn Attaway
 * @version Spring 2021
 */
public class QuestionManagerMock implements QuestionManagerInterface {

    /**
     * Returns the first question from the 
     * TriviaQuestions.getTriviaQuestions() resulting list 
     * @return 
     */
    @Override
    public Question getRandomQuestion() {
        return TriviaQuestions.getTriviaQuestions().get(0);
    }
    
}
