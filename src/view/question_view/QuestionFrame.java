/**
 * Amazing Trivial Maze 
 * TCSS 360 Spring 2021
 */

package view.question_view;

import javax.swing.JFrame;
import javax.swing.JLabel;

import model.question.MultipleChoiceQuestion;
import model.question.Question;

public class QuestionFrame extends JFrame {
    
    public QuestionFrame(final MultipleChoiceQuestion theQuestion) {
        super();
        
        MultipleChoiceQuestionPanel mcqp = new MultipleChoiceQuestionPanel(theQuestion);
        add(mcqp);
       
      
        this.setTitle("Question Frame");
        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setAlwaysOnTop(true);
        requestFocus();
    }
}
