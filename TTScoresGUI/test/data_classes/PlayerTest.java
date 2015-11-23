/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_classes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author VSB
 */
public class PlayerTest {
    
    String playerName = "Vilde";
    Player player = new Player(playerName);
    

    /**
     * Test of getPlayerSetsPlayed method, of class Player.
     */
    @Test
    public void testGetPlayerSetsPlayed() {
        int expResult = 0;
        int result = player.getPlayerSetsPlayed();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlayerSetsWon method, of class Player.
     */
    @Test
    public void testGetPlayerSetsWon() {
        int expResult = 0;
        int result = player.getPlayerSetsWon();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlayerSetsLost method, of class Player.
     */
    @Test
    public void testGetPlayerSetsLost() {
        int expResult = 0;
        int result = player.getPlayerSetsLost();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Player.
     */
    @Test
    public void testGetName() {
        String expResult = playerName;
        String result = player.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Player.
     */
    @Test
    public void testSetName() {
        String name = "Cat";
        player.setName(name);
        assertEquals(name, player.getName());
    }
    
}
