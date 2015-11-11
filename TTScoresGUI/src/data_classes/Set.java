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
public class Set {
    private int maxNumberOfGames = 3;
    private ArrayList<Game> games;
    private String winner;
    private int homeWins;
    private int awayWins;

    public void addGame(Game game) {
      if(this.games == null) {
        this.games = new ArrayList<>();
      }
      if(this.games.size() < maxNumberOfGames) {
        this.games.add(game);
      } else {
        //TODO some error that says you cannot add more games to this set
      }
    }
    
    private int getHomeWins() {
        homeWins = 0;
        if(games.size() == maxNumberOfGames) {
            for(Game g : games) {
                if(g.gameWinner().equalsIgnoreCase("h")) {
                    homeWins = homeWins+1;
                }
            }
        }
        return homeWins;
    }
    
    private int getAwayWins() {
        awayWins = 0;
        if(games.size() == maxNumberOfGames) {
            for(Game g : games) {
                if(g.gameWinner().equalsIgnoreCase("a")) {
                    awayWins = awayWins+1;
                }
            }
        }
        return awayWins;
    }
    
    public int getHomePoint() {
        if(getHomeWins() > getAwayWins()) {
            return 1;
        } else {
            return 0;
        }
    }
    
    public int getAwayPoint() {
        if(getHomeWins() < getAwayWins()) {
            return 1;
        } else {
            return 0;
        }
    }
    
    //public String getWinner() {
    //    if(getHomeWins() > getAwayWins()) {
    //        return "h";
    //    } else if (getAwayWins() > getHomeWins()) {
    //        return "a";
    //    }
    //    return null;
    //}
    
}
