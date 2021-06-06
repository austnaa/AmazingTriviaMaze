/**
 * Amazing Trivia Maze
 * TCSS 360 Spring 2021
 */
package tests;

import static org.junit.Assert.*;

import java.util.List;

import model.question.Question;
import model.question.TriviaQuestions;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for TriviaQuestions.
 * @author Daniel Jiang
 * @version Spring 2021
 */
public class TriviaQuestionsTest {

	/** List of questions. */
	private List<Question> questions;
	
	/**
	 * Sets up the test class.
	 */
	@Before
	public void setUp() {
		questions = TriviaQuestions.getTriviaQuestions();
	}

	/**
     * Test method for {@link model.question.TriviaQuestions#getTriviaQuestions()}.
     */
	@Test
	public void testGetTriviaQuestions() {
		assertEquals("Failed to get questions from database.", 70, questions.size());
	}
}