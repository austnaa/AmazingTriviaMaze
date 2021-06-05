/**
 * Amazing Trivia Maze
 * TCSS 360 Spring 2021
 */

package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.question.Option;

/**
 * A JUnit test class for the Option class.
 * @author Austn Attaway
 * @version Spring 2021
 */
public class OptionTest {
    
    /** Text to be used when creating options; */
    private static final String OPTION_TEXT = "option text!";
    
    /**
     * A correct option for testing. 
     */
    private Option myCorrectOption;
    
    /**
     * An incorrect option for testing. 
     */
    private Option myIncorrectOption;
    
    /**
     * Sets up the test fixtures before each test.
     */
    @Before
    public void setUp() {
        myCorrectOption = new Option(OPTION_TEXT, true);
        myIncorrectOption = new Option(OPTION_TEXT, false);
    }
    
    
    /**
     * Tests the Option constructor to make sure it throws
     * a NullPointerException when the given option text is null. 
     */
    @Test(expected = NullPointerException.class)
    public void testOptionConstructorNullText() {
        new Option(null, true);
    }
    
    /**
     * Tests the Option constructor to make sure it sets
     * the text properly.
     */
    @Test
    public void testOptionConstructorCorrectText() {
        assertEquals("Option constructor does not set the text properly", 
                OPTION_TEXT, myCorrectOption.getText());
    }
    
    /**
     * Tests the Option constructor to make sure the passed theCorrectOption
     * sets the state of the Option correctly.
     */
    @Test
    public void testOptionConstructorOptionCorrectPassing() {
        boolean result = myCorrectOption.isCorrectOption() && !myIncorrectOption.isCorrectOption();
        assertTrue("the Option constructor does not assign an Option the correct myCorrectOption state.",
                result);
    }
    
    /**
     * Tests the Option constructor to make sure it sets 
     * the Option to not be focusable.
     */
    @Test
    public void testOptionConstructorNotFocusable() {
        assertFalse("Option constructor does not properly set Options to not be focusable.", 
                myCorrectOption.isFocusable());
    }
    
    /**
     * Tests the isCorrectOption method for a correct Option.
     */
    @Test
    public void testIsCorrectOptionWithCorrectOption() {
        assertTrue("the isCorrectOption method failed with a correct option", 
                myCorrectOption.isCorrectOption());
    }
    
    /**
     * Tests the isCorrectOption method for an incorrect Option.
     */
    @Test
    public void testIsCorrectOptionWithIncorrectOption() {
        assertFalse("the isCorrectOption method failed with an incorrect option", 
                myIncorrectOption.isCorrectOption());
    }
    
    /**
     * Tests the toString method for a correct Option.
     */
    @Test
    public void testToStringCorrectOption() {
        final String expected = "Option: correct\n";
        assertEquals("the toString method failed on a correct Option", 
                expected, myCorrectOption.toString());
    }
    
    /**
     * Tests the toString method for an incorrect Option.
     */
    @Test
    public void testToStringIncorrectOption() {
        final String expected = "Option: incorrect\n";
        assertEquals("the toString method failed on an incorrect Option", 
                expected, myIncorrectOption.toString());
    }

}
