/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_classes;

/**
 *
 * @author VSB
 */
public class Game {
    protected int homeScore;
    protected int awayScore;
    protected Player[] homePlayer;
    protected Player[] awayPlayer;

    public Player[] getHomePlayer() {
        return homePlayer;
    }

    public void setHomePlayer(Player[] homePlayer) {
        this.homePlayer = homePlayer;
    }

    public Player[] getAwayPlayer() {
        return awayPlayer;
    }

    public void setAwayPlayer(Player[] awayPlayer) {
        this.awayPlayer = awayPlayer;
    }

    public void setHomeScore(int score) {
      this.homeScore = score;
    }
    public int getHomeScore() {
      return this.homeScore;
    }
    public void setAwayScore(int score) {
      this.awayScore = score;
    }
    public int getAwayScore() {
      return this.awayScore;
    }
    
    public Game(int homeScore, int awayScore) {
        setHomeScore(homeScore);
        setAwayScore(awayScore);
    }
    
    public String gameWinner() {
        if(homeScore > awayScore) {
            return "h";
        } else if (awayScore > homeScore) {
            return "a";
        } else {
            return "u";
        }
    }

}
