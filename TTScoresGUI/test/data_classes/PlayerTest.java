/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_classes;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import data_classes.Player;

/**
 *
 * @author VSB
 */
@RunWith(JUnit4.class)
public class PlayerTest {
    
    String playerName = "Vilde";
    Player player = new Player(playerName);
   
    
    /**
     * Test of getPlayerSetsPlayed method, of class Player.
     */
    @Test
    public void test_GetPlayerSetsPlayed_zero_shouldSucceed() {
        int expResult = 0;
        int result = player.getSetsPlayed();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlayerSetsWon method, of class Player.
     */
    @Test
    public void test_GetPlayerSetsWon_zero_shouldSucceed() {
        int expResult = 0;
        int result = player.getSetsWon();
        assertEquals(expResult, result);
    }
    
    @Test
    public void test_GetPlayerSetsWon_someNumber_shouldSucceed() {
        int expResult = 0;
        int result = player.getSetsWon();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Player.
     */
    @Test
    public void test_GetName_shouldSucceed() {
        String expResult = playerName;
        String result = player.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Player.
     */
    @Test
    public void test_SetName_shouldSucceed() {
        String name = "Cat";
        player.setName(name);
        assertEquals(name, player.getName());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void test_SetName_empty_shouldFail() {
        String name = "";
        player.setName(name);
 
        assertEquals(name, player.getName());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void test_SetName_null_shouldFail() {
        String name = null;
        player.setName(name);
 
        assertEquals(name, player.getName());
    }
    
    @Test
    public void test_addSetsPlayed_addedTwo_shouldSucceed() {
        Player p = new Player(playerName);
        
        p.addSetsPlayed(2);
        
        assertEquals(2, p.getSetsPlayed());
        
    }
    
    @Test (expected=IllegalArgumentException.class)
    public void test_addSetsPlayed_addedNegativeOne_shouldFail() {
        Player p = new Player(playerName);
        
        p.addSetsPlayed(-1);
        
        //assertEquals(0, p.getSetsPlayed());
        
    }
    
    @Test (expected=IllegalArgumentException.class)
    public void test_addSetsPlayed_addedZero_shouldFail() {
        Player p = new Player(playerName);
        
        p.addSetsPlayed(0);
        
        //assertEquals(0, p.getSetsPlayed());
        
    }
}
