package view;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * About Frame that pops up when users click on the
 * about button in the menubar.
 * 
 * @author Chau Vu
 * @version Spring 2021
 * Last updated 05/19/2021
 *
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
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
