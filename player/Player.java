package player;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * @author Daniel Jiang
 * @version Spring 2021
 * Updated: May 13, 2021
 * The class for the Player model.
 */
// Tutorial source: https://www.youtube.com/watch?v=Yem67dViGSw
// TODO - We can probably merge the PlayerActions into here.
public class Player extends Rectangle
{
    /**
     * The initial player velocity on the x-axis.
     */
    private int myPlayerVelocityX = 0;

    /**
     * The initial player velocity on the y-axis.
     */
    private int myPlayerVelocityY = 0;

    /**
     * This constructs the Player model with the current parameters.
     * @param theStartingX The starting x-coordinate where the player will begin at.
     * @param theStartingY The starting y-coordinate where the player will begin at.
     * @param thePlayerWidth The width of the player model.
     * @param thePlayerHeight The height of the player model.
     */
    public Player(final int theStartingX, final int theStartingY, final int thePlayerWidth, final int thePlayerHeight)
    {
        // TODO | We can probably merge thePlayerWidth and thePlayerHeight into one parameter named thePlayerDimension as height x width
        // TODO | since thePlayerWidth and thePlayerHeight should be the same value conceptually
        setBounds(theStartingX, theStartingY, thePlayerWidth, thePlayerHeight);
    }

    /**
     * Updates the player tick.
     */
    public void updatePlayerTick()
    {
        this.x += myPlayerVelocityX;
        this.y += myPlayerVelocityY;
    }
    
    /**
     * Draws the player model with:
     *    x   | the x-coordinate of the rectangle to be filled
     *    y   | the y-coordinate of the rectangle to be filled
     *  width | the width of the rectangle
     *  height| the height of the rectangle
     * @param theGraphics
     */
    public void draw(final Graphics theGraphics)
    {
        theGraphics.fillRect(this.x, this.y, this.width, this.height);
    }

    /**
     * Setter for the player velocity on the x-axis.
     * @param thePlayerVelocityX The new value for the player's velocity on the x-axis.
     */
    public void setPlayerVelocityX(final int thePlayerVelocityX)
    {
        this.myPlayerVelocityX = thePlayerVelocityX;
    }

    /**
     * Setter for the player velocity on the y-axis.
     * @param thePlayerVelocityY The new value for the player's velocity on the y-axis.
     */
    public void setPlayerVelocityY(final int thePlayerVelocityY)
    {
        this.myPlayerVelocityY = thePlayerVelocityY;
    }
}