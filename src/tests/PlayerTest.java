package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import model.Door;
import model.Player;

/**
 * JUnit test class for the Player class. 
 * @author Chau Vu
 * @version Spring 2021
 */
public class PlayerTest {

    /**
     * The player of the game. 
     */
    private Player myPlayer;
    
    /**
     * The tickCount that we're using to test updated location.
     */
    private int myTickCount;
    
    /**
     * Set up method.
     */
    @Before
    public void setUp() {
        myPlayer = new Player();
        myTickCount = 50;
    }
    
    /**
     * expecting a null pointer exception if pass in a null door type.
     */
    @Test (expected = NullPointerException.class)
    public void testMoveRoomsNull() {
        myPlayer.moveRooms(null);
    }    
    
    /**
     * Test player cannot be null.
     */
    @Test
    public void testPlayerNotNull() {
        assertNotNull(myPlayer);        
    }
    
    /**
     * Testing if location updated based on tick.
     * When player moved down.
     */
    @Test
    public void testUpdatedLocationYMax() {
        final int locationY = myPlayer.getYPosition() + myTickCount * Player.MOVE_SPEED;
        myPlayer.moveDown();
        for (int i = 0; i < myTickCount; i++) { // 50 * 4
            myPlayer.updatePlayerTick();
        }
        assertEquals("Location is not updated properly", myPlayer.getYPosition(), locationY);
    }
    
    /**
     * Testing if location updated based on tick.
     * When player moved up.
     */
    @Test
    public void testUpdatedLocationYMin() {
        final int locationY = myPlayer.getYPosition() - myTickCount * Player.MOVE_SPEED;
        myPlayer.moveUp();
        for (int i = 0; i < myTickCount; i++) { // 50 * 4
            myPlayer.updatePlayerTick();
        }
        assertEquals("Location is not updated properly", myPlayer.getYPosition(), locationY);
    }
    
    /**
     * Testing if location updated based on tick.
     * When player moved right.
     */
    @Test
    public void testUpdatedLocationXMax() {
        final int locationX = myPlayer.getXPosition() + myTickCount * Player.MOVE_SPEED;
        myPlayer.moveRight();
        for (int i = 0; i < myTickCount; i++) { // 50 * 4
            myPlayer.updatePlayerTick();
        }
        assertEquals("Location is not updated properly", myPlayer.getXPosition(), locationX);
    } 
    
    /**
     * Testing if location updated based on tick.
     * When player move left.
     */
    @Test
    public void testUpdatedLocationXMin() {
        final int locationX = myPlayer.getXPosition() - myTickCount * Player.MOVE_SPEED;
        myPlayer.moveLeft();
        for (int i = 0; i < myTickCount; i++) { // 50 * 4
            myPlayer.updatePlayerTick();
        }
        assertEquals("Location is not updated properly", myPlayer.getXPosition(), locationX);
    }
    
    /**
     * Testing if location updated based on tick.
     * When player move down right.
     */
    @Test
    public void testMoveDownRight() {
        final int locationX = myPlayer.getXPosition() + myTickCount * Player.MOVE_SPEED;
        final int locationY = myPlayer.getYPosition() + myTickCount * Player.MOVE_SPEED;
        myPlayer.moveRight();
        myPlayer.moveDown();
        for (int i = 0; i < myTickCount; i++) { 
            myPlayer.updatePlayerTick();
        }
        assertEquals("Location is not updated properly", myPlayer.getXPosition(), locationX);
        assertEquals("Location is not updated properly", myPlayer.getYPosition(), locationY);
    }
    
    /**
     * Testing if location updated based on tick.
     * When player move down left.
     */
    @Test
    public void testMoveDownLeft() {
        final int locationX = myPlayer.getXPosition() - myTickCount * Player.MOVE_SPEED;
        final int locationY = myPlayer.getYPosition() + myTickCount * Player.MOVE_SPEED;
        myPlayer.moveLeft();
        myPlayer.moveDown();
        for (int i = 0; i < myTickCount; i++) { 
            myPlayer.updatePlayerTick();
        }
        assertEquals("Location is not updated properly", myPlayer.getXPosition(), locationX);
        assertEquals("Location is not updated properly", myPlayer.getYPosition(), locationY);
    }
    
    /**
     * Testing if location updated based on tick.
     * When player move up right.
     */
    @Test
    public void testMoveUpRight() {
        final int locationX = myPlayer.getXPosition() + myTickCount * Player.MOVE_SPEED;
        final int locationY = myPlayer.getYPosition() - myTickCount * Player.MOVE_SPEED;
        myPlayer.moveRight();
        myPlayer.moveUp();
        for (int i = 0; i < myTickCount; i++) { 
            myPlayer.updatePlayerTick();
        }
        assertEquals("Location is not updated properly", myPlayer.getXPosition(), locationX);
        assertEquals("Location is not updated properly", myPlayer.getYPosition(), locationY);
    }
    
    /**
     * Testing if location updated based on tick.
     * When player move up left.
     */
    @Test
    public void testMoveUpLeft() {
        final int locationX = myPlayer.getXPosition() - myTickCount * Player.MOVE_SPEED;
        final int locationY = myPlayer.getYPosition() - myTickCount * Player.MOVE_SPEED;
        myPlayer.moveLeft();
        myPlayer.moveUp();
        for (int i = 0; i < myTickCount; i++) { 
            myPlayer.updatePlayerTick();
        }
        assertEquals("Location is not updated properly", myPlayer.getXPosition(), locationX);
        assertEquals("Location is not updated properly", myPlayer.getYPosition(), locationY);
    }
    
    /**
     * Testing if location is updated based on tick.
     * When player stop moving x direction.
     */
    @Test
    public void testStopMovingX() {
        final int locationX = myPlayer.getXPosition();
        myPlayer.stopMovingX();
        for (int i = 0; i < myTickCount; i++) { 
            myPlayer.updatePlayerTick();
        }
        assertEquals("Location is not updated properly", myPlayer.getXPosition(), locationX);
    }
    /**
     * Testing if location is updated based on tick.
     * When player stop moving y direction.
     */
    @Test
    public void testStopMovingY() {
        final int location = myPlayer.getYPosition();
        myPlayer.stopMovingY();
        for (int i = 0; i < myTickCount; i++) { 
            myPlayer.updatePlayerTick();
        }
        assertEquals("Location is not updated properly", myPlayer.getYPosition(), location);
    }
    
    /**
     * Testing if the location is updated when player move room.
     * When moved to NORTH door x location.
     */
    @Test
    public void testMoveRoomNorthX() {
        final int location = Player.MAX_X / 2;
        myPlayer.moveRooms(Door.DoorType.NORTH);
        assertEquals("Location is not updated properly", myPlayer.getXPosition(), location);
    }
    /**
     * Testing if the location is updated when player move room.
     * When moved to NORTH door y location.
     */
    @Test
    public void testMoveRoomNorthY() {
        final int location = Player.MAX_Y;
        myPlayer.moveRooms(Door.DoorType.NORTH);
        assertEquals("Location is not updated properly", myPlayer.getYPosition(), location);
    }
    /**
     * Testing if the location is updated when player move room.
     * When moved to SOUTH door x location.
     */
    @Test
    public void testMoveRoomSouthX() {
        final int location = Player.MAX_X / 2;
        myPlayer.moveRooms(Door.DoorType.SOUTH);
        assertEquals("Location is not updated properly", myPlayer.getXPosition(), location);
    }
    /**
     * Testing if the location is updated when player move room.
     * When moved to SOUTH door y location.
     */
    @Test
    public void testMoveRoomSouthY() {
        final int location = Player.MIN_Y;
        myPlayer.moveRooms(Door.DoorType.SOUTH);
        assertEquals("Location is not updated properly", myPlayer.getYPosition(), location);
    }
    /**
     * Testing if the location is updated when player move room.
     * When moved to EAST door x location.
     */
    @Test
    public void testMoveRoomEastX() {
        final int location = Player.MIN_X;
        myPlayer.moveRooms(Door.DoorType.EAST);
        assertEquals("Location is not updated properly", myPlayer.getXPosition(), location);
    }
    /**
     * Testing if the location is updated when player move room.
     * When moved to EAST door y location.
     */
    @Test
    public void testMoveRoomEastY() {
        final int location = Player.MAX_Y / 2;
        myPlayer.moveRooms(Door.DoorType.EAST);
        assertEquals("Location is not updated properly", myPlayer.getYPosition(), location);
    }
    /**
     * Testing if the location is updated when player move room.
     * When moved to WEST door x location.
     */
    @Test
    public void testMoveRoomWestX() {
        final int location = Player.MAX_X;
        myPlayer.moveRooms(Door.DoorType.WEST);
        assertEquals("Location is not updated properly", myPlayer.getXPosition(), location);
    }
    /**
     * Testing if the location is updated when player move room.
     * When moved to WEST door y location.
     */
    @Test
    public void testMoveRoomWestY() {
        final int location = Player.MAX_Y / 2;
        myPlayer.moveRooms(Door.DoorType.WEST);
        assertEquals("Location is not updated properly", myPlayer.getYPosition(), location);
    }
    /**
     * Test get method for brains.
     */
    @Test
    public void testGetBrainsRemaining() {
        assertEquals("Value for brain isn't correct", myPlayer.getBrainsremaining(), Player.START_BRAINS);
    }
    
    /**
     * Test set method for brains.
     */
    @Test
    public void testSetBrainsRemaining() {
        myPlayer.setBrains(5);
        assertEquals("Value for brain isn't updated", myPlayer.getBrainsremaining(), 5);
    }
    /**
     * Test set method for brains max value.
     */
    @Test
    public void testSetBrainsRemainingMax() {
        myPlayer.setBrains(12);
        assertEquals("Value for brain isn't updated", myPlayer.getBrainsremaining(), Player.MAX_BRAINS);
    }
 
}
