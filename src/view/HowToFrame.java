/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package view;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * The "How to Play" frame that pops up when users click
 * on the "How to Play" button in the menu bar.
 * @author Chau Vu
 * @version Spring 2021
 */
public class HowToFrame extends JFrame { 
    
    /** Generated ID for serialization. */
    private static final long serialVersionUID = -981295503148408992L;

    /**
     * The "How to Play" frame constructor that sets up the frame.
     */
    public HowToFrame() {
        setTitle("How To Play");
        final JLabel label = new JLabel();
        final String path = System.getProperty("user.dir") + "/assets/HowToPlay.png";
        final BufferedImage img = SheetLoader.loadImage(path);       
        label.setIcon(new ImageIcon(SheetLoader.resizeImage(img, GameFrame.FRAME_WIDTH, GameFrame.FRAME_HEIGHT)));
        add(label);  
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setAlwaysOnTop(true);
        requestFocus();
    }
}