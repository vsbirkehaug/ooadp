package controllers;

import data_models.*;

import java.util.ArrayList;

/**
 * Created by VSB on 17/01/2016.
 */
public class MatchManager {
    private ArrayList<Match> matches;
    private static MatchManager mm;

    private MatchManager() {
        matches = new ArrayList<>();
    }

    public static MatchManager getMatchMgr() {
        if(mm == null) {
            mm = new MatchManager();
        }
        return mm;
    }

    public ArrayList<Match> getMatches() {
        return this.matches;
    }

    public void addMatchToList(Match m) {
        if(m != null) {
            for(Set s : m.getSets()) {
                m.getTeam(TeamType.HOME).addSetsWon(s.getSetPointForTeam(TeamType.HOME));
                m.getTeam(TeamType.AWAY).addSetsWon(s.getSetPointForTeam(TeamType.AWAY));
                addSetStatsToPlayers(s);
            }
            m.getTeam(TeamType.HOME).addSetsPlayed(m.getSets().size());
            m.getTeam(TeamType.AWAY).addSetsPlayed(m.getSets().size());

            matches.add(m);
        } else {
            throw new IllegalArgumentException("The match you tried add to the collection was empty.");
        }
    }

    private void addSetStatsToPlayers(Set s) {

        for(Player p : s.getAllSetPlayers()) {
            p.addSetsPlayed(1);
        }

        if(s.getSetPointForTeam(TeamType.HOME) > s.getSetPointForTeam(TeamType.AWAY)) {
            for(Player p : s.getHomePlayers()) {
                p.addOneSetWin();
            }
        } else if (s.getSetPointForTeam(TeamType.HOME) < s.getSetPointForTeam(TeamType.AWAY)) {
            for(Player p : s.getAwayPlayers()) {
                p.addOneSetWin();
            }
        } else {
            throw new IllegalStateException("Set draw - should not occur.");
        }
    }


    public int getTotalSeasonPointsWonByTeam(Team team) {
        int points = 0;
        if(matches != null && !matches.isEmpty()) {
            for(Match m : matches) {
                if(m.getPointsForTeam(team) >= 0) {
                    points = points + m.getPointsForTeam(team);
                }
            }
        }
        return points;
    }


    //Each team can only play another team once home and once away
    public boolean matchExistsForThisTeamSetup(String homeTeamName, String awayTeamName) {
        Team homeTeam = TeamManager.getTeamMgr().getTeamByName(homeTeamName);
        Team awayTeam = TeamManager.getTeamMgr().getTeamByName(awayTeamName);

        for(Match m : getMatches()) {
            if(m.getTeam(TeamType.HOME).equals(homeTeam) && m.getTeam(TeamType.AWAY).equals(awayTeam)) {
                return true;
            }
        }
        return false;
    }
}
