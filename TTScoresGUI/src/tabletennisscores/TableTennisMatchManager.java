/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabletennisscores;

import data_classes.Match;
import data_classes.Player;
import data_classes.Set;
import data_classes.Team;
import data_classes.Venue;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author VSB
 */
public class TableTennisMatchManager {
    
    private ArrayList<Team> teams;
    private ArrayList<Match> matches;
    private ArrayList<Player> players;
    public static TableTennisMatchManager INSTANCE;

    public TableTennisMatchManager() {
        if(INSTANCE == null) {
            INSTANCE = this;
            intializeLists();
            setupTestData();
        }
    }

    private void intializeLists() {
        teams = new ArrayList<>();
        matches = new ArrayList<>();  
        this.players = new ArrayList<>();
    } 
    
    public ArrayList<Player> getPlayers() {
        this.players.clear();
        
        for(Team t : teams) {
            for(Player p : t.getPlayers()) {
                this.players.add(p);
            }
        }
        return this.players;
    }
    
    public ArrayList<Match> getMatches() {
        return this.matches;
    }
    
    public ArrayList<Team> getTeams() {
        return this.teams;
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
        
        for(Team t : teams) {
            addPlayersToList(t.getPlayers());
        }
    }
    
    public Player getPlayerWithName(String name) {
        for(Player p : players) {
            if(p.getName().equals(name.trim())) {
                return p;
            }
        }
        return null;
    }
    
    private void addPlayersToList(ArrayList<Player> ps) {
        for(Player p : ps) {
            players.add(p);
        }
    }
   
    private boolean verifyPlayerNames(String teamName, String[] players) {
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
    
    public ArrayList<Team> getTeamsWithOpenPlayerSlots() {
        ArrayList<Team> availableTeams = new ArrayList<>();
        
        for(Team t : teams) {
            if(t.hasRoomForMorePlayers()) {
                availableTeams.add(t);
            }
        }
        
        return availableTeams;
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
    
    public Team getTeamWithName(String teamName) {
        if(teams != null && !teams.isEmpty()) {
            for(Team t : teams) {
                if(t.getName().equalsIgnoreCase(teamName.trim())){
                    return t;
                }              
            }
        }
        return null;
    }
    
    public void addMatch(Match m) {
        if(m != null) {
            matches.add(m);
            for(Set s : m.getSets()) {
                m.getHomeTeam().addSetsWon(s.getHomePoints());
                m.getAwayTeam().addSetsWon(s.getAwayPoints()); 
                addSetStatsToPlayers(s);
            }
            m.getHomeTeam().addSetsPlayed(m.getSets().size());
            m.getAwayTeam().addSetsPlayed(m.getSets().size());
        }
        
    }
    
    private void addSetStatsToPlayers(Set s) {
        for(Player p : s.getAllSetPlayers()) {
            p.addSetsPlayed(1);
        }
        
        if(s.getHomePoints() > s.getAwayPoints()) {
            for(Player p : s.getHomePlayers()) {
                p.addOneSetWin();
            }
        } else {
            for(Player p : s.getAwayPlayers()) {
                p.addOneSetWin();
            }
        }
        
    }

    public int getPointsWonByTeam(Team team) {
        int points = 0;
        if(matches != null && !matches.isEmpty()) {
            for(Match m : matches) {
                if(m.getPointsForTeam(team) >= 0) {
                    points = points + m.getPointsForTeam(team);
                }
            }
        }
        return points;
    }
    
   
        
}
