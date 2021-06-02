/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package view.oldquestion_view;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Provides mandatory implementations for all classes that are QuestionPanels
 * @author Austn Attaway
 * @version Spring 2021
 */
public abstract class AbstractQuestionPanel extends JPanel {

    /** An auto-generated serial version UID for object Serialization */
    private static final long serialVersionUID = 3769172387697694444L;

    /**
     * Allows this QuestionPanel to access it's containing frame.
     *  
     * @param theFrame the frame that contains this panel
     * @throws NullPointerException if theFrame is null
     */
    public abstract void setupFrame(final JFrame theFrame);
}