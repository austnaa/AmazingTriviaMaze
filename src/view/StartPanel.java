/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 * The panel that paints the start
 * images at the beginning.
 * @author Chau Vu
 * @version Spring 2021
 */
public class StartPanel extends JPanel {
    
    /** An auto-generated serial version UID for object serialization. */
    private static final long serialVersionUID = 3216576382698567738L;
    
    /** The image that represent the background. */
    private BufferedImage myBackgroundImage;
    
    /** The sheet that contains the background images. */
    private PanelSheet myBackgroundSheet;
    
    /**
     * Constructor that implements mouse motion listener for the "start button".
     */
    public StartPanel() {
        myBackgroundSheet = new PanelSheet();
        myBackgroundImage = myBackgroundSheet.grabPanelImage(1, 1);
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {                 
                if (e.getX() >= 214 && e.getX() <= 427 && e.getY() >= 485  && e.getY() <= 534) {
                    myBackgroundImage = myBackgroundSheet.grabPanelImage(2, 1);
                    repaint();
                } else {
                    myBackgroundImage = myBackgroundSheet.grabPanelImage(1, 1);
                    repaint();
                }
            }          
        });
        setFocusable(true);
        setVisible(true);
    }
  
    /**
     * Call the draw method and paint component.
     */
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;
        drawBackgroundImage(g2d);
        Toolkit.getDefaultToolkit().sync();  
    }
    
    /**
     * Draw the background image for the panel.
     * @param theGraphics
     */
    public void drawBackgroundImage(final Graphics2D theGraphics) {
        theGraphics.drawImage(myBackgroundImage, 0, 0, this);
    }
}