package controllers;

import models.*;
import views.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.ArrayList;

/**
 * Created by VSB on 17/01/2016.
 */
public class GuiScoreManager {

    private TTScoreGUI1 gui;
    private ArrayList<Set> sets;
    private Match match;
    private TeamManager teamManager = TeamManager.getTeamMgr();
    private MatchManager matchManager = MatchManager.getMatchMgr();

    public GuiScoreManager(TTScoreGUI1 gui) {
        this.gui = gui;
    }

    protected Player getHomePlayer1() {
        return teamManager.getPlayerWithName(gui.getHomePlayer1());
    }

    protected Player getHomePlayer2() {
        return teamManager.getPlayerWithName(gui.getHomePlayer2());
    }

    protected Player getAwayPlayer1() {
        return teamManager.getPlayerWithName(gui.getAwayPlayer1());
    }

    protected Player getAwayPlayer2() {
        return teamManager.getPlayerWithName(gui.getAwayPlayer2());
    }

    protected Player[] getHomePlayers() {
        return new Player[]{teamManager.getPlayerWithName(gui.getHDblPlayer1()), teamManager.getPlayerWithName(gui.getHDblPlayer2())};
    }

    protected Player[] getAwayPlayers() {
        return new Player[]{teamManager.getPlayerWithName(gui.getADblPlayer1()), teamManager.getPlayerWithName(gui.getADblPlayer2())};
    }

    public void doCalculateScores(ArrayList<JTextField> scoreTextFields) {
        if (createMatchFromFields(scoreTextFields)) {
            if (calculateScores(sets)) {
                gui.setSubmitScoresButtonEnabled(true);
            } else {
                gui.setSubmitScoresButtonEnabled(false);
            }
        }
    }

    private boolean createMatchFromFields(ArrayList<JTextField> scoreTextFields) {

        sets = new ArrayList<>();
        try {

            Team homeTeam = teamManager.getTeamByName(gui.getHomeTeamName());
            Team awayTeam = teamManager.getTeamByName(gui.getAwayTeamName());

            match = new Match(homeTeam, awayTeam);

            createSetsFromFields();
            addGamesToSets(scoreTextFields);

            match.setSets(sets);

        } catch (NumberFormatException nfex) {
            String errorMessage = "Error reading scores. Please check that only numbers are entered.";
            doErrorMessage(errorMessage, nfex.getMessage());
            return false;
        } catch (IllegalArgumentException iaex) {
            String errorMessage = "Error verifying scores. Please check that the scores are valid.";
            doErrorMessage(errorMessage, iaex.getMessage());
            return false;
        } catch (Exception ex) {
            String errorMessage = "Error reading scores. Please check that all values are entered and try again.";
            doErrorMessage(errorMessage, ex.getMessage());
            return false;
        }

        return true;
    }

    private void doErrorMessage(String errorMessage, String exceptionMessage) {
        showErrorMessage(errorMessage);
        System.out.println(errorMessage);
        System.out.println(exceptionMessage);
    }

    public void submitScores() {
        matchManager.addMatchToList(match);

        gui.setSubmitScoresButtonEnabled(false);
        gui.setCalculateScoresButtonEnabled(false);
    }

    private void showErrorMessage(String message) {
        String msg = "<html>" + message + "</html>";
        ErrorMessageFrame errorMessage = new ErrorMessageFrame();
        //wrapped in HTML to allow for multiline error label.
        errorMessage.setMessage(msg);
        errorMessage.setVisible(true);
    }

    private void createSetsFromFields() {
        sets.add(new SingleSet(gui.getSet11(), getHomePlayer1(), getAwayPlayer1()));
        sets.add(new SingleSet(gui.getSet12(), getHomePlayer1(), getAwayPlayer2()));
        sets.add(new SingleSet(gui.getSet21(), getHomePlayer2(), getAwayPlayer1()));
        sets.add(new SingleSet(gui.getSet22(), getHomePlayer2(), getAwayPlayer2()));
        sets.add(new DoubleSet(gui.getSetDbl(), getHomePlayers(), getAwayPlayers()));
    }

    private void addGamesToSets(ArrayList<JTextField> scoreTextFields) {
        int gamesPerSet = 3;
        int counter = 0;
        for (int i = 0; i < sets.size(); i++) {
            for (int j = 0; j < gamesPerSet; j++) {
                sets.get(i).addGameToSet(new Game(
                        Integer.parseInt(scoreTextFields.get(counter).getText()),
                        Integer.parseInt(scoreTextFields.get(counter + 1).getText())));
                counter = counter + 2;
            }
        }
    }

    protected boolean calculateScores(ArrayList<Set> sets) {
        try {
            int homeWin1 = 0, homeWin2 = 0, homeWin3 = 0;
            int awayWin1 = 0, awayWin2 = 0, awayWin3 = 0;

            homeWin1 = sets.get(0).getSetPointForTeam(TeamType.HOME) + sets.get(1).getSetPointForTeam(TeamType.HOME);
            awayWin1 = sets.get(0).getSetPointForTeam(TeamType.AWAY) + sets.get(1).getSetPointForTeam(TeamType.AWAY);

            homeWin2 = sets.get(2).getSetPointForTeam(TeamType.HOME) + sets.get(3).getSetPointForTeam(TeamType.HOME);
            awayWin2 = sets.get(2).getSetPointForTeam(TeamType.AWAY) + sets.get(3).getSetPointForTeam(TeamType.AWAY);

            homeWin3 = sets.get(4).getSetPointForTeam(TeamType.HOME);
            awayWin3 = sets.get(4).getSetPointForTeam(TeamType.AWAY);

            gui.showTeamScores(homeWin1, homeWin2, homeWin3, awayWin1, awayWin2, awayWin3);

        } catch (IndexOutOfBoundsException ioobex) {
            String errorMessage = "Error calculating scores. Please restart and try again.";
            doErrorMessage(errorMessage, ioobex.getMessage());
            return false;
        } catch (Exception ex) {
            String errorMessage = "Error calculating scores. Please restart and try again.";
            doErrorMessage(errorMessage, ex.getMessage());
            return false;
        }
        return true;
    }

    public void checkPlayerNames() {
        gui.updateNamesFromTextFields();
        Boolean isVerified = teamManager.verifyNames(
                gui.getHomeTeamName(), gui.getHomeSinglesPlayers(), gui.getHomeDoublesPlayers(),
                gui.getAwayTeamName(), gui.getAwaySinglesPlayers(), gui.getAwayDoublesPlayers());

        if (isVerified && !homeAwayCombinationExists(gui.getHomeTeamName(), gui.getAwayTeamName())) {
            gui.setCalculateScoresButtonEnabled(true);
        } else if (isVerified) {
            showErrorTeamHomeAwayComboAlreadyExists();
        } else {
            gui.setCalculateScoresButtonEnabled(false);
            showErrorNamesNotVerified();
        }
    }

    private void showErrorTeamHomeAwayComboAlreadyExists() {
        ErrorMessageFrame errorMessage = new ErrorMessageFrame();
        //wrapped in HTML to allow for multiline error label.
        errorMessage.setMessage("<html>Error, these teams have already played a match with that home/away team combination.</html>");
        errorMessage.setVisible(true);
    }

    private boolean homeAwayCombinationExists(String homeTeamName, String awayTeamName) {
        return matchManager.matchExistsForThisTeamSetup(homeTeamName, awayTeamName);
    }

    private void showErrorNamesNotVerified() {
        ErrorMessageFrame errorMessage = new ErrorMessageFrame();
        //wrapped in HTML to allow for multiline error label.
        errorMessage.setMessage("<html>Error, player names could not be verified. Please check your entries and try again.</html>");
        errorMessage.setVisible(true);
    }

    protected void doNameTextChanged() {
        gui.setCalculateScoresButtonEnabled(false);
        gui.setSubmitScoresButtonEnabled(false);
    }

    protected void doScoreTextChanged() {
        gui.setSubmitScoresButtonEnabled(false);
    }

    public void setNameChangeListener(ArrayList<JTextField> nameTextFields) {
        for (JTextField tf : nameTextFields) {
            tf.getDocument().addDocumentListener(new DocumentListener() {
                public void changedUpdate(DocumentEvent e) {
                    textChanged();
                }

                public void removeUpdate(DocumentEvent e) {
                    textChanged();
                }

                public void insertUpdate(DocumentEvent e) {
                    textChanged();
                }

                public void textChanged() {
                    doNameTextChanged();
                }
            });
        }
    }

    public void setScoreChangeListener(ArrayList<JTextField> scoreTextFields) {
        for (JTextField tf : scoreTextFields) {
            tf.getDocument().addDocumentListener(new DocumentListener() {
                public void changedUpdate(DocumentEvent e) {
                    textChanged();
                }

                public void removeUpdate(DocumentEvent e) {
                    textChanged();
                }

                public void insertUpdate(DocumentEvent e) {
                    textChanged();
                }

                public void textChanged() {
                    doScoreTextChanged();
                }
            });
        }
    }
}
