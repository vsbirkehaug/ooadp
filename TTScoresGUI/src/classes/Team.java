/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author VSB
 */
public class Team {
   public static final int MAX_TEAM_SIZE = 2;
   Venue venue;
   ArrayList<Player> players;

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

}
