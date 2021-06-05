/**
 * Amazing Trivia Maze
 * TCSS 360 Spring 2021
 */

package model.question;

import java.util.Objects;

import javax.swing.JRadioButton;

/**
 * Option radio buttons for multiple choice questions and true/false questions
 * @author Daniel Jiang
 * @version Spring 2021
 */
public class Option extends JRadioButton {
    
    /** Auto-generated serial version ID. */
    private static final long serialVersionUID = -2129560532822415441L;

    /** The correctness of the option. */
    private boolean myCorrectOption;

    /**
     * Constructor for the options for the multiple choice questions and true/false questions.
     * @param theOptionText The text of the option.
     * @param theCorrectOption The correctness of the option.
     */
    public Option(final String theOptionText, final boolean theCorrectOption) {
        super(Objects.requireNonNull(theOptionText, "theOptionText can not be null"));
        myCorrectOption = theCorrectOption;
        this.setFocusable(false);
    }

    /**
     * Checks for the correctness of the option.
     * @return The correctness of the option.
     */
    public boolean isCorrectOption() {
        return myCorrectOption;
    }

    /**
     * Creates a String representation of options.
     * @return The String representation of options.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Option: ");
        final String correct = myCorrectOption ? "correct\n" : "incorrect\n";
        sb.append(correct);
        return sb.toString();
    }
}