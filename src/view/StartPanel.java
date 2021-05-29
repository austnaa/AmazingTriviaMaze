package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
    
    /** the sheet that contains the background images. */
    private BufferedImage myBackgroundSheet;
    
    /**
     * Constructor that implements mouse motion listener for the "start button".
     */
    public StartPanel() {
        final String path = System.getProperty("user.dir") + "/assets/start_sheet.png";
        myBackgroundSheet= BufferedImageLoader.loadImage(path);
        myBackgroundImage = SheetLoader.resizeImage(myBackgroundSheet.getSubimage(0, 0, 128, 128), GameFrame.FRAME_WIDTH, GameFrame.FRAME_HEIGHT);
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {                 
                if (e.getX() >= 214 && e.getX() <= 427 && e.getY() >= 485  && e.getY() <= 534) {
                    myBackgroundImage = SheetLoader.resizeImage(myBackgroundSheet.getSubimage(128, 0, 128, 128), GameFrame.FRAME_WIDTH, GameFrame.FRAME_HEIGHT);
                    repaint();
                } else {
                    myBackgroundImage = SheetLoader.resizeImage(myBackgroundSheet.getSubimage(0, 0, 128, 128), GameFrame.FRAME_WIDTH, GameFrame.FRAME_HEIGHT);
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
     * draw the background image for the panel.
     * @param theGraphics
     */
    public void drawBackgroundImage(final Graphics2D theGraphics) {
        theGraphics.drawImage(myBackgroundImage, 0, 0, this);
    }
}
