package controllers;

import tabletennisscores.*;

import javax.swing.*;

/**
 * Created by VSB on 17/01/2016.
 */
public class GuiOptionsManager {


    public void optionAddTeam() {
        JFrame addTeam = new AddTeamJFrame();
        addTeam.setVisible(true);
    }

    public void optionRegisterPlayer() {
        JFrame registerPlayer = new RegisterPlayerJFrame();
        registerPlayer.setVisible(true);
    }

    public void optionListAllPlayers() {
        ListAllPlayersJFrame listAllPlayers = new ListAllPlayersJFrame();
        listAllPlayers.setVisible(true);
    }

    public void optionViewMatchScore() {
        ViewMatchScoreJFrame viewMatchScore = new ViewMatchScoreJFrame();
        viewMatchScore.setVisible(true);
    }

    public void optionListTeamRanking() {
        ListTeamRankingJFrame listTeamRanking = new ListTeamRankingJFrame();
        listTeamRanking.setVisible(true);
    }

    public void optionListAllTeams() {
        ListAllTeamsJFrame listAllTeams = new ListAllTeamsJFrame();
        listAllTeams.setVisible(true);
    }

}
