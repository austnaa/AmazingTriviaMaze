/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */

package view.oldquestion_view;

import java.util.Objects;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.oldquestion.AustnQuestion;
import model.oldquestion.MultipleChoiceQuestion;


/**
 * A Frame build particularly for containing QuestionPanel objects. 
 * 
 * @author Austn Attaway
 * @version Spring 2021
 */
public class QuestionFrame extends JFrame {
    
    /** An auto-generated serial version UID for object Serialization */
    private static final long serialVersionUID = -8649295778935069382L;

    /**
     * Constructs a new QuestionFrame that contains the given AbstractQuestionPanel 
     * @param thePanel the AbstractQuestionPanel that this frame will contain
     * @throws NullPointerException if thePanel is null
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
        requestFocus();
        thePanel.setupFrame(this);
    }
}