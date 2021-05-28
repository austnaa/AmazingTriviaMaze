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
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.Timer;
import model.Door;
import model.MazeBuilder;
import model.MazeManager;
import model.Player;
import model.Room;

/**
 * The panel that paints the graphics of the program. 
 * 
 * @author Daniel Jiang
 * @author Austn Attaway
 * @author Chau Vu
 * @version Spring 2021
 * The class for the Player model's movement.
 */
public class GamePanel extends JPanel implements ActionListener, KeyListener {
    
    /** An auto-generated serial version UID for object Serialization */
    private static final long serialVersionUID = 86445190678492115L;
    
    /** The delay between each game tick. */
    private static final int TICK_DELAY = 30;
    
    /**
     * The internal game timer.
     */
    final Timer myGameTimer;

    /**
     * This Panel's Player 
     */ 
    private Player myPlayer;

    /**
     * The MazeManager that keeps track of the available Mazes and the current maze.
     */
    private MazeManager myMazeManager;
    
    
    /**
     * Constructs a new GamePanel. 
     * Adds a key listener to the player movement and starts the game timer.
     */
    public GamePanel() {
        addKeyListener(this);
        setFocusable(true);   
        myPlayer = new Player();
        myGameTimer = new Timer(TICK_DELAY, this);
        myGameTimer.start();
        
        // sets up and handles the maze of rooms
        myMazeManager = new MazeManager();
    }
    
    /**
     * Call the draw method and paint component.
     */
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        Graphics2D g2d = (Graphics2D) theGraphics;
        
        final BackgroundSheet backgroundSheet = new BackgroundSheet();
        backgroundSheet.drawBackground(g2d, myMazeManager.getCurrentRoom());
        drawPlayerImage(g2d); 
        backgroundSheet.drawBottomRowTransparent(g2d, myMazeManager.getCurrentRoom());
        final ItemSheet itemsheet = new ItemSheet();
        itemsheet.drawBrainsList(g2d, myPlayer);
        MiniMap.drawMiniMap(g2d, myMazeManager.getCurrentMaze(), myMazeManager.getCurrentRoom());
        Toolkit.getDefaultToolkit().sync();
    }

    /**
     * draw player image on the screen.
     * @param theGraphics - the 2D Graphics
     */
    private void drawPlayerImage(final Graphics2D theGraphics) {
        theGraphics.drawImage(myPlayer.getImage(), myPlayer.getXPosition(), 
                myPlayer.getYPosition(), this);
    }
//    
//    /**
//     * draw the brains image on the screen.
//     */
//    
//    private void drawBrainImage(final Graphics2D theGraphics) {
//        theGraphics.drawImage(myPlayer.getBrainImage(), 400, 400, this);
//    }
    
    /**
     * Updates the player tick and repaints the panel.
     * @param theActionEvent The action event.
     */
    public void actionPerformed(final ActionEvent theActionEvent) {
        myPlayer.updatePlayerTick();
        repaint();
        requestFocus();        
    }

    /**
     * Handles the player movement with WASD on key press.
     * TODO - Later also handles the player interact between doors and items.
     * @param theKeyEvent The key event that is being listened for.
     */
    public void keyPressed(final KeyEvent theKeyEvent) {
        switch(theKeyEvent.getKeyCode()) {
            case KeyEvent.VK_W: // Up
                myPlayer.moveUp();
                break;
            case KeyEvent.VK_S: // Down
                myPlayer.moveDown();
                break;
            case KeyEvent.VK_A: // Left
                myPlayer.moveLeft();
                break;
            case KeyEvent.VK_D: // Right
                myPlayer.moveRight();
                break;
            case KeyEvent.VK_SPACE: // interaction
                interact();
                break;
                
        }
    }
    
    /**
     * Completes the interaction between the player and the interactable objects in the room.
     * 
     * TODO: controller code kinda
     */
    private void interact() {
        final Door interactedDoor = myMazeManager.getCurrentRoom().interact(myPlayer);
        
        
        if (interactedDoor != null && !interactedDoor.isLocked()) {
            myMazeManager.moveRooms(interactedDoor.getType());
            myPlayer.moveRooms(interactedDoor.getType());
        }

    }

    /**
     * Handles the player halting with WASD on key release.
     * TODO - Later also handles the player interact between doors and items.
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
            // TODO | Can add interaction here with spacebar
        }
    }

    /**
     * The type PlayerActions must implement the inherited abstract method KeyListener.keyTyped(KeyEvent).
     * @param theKeyEvent The key event that is being listened for.
     */
    public void keyTyped(final KeyEvent theKeyEvent) {

    }
}