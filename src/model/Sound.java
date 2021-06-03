/**
 * Amazing Trivia Maze
 * TCSS 360 Spring 2021
 */
package model;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * The class for sound integration.
 * @author Daniel Jiang
 * @version Spring 2021
 */
public final class Sound {

    /** Path for the menu background music. */
    public static final String MENU_BGD = System.getProperty("user.dir") + "/assets/menubgd.wav";

    /** Path for the gameplay background music. */
    public static final String GAMEPLAY_BGD = System.getProperty("user.dir") + "/assets/gameplaybgd.wav";

    /** Path for the win sound. */
    public static final String WIN_SOUND = System.getProperty("user.dir") + "/assets/winsound.wav";

    /** Path for the lose sound. */
    public static final String LOSE_SOUND = System.getProperty("user.dir") + "/assets/losesound.wav";

    /**
     * Private constructor so we cannot initialize an object of this class.
     */
    private Sound() {

    }
    
    /**
     * The background music for the menu.
     * @return Background music for the menu.
     */
    public static Clip sound(final String thePath, final double theVolume) {
        Clip clip = null;
        try {
            final File file = new File(thePath);
            final AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            final FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(20f * (float) Math.log(theVolume));
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
        return clip;
    }
}