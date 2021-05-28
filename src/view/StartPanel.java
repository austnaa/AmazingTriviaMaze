package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 * The panel that paints the start
 * images at the beginning.
 * 
 * @author Chau Vu
 * @version Spring 2021
 */
public class StartPanel extends JPanel {

    /** An auto-generated serial version UID for object serialization. */
    private static final long serialVersionUID = 3216576382698567738L;
    
    /** the image that represent the background. */
    private BufferedImage myBackgroundImage;
    
    /**
     * Constructs a start panel
     */
    public StartPanel() {
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
     * draw the background image for the panel.
     * @param theGraphics
     */
    private void drawBackgroundImage(final Graphics2D theGraphics) {
        final String path = System.getProperty("user.dir") + "/assets/start_panel.png";
        myBackgroundImage = BufferedImageLoader.loadImage(path);
        theGraphics.drawImage(SheetLoader.resizeImage(myBackgroundImage, GameFrame.FRAME_WIDTH, GameFrame.FRAME_HEIGHT), 0, 0, this);
    }

}
