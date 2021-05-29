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
 * About Frame that pops up when users click on the
 * about button in the menubar.
 * 
 * @author Chau Vu
 * @version Spring 2021
 */
public class AboutFrame extends JFrame { 
    
    /**
     * Generated ID for serialization.
     */
    private static final long serialVersionUID = 6313021765242043472L;
    
    /**
     * About Frame constructor that sets up the frame.
     */
    public AboutFrame(){
        setTitle("About");
        final JLabel label = new JLabel();
        final String path = System.getProperty("user.dir") + "/assets/About.png";
        final BufferedImage img = BufferedImageLoader.loadImage(path);  
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