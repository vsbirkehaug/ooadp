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
    String name;
    int setsPlayed;
    int setsWon;
    int setsLost;

    public int getSetsPlayed() {
        setsPlayed = 0;
        for(Match m : TTScoreGUI1.manager.matches) {
            for(Set s : m.getSets()) {
                if(Arrays.asList(s.getHomePlayers()).contains(this) || Arrays.asList(s.getAwayPlayers()).contains(this)) {
                   ++setsPlayed;
                }
            }
        }       
        return setsPlayed;
    }

    public int getSetsWon() {
        setsWon = 0;
        System.out.println("get set wins for player: " + this.getName());
        for(Match m : TTScoreGUI1.manager.matches) {
            if(m.getHomeTeam().getPlayers().contains(this)) {  
                int setnumber = 1;
                for(Set s : m.getSets()) {
                    System.out.println("setnumber: " + setnumber);
                    if(Arrays.asList(s.getHomePlayers()).contains(this) && (s.getAwayPoint() < s.getHomePoint())) {
                       setsWon++; 
                    }
                    setnumber++;
                }               
            } else if (m.getAwayTeam().getPlayers().contains(this)) {
                int setnumber = 1;
                for(Set s : m.getSets()) {
                    System.out.println("setnumber: " + setnumber);
                    if(Arrays.asList(s.getAwayPlayers()).contains(this) && (s.getAwayPoint() > s.getHomePoint())) {
                       setsWon++; 
                    }
                    setnumber++;
                }  
            }          
        } 
        return setsWon;
    }

    public int getSetsLost() {
//        for(Match m : TTScoreGUI1.manager.matches) {
//            if(m.getHomeTeam().getPlayers().contains(this)) {
//                setsLost = setsLost + (m.MAX_NUMBER_OF_SETS - m.getPointsForTeam(m.getHomeTeam()));
//            } else if (m.getAwayTeam().getPlayers().contains(this)) {
//                setsLost = setsLost + (m.MAX_NUMBER_OF_SETS - m.getPointsForTeam(m.getAwayTeam()));
//            }          
//        } 
        setsLost = setsPlayed - setsWon;
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
