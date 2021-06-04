package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Player;

/**
 * JUnit test class for the Player class. 
 * @author Chau Vu
 * @version Spring 2021
 */
public class PlayerTest {

    private Player myPlayer;
    
    @Before
    public void setUp() {
        myPlayer = new Player();
    }
    
    
    @Test
    public void test() {
        assertTrue(myPlayer != null);
    }
    
    

}
