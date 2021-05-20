package view;

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JLabel label = new JLabel("test");
        add(label);
        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setAlwaysOnTop(true);
        requestFocus();
    }
}
