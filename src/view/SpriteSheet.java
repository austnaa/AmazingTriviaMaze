/**
 * Amazing Trivia Maze 
 * TCSS 360 Spring 2021
 */
package view;

/**
 * Class contains a method that grabs the specific image from 
 * a spritesheet.
 * 
 * References: https://www.youtube.com/watch?v=jedilHUPO7c
 *             https://www.baeldung.com/java-resize-image
 * 
 * @author Austn Attaway
 * @author Chau Vu
 * @version Spring 2021
 */
public class SpriteSheet extends SheetLoader {
   
    /** The row that contains images for upwards sprite animation. */
    public static final int UP_MOVEMENT_ROW = 1;
    
    /** The row that contains images for downwards sprite animation. */
    public static final int DOWN_MOVEMENT_ROW = 2;
    
    /** The row that contains images for leftwards sprite animation. */
    public static final int LEFT_MOVEMENT_ROW = 3;
    
    /** The row that contains images for rightwards sprite animation. */
    public static final int RIGHT_MOVEMENT_ROW = 4;
    
    /** The row that contains images for up-leftwards sprite animation. */
    public static final int UP_LEFT_MOVEMENT_ROW = 5;
    
    /** The row that contains images for up-rightwards sprite animation. */
    public static final int UP_RIGHT_MOVEMENT_ROW = 6;
    
    /** The row that contains images for down-rightwards sprite animation. */
    public static final int DOWN_RIGHT_MOVEMENT_ROW = 7;
    
    /** The row that contains images for down-leftwards sprite animation. */
    public static final int DOWN_LEFT_MOVEMENT_ROW = 8;
    
    /** The column that contains images for a player that is standing still. */
    public static final int NO_MOVEMENT_COL = 1;
    
    /** The name of the sprite sheet image located in the assets folder. */
    private static final String FILE_NAME = "sprite_sheet.png";
     
    /**
     * Creates a new sprite sheet instance with the given sprite sheet image.
     */
    public SpriteSheet() {
        super(FILE_NAME);
    }
}