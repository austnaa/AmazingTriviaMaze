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
 * The "About Us" frame that pops up when users click on the
 * "About Us" button in the menu bar.
 * @author Chau Vu
 * @version Spring 2021
 */
public class AboutFrame extends JFrame {

    /** Generated ID for serialization. */
    private static final long serialVersionUID = 6313021765242043472L;
    
    /**
     * Constructor that sets up the "About Us" frame.
     */
    public AboutFrame(){
        setTitle("About");
        final JLabel label = new JLabel();
        final String path = System.getProperty("user.dir") + "/assets/About.png";
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