/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_classes;

import data_classes.Team;
import data_classes.Player;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import tabletennisscores.TTScoreGUI1;

/**
 *
 * @author VSB
 */
@RunWith(JUnit4.class)
public class TeamTest {
    
    String teamName = "TestTeam";
    String teamVenue = "TestVenue";
    Team team = new Team(teamName, teamVenue);
    String playerOneName = "Vilde";
    String playerTwoName = "Elliot";
    String playerThreeName = "Ryan";
    
    @Rule 
    public ExpectedException thrown = ExpectedException.none();

    
    @Test
    public void test_GetTeamName_returnString() {
       assertEquals(teamName, team.getName());
    }
    
    @Test
    public void test_GetTeamVenueName() {
        assertEquals(teamVenue, team.getVenueName());
        assertEquals(teamVenue, team.getVenue().getName());
    }
    
    @Test
    public void test_AddPlayer_NoMoreThanMaxSize() {    
        for(int i = 0; i < (Team.MAX_TEAM_SIZE+1); i++) {
           team.addPlayer(new Player("Player"+(i+1))); 
        }
       assertEquals(2, team.getPlayers().size());
    }
    
    @Test
    public void test_toStringOverride_EqualsName_shouldSucceed() {
        assertEquals(teamName, team.toString());
    }

    @Test
    public void test_hasPlayerWithThisName_addedPlayer_shouldSucceed() {       
        team.addPlayer(new Player(playerOneName)); 
        assertEquals(true, team.hasPlayerWithThisName(playerOneName));
    }
    
    @Test
    public void test_hasPlayerWithThisName_notAdded_shouldFail() {
        assertEquals(false, team.hasPlayerWithThisName(playerOneName));
    }

    
    @Test
    public void test_hasRoomForMorePlayers_isEmpty_shouldSucceed() {
        assertEquals(true, team.hasRoomForMorePlayers());
    }
    
    @Test 
    public void test_hasRoomForMorePlayers_hasOne_shouldSucceed() {
        team.addPlayer(new Player(playerOneName));
        assertEquals(true, team.hasRoomForMorePlayers());
    }
    
    @Test
    public void test_hasRoomForMorePlayers_isFull_shouldFail() {
        
        for(int i = 0; i < Team.MAX_TEAM_SIZE; i++) {
           team.addPlayer(new Player("Player"+(i+1))); 
        }
 
        assertEquals(false, team.hasRoomForMorePlayers());   
    }
    
    @Test
    public void test_hasPlayer_playerAdded_shouldSucceed() {
        Player p = new Player(playerOneName);       
        team.addPlayer(p);     
        assertEquals(true, team.hasPlayer(p));
    }
    
    @Test
    public void test_hasPlayer_playerNotAdded_shouldFail() {
        Player p = new Player(playerOneName);                 
        assertEquals(false, team.hasPlayer(p));
    }

    @Test
    public void test_getPoints() {
        int points = TTScoreGUI1.manager.getPointsWonByTeam(team);
        assertEquals(points, TTScoreGUI1.manager.getPointsWonByTeam(team));
    }

}
