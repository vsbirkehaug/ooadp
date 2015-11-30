/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_classes;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author VSB
 */
public class MatchTest {
    
    Match match = new Match();
    String homeTeamName = "Bristol";
    String homeTeamVenue = "Bristol uni";
    Team homeTeam = new Team(homeTeamName, homeTeamVenue);
    String awayTeamName = "Plymouth";
    String awayTeamVenue = "Nancy Astor";
    Team awayTeam = new Team(awayTeamName, awayTeamVenue);
    

    /**
     * Test of setHomeTeam method, of class Match.
     */
    @Test
    public void testSetHomeTeam() {
        match.setHomeTeam(homeTeam);
        assertEquals(homeTeam, match.getHomeTeam());
    }

    /**
     * Test of getHomeTeam method, of class Match.
     */
    @Test
    public void testGetHomeTeam() {
        match.setHomeTeam(homeTeam);
        assertEquals(homeTeam, match.getHomeTeam());
    }

    /**
     * Test of setAwayTeam method, of class Match.
     */
    @Test
    public void testSetAwayTeam() {
        match.setAwayTeam(awayTeam);
        assertEquals(awayTeam, match.getAwayTeam());
    }

    /**
     * Test of getAwayTeam method, of class Match.
     */
    @Test
    public void testGetAwayTeam() {
        match.setAwayTeam(awayTeam);
        assertEquals(awayTeam, match.getAwayTeam());
    }

    /**
     * Test of getPointsForTeam method, of class Match.
     */
    @Test
    public void testGetPointsForTeam() {
        System.out.println("getPointsForTeam");
        Team t = null;
        Match instance = new Match();
        int expResult = 0;
        int result = instance.getPointsForTeam(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSets method, of class Match.
     */
    @Test
    public void test_SetSets() {
        System.out.println("setSets");
        ArrayList<Set> sets = null;
        Match instance = new Match();
        instance.setSets(sets);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSets method, of class Match.
     */
    @Test
    public void test_GetSets() {
        System.out.println("getSets");
        Match instance = new Match();
        ArrayList<Set> expResult = null;
        ArrayList<Set> result = instance.getSets();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
