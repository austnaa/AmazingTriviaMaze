package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import model.Player;

/**
 * @author Daniel Jiang
 * @version Spring 2021
 * Updated: May 13, 2021
 * The class for the Player model's movement.
 */
public class GamePanel extends JPanel implements ActionListener, KeyListener {
    
    /** An auto-generated serial version UID for object Serialization */
    private static final long serialVersionUID = 86445190678492115L;

    /**
     * The internal game timer.
     * Param1 = the initial and between-event delay in milliseconds.
     * Param2 = the action listener associated with it.
     */
    final Timer gameTimer = new Timer(10, this);

    /**
     * The player model.
     * Param1 = starting x-coordinate.
     * Param2 = starting y-coordinate.
     * Param3 = player width.
     * Param4 = player height.
     */
    //final Player player = new Player(300, 300, 10, 10);
    final Player player = new Player();

    /**
     * The value for the player's speed/velocity.
     */
    //final static int PLAYER_SPEED = 3;

    /**
     * The value for halting the player on key release.
     */
    final static int PLAYER_HALT = 0;

    /**
     * Adds a key listener to the player movement and starts the game timer.
     */
    public GamePanel() {
        addKeyListener(this);
        setFocusable(true);

        gameTimer.start();
    }

    /**
     * Updates the player tick and repaints the panel.
     * @param theActionEvent The action event.
     */
    public void actionPerformed(final ActionEvent theActionEvent) {
        player.updatePlayerTick();
        repaint();
    }

    /**
     * Paints the panel and draws the player.
     * @param theGraphics The graphics.
     */
    public void paint(final Graphics theGraphics) {
        // Param1 = the x-coordinate of the rectangle to clear
        // Param2 = the y-coordinate of the rectangle to clear
        // Param3 = the width of the panel
        // Param4 = the height of the panel
        theGraphics.clearRect(0, 0, getWidth(), getHeight());
        player.draw(theGraphics);
    }

    /**
     * Handles the player movement with WASD on key press.
     * TODO - Later also handles the player interact between doors and items.
     * @param theKeyEvent The key event that is being listened for.
     */
    public void keyPressed(final KeyEvent theKeyEvent) {
        switch(theKeyEvent.getKeyCode()) {
            case KeyEvent.VK_W: // Up
                //player.setPlayerVelocityY(-PLAYER_SPEED);
                player.moveUp();
                break;
            case KeyEvent.VK_S: // Down
//                player.setPlayerVelocityY(PLAYER_SPEED);
                player.moveDown();
                break;
            case KeyEvent.VK_A: // Left
//                player.setPlayerVelocityX(-PLAYER_SPEED);
                player.moveLeft();
                break;
            case KeyEvent.VK_D: // Right
//                player.setPlayerVelocityX(PLAYER_SPEED);
                player.moveRight();
                break;
            // TODO | Can add interaction here with spacebar
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
//                player.setPlayerVelocityY(PLAYER_HALT);//
//                break;
            case KeyEvent.VK_S: // Down
//                player.setPlayerVelocityY(PLAYER_HALT);
//                break;
            case KeyEvent.VK_A: // Left
//                player.setPlayerVelocityX(PLAYER_HALT);
//                break;
            case KeyEvent.VK_D: // Right
//                player.setPlayerVelocityX(PLAYER_HALT);
//                break;
                player.stopMoving();
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