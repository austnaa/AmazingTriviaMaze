/**
 * Amazing Trivial Maze 
 * TCSS 360 Spring 2021
 */

package view.question_view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import model.question.MultipleChoiceQuestion;
import model.question.Option;

public class MultipleChoiceQuestionPanel extends JPanel {

    /** An auto-generated serial version UID for object Serialization */
    private static final long serialVersionUID = -2729044720547678473L;
    
    private MultipleChoiceQuestion myQuestion;
    private Option[] myOptions;
    
    public MultipleChoiceQuestionPanel(final MultipleChoiceQuestion theQuestion) {
        super();
        myQuestion = theQuestion;
        setup();
    }
    
    private void setup() {
        this.setLayout(null);
        // add the question label 
        final JLabel questionLabel = new JLabel();
        questionLabel.setText(myQuestion.getPrompt());
        questionLabel.setBounds(30, 10, 400, 30);
        add(questionLabel);
        
        // add the answer buttons
        myOptions = myQuestion.getOptions();
        JRadioButton button1 = myOptions[0];
        button1.setBounds(30, 50, 400, 20);
        
        JRadioButton button2 = myOptions[1];
        button2.setBounds(30, 70, 400, 20);
       
        JRadioButton button3 = myOptions[2];
        button3.setBounds(30, 90, 400, 20);
        
        JRadioButton button4 = myOptions[3];
        button4.setBounds(30, 110, 400, 20);
       
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        
//        // add the submit and cancel button
//        JButton cancelButton = new JButton("Cancel");
//        cancelButton.setBounds(90, 140, 90, 20);
//        cancelButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(final ActionEvent theEvent) {
//                
//            }
//        });
        
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(190, 140, 90, 20);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                boolean result = myQuestion.checkAnswer();
                if (result) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("incorrect");
                }
            }
        });
        
        this.add(submitButton);
//        this.add(cancelButton);
        
       
        
        this.setBackground(Color.WHITE);
        repaint();
        this.setVisible(true);
        
        
    }
    
//    @Override
//    public void paintComponent(final Graphics theGraphics) {
//        super.paintComponent(theGraphics);
//        theGraphics.setColor(Color.red);
//        theGraphics.drawRect(100, 100, 100, 100);
//    }
    
    
    
}
