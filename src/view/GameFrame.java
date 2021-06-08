/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.sound.sampled.Clip;
import javax.swing.JFrame;

import model.MazeManager;
import model.question.QuestionManager;

/**
 * The class for the amazing trivia maze game frame.
 * @author Daniel Jiang
 * @author Austn Attaway
 * @author Chau Vu
 * @version Spring 2021
 */
public class GameFrame extends JFrame {
    
    /** An auto-generated serial version UID for object Serialization */
    private static final long serialVersionUID = -523569722387519606L;
    
    /** The width of the frame in pixels. */
    public static final int FRAME_WIDTH = 5*32*4;
    
    /** The height of the frame in pixels. */
    public static final int FRAME_HEIGHT = 5*32*4+45;
    
    /** The start panel displayed at the beginning of the game. */
    private StartPanel myStartPanel;
    
    /** The game panel displayed while the user is playing the game. */
    private GamePanel myGamePanel;
    
    /** The maze manager that helps manage the current game's and future games' mazes. */
    private MazeManager myMazeManager;

    /**
     * Creates the game frame.
     */
    public GameFrame() {
        myStartPanel = new StartPanel();
        final QuestionManager questionManager = new QuestionManager();
        myMazeManager = new MazeManager(questionManager);
        myGamePanel = new GamePanel(myMazeManager);
        setup();
    }

    /**
     * Sets up the frame.
     */
    private void setup() {
        
        // setup up frame settings
        this.setTitle("Amazing Trivia Maze");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setVisible(true);  
        this.setJMenuBar(new MenuBar());
        
        // Starts the menu sound.
        Sound.MENU.start();
        Sound.MENU.loop(Clip.LOOP_CONTINUOUSLY);
        
        // Adds a mouse listener to the start panel that checks if the user clicks the start button.
        myStartPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent theEvent) {
                if (theEvent.getX() >= 214 && theEvent.getX() <= 427 && theEvent.getY() >= 485  && theEvent.getY() <= 534) {
                    myStartPanel.setVisible(false);
                    Sound.MENU.stop();
                    Sound.GAMEPLAY.start();
                    Sound.GAMEPLAY.loop(Clip.LOOP_CONTINUOUSLY);
                    setNewGamePanel();    
                }
            } 
        });
        
        add(myStartPanel);
        setVisible(true);
    }
    
    /**
     * Sets up a new game instance by setting up a new game panel and adds.
     * it to this panel and ensures that the maze manager sets a new maze.
     */
    private void setNewGamePanel() {
        // Stops the timer on the current game panel.
        myGamePanel.disable();
        myGamePanel.setVisible(false);

        // Creates a new game panel.
        myMazeManager.setNewMaze();
        myGamePanel = new GamePanel(myMazeManager);
        myGamePanel.setVisible(true);
        
        add(myGamePanel);
        myGamePanel.grabFocus();
    }
}