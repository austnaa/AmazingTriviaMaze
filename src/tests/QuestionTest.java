/**
 * Amazing Trivia Maze
 * TCSS 360 Spring 2021
 */

package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.question.Question.QuestionType;
import tests.mock_objects.QuestionMock;

/**
 * A JUnit test class for the Question abstract class. 
 * 
 * @author Austn Attaway
 * @version Spring 2021
 */
public class QuestionTest {

    /** A default String used for the question string text. */
    private static final String QUESTION_TEXT = "question";
    
    /**
     * A mock multiple choice question for testing.
     */
    private QuestionMock myMultipleChoiceQuestionMock;
    
    /**
     * A mock true/false question for testing.
     */
    private QuestionMock myTrueFalseQuestionMock;
    
    /**
     * A mock free response question for testing.
     */
    private QuestionMock myFreeResponseQuestionMock;
    
    /**
     * Sets up tests fixtures before each test.
     */
    @Before
    public void setUp() {
        myMultipleChoiceQuestionMock = new QuestionMock(QUESTION_TEXT, QuestionType.MULTIPLE_CHOICE);
        myTrueFalseQuestionMock = new QuestionMock(QUESTION_TEXT, QuestionType.TRUE_FALSE);
        myFreeResponseQuestionMock = new QuestionMock(QUESTION_TEXT, QuestionType.FREE_RESPONSE);
    }
    
    /**
     * Tests the Question constructor for a NullPointerException when the passed
     * question text is null.
     */
    @Test(expected = NullPointerException.class)
    public void testQuestionConstructorNullText() {
        new QuestionMock(null, QuestionType.MULTIPLE_CHOICE);
    }
    
    /**
     * Tests the Question constructor for a NullPointerException when the passed
     * QuestionType is null.
     */
    @Test(expected = NullPointerException.class)
    public void testQuestionConstructorNullType() {
        new QuestionMock(QUESTION_TEXT, null);
    }
    
    /**
     * Tests the Question constructor to ensure that the question text is set properly.
     */
    @Test
    public void testQuestionConstructorText() {
        assertEquals("the Question constructor failed to set the question text properly",
                QUESTION_TEXT, myMultipleChoiceQuestionMock.getQuestionPrompt());
    }
    
    
    /**
     * Tests the Question constructor to ensure that the QuestionType is set properly
     * with a multiple choice question.
     */
    @Test
    public void testQuestionConstructorQuestionTypeMultipleChoice() {
        assertEquals("the Question constructor failed to set the question type "
                + "to a multiple choice question.", 
                QuestionType.MULTIPLE_CHOICE, myMultipleChoiceQuestionMock.getType());
    }
    
    /**
     * Tests the Question constructor to ensure that the QuestionType is set properly
     * with a true/false question.
     */
    @Test
    public void testQuestionConstructorQuestionTypeTrueFalse() {
        
        assertEquals("the Question constructor failed to set the question type "
                + "to a true false question.",
                QuestionType.TRUE_FALSE, myTrueFalseQuestionMock.getType());
    }
    
    /**
     * Tests the Question constructor to ensure that the QuestionType is set properly
     * with a free response question.
     */
    @Test
    public void testQuestionConstructorQuestionTypeFreeResponse() {
        
        assertEquals("the Question constructor failed to set the question type properly",
                QuestionType.FREE_RESPONSE, myFreeResponseQuestionMock.getType());
    }
    
    /**
     * Tests the Question constructor to ensure that the question is initially set to 
     * not be answered yet.
     */
    @Test
    public void testQuestionConstructorSetUnansweredInitially() {
        assertFalse("the Question constructor failed to set the question to be initially unanswered", 
                myMultipleChoiceQuestionMock.getAnsweredAlready());
    }
    
    /**
     * Tests the getQuestionPrompt method to ensure it returns the correct String.
     */
    @Test
    public void testGetQuestionPrompt() {
        assertEquals("the getQuestionPrompt method failed to return the correct String", 
                QUESTION_TEXT, myMultipleChoiceQuestionMock.getQuestionPrompt());
    }
    
    /**
     * Tests the getAnsweredAlready method with a Question that has not been answered.
     */
    @Test
    public void testgetAnsweredAlreadyNotAnswered() {
        assertFalse("the getAnsweredAlready returned the incorrect value for a question"
                + " that had not been answered correctly.", 
                myMultipleChoiceQuestionMock.getAnsweredAlready());
    }
    
    /**
     * Tests the getAnsweredAlready method with a Question that has been answered.
     */
    @Test
    public void testgetAnsweredAlreadyAnswered() {
        myMultipleChoiceQuestionMock.setAnsweredAlready(true);
        assertTrue("the getAnsweredAlready returned the incorrect value for a question"
                + " that had been answered correctly.", 
                myMultipleChoiceQuestionMock.getAnsweredAlready());
    }
    
    /**
     * Tests the setAnsweredAlready method setting the question to not be answered.
     */
    @Test
    public void testSetAnsweredAlreadyNotAnswered() {
        myMultipleChoiceQuestionMock.setAnsweredAlready(false);
        assertFalse("the setAnsweredAlready method failed to set the question to not be answered.",
                myMultipleChoiceQuestionMock.getAnsweredAlready());
    }
    
    /**
     * Tests the setAnsweredAlready method setting the question to be answered.
     */
    @Test
    public void testSetAnsweredAlreadyAnswered() {
        myMultipleChoiceQuestionMock.setAnsweredAlready(true);
        assertTrue("the setAnsweredAlready method failed to set the question to be answered.",
                myMultipleChoiceQuestionMock.getAnsweredAlready());
    }
    
    /**
     * Tests the getType method with a MultipleChoiceQuestion
     */
    @Test
    public void testGetTypeMultipleChoiceQuestion() {
        assertEquals("the getType failed to return the correct type for a multiple choice question", 
                QuestionType.MULTIPLE_CHOICE, myMultipleChoiceQuestionMock.getType());
    }
    
    /**
     * Tests the getType method with a TrueFalseQuestion
     */
    @Test
    public void testGetTypeTrueFalseQuestion() {
        assertEquals("the getType failed to return the correct type for a true/false question", 
                QuestionType.TRUE_FALSE, myTrueFalseQuestionMock.getType());
    }
    
    /**
     * Tests the getType method with a FreeResponseQuestion
     */
    @Test
    public void testGetTypeFreeResponseQuestion() {
        assertEquals("the getType failed to return the correct type for a free response question", 
                QuestionType.FREE_RESPONSE, myFreeResponseQuestionMock.getType());
    }
    
    /**
     * Tests the toString method on a Question that is not answered yet.
     */
    @Test
    public void testToStringNotAnswered() {
        final String expected = "Question: " + QUESTION_TEXT + "\nIsAnswered: false\n";
        assertEquals("the toString method failed with an unanswered question", 
                expected, myMultipleChoiceQuestionMock.toString());
    }
    
    /**
     * Tests the toString method on a Question that is answered.
     */
    @Test
    public void testToStringAnswered() {
        final String expected = "Question: " + QUESTION_TEXT + "\nIsAnswered: true\n";
        myMultipleChoiceQuestionMock.setAnsweredAlready(true);
        assertEquals("the toString method failed with an unanswered question", 
                expected, myMultipleChoiceQuestionMock.toString());
    }

}
