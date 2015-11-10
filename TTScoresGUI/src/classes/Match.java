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
public class Match {
    private ArrayList<Set> sets;
    private Team homeTeam;
    private Team awayTeam;

    public void setHomeTeam(Team team) {
      this.homeTeam = team;
    }
    public Team getHomeTeam() {
      return this.homeTeam;
    }

    public void setAwayTeam(Team team) {
      this.awayTeam = team;
    }
    public Team getAwayTeam() {
      return this.awayTeam;
    }
}
