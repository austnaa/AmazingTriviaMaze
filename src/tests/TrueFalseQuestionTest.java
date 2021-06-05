/**
 * Amazing Trivia Maze
 * TCSS 360 Spring 2021
 */

package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.question.Option;
import model.question.TrueFalseQuestion;

/**
 * A JUnit test class for the TrueFalseQuestion class.
 * 
 * @author Austn Attaway
 * @version Spring 2021
 */
public class TrueFalseQuestionTest {
    
    private static final String QUESTION = "question";
    private static final String ANSWER = "answer";
    private static final String INCORRECT = "incorrect";
    private Option myOptionCorrect;
    private Option myOptionIncorrect;
    private TrueFalseQuestion myTrueFalseQuestion;
    
    @Before
    public void setUp() {
        myOptionCorrect = new Option(ANSWER, true);
        myOptionIncorrect = new Option(INCORRECT, false);
        myTrueFalseQuestion = new TrueFalseQuestion(QUESTION, myOptionCorrect, myOptionIncorrect);
    }
    

    /**
     * Tests the TrueFalseQuestion constructor for a NullPointerException
     * when passed a null question String. 
     */
    
    /**
     * Tests the TrueFalseQuestion constructor for a NullPointerException
     * when passed a null answer Option. 
     */
    
    /**
     * Tests the TrueFalseQuestion constructor for a NullPointerException
     * when passed a null incorrect answer option.
     */
    
    /**
     * Tests the TrueFalseQuestion constructor for an IllegalArgumentException
     * if it is passed an answer Option that does not have a state of correct.
     */
    
    /**
     * Tests the TrueFalseQuestion constructor for an IllegalArgumentException
     * if it is passed an incorrect answer Option that does not have a state of incorrect.
     */
    
    /**
     * Tests the TrueFalseQuestion constructor to make sure the 
     * given question String is set correctly.
     */
    
    /**
     * Tests the TrueFalseQuestion constructor to make sure the type of the question
     * is set to be a true/false question
     */
    
    /**
     * Tests the clearButtons method to ensure that none of the Options 
     * (either answer or incorrect answer) are selected.
     */
    
    /**
     * Tests the getAllOptions method to ensure it returns the two expected Options. 
     * We expect both the answer option and the incorrect answer option to be returned in the List.
     */
    
    /**
     * Tests the getAnswer method to ensure that it returns the correct answer Option.
     */
    
    /**
     * Tests the checkAnswer method when the correct Option is selected to ensure that
     * true is returned.
     */
    
    /** 
     * Tests the checkAnswer method when the correct Option is selected to ensure that 
     * the state of the question is set to answered
     */
    
    /**
     * Tests the checkAnswer method when the correct Option is selected to ensure that
     * all of the buttons are cleared.
     */
    
    /**
     * Tests the checkAnswer method when the incorrect Option is selected to ensure that
     * false is returned.
     */
    
    /** 
     * Tests the checkAnswer method when the incorrect Option is selected to ensure that 
     * the state of the question is not to answered (if it was originally unanswered)
     */
    
    /** 
     * Tests the checkAnswer method when the incorrect Option is selected and the 
     * question is already answered to ensure that the state of the question is still set to answered.
     */
    
    /**
     * Tests the checkAnswer method when the correct Option is selected to ensure that
     * all of the buttons are cleared.
     */
    
    /**
     * Tests the toString method with a question that is answered.
     */
    @Test
    public void testToStringAnswered() {
        final String expected = "Question: " + QUESTION + 
                "\nIsAnswered: true\nCorrect answer: " + myOptionCorrect.toString() + 
                "\nIncorrect answer: " + myOptionIncorrect.toString() + "\n";
        answerQuestionCorrectly();
        assertEquals("the toString method failed to return a correct String for "
                + "a question that has not been answered yet.",
                expected, myTrueFalseQuestion.toString());
    }
    
    /**
     * Tests the toString method with a question that is not answered.
     */
    @Test
    public void testToStringNotAnswered() {
        final String expected = "Question: " + QUESTION + 
                "\nIsAnswered: false\nCorrect answer: " + myOptionCorrect.toString() + 
                "\nIncorrect answer: " + myOptionIncorrect.toString() + "\n";
        assertEquals("the toString method failed to return a correct String for "
                + "a question that has not been answered yet.",
                expected, myTrueFalseQuestion.toString());
    }
    
    /**
     * Helper method that sets myTrueFalseQuestion to be answered.
     */
    private void answerQuestionCorrectly() {
        myOptionCorrect.setSelected(true);
        myTrueFalseQuestion.checkAnswer();
    }
    

}
