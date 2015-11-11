/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_classes;

import java.util.ArrayList;
import tabletennisscores.TTScoreGUI1;

/**
 *
 * @author VSB
 */
public class Team {
   public static final int MAX_TEAM_SIZE = 2;
   private String name;
   Venue venue;
   ArrayList<Player> players;
   int points;

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

   public String getVenueName() {
     return this.venue.getName();
   }

   public void addPlayer(Player player) {
     if(players == null) {
       players = new ArrayList<>();
     }
     if(players.size() < MAX_TEAM_SIZE) {
       players.add(player);
     } else {
       //TODO some error that says you cannot add more playes
     }
   }
   
   public ArrayList<Player> getPlayers() {
       return this.players;
   }

    public boolean hasPlayerWithThisName(String playerName) {
        for(Player p : players) {
            if(p.getName().toLowerCase().equals(playerName.toLowerCase()))
                return true;
        }
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return ("Name: " + name + ", venue: " + venue.getName());
    }

    public boolean hasRoomForMorePlayers() {
        if(players == null || players.size() < MAX_TEAM_SIZE) {
            return true;
        } else {
            return false;
        }
    }
    
    public int getPoints() {
        points = TTScoreGUI1.manager.getPointsWonByTeam(this);
        return points;
    }
}
