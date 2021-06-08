/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package model.question;

/**
 * An interface for QuestionManagers.
 * @author Austn Attaway
 * @version Spring 2021
 */
public interface QuestionManagerInterface {
    
    /**
     * Returns a random question from the current game's list of unused questions.
     * Will repopulate the backing store of questions if all questions have been pulled.
     * @return A random question from the current game's list of unused questions.
     */
    public Question getRandomQuestion();
}