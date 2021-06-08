/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package model.question;

import java.util.List;
import java.util.Random;

/**
 * Creates and manages the list of available questions that can be accessed.
 * instances of the Trivia Maze game.
 * @author Austn Attaway
 * @version Spring 2021
 */
public class QuestionManager implements QuestionManagerInterface {
    
    /** The List of questions that will be copied each time we set up a new game. */
    private List<Question> myQuestionList;
    
    /**
     * Sets up the list of questions that can be copied for future game instances
     * and sets up the list of questions for the first game instance.
     */
    public QuestionManager() {
        setupQuestionList();
    }
    
    /**
     * Gets a random question out our accumulated question bank.
     */
    @Override
    public Question getRandomQuestion() {
        
        if (myQuestionList.size() == 0) {
            setupQuestionList();
        }
        final Random random = new Random();
        return myQuestionList.remove(random.nextInt(myQuestionList.size()));
    }
   
    /**
     * Sets up the list of questions using a database that will 
     * be copied for future game instances.
     */
    private void setupQuestionList() {
        myQuestionList = TriviaQuestions.getTriviaQuestions();
    }
}