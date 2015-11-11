/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabletennisscores;

import classes.Match;
import classes.Player;
import classes.Team;
import classes.Venue;
import java.util.ArrayList;

/**
 *
 * @author VSB
 */
public class TableTennisMatchManager {
    
    public ArrayList<Team> teams;
    public ArrayList<Match> matches;

    public TableTennisMatchManager() {
        intializeLists();
        setupTestData();
    }

    private void intializeLists() {
        teams = new ArrayList<>();
        matches = new ArrayList<>();   
    }  
    
    private void setupTestData() {
        Team filtonTeam = new Team("filton");
        filtonTeam.setVenue(new Venue("Gloucester road"));
        filtonTeam.addPlayer(new Player("alex"));
        filtonTeam.addPlayer(new Player("brian"));
        teams.add(filtonTeam);
        Team uweTeam = new Team("uwe");
        uweTeam.setVenue(new Venue("Frenchay campus"));
        uweTeam.addPlayer(new Player("jin"));
        uweTeam.addPlayer(new Player("julia"));
        teams.add(uweTeam);
    }
   
    boolean verifyPlayerNames(String teamName, String[] players) {
        if(stringIsEmpty(teamName) || stringIsEmpty(players[0]) || stringIsEmpty(players[1])) {
            return false;
        }
        
        //to keep track of the verified players
        int unverifiedPlayers = players.length;
        
        for(Team t : teams) {
            if(t.getName().equalsIgnoreCase(teamName)) {
                for(String s : players) {
                     if(t.hasPlayerWithThisName(s)) {
                        unverifiedPlayers = unverifiedPlayers-1;
                    }
                }   
            }
        }
        if(unverifiedPlayers == 0) {
            return true;
        } else {
            return false;
        }
    }
        
    boolean stringIsEmpty(String str) {
        if(str != null && str.length() > 0) {
            return false;
        } else {
            return true;
        }
    }
    
    
    
    

     
     
     
    Boolean verifyNames(String homeTeamName, String[] homeTeamMembersNames, String awayTeamName, String[] awayTeamMembersNames) {
        if(verifyPlayerNames(homeTeamName, homeTeamMembersNames) && verifyPlayerNames(awayTeamName, awayTeamMembersNames)) {
          System.out.println("" +verifyPlayerNames(homeTeamName, homeTeamMembersNames) );
          System.out.println("" +verifyPlayerNames(awayTeamName, awayTeamMembersNames) );
          
        return true;
      } else {
        return false;
      }
    }

    void calculateScores(ArrayList<int[][]> scores) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
