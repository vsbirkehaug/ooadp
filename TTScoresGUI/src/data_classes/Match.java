/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_classes;

import java.util.ArrayList;

/**
 *
 * @author VSB
 */
public class Match {
    private ArrayList<Set> sets;
    private Team homeTeam;
    private Team awayTeam;
    public final static int MAX_NUMBER_OF_SETS = 5;

    public Match(Team homeTeam, Team awayTeam) {
        //ASSUMPTION : a team cannot play itself
        if(!homeTeam.equals(awayTeam)) {
            setTeam(TeamType.HOME, homeTeam);
            setTeam(TeamType.AWAY, awayTeam);
        }
    }

    private void setTeam(TeamType teamId, Team team) {
        if(teamId.equals(TeamType.HOME)) {
            this.homeTeam = team;
        } else if (teamId.equals(TeamType.AWAY)) {
            this.awayTeam = team;
        } else {
            throw new IllegalArgumentException("Please select a valid team identifier for this team (HOME or AWAY");
        }
    }

    public Team getTeam(TeamType teamId) {
        if(teamId.equals(TeamType.HOME)) {
            return this.homeTeam;
        } else if (teamId.equals(TeamType.AWAY)) {
            return this.awayTeam;
        } else {
            throw new IllegalArgumentException("Please select a valid team identifier for this team (HOME or AWAY");
        }
    }

    
    public int getPointsForTeam(Team t) {
        int points = 0;
        if(homeTeam != null && awayTeam != null) {
            if(homeTeam.equals(t)) {
                points = 0;
                for(Set s : sets) {
                    points += s.getSetPointForTeam(TeamType.HOME);
                }
            } else if (awayTeam.equals(t)) {
                points = 0;
                for(Set s : sets) {
                    points += s.getSetPointForTeam(TeamType.AWAY);
                }
            } else {
                return 0;
            }   
        }
        return points;
    }

    public void setSets(ArrayList<Set> sets) {
        if(sets == null) {
            throw new IllegalArgumentException("Set list was null.");
        } else if (sets.size() == 5) {
            this.sets = sets;
        } else {
            throw new IllegalArgumentException("Set list was the wrong size. Please add a list of size " + Match.MAX_NUMBER_OF_SETS + ".");
        }
    }

    public ArrayList<Set> getSets() {
        if(sets != null) {
            return sets; 
        } else {
            return null;
        }
    }
    

}
