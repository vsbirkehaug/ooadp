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

    public void setHomeScore(int score) {
        if(score >= 0) {
            this.homeScore = score;
        } else {
            throw new IllegalArgumentException();
        }
    }
    public int getHomeScore() {
      return this.homeScore;
    }
    public void setAwayScore(int score) {
        if(score >= 0) {
            this.awayScore = score;
        } else {
            throw new IllegalArgumentException();
        }
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
