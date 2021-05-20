/**
 * Amazing Trivial Maze 
 * TCSS 360 Spring 2021
 */

package model.question;



/**
 * Simple main method used to test question components. 
 *
 */
public class QuestionTester {  
    public static void main(String[] args) {
              
        Option option1 = new Option("option 1", true);
        Option option2 = new Option("option 2", false);
        Option option3 = new Option("option 3", false);
        Option option4 = new Option("option 4", false);
        Option[] options = {option1, option2, option3, option4}; 
        
        MultipleChoiceQuestion mcq = new MultipleChoiceQuestion("Which option correct?", options);
        
        
        mcq.checkAnswer();
        
    }
}
