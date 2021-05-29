/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */

package view.question_view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.question.MultipleChoiceQuestion;
import model.question.Question;

public class QuestionFrame extends JFrame {
    
    public QuestionFrame(final JPanel thePanel) {
        super();
        
        add(thePanel);
       
        setTitle("Question Frame");
        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setAlwaysOnTop(true);
        requestFocus();
    }
}