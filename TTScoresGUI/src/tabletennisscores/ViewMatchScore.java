/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabletennisscores;

import data_classes.Game;
import data_classes.Match;
import data_classes.Set;
import data_classes.Team;
import java.awt.Color;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Vilde
 */
public class ViewMatchScore extends javax.swing.JFrame {

    /**
     * Creates new form ViewMatchScore
     */
    public ViewMatchScore() {
        initComponents();
        fillTeamBoxes();
    }
    
    private void fillTeamBoxes() {
        Vector teamsVector = new Vector();
        for(Team t : TTScoreGUI1.manager.getTeams()) {          
            teamsVector.add(t);          
        }
        final DefaultComboBoxModel homeModel = new DefaultComboBoxModel(teamsVector);
        homeTeamComboBox.setModel(homeModel);
        homeTeamComboBox.invalidate();
        
        final DefaultComboBoxModel awayModel = new DefaultComboBoxModel(teamsVector);
        awayTeamComboBox.setModel(awayModel); 
        awayTeamComboBox.invalidate();      

    }
    
    private void getMatch() {
        for(Match m : TTScoreGUI1.manager.getMatches()) {
            if(m.getHomeTeam().equals(homeTeamComboBox.getSelectedItem()) 
                    && m.getAwayTeam().equals(awayTeamComboBox.getSelectedItem())) {
                //showMatchDetails(m);
                printMatchDetails(m);
                errorLabel.setVisible(false);
                return;
            }
        }
        
        //else say there is no match for these teams
        errorLabel.setVisible(true);
        errorLabel.setText("No matches found for these teams.");
    }
    
    private void printMatchDetails(Match m) {
        System.out.println("Match : " + homeTeamComboBox.getSelectedItem().toString() + " VS " +  awayTeamComboBox.getSelectedItem().toString());
        for(Set s : m.getSets()) {
            System.out.println("Set : " + s.getSetIdentifier());
            int i = 1;
            for(Game g : s.getGames()) {
                System.out.println("Game " + i + ": " + g.getHomePlayerString() + " " + g.getHomeScore() + ", " + g.getAwayPlayerString() + " " + g.getAwayScore());
                i++;
            }       
        }
        
        System.out.println("");     
        System.out.println("Total home win: " + m.getPointsForTeam(m.getHomeTeam()));
        System.out.println("Total away win: " + m.getPointsForTeam(m.getAwayTeam()));
        
    }
    
//    private void showMatchDetails(Match m) {
//        setupSetList(m);
//        
//    }
    
//    private void setupSetList(Match m) {
//        Vector setsVector = new Vector();
//        for(Set s : m.getSets()) {          
//            setsVector.add(s);          
//        }
//        final DefaultComboBoxModel setModel = new DefaultComboBoxModel(setsVector);
//        setList.setModel(setModel);
//        setList.invalidate();
//        
//        setList.setSelectedIndex(0);
//        
//        setGameList(m.getSets().get(setList.getSelectedIndex()));
//
//    }
//    
//    private void setGameList(Set s) {
//        Vector gameVector = new Vector();
//        for(Game g : s.getGames()) {          
//            gameVector.add(s);          
//        }
//        final DefaultComboBoxModel gameModel = new DefaultComboBoxModel(gameVector);
//        gameList.setModel(gameModel);
//        gameList.invalidate();
//        
//        gameList.setSelectedIndex(0);
//
//
//    }
    

            
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        homeTeamComboBox = new javax.swing.JComboBox<>();
        awayTeamComboBox = new javax.swing.JComboBox<>();
        getMatchButton = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Match scores");

        jLabel1.setText("Home team");

        jLabel2.setText("Away team");

        homeTeamComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        homeTeamComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeTeamComboBoxActionPerformed(evt);
            }
        });

        awayTeamComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        getMatchButton.setText("Print match details");
        getMatchButton.setActionCommand("Print match details");
        getMatchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getMatchButtonActionPerformed(evt);
            }
        });

        errorLabel.setForeground(java.awt.Color.red);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(getMatchButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(homeTeamComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(jLabel2))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(16, 16, 16)
                                    .addComponent(awayTeamComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homeTeamComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(awayTeamComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(getMatchButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeTeamComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeTeamComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_homeTeamComboBoxActionPerformed

    private void getMatchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getMatchButtonActionPerformed
        getMatch();
    }//GEN-LAST:event_getMatchButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewMatchScore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewMatchScore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewMatchScore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewMatchScore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewMatchScore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> awayTeamComboBox;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JButton getMatchButton;
    private javax.swing.JComboBox<String> homeTeamComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
