/**
 * Amazing Trivia Maze
 * TCSS 360 Spring 2021
 */
package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import model.question.MultipleChoiceQuestion;
import model.question.Option;
import model.question.Question;

/**
 * Test class for TriviaQuestions.
 * @author Daniel Jiang
 * @version Spring 2021
 */
public class MultipleChoiceQuestionTest {

    /** Question text. */
    private String myQuestion;
    
    /** The answer. */
    private Option myAnswer;
    
    /** The second option. */
    private Option myOptionB;
    
    /** The third option. */
    private Option myOptionC;
    
    /** The fourth option. */
    private Option myOptionD;
    
    /** Multiple choice question. */
    private MultipleChoiceQuestion myMultipleChoiceQuestion;
    
    /**
     * Sets up the test class.
     */
    @Before
    public void setUp() {
        myQuestion = "Question";
        myAnswer = new Option("Answer", true);
        myOptionB = new Option("OptionB", false);
        myOptionC = new Option("OptionC", false);
        myOptionD = new Option("OptionD", false);
        myMultipleChoiceQuestion = new MultipleChoiceQuestion(myQuestion, myAnswer, myOptionB, myOptionC, myOptionD);
    }
    
    /**
     * Tests a null question text.
     */
    @Test(expected = NullPointerException.class)
    public void testNullQuestion() {
        myMultipleChoiceQuestion = new MultipleChoiceQuestion(null, myAnswer, myOptionB, myOptionC, myOptionD);
    }
    
    /**
     * Tests a null answer option.
     */
    @Test(expected = NullPointerException.class)
    public void testNullAnswer() {
        myMultipleChoiceQuestion = new MultipleChoiceQuestion(myQuestion, null, myOptionB, myOptionC, myOptionD);
    }
    
    /**
     * Tests a null option B.
     */
    @Test(expected = NullPointerException.class)
    public void testNullOptionB() {
        myMultipleChoiceQuestion = new MultipleChoiceQuestion(myQuestion, myAnswer, null, myOptionC, myOptionD);
    }
    
    /**
     * Tests a null option C.
     */
    @Test(expected = NullPointerException.class)
    public void testNullOptionC() {
        myMultipleChoiceQuestion = new MultipleChoiceQuestion(myQuestion, myAnswer, myOptionB, null, myOptionD);
    }
    
    /**
     * Tests a null option D.
     */
    @Test(expected = NullPointerException.class)
    public void testNullOptionD() {
        myMultipleChoiceQuestion = new MultipleChoiceQuestion(myQuestion, myAnswer, myOptionB, myOptionC, null);
    }

    /**
     * Tests the multiple choice question text.
     */
    @Test
    public void testQuestion() {
        assertEquals("The question is incorrect!", myMultipleChoiceQuestion.getQuestionPrompt(), "Question");
    }
    
    /**
     * Tests getting the answer.
     */
    @Test
    public void testGetAnswer() {
        assertEquals("The answer is incorrect!", myMultipleChoiceQuestion.getAnswer(), myAnswer);
    }
    
    /**
     * Tests the multiple choice question answered already.
     */
    @Test
    public void testAnsweredAlreadyFalse() {
        assertEquals("The question has not been answered yet!", myMultipleChoiceQuestion.getAnsweredAlready(), false);
    }
    
    /**
     * Tests the multiple choice question answered already to true.
     */
    @Test
    public void testAnsweredAlreadyTrue() {
        myMultipleChoiceQuestion.setAnsweredAlready(true);
        assertEquals("The question has not been answered already!", myMultipleChoiceQuestion.getAnsweredAlready(), true);
    }
    
    /**
     * Tests the question type of the multiple choice question.
     */
    @Test
    public void testQuestionType() {
        assertEquals("The question has not the correct type!", myMultipleChoiceQuestion.getType(), Question.QuestionType.MULTIPLE_CHOICE);
    }
    
    /**
     * Tests the toString method of the multiple choice question.
     */
    @Test
    public void testToString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Question: " + myQuestion + "\n");
        sb.append("IsAnswered: " + false + "\n");
        sb.append(myAnswer);
        sb.append(myOptionB);
        sb.append(myOptionC);
        sb.append(myOptionD);
        assertEquals("The question has not the correct type!", myMultipleChoiceQuestion.toString(), sb.toString());
    }
    
    /**
     * Tests the clear buttons method on the answer.
     */
    @Test
    public void testClearButtonsAnswer() {
        myMultipleChoiceQuestion.clearButtons();
        assertEquals("The answer was not cleared!", myAnswer.isSelected(), false);
    }
    
    /**
     * Tests the clear buttons method on OptionB.
     */
    @Test
    public void testClearButtonsOptionB() {
        myMultipleChoiceQuestion.clearButtons();
        assertEquals("OptionB was not cleared!", myOptionB.isSelected(), false);
    }
    
    /**
     * Tests the clear buttons method on OptionC.
     */
    @Test
    public void testClearButtonsOptionC() {
        myMultipleChoiceQuestion.clearButtons();
        assertEquals("OptionC was not cleared!", myOptionC.isSelected(), false);
    }
    
    /**
     * Tests the clear buttons method on OptionD.
     */
    @Test
    public void testClearButtonsOptionD() {
        myMultipleChoiceQuestion.clearButtons();
        assertEquals("OptionD was not cleared!", myOptionD.isSelected(), false);
    }

    /**
     * Tests getting the options only.
     */
    @Test
    public void testGetOptionsOnly() {
        final List<Option> list = new ArrayList<Option>();
        list.add(myOptionB);
        list.add(myOptionC);
        list.add(myOptionD);
        assertEquals("We didn't get the options only!", myMultipleChoiceQuestion.getOptionsOnly(), list);
    }

    /**
     * Tests getting all of the options (including the answer).
     */
    @Test
    public void testGetAllOptions() {
        final List<Option> list = new ArrayList<Option>();
        list.add(myAnswer);
        list.add(myOptionB);
        list.add(myOptionC);
        list.add(myOptionD);
        assertEquals("We didn't all the options (including the answer)!", myMultipleChoiceQuestion.getAllOptions(), list);
    }

    /**
     * Tests checking for the answer on the actual answer.
     */
    @Test
    public void testCheckAnswerMyAnswer() {
        myAnswer.setSelected(true);
        assertEquals("This is the correct answer!", myMultipleChoiceQuestion.checkAnswer(), true);
    }
    
    /**
     * Tests checking for the answer on OptionB.
     */
    @Test
    public void testCheckAnswerOptionB() {
        myOptionB.setSelected(true);
        assertEquals("This is the correct answer!", myMultipleChoiceQuestion.checkAnswer(), false);
    }
    
    /**
     * Tests checking for the answer on OptionC.
     */
    @Test
    public void testCheckAnswerOptionC() {
        myOptionC.setSelected(true);
        assertEquals("This is the correct answer!", myMultipleChoiceQuestion.checkAnswer(), false);
    }
    
    /**
     * Tests checking for the answer on OptionD.
     */
    @Test
    public void testCheckAnswerOptionD() {
        myOptionD.setSelected(true);
        assertEquals("This is the correct answer!", myMultipleChoiceQuestion.checkAnswer(), false);
    }
}