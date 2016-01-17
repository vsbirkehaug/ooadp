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

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author VSB
 */
public class TableTennisManager {

    private ArrayList<Team> teams;
    private ArrayList<Match> matches;
    public static TableTennisManager INSTANCE = new TableTennisManager();

    private TableTennisManager() {
        intializeLists();
        setupTestData();
    }

    private void intializeLists() {
        teams = new ArrayList<>();
        matches = new ArrayList<>();
    }

    public ArrayList<Player> getPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        for(Team t : teams) {
            for(Player p : t.getPlayers()) {
                players.add(p);
            }
        }
        return players;
    }

    public ArrayList<Match> getMatches() {
        return this.matches;
    }

    public ArrayList<Team> getTeams() {
        return this.teams;
    }

    private void setupTestData() {
        Team filtonTeam = new Team("Filton", "Gloucester road");
        filtonTeam.addPlayer(new Player("alex"));
        filtonTeam.addPlayer(new Player("brian"));
        teams.add(filtonTeam);
        Team uweTeam = new Team("UWE", "Frenchay campus");
        uweTeam.addPlayer(new Player("jin"));
        uweTeam.addPlayer(new Player("julia"));
        teams.add(uweTeam);
        Team kccTeam = new Team("KCC", "Fortfield road");
        kccTeam.addPlayer(new Player("Chris"));
        kccTeam.addPlayer(new Player("Ryan"));
        teams.add(kccTeam);
        Team pageTeam = new Team("Page", "Page road");
        pageTeam.addPlayer(new Player("Peter"));
        pageTeam.addPlayer(new Player("Phil"));
        teams.add(pageTeam);

 
    }

    public Player getPlayerWithName(String name) {
        for(Player p : getPlayers()) {
            if(p.getName().toLowerCase().equals(name.trim().toLowerCase())) {
                return p;
            }
        }
        throw new NullPointerException("Could not find player");
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
        return unverifiedPlayers == 0;
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
        return !(str != null && str.length() > 0);
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
            //System.out.println("" +verifyPlayerNames(hTeamName, hSinglesPlayers) );
            //System.out.println("" +verifyPlayerNames(aTeamName, aSinglesPlayers) );

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
                m.getHomeTeam().addSetsWon(s.getHomePoint());
                m.getAwayTeam().addSetsWon(s.getAwayPoint());
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

        if(s.getHomePoint() > s.getAwayPoint()) {
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


    public boolean matchExistsForThisTeamSetup(String homeTeamName, String awayTeamName) {
        for(Team t : teams) {
            System.out.println("Team: " + t.getName());
        }
        Team homeTeam = getTeamWithName(homeTeamName);
        Team awayTeam = getTeamWithName(awayTeamName);
        for(Match m : getMatches()) {
            if(m.getHomeTeam().equals(homeTeam) && m.getAwayTeam().equals(awayTeam)) {
                return true;
            }
        }
        return false;
    }

    public void addTeam(Team newTeam) {
        if(newTeam != null) {
            teams.add(newTeam);
        }
    }

    boolean hasTeamWithName(String newName) {
        for(Team t : getTeams()) {
            if(t.getName().equalsIgnoreCase(newName)) {
                return true;
            } 
        }
        
        return false;
    }
}
