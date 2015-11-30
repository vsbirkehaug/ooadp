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

    public void setHomeTeam(Team team) {
      this.homeTeam = team;
    }
    public Team getHomeTeam() {
      return this.homeTeam;
    }

    public void setAwayTeam(Team team) {
      this.awayTeam = team;
    }
    public Team getAwayTeam() {
      return this.awayTeam;
    }
    
    public int getPointsForTeam(Team t) {
        int points = 0;
        if(homeTeam != null && awayTeam != null) {
            if(homeTeam.equals(t)) {
                points = 0;
                for(Set s : sets) {
                    points += s.getHomePoints();
                }
            } else if (awayTeam.equals(t)) {
                points = 0;
                for(Set s : sets) {
                    points += s.getAwayPoints();
                }
            } else {
                return 0;
            }   
        }
        return points;
    }

    public void setSets(ArrayList<Set> sets) {
        if(sets.size() == 5) {
            this.sets = sets;
        } else {
            throw new IllegalArgumentException();
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
