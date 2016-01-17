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
    protected Player[] homePlayers;
    protected Player[] awayPlayers;

    protected Set(String id, Player[] homePlayers, Player[] awayPlayers) {
        this.setIdentifier = id;
        this.homePlayers = homePlayers;
        this.awayPlayers = awayPlayers;
    }

    public Player[] getPlayers(TeamType team) {
        if(team.equals(TeamType.HOME)) {
            return homePlayers;
        } else if (team.equals(TeamType.AWAY)) {
            return awayPlayers;
        } else {
            throw new IllegalArgumentException("Please select a valid team to get players from. (Illegal argument)");
        }
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

    public void addGameToSet(Game game) {
      if(this.games == null) {
        this.games = new ArrayList<>();
      }
      if(this.games.size() < MAX_NUMBER_OF_GAMES) {
        this.games.add(game);
      } else {
         throw new IllegalStateException("Cannot add more games to this set.");
      }
    }

    private int getSetGameWins(TeamType team) {
        int wins = 0;
        if(games.size() == MAX_NUMBER_OF_GAMES) {
            for(Game g : games) {
                if(g.gameWinner().equals(team)) {
                    wins = wins +1;
                }
            }
        }
        return wins;
    }
//
//    private int getHomeWins() {
//        int homeWins = 0;
//        if(games.size() == MAX_NUMBER_OF_GAMES) {
//            for(Game g : games) {
//                if(g.gameWinner().equals(TeamType.HOME)) {
//                    homeWins = homeWins +1;
//                }
//            }
//        }
//        return homeWins;
//    }
//
//    private int getAwayWins() {
//        int awayWins = 0;
//        if(games.size() == MAX_NUMBER_OF_GAMES) {
//            for(Game g : games) {
//                if(g.gameWinner().equals(TeamType.AWAY)) {
//                    awayWins = awayWins +1;
//                }
//            }
//        }
//        return awayWins;
//    }

    public int getSetPointForTeam(TeamType team) {
        if(getSetWinner().equals(team)) {
            return 1;
        } else {
            return 0;
        }
    }

    public TeamType getSetWinner() {
        if(getSetGameWins(TeamType.HOME) > getSetGameWins(TeamType.AWAY)) {
            return TeamType.HOME;
        } else if (getSetGameWins(TeamType.AWAY) > getSetGameWins(TeamType.HOME)) {
            return TeamType.AWAY;
        } else {
            throw new IllegalStateException("No game winner. (Draw is not allowed)");
        }
    }

    
    public Player[] getAllSetPlayers() {
        ArrayList<Player> allPlayers = new ArrayList<>();
        allPlayers.addAll(Arrays.asList(getPlayers(TeamType.HOME)));
        allPlayers.addAll(Arrays.asList(getPlayers(TeamType.AWAY)));

        return allPlayers.toArray(new Player[allPlayers.size()]);
    }
    
    @Override
    public String toString() {
        return getSetIdentifier();
    }

}
