/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package view.question_view;

import java.util.Objects;

import javax.swing.JFrame;

/**
 * A frame build particularly for containing question panel objects. 
 * @author Austn Attaway
 * @version Spring 2021
 */
public class QuestionFrame extends JFrame {
    
    /** An auto-generated serial version UID for object Serialization */
    private static final long serialVersionUID = -8649295778935069382L;

    /**
     * Constructs a new question frame that contains the given abstract question panel.
     * @param thePanel The abstract question panel that this frame will contain.
     * @throws NullPointerException If the panel is null.
     */
    public QuestionFrame(final AbstractQuestionPanel thePanel) {
        super();
        Objects.requireNonNull(thePanel, "thePanel can not be null");
        add(thePanel);
        setTitle("Question Frame");
        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setAlwaysOnTop(true);
        thePanel.setupFrame(this);
    }
}