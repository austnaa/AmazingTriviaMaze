/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package view.question_view;

import java.util.Objects;

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
    
   
    /** The frame that contains this panel. */
    protected JFrame myFrame;


    
    /**
     * Sets the Frame for this panel. Important to use this method
     * before trying to use this panel.
     * @param theFrame theFrame that contains this panel
     * @throws NullPointerException when theFrame is null
     */
    public void setupFrame(final JFrame theFrame) {
        myFrame = Objects.requireNonNull(theFrame, "theFrame can not be null");
    }
    
//    /**
//     * Returns the Frame that contains this panel.
//     * @return theJFrame that contains this panel.
//     */
//    protected JFrame getFrame() {
//        return myFrame;
//    }

    
}