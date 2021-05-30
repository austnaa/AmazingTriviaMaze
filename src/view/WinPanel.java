package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class WinPanel extends JPanel {

    /** An auto-generated serial version UID for object serialization. */
    private static final long serialVersionUID = -6756130806728348949L;
    
    /** the image that represent the background. */
    private BufferedImage myBackgroundImage;
    
    public WinPanel() {
        final String path = System.getProperty("user.dir") + "/assets/win_panel.png";
        myBackgroundImage = SheetLoader.resizeImage(BufferedImageLoader.loadImage(path).getSubimage(0, 0, 128, 128), GameFrame.FRAME_WIDTH, GameFrame.FRAME_HEIGHT);
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
    public void drawBackgroundImage(final Graphics2D theGraphics) {
        theGraphics.drawImage(myBackgroundImage, 0, 0, this);
    }
}
