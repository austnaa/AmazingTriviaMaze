/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package model.oldquestion;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import model.Player;
import model.question.Question;
import model.question.Question.QuestionType;
import model.question.TriviaQuestions;
import model.question.TrueFalseQuestion;
import view.GameFrame;
import view.GamePanel;
import view.oldquestion_view.MultipleChoiceQuestionPanel;
import view.oldquestion_view.QuestionFrame;


/**
 * Simple main method used to test question components. 
 * @author Austn Attaway
 * @version Spring 2021
 */
public class QuestionTester {
    
    /**
     * TODO
     * @param args
     */
    public static void main(String[] args) {
              
//        Option option1 = new Option("Minecraft", true);
//        Option option2 = new Option("Fornite", false);
//        Option option3 = new Option("Roblox", false);
//        Option option4 = new Option("Among Us", false);
//        Option[] options = {option1, option2, option3, option4}; 
//        
        Player p = new Player();
        Question question = TriviaQuestions.getTriviaQuestions().get(69);
        
//        System.out.println((Object) question instanceof TrueFalseQuestion);
        System.out.println(question.getType() == QuestionType.FREE_RESPONSE);
        
//        AbstractQuestionPanel panel
        if (question.getType() == QuestionType.MULTIPLE_CHOICE) {
            MultipleChoiceQuestionPanel panel = new MultipleChoiceQuestionPanel(p, question);
        } else if (question.getType() == QuestionType.TRUE_FALSE) {
            System.out.println("true false");
        } else if (question.getType() == QuestionType.FREE_RESPONSE) {
            System.out.println("free response");
        }
        
        
//        QuestionFrame frame = new QuestionFrame(panel);
        
        
        
//        Question question = new MultipleChoiceQuestion();
        
        
        
        
        
        
        
        
        
        
        
        
//        MultipleChoiceQuestion mcq = new MultipleChoiceQuestion("Which game is the most popular PC game?", 
//                options);
//        
//        FreeResponseQuestion frq = new FreeResponseQuestion("What is answer?", "answer");
//        System.out.println(frq.checkAnswer("Answer"));
//        
//        
//        
//        mcq.checkAnswer();
//        
//        MultipleChoiceQuestionPanel mcqp = new MultipleChoiceQuestionPanel(p, mcq);
//        new QuestionFrame(mcqp);
//        
//        QuestionManager qm = new QuestionManager();
        
        
//        GameFrame frame = new GameFrame();
//        GamePanel panel = new GamePanel();
//        frame.add(panel);
//        System.out.println("What is the frame?");
//        System.out.println(frame.equals( (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel)));
    }
}