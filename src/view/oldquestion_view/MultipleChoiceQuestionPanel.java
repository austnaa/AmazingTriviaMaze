/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */

package view.oldquestion_view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

import model.Player;
import model.oldquestion.MultipleChoiceQuestion;
import model.oldquestion.Option;

import view.GamePanel;


/**
 * A Panel that displays a multiple choice question.
 * 
 * @author Austn Attaway
 * @version Spring 2021
 */
public class MultipleChoiceQuestionPanel extends AbstractQuestionPanel {

    /** An auto-generated serial version UID for object Serialization */
    private static final long serialVersionUID = -2729044720547678473L;
    
    /**
     * The MultipleChoiceQuestion that this panel is displaying.
     */
    private MultipleChoiceQuestion myQuestion;
    
    // TODO: MAY NOT NEED THIS
    /**
     * The options available for this multiple choice question
     */
    private Option[] myOptions;
    
    /**
     * The Player object that could be affected from answering this panel's Question incorrectly.
     */
    private Player myPlayer;
    
    /**
     * The frame that contains this panel.
     */
    private JFrame myFrame;
    
    /**
     * Constructs a new MultipleChoiceQuestionPanel with the given Player and Question.
     * 
     * @param thePlayer the Player that could be affected by answering the given Question incorrectly.
     * @param theQuestion the MultipleChoiceQuestion this panel is displaying
     * @throws NullPointerException if thePlayer is null
     * @throws NullPointerException if theQuestion is null
     */
    public MultipleChoiceQuestionPanel(final Player thePlayer, final MultipleChoiceQuestion theQuestion) {
        super();
        myQuestion = Objects.requireNonNull(theQuestion, "theQuestion can not be null");
        myPlayer = Objects.requireNonNull(thePlayer, "thePlayer can not be null");

        myFrame = null;
        setup();
    }
    
    /**
     * Sets the Frame for this panel. Important to use this method
     * before trying to use the panel.
     * 
     * @param theFrame theFrame that contains this panel
     * @throws NullPointerException when theFrame is null
     */
    public void setupFrame(final JFrame theFrame) {
        myFrame = Objects.requireNonNull(theFrame, "theFrame can not be null");
    }
    
    /**
     * Sets up this panel.
     */
    private void setup() {
        this.setLayout(null);
        
        // add the question label 
        final JLabel questionLabel = new JLabel();
        questionLabel.setText(myQuestion.getPrompt());
        questionLabel.setBounds(30, 10, 400, 30);
        add(questionLabel);
        
        // add the answer buttons
        myOptions = myQuestion.getOptions();
        final JRadioButton button1 = myOptions[0];
        button1.setBounds(30, 50, 400, 20);
        
        final JRadioButton button2 = myOptions[1];
        button2.setBounds(30, 70, 400, 20);
       
        final JRadioButton button3 = myOptions[2];
        button3.setBounds(30, 90, 400, 20);
        
        final JRadioButton button4 = myOptions[3];
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
        
        final JButton submitButton = new JButton("Submit");
        submitButton.setBounds(190, 140, 90, 20);
        
        
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                boolean result = myQuestion.checkAnswer();
//                if (result) {
//                    System.out.println("Correct!");
//                } else {
//                    System.out.println("incorrect");
//                }
                
                // THIS IS WHERE WE COULD SHOW THAT THE ANSWER 
                // IS CORRECT OR CLOSE THE PANEL AND CHANGE ROOMS...
                if (myQuestion.isAnswered()) {
                    if (myFrame != null) {
                        myFrame.dispose();
                    }
                    GamePanel.interact();
                } 
                // question was not answered correctly, 
                // so decrement the number of brains remaining
                else {
                    myPlayer.setBrains(myPlayer.getBrainsremaining() - 1);
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