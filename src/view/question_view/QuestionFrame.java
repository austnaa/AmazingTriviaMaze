/**
 * Amazing Trivia Maze
 * TCSS 360 Spring 2021
 */
package view.question_view;

import javax.swing.JFrame;

import view.GameFrame;

/**
 * Provides basic functionalities for all types of question frames.
 * @author Daniel Jiang
 * @version Spring 2021
 */
public abstract class QuestionFrame extends JFrame {
	
    /** Auto-generated serial ID for serialization. */
	private static final long serialVersionUID = 6121294826588417584L;

	/**
	 * TODO
	 * @param theGameFrame
	 */
	public QuestionFrame(final GameFrame theGameFrame) {
        setLocationRelativeTo(theGameFrame);
    }
}