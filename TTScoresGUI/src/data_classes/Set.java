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
    private final int MAX_NUMBER_OF_GAMES = 3;
    private ArrayList<Game> games;
    private String setIdentifier;
    private String winner;
    private int homeWins;
    private int awayWins;
    
    
    public Set(String id) {
        setSetIdentifier(id.trim());
    }
    
    public String getSetIdentifier() {
        return setIdentifier;
    }

    private void setSetIdentifier(String setIdentifier) {
        this.setIdentifier = setIdentifier;
    }

    public ArrayList<Game> getGames() {
        return games;
    }


    public void addGame(Game game) {
      if(this.games == null) {
        this.games = new ArrayList<>();
      }
      if(this.games.size() < MAX_NUMBER_OF_GAMES) {
        this.games.add(game);
      } else {
        //TODO some error that says you cannot add more games to this set
      }
    }
    
    private int getHomeWins() {
        homeWins = 0;
        if(games.size() == MAX_NUMBER_OF_GAMES) {
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
        if(games.size() == MAX_NUMBER_OF_GAMES) {
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
    
    @Override
    public String toString() {
        return getSetIdentifier();
    }

}
