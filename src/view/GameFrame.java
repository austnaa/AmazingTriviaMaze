/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */

package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

import model.Door;
import model.MazeManager;
import model.Player;
import model.Room;

/**
 * The class for the Amazing Trivia Maze game frame.
 * @author Daniel Jiang
 * @author Chau Vu
 * @version Spring 2021
 */
public class GameFrame extends JFrame {
    // standard ui
    // start up set look and feel
    // 
   
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
        final StartPanel startPanel = new StartPanel(); 
        final GamePanel gamePanel = new GamePanel();
        final WinPanel winPanel = new WinPanel();

        add(startPanel); 
        startPanel.addMouseListener(new MouseAdapter() {          
            @Override
            public void mousePressed(final MouseEvent theEvent) {
//                System.out.println(e.getX() + ", " + e.getY());
                if(theEvent.getX() >= 214 && theEvent.getX() <= 427 && theEvent.getY() >= 485  && theEvent.getY() <= 534) {
                    startPanel.setVisible(false); 
                    add(gamePanel);
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
        GameFrame frame = new GameFrame();
    }

}