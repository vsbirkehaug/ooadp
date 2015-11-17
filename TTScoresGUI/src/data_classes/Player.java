/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_classes;

import java.util.Arrays;
import tabletennisscores.TTScoreGUI1;

/**
 *
 * @author VSB
 */
public class Player {
    private String name;

    public int getPlayerSetsPlayed() {
        int setsPlayed = 0;
        for(Match m : TTScoreGUI1.manager.getMatches()) {
            for(Set s : m.getSets()) {
                if(Arrays.asList(s.getHomePlayers()).contains(this) || Arrays.asList(s.getAwayPlayers()).contains(this)) {
                   ++setsPlayed;
                }
            }
        }       
        return setsPlayed;
    }

    public int getPlayerSetsWon() {
        int setsWon = 0;
        for(Match m : TTScoreGUI1.manager.getMatches()) {
            if(m.getHomeTeam().getPlayers().contains(this)) {
                for(Set s : m.getSets()) {
                    if(Arrays.asList(s.getHomePlayers()).contains(this) && (s.getAwayPoint() < s.getHomePoint())) {
                       setsWon++; 
                    }
                }               
            } else if (m.getAwayTeam().getPlayers().contains(this)) {
                for(Set s : m.getSets()) {
                    if(Arrays.asList(s.getAwayPlayers()).contains(this) && (s.getAwayPoint() > s.getHomePoint())) {
                       setsWon++; 
                    }
                }  
            }          
        } 
        return setsWon;
    }

    public int getPlayerSetsLost() {
//        for(Match m : TTScoreGUI1.manager.matches) {
//            if(m.getHomeTeam().getPlayers().contains(this)) {
//                setsLost = setsLost + (m.MAX_NUMBER_OF_SETS - m.getPointsForTeam(m.getHomeTeam()));
//            } else if (m.getAwayTeam().getPlayers().contains(this)) {
//                setsLost = setsLost + (m.MAX_NUMBER_OF_SETS - m.getPointsForTeam(m.getAwayTeam()));
//            }          
//        }

        //assuming a set is either won or lost
        int setsLost = getPlayerSetsPlayed() - getPlayerSetsWon();
        return setsLost;
    }

    public Player(String name) {
        setName(name);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
