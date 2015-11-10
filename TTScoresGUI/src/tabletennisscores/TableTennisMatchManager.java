/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabletennisscores;

import classes.Match;
import classes.Team;
import java.util.ArrayList;

/**
 *
 * @author VSB
 */
public class TableTennisMatchManager {
    
    public ArrayList<Team> teams;
    public ArrayList<Match> matches;

    public TableTennisMatchManager() {
        intializeLists();
    }

    private void intializeLists() {
        teams = new ArrayList<>();
        matches = new ArrayList<>();
    }
        
        
   
    private boolean verifyPlayerNames(String teamName, String[] players) {
        Team thisTeam;
        for(Team t : teams) {
            for(String s : players) {
                 if(!t.hasPlayerWithThisName(s)) {
                     return false;
                }
            }    
        }
        return true;
    }
        
        
}
