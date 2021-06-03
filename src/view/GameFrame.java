/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.sound.sampled.Clip;
import javax.swing.JFrame;

import model.Sound;

/**
 * The class for the Amazing Trivia Maze game frame.
 * @author Daniel Jiang
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

    /** The clip for managing the menu background music. */
    public static Clip MENU = Sound.sound(Sound.MENU_BGD, 0.5);

    /** The clip for managing the gameplay background music. */
    public static Clip GAMEPLAY = Sound.sound(Sound.GAMEPLAY_BGD, 0.5);

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
        MENU.start();
        MENU.loop(Clip.LOOP_CONTINUOUSLY);
    }

    /**
     * Starts the frame.
     */
    public void start() {
        final StartPanel startPanel = new StartPanel(); 
        final GamePanel gamePanel = new GamePanel();
        add(startPanel);

        startPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent theEvent) {
                if (theEvent.getX() >= 214 && theEvent.getX() <= 427 && theEvent.getY() >= 485  && theEvent.getY() <= 534) {
                    startPanel.setVisible(false);
                    MENU.stop();
                    GAMEPLAY.start();
                    GAMEPLAY.loop(Clip.LOOP_CONTINUOUSLY);
                    final GamePanel gamePanel = new GamePanel();
                    add(gamePanel);
                    gamePanel.grabFocus();
                }
            } 
        });  
        
//        if (myMazeManager.getCurrentRoom().isMyIsEndRoom()) {
//            gamePanel.setVisible(false);
//            add(winPanel);
//        }
        setVisible(true);
    }   
    
    /**
     * Starts the game frame.
     * @param theArgs The argument.
     */
    public static void main(final String[] theArgs) {
        final GameFrame frame = new GameFrame();
    }
}