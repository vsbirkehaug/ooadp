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
public class GameTest {
    
    private int homeScore = 2;
    private int awayScore = 11;
    Game game = new Game(homeScore, awayScore);

    /**
     * Test of setHomeScore method, of class Game.
     */
     @Test
    public void test_SetHomeScore_one_shouldSucceed() {
        game.setHomeScore(1);
        assertEquals(1, game.getHomeScore());
    }
    
    @Test
    public void test_SetHomeScore_zero_shouldSucceed() {
        game.setHomeScore(0);
        assertEquals(0, game.getHomeScore());
    }
    
    @Test (expected=IllegalArgumentException.class)
    public void test_SetHomeScore_negativeNumber_shouldFail() {
        game.setHomeScore(-1);
    }
    
    /**
     * Test of getHomeScore method, of class Game.
     */
    @Test
    public void testGetHomeScore() {
        assertEquals(homeScore, game.getHomeScore());
    }

    /**
     * Test of setAwayScore method, of class Game.
     */
    @Test
    public void test_SetAwayScore_one_shouldSucceed() {
        game.setAwayScore(1);  
        assertEquals(1, game.getAwayScore());
    }
    
    @Test
    public void test_SetAwayScore_zero_shouldSucceed() {
        game.setAwayScore(0);  
        assertEquals(0, game.getAwayScore());
    }

    
    @Test (expected=IllegalArgumentException.class)
    public void test_SetAwayScore_negativeNumber_shouldFail() {
        game.setAwayScore(-1);  
    }
    
    /**
     * Test of getAwayScore method, of class Game.
     */
    @Test
    public void test_GetAwayScore() {
        assertEquals(awayScore, game.getAwayScore());
    }

    /**
     * Test of gameWinner method, of class Game.
     */
    @Test
    public void test_GameWinner_awayWins() {
        assertEquals("a", game.gameWinner());
    }
    
}
