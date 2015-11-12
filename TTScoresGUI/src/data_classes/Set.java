/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_classes;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author VSB
 */
public class Set {
    private int maxNumberOfGames = 3;
    private ArrayList<Game> games;

    public ArrayList<Game> getGames() {
        return games;
    }
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
    
    public Player[] getAllPlayers() {
        //will have to be changed if there are different players for the various set games
        
        ArrayList<Player> playersList = new ArrayList<>();
        for(Player p : games.get(0).getHomePlayer()) {
            playersList.add(p);
        }
        for(Player p : games.get(0).getAwayPlayer()) {
            playersList.add(p);
        }
        
        Player[] players = (Player[])playersList.toArray();
        return players;
    }
    
    public Player[] getHomePlayers() {
         //will have to be changed if there are different players for the various set games
         System.out.println("home players: " + (games.get(0).getHomePlayer()).length);
         System.out.println("home players: " + (games.get(0).getHomePlayer())[0].getName());
        return games.get(0).getHomePlayer();
    }
    
    public Player[] getAwayPlayers() {
        return games.get(0).getAwayPlayer();
    }
}
