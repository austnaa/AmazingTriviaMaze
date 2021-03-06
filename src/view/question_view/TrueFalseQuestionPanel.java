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
import model.question.Option;
import model.question.Question;
import model.question.TrueFalseQuestion;

import view.GamePanel;
import view.Sound;

/**
 * The class for multiple choice question panels.
 * @author Austn Attaway
 * @version Spring 2021
 */
public class TrueFalseQuestionPanel extends AbstractQuestionPanel {

    /** An auto-generated serial version UID for object Serialization */
    private static final long serialVersionUID = 5105930508290698162L;
    
    /** The true/false question that this panel is displaying. */
    private TrueFalseQuestion myQuestion;
    
    /** The options available for this true/false question. */
    private List<Option> myOptions;
    
    /** The player that could be affected from answering this panel's question incorrectly. */
    private Player myPlayer;
    
    /**
     * The question panel for multiple choice questions.
     * @param thePlayer The player.
     * @param theQuestion The multiple choice question.
     * @throws NullPointerException If the player is null.
     * @throws NullPointerException If the question is null.
     */
    public TrueFalseQuestionPanel(final Player thePlayer, final Question theQuestion) {
        super();
        myQuestion = (TrueFalseQuestion) Objects.requireNonNull(theQuestion, "theQuestion can not be null");
        myPlayer = Objects.requireNonNull(thePlayer, "thePlayer can not be null");
        myFrame = null;
        myOptions = myQuestion.getAllOptions();
        Collections.shuffle(myOptions);
        
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
       
        this.add(button1);
        this.add(button2);
        
        // Ensures that none of the options are selected beforehand.
        myQuestion.clearButtons();
        
        // Sets up the submit button.
        final JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 160, 90, 20);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
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