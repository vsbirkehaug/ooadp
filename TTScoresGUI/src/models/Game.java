package models;

/**
 *
 * @author VSB
 */
public class Game {

    private int homeScore;
    private int awayScore;

    private void setScore(int score, TeamType team) {
        if (score >= 0) {
            if (team.equals(TeamType.HOME)) {
                this.homeScore = score;
            } else if (team.equals(TeamType.AWAY)) {
                this.awayScore = score;
            }
        } else {
            throw new IllegalArgumentException("Invalid score entered.");
        }
    }

    public int getScore(TeamType team) {
        switch (team) {
            case HOME:
                return this.homeScore;
            case AWAY:
                return this.awayScore;
            default:
                throw new IllegalArgumentException("Please select a team to getMatchMgr score for.");
        }
    }

    public Game(int homeScore, int awayScore) {
        if (verifyScores(homeScore, awayScore)) {
            setScore(homeScore, TeamType.HOME);
            setScore(awayScore, TeamType.AWAY);
        } else {
            throw new IllegalArgumentException("Scores could not be verified.");
        }
    }

    public TeamType gameWinner() {
        if (homeScore > awayScore) {
            return TeamType.HOME;
        } else if (awayScore > homeScore) {
            return TeamType.AWAY;
        } else {
            throw new IllegalStateException("No game winner. (Illegal state)");
        }
    }

    private boolean verifyScores(int hs, int as) {
        return (scoresArePositive(hs, as) && (scoreConditionOne(hs, as) || scoreConditionTwo(hs, as)));
    }

    private boolean scoresArePositive(int hs, int as) {
        return (hs >= 0 && as >= 0);
    }

    private boolean scoreConditionOne(int hs, int as) {
        return (hs == 11 || as == 11) && wonByAtLeastTwoPoints(hs, as);
    }

    private boolean wonByAtLeastTwoPoints(int hs, int as) {
        return ((hs - as) >= 2 || (as - hs) >= 2);
    }

    private boolean scoreConditionTwo(int hs, int as) {
        return ((hs > 11 || as > 11) && wonByExactlyTwoPoints(hs, as));
    }

    private boolean wonByExactlyTwoPoints(int hs, int as) {
        return ((hs - as) == 2 || (as - hs) == 2);
    }

}
