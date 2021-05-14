package view;

import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 * @author Daniel Jiang
 * @version Spring 2021
 * Updated: May 13, 2021
 * The class for the Amazing Trivia Maze game frame.
 */
public class GameFrame extends JFrame {
    /**
     * Creates the game frame.
     */
    public GameFrame() {
        setTitle("Amazing Trivia Maze");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        start();
    }

    /**
     * Starts the frame.
     */
    public void start() {
        setLayout(new GridLayout(1, 1, 0, 0));
        PlayerActions player = new PlayerActions();
        add(player);
        setVisible(true);
    }

    /**
     * Starts the game frame.
     * @param theArgs The argument.
     */
    public static void main(final String[] theArgs) {
        GameFrame frame = new GameFrame();
    }
}