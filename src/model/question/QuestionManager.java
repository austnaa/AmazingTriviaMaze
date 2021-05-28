/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */

package model.question;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Random;

// TODO: need to repopulate the current question list if it is empty? (results in duplicate Qs)

/**
 * Creates and manages the list of available questions that can be accessed to build 
 * instances of the Trivia Maze game.  
 *   
 * @author Austn Attaway
 * @version Spring 2021
 */
public class QuestionManager {
    
    /**
     * The List of questions that will be copied each time we set up a new game.
     */
    private List<Question> myQuestionList; 
    
    /**
     * The List of questions that questions will be pulled from for the current game instance.
     */
    private List<Question> myCurrentQuestionList;
    
    /**
     * Sets up a new QuestionManager. Sets up the list of questions that can be copied for 
     * future game instances, and sets up the list of questions for the first game instance. 
     */
    public QuestionManager() {
        setupQuestionList();
        setNewQuestionList();
    }
    
    
    /**
     * Returns a random question from the current game's list of unused questions.
     * @return a random question from the current game's list of unused questions.
     */
    public Question getRandomQuestion() {
        final Random random = new Random();
        return myCurrentQuestionList.remove(random.nextInt(myCurrentQuestionList.size()));
    }

    /**
     * Using a database, sets up the list of questions that will 
     * be copied for future game instances.  
     */
    private void setupQuestionList() {
        myQuestionList = new ArrayList<Question>();
        
        // ******** TEMP QUESTION LIST FOR TESTING ... 
        // ******** ADD DATABASE ACCESSES HERE TO POPULATE LIST
        // this is where we will access each table in the database 
        // and add create each question using the table's data. Once a question is created we add
        // it to myQuestionList
        for (int i = 0; i < 50; i++) {
            Option option1 = new Option("Minecraft", true);
            Option option2 = new Option("Fornite", false);
            Option option3 = new Option("Roblox", false);
            Option option4 = new Option("Among Us", false);
            Option[] options = {option1, option2, option3, option4}; 
            Question mcq = new MultipleChoiceQuestion("Which game is the most popular PC game?", 
                    options);
            // ********
            
            myQuestionList.add(mcq);
        }
        
    }
    
    
    /**
     * Sets up a brand new List of questions for use in a particular game instance.
     */
    public void setNewQuestionList() {
        myCurrentQuestionList = makeDeepCopy(myQuestionList);
    }
    
    // NOTE: NOT 100% CONFIDENT THIS WORKS YET.. IS DEPENDENT ON THE SUCCESS OF EACH QUESTION'S CLONE METHOD
    /**
     * Returns a deep copy of the given list.
     * 
     * @param theList the List that will be copied
     * @return the deep copy of the given list
     * @throws NullPointerException if theList is null
     */
    private List<Question> makeDeepCopy(final List<Question> theList) {
        Objects.requireNonNull(theList, "theList can not be null");
        
        List<Question> copy = new ArrayList<>();
        for (Question question : theList) {
            copy.add(question.clone());
        }
        return copy;
    }
    
}
