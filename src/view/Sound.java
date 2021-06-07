/**
 * Amazing Trivia Maze
 * TCSS 360 Spring 2021
 */
package view;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

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

    /** Path for the door opening sound. */
    public static final String DOOR_OPEN_SOUND = System.getProperty("user.dir") + "/assets/dooropensound.wav";

    /** Path for the lose brain sound. */
    public static final String LOSE_BRAIN_SOUND = System.getProperty("user.dir") + "/assets/losebrainsound.wav";

    /** The clip for managing the menu background music. */
    public static Clip MENU = Sound.sound(Sound.MENU_BGD, 0.5);

    /** The clip for managing the gameplay background music. */
    public static Clip GAMEPLAY = Sound.sound(Sound.GAMEPLAY_BGD, 0.5);

    /** The clip for managing the win sound. */
    public static Clip WIN = Sound.sound(Sound.WIN_SOUND, 0.5);

    /** The clip for managing the lose sound. */
    public static Clip LOSE = Sound.sound(Sound.LOSE_SOUND, 0.5);

    /** The clip for managing the lose brain sound. */
    public static Clip LOSE_BRAIN = Sound.sound(Sound.LOSE_BRAIN_SOUND, 0.5);

    /**
     * Private constructor so we cannot initialize an object of this class.
     */
    private Sound() {

    }
    
    /**
     * Returns an audio Clip object based on the given .wav music file.
     * 
     * @return Background music for the menu.
     * @param thePath the file path
     * @param theVolume the volume the clip should play at
     * @throws NullPointerException if thePath is null
     */
    public static Clip sound(final String thePath, final double theVolume) {
        Objects.requireNonNull(thePath, "thePath can not be null");
        Clip clip = null;
        try {
            final File file = new File(thePath);
            final AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            final FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(20f * (float) Math.log(theVolume));
        }
        catch (final IOException exception) {
            System.out.println("Unexpected input/output!");
        }
        catch (final UnsupportedAudioFileException exception) {
            System.out.println("Audio file is not supported (.wav only)!");
        }
        catch (final LineUnavailableException exception) {
            System.out.println("Audio line unavailable!");
        }
        return clip;
    }
}