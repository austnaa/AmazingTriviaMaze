/**
 * Amazing Trivia Maze
 * TCSS 360 Spring 2021
 */
package view.question_view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Player;
import model.question.FreeResponseQuestion;
import model.question.Question;
import view.GamePanel;

/**
 * The class for free response question panels.
 * @author Austn Attaway
 * @version Spring 2021
 */
public class FreeResponseQuestionPanel extends AbstractQuestionPanel {

    /** An auto-generated serial version UID for object serialization. */
    private static final long serialVersionUID = -3013920620597350575L;
    
    /** The free response questions that this panel is displaying. */
    private FreeResponseQuestion myQuestion;
    
    /** The player will lose a brain for answering the question incorrectly. */
    private Player myPlayer;
    
    /**
     * The question panel for free response questions.
     * @param thePlayer The player.
     * @param theQuestion The free response question.
     */
    public FreeResponseQuestionPanel(final Player thePlayer, final Question theQuestion) {
        super();
        myQuestion = (FreeResponseQuestion) Objects.requireNonNull(theQuestion, "theQuestion can not be null");
        myPlayer = Objects.requireNonNull(thePlayer, "thePlayer can not be null");
        myFrame = null;
        setup();
    }
    
    /**
     * Sets up the free response question panel.
     */
    public void setup() {
        this.setLayout(null);
        
        // Adds the question label 
        final JLabel questionLabel = new JLabel();
        questionLabel.setText(myQuestion.getQuestionPrompt());
        questionLabel.setBounds(30, 10, 400, 30);
        add(questionLabel);
        
        // Text area
        final JTextField textField = new JTextField();
        textField.setBounds(30, 50, 400, 20);
        
        final JButton submitButton = new JButton("Submit");
        submitButton.setBounds(190, 140, 90, 20);
        
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                final boolean result = myQuestion.checkAnswer(textField.getText());// get text from textbox
                
                if (result) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("incorrect");
                }
                
                // THIS IS WHERE WE COULD SHOW THAT THE ANSWER 
                // IS CORRECT OR CLOSE THE PANEL AND CHANGE ROOMS...
                if (myQuestion.getAnsweredAlready()) {
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
                myFrame.dispose();
            }
        });
        
        this.add(submitButton);
        this.add(textField);       
        
        this.setBackground(Color.WHITE);
        repaint();
        this.setVisible(true);
    }
}