/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabletennisscores;

import data_classes.Match;
import data_classes.Player;
import data_classes.Team;
import data_classes.Venue;
import java.util.ArrayList;
import java.util.HashSet;

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
        Team filtonTeam = new Team("filton", "Gloucester road");
        filtonTeam.addPlayer(new Player("alex"));
        filtonTeam.addPlayer(new Player("brian"));
        teams.add(filtonTeam);
        Team uweTeam = new Team("uwe", "Frenchay campus");
        uweTeam.addPlayer(new Player("jin"));
        uweTeam.addPlayer(new Player("julia"));
        teams.add(uweTeam);
    }
   
    boolean verifyPlayerNames(String teamName, String[] players) {
        if(stringIsEmpty(teamName) || 
            anyPlayerNamesAreEmpty(players) || 
            anyPlayerNamesAreIdentical(players)) {
            
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
    
    private boolean anyPlayerNamesAreEmpty(String[] players) {
        for(String s : players) {
            if(stringIsEmpty(s)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean anyPlayerNamesAreIdentical(String[] players) {
        
        HashSet tempHashSet = new HashSet();
        
        for(String s : players) {
            if(!tempHashSet.add(s)) {
                return true;
            }
        }
        return false;
    }
    
    
        
    boolean stringIsEmpty(String str) {
        if(str != null && str.length() > 0) {
            return false;
        } else {
            return true;
        }
    }
    
    
    
    

     
     
     
    Boolean verifyNames(String hTeamName, String[] hSinglesPlayers, String[] hDoublesPlayers, 
                        String aTeamName, String[] aSinglesPlayers, String[] aDoublesPlayers) {
        
        if(verifyPlayerNames(hTeamName, hSinglesPlayers) 
        && verifyPlayerNames(hTeamName, hDoublesPlayers)
        && verifyPlayerNames(aTeamName, aSinglesPlayers)
        && verifyPlayerNames(aTeamName, aDoublesPlayers)
        ) {
          System.out.println("" +verifyPlayerNames(hTeamName, hSinglesPlayers) );
          System.out.println("" +verifyPlayerNames(aTeamName, aSinglesPlayers) );
          
        return true;
      } else {
        return false;
      }
    }

    void calculateScores(ArrayList<int[][]> scores) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
