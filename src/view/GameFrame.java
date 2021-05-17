package view;

import javax.swing.JFrame;

/**
 * @author Daniel Jiang
 * @version Spring 2021
 * Updated: May 13, 2021
 * The class for the Amazing Trivia Maze game frame.
 */
public class GameFrame extends JFrame {
   
    /** An auto-generated serial version UID for object Serialization */
    private static final long serialVersionUID = -523569722387519606L;
    
    /** The width of the frame in pixels. */
    public static final int FRAME_WIDTH = 5*32*4;
    
    /** The height of the frame in pixels. */
    public static final int FRAME_HEIGHT = 5*32*4+45;
    
    /**
     * Creates the game frame.
     */
    public GameFrame() {
        setTitle("Amazing Trivia Maze");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        //setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        
        this.setJMenuBar(new MenuBar());

        start();
    }

    /**
     * Starts the frame.
     */
    public void start() {
//        setLayout(new GridLayout(1, 1, 0, 0));
        GamePanel player = new GamePanel();
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