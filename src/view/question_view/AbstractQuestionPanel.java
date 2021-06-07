/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package view.question_view;

import java.util.Objects;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Provides general implementations for question panels.
 * 
 * @author Austn Attaway
 * @version Spring 2021
 */
public abstract class AbstractQuestionPanel extends JPanel {

    /** An auto-generated serial version UID for object Serialization */
    private static final long serialVersionUID = 3769172387697694444L;
    
    /** The frame that contains this panel. */
    protected JFrame myFrame;
    
    /**
     * Sets default values for a Question panel.
     */
    protected AbstractQuestionPanel() {
        this.setLayout(null);
    }
    
    /**
     * Sets the Frame for this panel. Important to use this method
     * before trying to use this panel.
     * 
     * @param theFrame theFrame that contains this panel
     * @throws NullPointerException when theFrame is null
     */
    public void setupFrame(final JFrame theFrame) {
        Objects.requireNonNull(theFrame, "theFrame can not be null");
        myFrame = Objects.requireNonNull(theFrame, "theFrame can not be null");
    }
    
    /**
     * Sets and displays the given question prompt on the panel.
     * 
     * @param theQuestionPrompt the given question prompt
     * @throws NullPointerException if theQuestionPrompt is null
     */
    protected void setQuestionPrompt(final String theQuestionPrompt) {
        Objects.requireNonNull(theQuestionPrompt, "theQuestionPrompt can not be null");
        // Adds the question label
        final JTextArea questionPromptArea = new JTextArea();
        questionPromptArea.setText(theQuestionPrompt);
        // NOTE: could change these magic numbers into variables
        questionPromptArea.setBounds(30, 20, 350, 50);
        questionPromptArea.setWrapStyleWord(true);
        questionPromptArea.setLineWrap(true);
        questionPromptArea.setOpaque(false);
        questionPromptArea.setEditable(false);
        questionPromptArea.setFocusable(false);

        add(questionPromptArea);
    }

}