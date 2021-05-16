/**
 * Amazing Trivial Maze 
 * TCSS 360 Spring 2021
 */

package view;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Objects;

/**
 * Class contains a method that
 * grabs the specific image from 
 * a spritesheet.
 * 
 * @author Austn Attaway
 * @author Chau Vu
 * @version Spring 2021
 * Updated: May 15, 2021
 */
// references: https://www.youtube.com/watch?v=jedilHUPO7c&t=1s
//             https://www.baeldung.com/java-resize-image
public class SpriteSheet extends SheetLoader {
   
    /** The row that contains images for upwards sprite animation. */
    public static int UP_MOVEMENT_ROW = 1;
    
    /** The row that contains images for downwards sprite animation. */
    public static int DOWN_MOVEMENT_ROW = 2;
    
    /** The row that contains images for leftwards sprite animation. */
    public static int LEFT_MOVEMENT_ROW = 3;
    
    /** The row that contains images for rightwards sprite animation. */
    public static int RIGHT_MOVEMENT_ROW = 4;
    
    /** The column that contains images for a player that is standing still. */
    public static int NO_MOVEMENT_COL = 1;
    
    /** The name of the sprite sheet image located in the assets folder. */
    private static final String FILE_NAME = "sprite_sheet.png";
     
    /**
     * Creates a new sprite sheet instance with the given sprite sheet image.
     */
    public SpriteSheet() {
        super(FILE_NAME);
    }
 
}
