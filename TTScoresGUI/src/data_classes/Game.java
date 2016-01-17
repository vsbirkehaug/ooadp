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
    private int homeScore;
    private int awayScore;

    private void setHomeScore(int score) {
        if(score >= 0) {
            this.homeScore = score;
        } else {
            throw new IllegalArgumentException();
        }
    }
    public int getHomeScore() {
      return this.homeScore;
    }
    private void setAwayScore(int score) {
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
        if(verifyScores(homeScore, awayScore)) {
            setHomeScore(homeScore);
            setAwayScore(awayScore);
        } else {
            throw new IllegalArgumentException();
        }
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

    private boolean verifyScores(int hs, int as) {
        return (scoresArePositive(hs, as) &&
                (scoreIs11(hs, as) || scoreHigherThan11(hs, as)));
    }

    private boolean scoresArePositive(int hs, int as) {
        return (hs >= 0 && as >= 0);
    }

    private boolean scoreIs11(int hs, int as) {
        return (hs == 11 || as == 11) && wonByAtLeastTwoPoints(hs, as);
    }

    private boolean scoreHigherThan11(int hs, int as) {
        return ((hs > 11 || as > 11) && wonByExactlyTwoPoints(hs, as));
    }

    private boolean wonByExactlyTwoPoints(int hs, int as) {
        return ((hs-as)==2 || (as-hs)==2);
    }

    private boolean wonByAtLeastTwoPoints(int hs, int as) {
        return ((hs-as)>=2 || (as-hs)>=2);
    }

}
