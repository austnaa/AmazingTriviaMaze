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
import java.util.Objects;

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
    
    /** The leftmost x position where the start buttons starts. */
    private static final int START_X = 214;
    
    /** The rightmost x position where the start buttons ends. */
    private static final int END_X = 214;
    
    /** The upper y position where the start buttons starts. */
    private static final int START_Y = 485;
    
    /** The lower y position where the start buttons ends. */
    private static final int END_Y = 534;
    
    
    
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
            public void mouseMoved(MouseEvent theEvent) {                 
                if (theEvent.getX() >= START_X && theEvent.getX() <= END_X && theEvent.getY() >= START_Y  && theEvent.getY() <= END_Y) {
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
     * 
     * @param theGraphics the Graphics2D object used for painting.
     * @throws NullPointerException if theGraphics is null
     */
    public void drawBackgroundImage(final Graphics2D theGraphics) {
        Objects.requireNonNull(theGraphics, "theGraphics can not be null");
        theGraphics.drawImage(myBackgroundImage, 0, 0, this);
    }
}