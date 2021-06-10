/**
 * Amazing Trivia Maze
 * TCSS 360 Spring 2021
 */
package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.question.Option;
import model.question.TrueFalseQuestion;
import model.question.Question.QuestionType;

/**
 * A JUnit test class for the true/false question class.
 * @author Austn Attaway
 * @version Spring 2021
 */
public class TrueFalseQuestionTest {
    
    /** The string used as the question text for the test questions. */
    private static final String QUESTION = "question";
    
    /** The string for the correct answer test options. */
    private static final String ANSWER = "answer";
    
    /** The string for the incorrect answer test options. */
    private static final String INCORRECT = "incorrect";
    
    /** A correct option used for testing. */
    private Option myOptionCorrect;
    
    /** An incorrect option used for testing. */
    private Option myOptionIncorrect;
    
    /** A true/false question used for testing. */
    private TrueFalseQuestion myTrueFalseQuestion;
    
    /**
     * Sets up test fixtures before each test.
     */
    @Before
    public void setUp() {
        myOptionCorrect = new Option(ANSWER, true);
        myOptionIncorrect = new Option(INCORRECT, false);
        myTrueFalseQuestion = new TrueFalseQuestion(QUESTION, myOptionCorrect, myOptionIncorrect);
    }

    /**
     * Tests true/false question constructor for a NullPointerException
     * when passed a null question string. 
     */
    @Test(expected = NullPointerException.class)
    public void testTrueFalseQuestionConstructorNullQuestion() {
        new TrueFalseQuestion(null, myOptionCorrect, myOptionIncorrect);
    }
    
    /**
     * Tests the true/false question constructor for a NullPointerException
     * when passed a null answer option. 
     */
    @Test(expected = NullPointerException.class)
    public void testTrueFalseQuestionConstructorNullAnswerOption() {
        new TrueFalseQuestion(QUESTION, null, myOptionIncorrect);
    }
    
    /**
     * Tests the true/false question constructor for a NullPointerException
     * when passed a null incorrect answer option.
     */
    @Test(expected = NullPointerException.class)
    public void testTrueFalseQuestionConstructorNullIncorrectAnswerOption() {
        new TrueFalseQuestion(QUESTION, myOptionCorrect, null);
    }
    
    /**
     * Tests the true/false question constructor for an IllegalArgumentException
     * if it is passed an answer option that does not have a state of correct.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testTrueFalseQuestionConstructorIllegalAnswerOption() {
        new TrueFalseQuestion(QUESTION, myOptionIncorrect, myOptionIncorrect);
    }
    
    /**
     * Tests the true/false question constructor for an IllegalArgumentException
     * if it is passed an incorrect answer option that does not have a state of incorrect.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testTrueFalseQuestionConstructorIllegalIncorrectAnswerOption() {
        new TrueFalseQuestion(QUESTION, myOptionCorrect, myOptionCorrect);
    }
    
    /**
     * Tests the true/false question constructor to make sure the 
     * given question string is set correctly.
     */
    @Test
    public void testTrueFalseQuestionConstructorSetQuestionString() {
        assertEquals("the TrueFalseQuestion constructor failed to "
                + "set the question text properly", 
                QUESTION, myTrueFalseQuestion.getQuestionPrompt());
    }
    
    /**
     * Tests the true/false question constructor to make sure the type of the question
     * is set to be a true/false question.
     */
    @Test
    public void testTrueFalseQuestionConstructorSetsCorrectType() {
        assertEquals("the TrueFalseQuestion constructor failed to set the correct type",
                QuestionType.TRUE_FALSE, myTrueFalseQuestion.getType());
    }
    
    /**
     * Tests the clear buttons method to ensure that none of the options
     * are selected afterwards.
     */
    @Test
    public void testClearButtons() {
        myOptionCorrect.setSelected(true);
        myOptionIncorrect.setSelected(true);
        
        myTrueFalseQuestion.clearButtons();
        
        assertTrue("clearButtons method failed to clear the selected buttons", 
                !myOptionCorrect.isSelected() && !myOptionIncorrect.isSelected());
    }
    
    /**
     * Tests the get all options method to ensure it returns the two expected options.
     * We expect both the answer option and the incorrect answer option to be returned in the list.
     */
    @Test
    public void testGetAllOptions() {
        List<Option> resultList = myTrueFalseQuestion.getAllOptions();
        
        assertTrue("getAllOptions failed to return all Options", 
                resultList.contains(myOptionCorrect) && resultList.contains(myOptionIncorrect));
    }
    
    /**
     * Tests the get answer method to ensure that it returns the correct answer option.
     */
    @Test
    public void testGetAnswer() {
        assertEquals("getAnswer did not return the correct Option", 
                myOptionCorrect, myTrueFalseQuestion.getAnswer());
    }
    
    /**
     * Tests the check answer method when the correct option is selected to ensure that
     * true is returned.
     */
    @Test
    public void testCheckAnswerCorrectSelectedForTrue() {
        myOptionCorrect.setSelected(true);
        assertTrue("checkAnswer did not return true after answering question correctly", 
                myTrueFalseQuestion.checkAnswer());
    }
    
    /** 
     * Tests the check answer method when the correct option is selected to ensure that 
     * the state of the question is set to answered.
     */
    @Test
    public void testCheckAnswerCorrectSelectedForCorrectAnsweredState() {
        answerQuestionCorrectly();
        assertTrue("checkAnswer did not update state properly after answering question correctly", 
                myTrueFalseQuestion.getAnsweredAlready());
    }
    
    /**
     * Tests the check answer method when the correct option is selected to ensure that
     * all of the buttons are cleared.
     */
    @Test
    public void testCheckAnswerCorrectSelectedForNoSelectedButtons() {
        answerQuestionCorrectly();
        assertTrue("checkAnswer did not unselect buttons after answering a question correctly", 
                !myOptionCorrect.isSelected() && !myOptionIncorrect.isSelected());
    }
    
    /**
     * Tests the check answer method when the incorrect option is selected to ensure that
     * false is returned.
     */
    @Test
    public void testCheckAnswerIncorrectSelectedForFalse() {
        myOptionIncorrect.setSelected(true);
        assertFalse("checkAnswer did not return false after answering a question incorrectly", 
                myTrueFalseQuestion.checkAnswer());
    }
      
    /** 
     * Tests the check answer method when the incorrect option is selected to ensure that
     * the state of the question is not to answered (if it was originally unanswered).
     */
    @Test
    public void testCheckAnswerIncorrectSelectedForUnansweredState() {
        myOptionIncorrect.setSelected(true);
        myTrueFalseQuestion.checkAnswer();
        assertFalse("checkAnswer did not leave the unanswered question state alone after answering a question incorrectly", 
                myTrueFalseQuestion.getAnsweredAlready());
    }
    
    /** 
     * Tests the check answer method when the incorrect option is selected and the 
     * question is already answered to ensure that the state of the question is still set to answered.
     */
    @Test
    public void testCheckAnswerIncorrectSelectedForAnsweredState() {
        answerQuestionCorrectly();
        myOptionIncorrect.setSelected(true);
        myTrueFalseQuestion.checkAnswer();
        assertTrue("checkAnswer updated the question state from answered to unanswered", 
                myTrueFalseQuestion.getAnsweredAlready());
    }
    
    /**
     * Tests the check answer method when the incorrect option is selected to ensure that
     * all of the buttons are cleared.
     */
    @Test
    public void testCheckAnswerIncorrectSelectedForNoSelectedButtons() {
        answerQuestionCorrectly();
        myOptionIncorrect.setSelected(true);
        myTrueFalseQuestion.checkAnswer();
        assertTrue("checkAnswer didn't clear the buttons from being selected", 
                !myOptionCorrect.isSelected() && !myOptionIncorrect.isSelected());
    }
    
    /**
     * Tests the to string method with a question that is answered.
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
     * Tests the to string method with a question that is not answered.
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
     * Helper method that sets my true/false question to be answered.
     */
    private void answerQuestionCorrectly() {
        myOptionCorrect.setSelected(true);
        myTrueFalseQuestion.checkAnswer();
    }
}