/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

import javax.sound.sampled.Clip;
import javax.swing.JPanel;
import javax.swing.Timer;
import model.Door;
import model.MazeManager;
import model.Player;

/**
 * The panel that paints the graphics of the program.
 * @author Daniel Jiang
 * @author Austn Attaway
 * @author Chau Vu
 * @version Spring 2021
 */
public class GamePanel extends JPanel implements ActionListener, KeyListener {
    
    /** The delay between each game tick. */
    private static final int TICK_DELAY = 30;
    
    /** An auto-generated serial version UID for object Serialization */
    private static final long serialVersionUID = 86445190678492115L;
    
    /** The player. */ 
    private static Player myPlayer;
    
    /** The maze manager that keeps track of the available mazes and the current maze. */
    private static MazeManager myMazeManager;
    
    /** The internal game timer. */
    private final Timer myGameTimer;
    
    /** he item sheet responsible for drawing items. */
    private ItemSheet myItemSheet;
    
    /** The background sheet for drawing the background. */
    private BackgroundSheet myBackgroundSheet;
    
    /** The panel sheet used for drawing the win/lose panels. */
    private PanelSheet myPanelSheet;
    
    /**
     * Constructs a new game panel instance that corresponds to the current maze
     * in the given maze manager.
     * This adds a key listener to the player movement and starts the game timer.
     * 
     * @param theMazeManager The maze manager that tracks the current maze for the game instance.
     * @throws NullPointerException If the maze manager is null.
     */
    public GamePanel(final MazeManager theMazeManager) {
        myMazeManager = Objects.requireNonNull(theMazeManager, "theMazeManager can not be null");
        myPlayer = new Player();
        
        myItemSheet = new ItemSheet();
        myBackgroundSheet = new BackgroundSheet();
        myPanelSheet = new PanelSheet();
        
        myGameTimer = new Timer(TICK_DELAY, this);
        myGameTimer.start();  
        
        addKeyListener(this);
        setFocusable(true);
       
        // Mouse listener that ensures the panel is focused on mouse click.
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent theEvent) {
                super.mouseReleased(theEvent);
                GamePanel.this.grabFocus();
            }
        });
    }
    
    /**
     * Completes the interaction between the player and the interactable objects in the room.
     */
    public static void interact() {
        // Gets the door we are trying to interact with.
        // If there is no nearby door, then the interaction will be null.
        final Door interactedDoor = myMazeManager.getCurrentRoom().interact(myPlayer);
        
        // if the door isn't null or it isn't locked move through the door
        if (interactedDoor != null && !interactedDoor.isLocked()) {
            myMazeManager.moveRooms(interactedDoor.getType());
            myPlayer.moveRooms(interactedDoor.getType());
            final Clip openDoor = Sound.sound(Sound.DOOR_OPEN_SOUND, 0.5);
            openDoor.start();
        } 
    }
    
    /**
     * Ensures that the state of the game panel is disabled so it can no longer be used.
     */
    public void disable() {
        myGameTimer.stop();
    }

    /**
     * Draws the game onto the game panel.
     * @param theGraphics The graphics used for drawing.
     */
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;
        
        // Draws the background and the player.
        myBackgroundSheet.drawBackground(g2d, myMazeManager.getCurrentRoom()); 
        drawPlayerImage(g2d); 
        myBackgroundSheet.drawBottomRowTransparent(g2d, myMazeManager.getCurrentRoom());
        
        // Draws the brains and minimap.
        myItemSheet.drawBrainsList(g2d, myPlayer);
        MiniMap.drawMiniMap(g2d, myMazeManager.getCurrentMaze(), myMazeManager.getCurrentRoom());
        
        // Draws the win/lose panels if the state of the game makes sense.
        myPanelSheet.drawWinLosePanel(g2d, myMazeManager.getCurrentRoom(), myPlayer);
        Toolkit.getDefaultToolkit().sync();
    }
    
    /**
     * Updates the player tick and repaints the panel.
     * @param theActionEvent The action event.
     */
    public void actionPerformed(final ActionEvent theActionEvent) {
        myPlayer.updatePlayerTick();
        repaint();    
    }
    
    /**
     * Handles the player movement with WASD on key press.
     * @param theKeyEvent The key event that is being listened for.
     */
    public void keyPressed(final KeyEvent theKeyEvent) {
        switch(theKeyEvent.getKeyCode()) {
            case KeyEvent.VK_W: // Up.
                myPlayer.moveUp();
                break;
            case KeyEvent.VK_S: // Down.
                myPlayer.moveDown();
                break;
            case KeyEvent.VK_A: // Left.
                myPlayer.moveLeft();
                break;
            case KeyEvent.VK_D: // Right.
                myPlayer.moveRight();
                break;
            case KeyEvent.VK_SPACE: // Interaction.
                myPlayer.stopMovingX();
                myPlayer.stopMovingY();
                interact();           
                break;       
        }
    }
    
    
    /**
     * Handles the player halting with WASD on key release.
     * @param theKeyEvent The key event that is being listened for.
     */
    public void keyReleased(final KeyEvent theKeyEvent) {
        switch(theKeyEvent.getKeyCode()) {
            case KeyEvent.VK_W: // Up
            case KeyEvent.VK_S: // Down
              myPlayer.stopMovingY();
                break;
            case KeyEvent.VK_A: // Left
            case KeyEvent.VK_D: // Right
                myPlayer.stopMovingX();
                break;
        }
    }

    /**
     * Unused (required method for implementing KeyListener).
     */
    public void keyTyped(final KeyEvent theKeyEvent) {
        
    }
    
    /**
     * Draws the player image on the screen.
     * @param theGraphics The graphics used for drawing.
     * @throws NullPointerException If the graphics are null.
     */
    private void drawPlayerImage(final Graphics2D theGraphics) {
        Objects.requireNonNull(theGraphics, "theGraphics can not be null");
        theGraphics.drawImage(myPlayer.getImage(), myPlayer.getXPosition(), 
                myPlayer.getYPosition(), this);
    }
}