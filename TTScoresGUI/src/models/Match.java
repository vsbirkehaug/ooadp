package models;

import java.util.ArrayList;

/**
 *
 * @author VSB
 */
public class Match {

    private ArrayList<Set> sets;
    private Team homeTeam;
    private Team awayTeam;
    public final static int MAX_NUMBER_OF_SETS = 5;

    public Match(Team homeTeam, Team awayTeam) {
        if (!homeTeam.equals(awayTeam)) {
            setTeam(TeamType.HOME, homeTeam);
            setTeam(TeamType.AWAY, awayTeam);
        }
    }

    private void setTeam(TeamType teamId, Team team) {
        switch (teamId) {
            case HOME:
                this.homeTeam = team;
                break;
            case AWAY:
                this.awayTeam = team;
                break;
            default:
                throw new IllegalArgumentException("Please select a valid team identifier for this team (HOME or AWAY");
        }
    }

    public Team getTeam(TeamType teamId) {
        switch (teamId) {
            case HOME:
                return this.homeTeam;
            case AWAY:
                return this.awayTeam;
            default:
                throw new IllegalArgumentException("Please select a valid team identifier for this team (HOME or AWAY");
        }
    }

    public int getPointsForTeam(Team t) {
        int points = 0;

        if (homeTeam != null && homeTeam.equals(t)) {
            points = 0;
            for (Set s : sets) {
                points += s.getSetPointForTeam(TeamType.HOME);
            }
        } else if (awayTeam != null && awayTeam.equals(t)) {
            points = 0;
            for (Set s : sets) {
                points += s.getSetPointForTeam(TeamType.AWAY);
            }
        }

        return points;
    }

    public void setSets(ArrayList<Set> sets) {
        if (sets == null) {
            throw new IllegalArgumentException("Set list was null.");
        } else if (sets.size() == 5) {
            this.sets = sets;
        } else {
            throw new IllegalArgumentException("Set list was the wrong size. Please add a list of size " + Match.MAX_NUMBER_OF_SETS + ".");
        }
    }

    public ArrayList<Set> getSets() {
        return sets;
    }

}
