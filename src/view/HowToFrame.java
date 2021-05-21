package view;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * How to play Frame that pops up when users click on the
 * How to play button in the menu bar.
 * 
 * @author Chau Vu
 * @version Spring 2021
 * Last updated 05/19/2021
 *
 */
public class HowToFrame extends JFrame { 
    
    /**
     * Generated ID for serialization.
     */
    private static final long serialVersionUID = -981295503148408992L;

    /**
     * How To Play Frame constructor that sets up the frame.
     */
    public HowToFrame(){
        setTitle("How To Play");
  
        final JLabel label = new JLabel();
        final String path = System.getProperty("user.dir") + "/assets/HowToPlay.png";
        final BufferedImage img = BufferedImageLoader.loadImage(path);  
        
        label.setIcon(new ImageIcon(SheetLoader.resizeImage(img, 600, 600)));
        add(label);
        setSize(600, 600);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setAlwaysOnTop(true);
        requestFocus();
    }
}
