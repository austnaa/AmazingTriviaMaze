/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

/**
 * The class for the Amazing Trivia Maze game frame.
 * @author Daniel Jiang
 * @author Chau Vu
 * @version Spring 2021
 */
public class GameFrame extends JFrame {
    
    /** An auto-generated serial version UID for object Serialization */
    private static final long serialVersionUID = -523569722387519606L;
    
    /** The width of the frame in pixels. */
    public static final int FRAME_WIDTH = 5*32*4;
    
    /** The height of the frame in pixels. */
    public static final int FRAME_HEIGHT = 5*32*4+45;

    /**
     * TODO
     */
    private static final String MENU_BGD_PATH = System.getProperty("user.dir") + "/src/model/audio/menubgd.wav";
    
    /**
     * Creates the game frame.
     */
    public GameFrame() {
        setTitle("Amazing Trivia Maze");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        //setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);  
        this.setJMenuBar(new MenuBar());
        start();
    }

    /**
     * TODO
     */
    public void sound() {
        try {
            final String url = System.getProperty("user.dir") + "/assets/gameplay.wav";
            // String soundName = "yourSound.wav";    
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(url).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            // Adjust volume
            double gain = 0.2;   
            float dB = (float) (Math.log(gain) / Math.log(10.0) * 10.0);
            volume.setValue(dB);

            clip.start();
            // If you want the sound to loop infinitely, then put: clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            // If you want to stop the sound, then use clip.stop();
        }
        catch (final IOException e) {
            System.out.println("Unexpected input/output!");
        }
        catch (final UnsupportedAudioFileException e) {
            System.out.println("Audio file is not supported (.wav only)!");
        }
        catch (final LineUnavailableException e) {
            System.out.println("Audio line unavailable!");
        }
    }

    /**
     * Starts the frame.
     */
    public void start() {
        final StartPanel startPanel = new StartPanel(); 
        final GamePanel gamePanel = new GamePanel();
        add(startPanel); 

        // try {
        //     final AudioInputStream menuAudioInput = AudioSystem.getAudioInputStream(new File(MENU_BGD_PATH).getAbsoluteFile());
        //     final Clip menu = AudioSystem.getClip();
        //     menu.open(menuAudioInput);

        //     FloatControl volume = (FloatControl) menu.getControl(FloatControl.Type.MASTER_GAIN);

        //     // Adjust volume
        //     double gain = 0.20;   
        //     float dB = (float) (Math.log(gain) / Math.log(10.0) * 10.0);
        //     volume.setValue(dB);

        //     menu.start();
        //     // If you want the sound to loop infinitely, then put: clip.loop(Clip.LOOP_CONTINUOUSLY);
        //     menu.loop(Clip.LOOP_CONTINUOUSLY);
        // }
        // catch (final UnsupportedAudioFileException e) {
        //     System.out.println("Audio file is not supported (.wav only)!");
        // }
        // catch (final IOException e) {
        //     System.out.println("Unexpected input/output!");
        // }
        // catch (final LineUnavailableException e) {
        //     System.out.println("Audio line unavailable!");
        // }


        startPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent theEvent) {
                if (theEvent.getX() >= 214 && theEvent.getX() <= 427 && theEvent.getY() >= 485  && theEvent.getY() <= 534) {
                    startPanel.setVisible(false);
                    sound();
                    final GamePanel gamePanel = new GamePanel();
                    add(gamePanel);
                }
            } 
        });  
        
//        if (myMazeManager.getCurrentRoom().isMyIsEndRoom()) {
//            gamePanel.setVisible(false);
//            add(winPanel);
//        }
        setVisible(true);
    }   
    
    /**
     * Starts the game frame.
     * @param theArgs The argument.
     */
    public static void main(final String[] theArgs) {
        final GameFrame frame = new GameFrame();
    }
}