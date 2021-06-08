/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package view.question_view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import model.Player;
import model.question.MultipleChoiceQuestion;
import model.question.Option;
import model.question.Question;

import view.GamePanel;
import view.Sound;

/**
 * A panel that displays multiple choice questions.
 * @author Austn Attaway
 * @version Spring 2021
 */
public class MultipleChoiceQuestionPanel extends AbstractQuestionPanel {

    /** An auto-generated serial version UID for object Serialization */
    private static final long serialVersionUID = -2729044720547678473L;
    
    /** The multiple choice question that this panel is displaying. */
    private MultipleChoiceQuestion myQuestion;
    
    /** The options available for this multiple choice question. */
    private List<Option> myOptions;
    
    /** The player that could be affected from answering this panel's question incorrectly. */
    private Player myPlayer;
    
    /**
     * Constructs a new multiple choice question panel with the given player and question.
     * @param thePlayer The player affected by answering the question correctly/incorrectly.
     * @param theQuestion The multiple choice question this panel is dispalying.
     * @throws NullPointerException If the player is null.
     * @throws NullPointerException If the question is null.
     */
    public MultipleChoiceQuestionPanel(final Player thePlayer, final Question theQuestion) {
        super();
        myQuestion = (MultipleChoiceQuestion) Objects.requireNonNull(theQuestion, "theQuestion can not be null");
        myPlayer = Objects.requireNonNull(thePlayer, "thePlayer can not be null");
        myFrame = null;
        myOptions = myQuestion.getAllOptions();
        Collections.shuffle(myOptions);
        
        // Sets up the question text and option buttons.
        super.setQuestionPrompt(myQuestion.getQuestionPrompt());
        setupButtons();
        
        this.setVisible(true);
        repaint();
    }
    
    /**
     * Sets up and adds the buttons to this panel. 
     */
    private void setupButtons() {
        // Sets up the radio buttons.
        final JRadioButton button1 = myOptions.get(0);
        button1.setBounds(30, 60, 150, 20);
        
        final JRadioButton button2 = myOptions.get(1);
        button2.setBounds(30, 80, 150, 20);
       
        final JRadioButton button3 = myOptions.get(2);
        button3.setBounds(30, 100, 150, 20);
        
        final JRadioButton button4 = myOptions.get(3);
        button4.setBounds(30, 120, 150, 20);
       
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        
        // Ensures that none of the options are selected beforehand.
        myQuestion.clearButtons();
        
        // Sets up the submit button.
        final JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 160, 90, 20);
        submitButton.setFocusPainted(false);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                // Checks the answer from the player.
                myQuestion.checkAnswer();
                
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
    }
}