package models;

/**
 *
 * @author VSB
 */
public class Player {

    private String name;
    private int setsPlayed = 0;
    private int setsWon = 0;

    public Player(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void addSetsPlayed(int sets) {
        //ASSUMPTION : cannot add 0 or lower
        if (sets > 0) {
            setsPlayed = setsPlayed + sets;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void addOneSetWin() {
        setsWon = setsWon + 1;
    }

    public int getSetsWon() {
        return setsWon;
    }

    public int getSetsPlayed() {
        return setsPlayed;
    }

//    public int getPlayerSetsPlayed() {
//        int setsPlayed = 0;
//            if(TableTennisMatchManager.INSTANCE != null && TableTennisMatchManager.INSTANCE.getMatches() != null) {
//            for(Match m : TableTennisMatchManager.INSTANCE.getMatches()) {
//                for(Set s : m.getSets()) {
//                    if(Arrays.asList(s.getHomePlayers()).contains(this) || Arrays.asList(s.getAwayPlayers()).contains(this)) {
//                       ++setsPlayed;
//                    }
//                }
//            }  
//        }
//        return setsPlayed;
//    }
//    public int getPlayerSetsWon() {
//        int setsWon = 0;
//        if(TableTennisMatchManager.INSTANCE != null && TableTennisMatchManager.INSTANCE.getMatches() != null) {
//            for(Match m : TableTennisMatchManager.INSTANCE.getMatches()) {
//                if(m.getHomeTeam().getPlayers().contains(this)) {
//                    for(Set s : m.getSets()) {
//                        if(Arrays.asList(s.getHomePlayers()).contains(this) && (s.getAwayPoint() < s.getHomePoint())) {
//                           setsWon++; 
//                        }
//                    }               
//                } else if (m.getAwayTeam().getPlayers().contains(this)) {
//                    for(Set s : m.getSets()) {
//                        if(Arrays.asList(s.getAwayPlayers()).contains(this) && (s.getAwayPoint() > s.getHomePoint())) {
//                           setsWon++; 
//                        }
//                    }  
//                }          
//            } 
//        }
//        return setsWon;
//    }
//    public int getPlayerSetsLost() {
//        for(Match m : TableTennisMatchManager.INSTANCE.matches) {
//            if(m.getHomeTeam().getPlayers().contains(this)) {
//                setsLost = setsLost + (m.MAX_NUMBER_OF_SETS - m.getPointsForTeam(m.getHomeTeam()));
//            } else if (m.getAwayTeam().getPlayers().contains(this)) {
//                setsLost = setsLost + (m.MAX_NUMBER_OF_SETS - m.getPointsForTeam(m.getAwayTeam()));
//            }          
//        }
//
//        //assuming a set is either won or lost
//        int setsLost = getPlayerSetsPlayed() - getPlayerSetsWon();
//        return setsLost;
//    }
}
