/**
 * Amazing Trivia Maze
 * TCSS 360 Spring 2021
 */
package model.question;

/**
 * Free response trivia questions.
 * @author Daniel Jiang
 * @version Spring 2021
 */
public class FreeResponseQuestion extends Question {
    /**
     * Constructor the the free response trivia questions.
     * @param theQuestion The question prompt.
     * @param theAnswer The answer.
     */
    public FreeResponseQuestion(final String theQuestion, final String theAnswer) {
        super(theQuestion, theAnswer);
    }

    /**
     * Creates a String representation of free response questions.
     * @return The String representation of free response questions.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString() + "\n");
        return sb.toString();
    }
}