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
public abstract class Set {
    public final int MAX_NUMBER_OF_GAMES = 3;
    protected ArrayList<Game> games;
    protected String setIdentifier;
    private String winner;
    protected Player[] homePlayers;
    protected Player[] awayPlayers;

    protected Set(String id, Player[] homePlayers, Player[] awayPlayers) {
        this.setIdentifier = id;
        this.homePlayers = homePlayers;
        this.awayPlayers = awayPlayers;
    }

    public Player[] getHomePlayers() {
        return homePlayers;
    }

    public String getHomePlayerString() {
        String str = "";
        for(Player p : homePlayers) {
            str += p.getName() + ",";
        }
        return str.substring(0, str.length()-1);
    }

    public String getAwayPlayerString() {
        String str = "";
        for(Player p : awayPlayers) {
            str += p.getName() + ",";
        }
        return str.substring(0, str.length()-1);
    }

    public Player[] getAwayPlayers() {
        return awayPlayers;
    }

    public Set(String id) {
        setSetIdentifier(id.trim());
    }
    
    public String getSetIdentifier() {
        return setIdentifier;
    }

    protected void setSetIdentifier(String setIdentifier) {
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
        int homeWins = 0;
        if(games.size() == MAX_NUMBER_OF_GAMES) {
            for(Game g : games) {
                if(g.gameWinner().equalsIgnoreCase("h")) {
                    homeWins = homeWins +1;
                }
            }
        }
        return homeWins;
    }
    
    private int getAwayWins() {
        int awayWins = 0;
        if(games.size() == MAX_NUMBER_OF_GAMES) {
            for(Game g : games) {
                if(g.gameWinner().equalsIgnoreCase("a")) {
                    awayWins = awayWins +1;
                }
            }
        }
        return awayWins;
    }
    
    public int getHomePoints() {
        if(getHomeWins() > getAwayWins()) {
            return 1;
        } else {
            return 0;
        }
    }
    
    public int getAwayPoints() {
        if(getHomeWins() < getAwayWins()) {
            return 1;
        } else {
            return 0;
        }
    }
    
    public Player[] getAllSetPlayers() {
        ArrayList<Player> allPlayers = new ArrayList<>();
        allPlayers.addAll(Arrays.asList(getHomePlayers()));
        allPlayers.addAll(Arrays.asList(getAwayPlayers()));

        return allPlayers.toArray(new Player[allPlayers.size()]);
    }
    
    @Override
    public String toString() {
        return getSetIdentifier();
    }

}
