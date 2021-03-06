/**
 * Amazing Trivia Maze
 * TCSS 360 Spring 2021
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.question.FreeResponseQuestion;
import model.question.Question.QuestionType;

/**
 * A JUnit test class for the free response question class.
 * @author Austn Attaway
 * @version Spring 2021
 */
public class FreeResponseQuestionTest {
    
    /** The question text passed into test free response questions. */ 
    private static final String QUESTION = "question";
    
    /** The answer text passed into test free response questions. */
    private static final String ANSWER = "answer";
    
    /**
     * A free response question used for testing.
     */
    private FreeResponseQuestion myFreeResponseQuestion;
    
    /**
     * Sets up test fixtures before each test.
     */
    @Before
    public void setUp() {
        myFreeResponseQuestion = new FreeResponseQuestion(QUESTION, ANSWER);
    }

    /**
     * Tests the free response question constructor for a
     * NullPointerException given a null question string.
     */
    @Test(expected = NullPointerException.class)
    public void testFreeResponseQuestionConstructorNullQuestionString() {
        new FreeResponseQuestion(null, ANSWER);
    }
    
    
    /**
     * Tests the free response question constructor for a
     * NullPointerException given a null answer string.
     */
    @Test(expected = NullPointerException.class)
    public void testFreeResponseQuestionConstructorNullAnswerString() {
        new FreeResponseQuestion(QUESTION, null);
    }
    
    /**
     * Tests the free response question constructor to 
     * properly set the answer string.
     */
    @Test
    public void testFreeResponseQuestionConstructorAnswerTextSetting() {
        assertEquals("the FreeResponseQuestion constructor failed to set the "
                + "question text properly", ANSWER, myFreeResponseQuestion.getAnswer());
    }
    
    /**
     * Tests the free response question constructor to 
     * ensure it properly sets the questions's type to be 
     * a free response question.
     */
    @Test
    public void testFreeResponseQuestionConstructorType() {
        assertEquals("the FreeResponseQuestion constructor failed to set the "
                + "question type properly", 
                QuestionType.FREE_RESPONSE, myFreeResponseQuestion.getType());
    }
    
    /**
     * Tests the get answer method to make sure it returns 
     * the correct string.
     */
    @Test
    public void testGetAnswer() {
        assertEquals("the getAnswer method failed to return the question text properly",
                ANSWER, myFreeResponseQuestion.getAnswer());
    }
    
    
    /**
     * Tests the check answer method with an invalid answer to ensure
     * the question's state is not answered afterwards and false is returned.  
     */
    @Test
    public void testCheckAnswerIncorrectAnswer() {
        final boolean methodResult = myFreeResponseQuestion.checkAnswer("not a correct answer");
        boolean result = true;
        
        // Make sure false is returned.
        if (methodResult != false) {
            result = false;
        }
        // Make sure the question's state is still unanswered.
        if (myFreeResponseQuestion.getAnsweredAlready()) {
            result = false;
        }
        
        assertTrue("the checkAnswer method failed to handle an answer that was incorrect.",
                result);
    }
    
    /**
     * Tests the check answer method with a perfectly correct input.
     * Makes sure the method returns true and also updates the state of the question to be answered.
     */
    @Test
    public void testCheckAnswerPerfectCorrectAnswer() {
        final boolean methodResult = myFreeResponseQuestion.checkAnswer(ANSWER);
        boolean result = true;
        
        // Make sure false is returned.
        if (methodResult == false) {
            result = false;
        }
        // Make sure the question's state is still unanswered.
        if (!myFreeResponseQuestion.getAnsweredAlready()) {
            result = false;
        }
        
        assertTrue("the checkAnswer method failed to handle an answer that was perfect.",
                result);
    }
    
    
    /**
     * Tests the check answer method with a correct input with whitespace
     * in front and after the answer to ensure the whitespace trim works.
     * Makes sure the method returns true and also updates the state of 
     * the question to be answered.
     */
    @Test
    public void testCheckAnswerCorrectAnswerWithSurroundingWhitespace() {
        final boolean methodResult = myFreeResponseQuestion.checkAnswer("  " + ANSWER + "  ");
        boolean result = true;
        
        // Make sure false is returned.
        if (methodResult == false) {
            result = false;
        }
        // Make sure the question's state is still unanswered.
        if (!myFreeResponseQuestion.getAnsweredAlready()) {
            result = false;
        }
        
        assertTrue("the checkAnswer method failed to handle an answer that was correct "
                + "but also had whitespace before and after the answer.", result);
    }
    
    /**
     * Tests the check answer method with a correct input with varying
     * uppercase and lowercase letters to ensure that case does not matter.
     * Makes sure the method returns true and also updates the state of 
     * the question to be answered.
     */
    @Test
    public void testCheckAnswerCorrectAnswerVaryingCapitalization() {
        // Test string is "AnswER".
        final String varyingCapitalizationSubstring = Character.toUpperCase(ANSWER.charAt(0)) 
                + ANSWER.substring(1, ANSWER.length() - 2) 
                + ANSWER.substring(ANSWER.length() - 2).toUpperCase();

        final boolean methodResult = myFreeResponseQuestion.checkAnswer(varyingCapitalizationSubstring);
        boolean result = true;
        
        // Make sure false is returned.
        if (methodResult == false) {
            result = false;
        }
        // Make sure the question's state is still unanswered.
        if (!myFreeResponseQuestion.getAnsweredAlready()) {
            result = false;
        }
        
        assertTrue("the checkAnswer method failed to handle an answer that was correct "
                + "but also had varying capitalization.", result);
    }
    
    /**
     * Tests the to string method for an unanswered question.
     */
    @Test
    public void testToStringUnansweredQuestion() {
        final String expected = "Question: " + QUESTION + "\nIsAnswered: false\nAnswer: " + ANSWER + "\n";
        assertEquals("the toString method failed on an unanswered question", 
                expected, myFreeResponseQuestion.toString());
    }
    
    /**
     * Tests the to string method for an answered question.
     */
    @Test
    public void testToStringAnsweredQuestion() {
        final String expected = "Question: " + QUESTION + "\nIsAnswered: false\nAnswer: " + ANSWER + "\n";
        
        assertEquals("the toString method failed on an answered question", 
                expected, myFreeResponseQuestion.toString());
    }
}