/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package model.question;

import java.util.List;
import java.util.Random;

/**
 * Creates and manages the list of available questions that can be accessed to build 
 * instances of the Trivia Maze game.  
 * @author Austn Attaway
 * @version Spring 2021
 */
public class QuestionManager {
    
    /** 
     * The List of questions that will be copied each time we set up a new game. 
     */
    private List<Question> myQuestionList;
    
    /**
     * Sets up a new QuestionManager. Sets up the list of questions that can be copied for 
     * future game instances, and sets up the list of questions for the first game instance. 
     */
    public QuestionManager() {
        setupQuestionList();
    }
    
    /**
     * Returns a random question from the current game's list of unused questions.
     * Will repopulate the backing store of questions if all questions have been pulled.
     * @return a random question from the current game's list of unused questions.
     */
    public Question getRandomQuestion() {
        
        if (myQuestionList.size() == 0) {
            setupQuestionList();
        }
        final Random random = new Random();
        return myQuestionList.remove(random.nextInt(myQuestionList.size()));
    }
   
    /**
     * Using a database, sets up the list of questions that will 
     * be copied for future game instances.  
     */
    private void setupQuestionList() {
        myQuestionList = TriviaQuestions.getTriviaQuestions();
    }
    
}