/**
 * Amazing Trivia Maze
 * TCSS 360 Spring 2021
 */
package view.question_view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JTextField;

import model.Player;
import model.question.FreeResponseQuestion;
import model.question.Question;

import view.GamePanel;
import view.Sound;

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
    
    /** The player that could be affected from answering this panel's wuestion incorrectly. */
    private Player myPlayer;
    
    /**
     * The question panel for free response questions.
     * @param thePlayer The player.
     * @param theQuestion The free response question.
     * @throws NullPointerException If the player is null.
     * @throws NullPointerException If the question is null.
     */
    public FreeResponseQuestionPanel(final Player thePlayer, final Question theQuestion) {
        super();
        myQuestion = (FreeResponseQuestion) Objects.requireNonNull(theQuestion, "theQuestion can not be null");
        myPlayer = Objects.requireNonNull(thePlayer, "thePlayer can not be null");
        myFrame = null;
        
        super.setQuestionPrompt(myQuestion.getQuestionPrompt());
        setupComponents();
        
        this.setVisible(true);
        repaint();
    }
    
    /**
     * Sets up the text field and submit button for this panel.
     */
    private void setupComponents() {
        
        // Sets up the text area where the user answers.
        final JTextField textField = new JTextField();
        textField.setBounds(30, 60, 200, 20);
        
        // Sets up the submit button.
        final JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 100, 90, 20);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myQuestion.checkAnswer(textField.getText());
                
                // If the question was answered correctly.
                if (myQuestion.getAnsweredAlready()) {
                    GamePanel.interact();
                    final Clip openDoor = Sound.sound(Sound.DOOR_OPEN_SOUND, 0.5);
                    openDoor.start();
                } 
                // If the question was answered incorrectly.
                else {
                    myPlayer.setBrains(myPlayer.getBrainsremaining() - 1);
                    final Clip loseBrain = Sound.sound(Sound.LOSE_BRAIN_SOUND, 0.5);
                    loseBrain.start();
                }
                // Closes the frame once the submit button has been pressed.
                if (myFrame != null) {
                    myFrame.dispose();
                }
            }
        });
        this.add(submitButton);
        this.add(textField);           
    }
}