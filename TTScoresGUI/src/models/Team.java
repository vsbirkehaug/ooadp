package models;

import java.util.ArrayList;

/**
 *
 * @author VSB
 */
public class Team {

    public static final int MAX_TEAM_SIZE = 2;
    private String name;
    private Venue venue;
    private ArrayList<Player> players;
    private int setsWon = 0;
    private int setsPlayed = 0;

    public Team(String teamName, String venueName) {
        setName(teamName);
        setVenue(new Venue(venueName));
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Venue getVenue() {
        return this.venue;
    }

    public boolean addPlayer(Player player) {
        if (players == null) {
            players = new ArrayList<>();
        }
        //ASSUMPTION : team can only have one player with a specific name
        if (players.size() < MAX_TEAM_SIZE && !hasPlayerWithThisName(player.getName())) {
            players.add(player);
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public boolean hasPlayerWithThisName(String playerName) {
        if (players != null && players.size() > 0 && playerName != null) {
            for (Player p : players) {
                if (p.getName().toLowerCase().equals(playerName.toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setName(String name) {
        if(!name.isEmpty()) {
            this.name = name;
        }
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        //return ("Name: " + name + ", venue: " + venue.getName());
        return getName();
    }

    public boolean hasRoomForMorePlayers() {
        return players == null || players.size() < MAX_TEAM_SIZE;
    }

    public int getSetsWon() {
        return setsWon;
    }

    public void addSetsWon(int points) {
        this.setsWon += points;
    }

    public void addSetsPlayed(int setsPlayed) {
        this.setsPlayed = this.setsPlayed + setsPlayed;
    }
}
