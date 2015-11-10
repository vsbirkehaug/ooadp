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
public class Set {
    private int maxNumberOfGames = 3;
    private ArrayList<Game> games;

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
}
