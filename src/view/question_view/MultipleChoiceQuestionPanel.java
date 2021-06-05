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
 * A Panel that displays a multiple choice question.
 * @author Austn Attaway
 * @version Spring 2021
 */
public class MultipleChoiceQuestionPanel extends AbstractQuestionPanel {

    /** An auto-generated serial version UID for object Serialization */
    private static final long serialVersionUID = -2729044720547678473L;
    
    /** The MultipleChoiceQuestion that this panel is displaying. */
    private MultipleChoiceQuestion myQuestion;
    
    /** The options available for this multiple choice question. */
    private List<Option> myOptions;
    
    /** The Player object that could be affected from answering this panel's Question incorrectly. */
    private Player myPlayer;
    
    /**
     * Constructs a new MultipleChoiceQuestionPanel with the given Player and Question.
     * @param thePlayer the Player that could be affected by answering the given Question incorrectly.
     * @param theQuestion the MultipleChoiceQuestion this panel is displaying
     * @throws NullPointerException if thePlayer is null
     * @throws NullPointerException if theQuestion is null
     */
    public MultipleChoiceQuestionPanel(final Player thePlayer, final Question theQuestion) {
        super();
        myQuestion = (MultipleChoiceQuestion) Objects.requireNonNull(theQuestion, "theQuestion can not be null");
        myPlayer = Objects.requireNonNull(thePlayer, "thePlayer can not be null");
        myFrame = null;
        myOptions = myQuestion.getAllOptions();
        Collections.shuffle(myOptions);
        
        // set up the question prompt text and the buttons 
        super.setQuestionPrompt(myQuestion.getQuestionPrompt());
        setupButtons();
        
        this.setVisible(true);
        repaint();
    }
    
    /**
     * Sets up and adds the buttons to this panel. 
     */
    private void setupButtons() {
        // set up the radio buttons
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
        
        // ensure that none of the options are selected 
        myQuestion.clearButtons();
        
        // setup the submit button
        final JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 160, 90, 20);
        submitButton.setFocusPainted(false);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                // update the state of the question based on if the selected 
                // option is correct or not
                myQuestion.checkAnswer();
                
                // if the question was answered correctly close the question
                // frame and move through the door
                if (myQuestion.getAnsweredAlready()) {
                    GamePanel.interact();
                    final Clip openDoor = Sound.sound(Sound.DOOR_OPEN_SOUND, 0.5);
                    openDoor.start();
                } 
                // if the question was not answered correctly, 
                // decrement the number of brains remaining and close this question frame.
                else {
                    myPlayer.setBrains(myPlayer.getBrainsremaining() - 1);
                    final Clip loseBrain = Sound.sound(Sound.LOSE_BRAIN_SOUND, 0.5);
                    loseBrain.start();
                }
                // close the frame once the submit button has been pressed.
                if (myFrame != null) {
                    myFrame.dispose();
                }
                
            }
        });
        this.add(submitButton);
    }
}