package models;

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
        setSetIdentifier(id);
        setHomePlayers(homePlayers);
        setAwayPlayers(awayPlayers);
    }

    public Player[] getPlayers(TeamType team) {
        if (team.equals(TeamType.HOME)) {
            return homePlayers;
        } else if (team.equals(TeamType.AWAY)) {
            return awayPlayers;
        } else {
            throw new IllegalArgumentException("Please select a valid team to getMatchMgr players from. (Illegal argument)");
        }
    }

    public String getPlayerString(TeamType team) {
        String str = "";
        if(team.equals(TeamType.HOME)) {
            for (Player p : homePlayers) {
                str += p.getName() + ",";
            }
            return str.substring(0, str.length() - 1);
        } else if (team.equals(TeamType.AWAY)) {
            for (Player p : awayPlayers) {
                str += p.getName() + ",";
            }
            return str.substring(0, str.length() - 1);
        } else {
            return "";
        }
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
        if (this.games == null) {
            this.games = new ArrayList<>();
        }
        if (this.games.size() < MAX_NUMBER_OF_GAMES) {
            this.games.add(game);
        } else {
            throw new IllegalStateException("Cannot add more games to this set.");
        }
    }

    private int getGameWins(TeamType team) {
        int wins = 0;
        if (games.size() == MAX_NUMBER_OF_GAMES) {
            for (Game g : games) {
                if (g.gameWinner().equals(team)) {
                    wins = wins + 1;
                }
            }
        } else {
            throw new IllegalStateException("This set has less than the max number of games.");
        }
        return wins;
    }

    public int getSetPointForTeam(TeamType team) {
        if (getSetWinner().equals(team)) {
            return 1;
        } else {
            return 0;
        }
    }

    private TeamType getSetWinner() {
        if (getGameWins(TeamType.HOME) > getGameWins(TeamType.AWAY)) {
            return TeamType.HOME;
        } else if (getGameWins(TeamType.AWAY) > getGameWins(TeamType.HOME)) {
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

    private void setHomePlayers(Player[] homePlayers) {
        if(homePlayers.length > 0) {
            this.homePlayers = homePlayers;
        }
    }

    private void setAwayPlayers(Player[] awayPlayers) {
        if(awayPlayers.length > 0) {
            this.awayPlayers = awayPlayers;
        }
    }
}
