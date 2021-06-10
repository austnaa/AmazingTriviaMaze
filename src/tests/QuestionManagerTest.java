/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package tests;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import model.question.FreeResponseQuestion;
import model.question.MultipleChoiceQuestion;
import model.question.Question;
import model.question.QuestionManager;
import model.question.TrueFalseQuestion;

/**
 * A JUnit test class for the question manager class. 
 * @author Austn Attaway
 * @version Spring 2021
 */
public class QuestionManagerTest {
    
    /** The total number of questions in the database. */
    private static final int NUM_QUESTIONS = 70;
    
    /** The total number of multiple choice questions in the database. */
    private static final int NUM_MULTIPLE_CHOICE = 40;
    
    /** The total number of true/false questions in the database. */
    private static final int NUM_TRUE_FALSE = 20;
    
    /** The total number of free response questions in the database. */
    private static final int NUM_FREE_RESPONSE = 10;
    
    /** A question manager used for testing. */
    private QuestionManager myQuestionManager;

    /**
     * Sets up test fixtures before each test.
     */
    @Before
    public void setUp() {
        myQuestionManager = new QuestionManager();
    }
    
    /**
     * Tests the question manager constructor to ensure that
     * it creates a list of question objects.
     *
     * Indirectly tests the setup question list method
     * since it is the only thing that happens inside the constructor.
     */
    @Test
    public void testQuestionManagerConstructor() {
        final QuestionManager questionManager = new QuestionManager();
        boolean result = true;
        for (int i = 0; i < NUM_QUESTIONS; i++) {
            if (questionManager.getRandomQuestion() == null) {
                result = false;
                break;
            }
        }
        assertTrue("QuestionManager constructor failed to set up the QuestionManager question list",
                result);
    }
    
    /**
     * Tests the get random question method to see if 
     * it returns the correct number of multiple choice questions out of 
     * the total number of questions.
     */
    @Test
    public void testGetRandomQuestionNumMultipleChoice() {
        int multipleChoiceQuestionCount = 0;
        for (int i = 0; i < NUM_QUESTIONS; i++) {
            final Question question = myQuestionManager.getRandomQuestion();
            if (question instanceof MultipleChoiceQuestion) {
                multipleChoiceQuestionCount++;
            }
        }
        assertEquals("getRandomQuestion does not return the correct amount of multiple choice questions",
                NUM_MULTIPLE_CHOICE, multipleChoiceQuestionCount);
    }
    
    /**
     * Tests the get random question method to see if 
     * it returns the correct number of true false questions out of 
     * the total number of questions.
     */
    @Test
    public void testGetRandomQuestionNumTrueFalse() {
        int trueFalseQuestionCount = 0;
        for (int i = 0; i < NUM_QUESTIONS; i++) {
            final Question question = myQuestionManager.getRandomQuestion();
            if (question instanceof TrueFalseQuestion) {
                trueFalseQuestionCount++;
            }
        }
        assertEquals("getRandomQuestion does not return the correct amount of true/false questions",
                NUM_TRUE_FALSE, trueFalseQuestionCount);
    }
    
    /**
     * Tests the get random question method to see if 
     * it returns the correct number of true false questions out of 
     * the total number of questions.
     */
    @Test
    public void testGetRandomQuestionNumFreeResponse() {
        int freeResponseQuestionCount = 0;
        for (int i = 0; i < NUM_QUESTIONS; i++) {
            final Question question = myQuestionManager.getRandomQuestion();
            if (question instanceof FreeResponseQuestion) {
                freeResponseQuestionCount++;
            }
        }
        assertEquals("getRandomQuestion does not return the correct amount of multiple choice questions",
                NUM_FREE_RESPONSE, freeResponseQuestionCount);
    }
    
    /**
     * Tests the get random question method to see if 
     * it returns new question objects after it has used 
     * all questions from the database once.
     */
    @Test
    public void testGetRandomQuestionRepopulation() {
        Set<Question> questionSet = new HashSet<>();
        for (int i = 0; i < NUM_QUESTIONS * 2; i++) {
            questionSet.add(myQuestionManager.getRandomQuestion());
        }
        assertEquals("getRandomQuestion failed to populate the question list after it was empty", 
                NUM_QUESTIONS * 2, questionSet.size());
    }
}