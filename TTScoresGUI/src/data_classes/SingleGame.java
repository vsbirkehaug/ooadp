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
public class SingleGame extends Game {
    private Player[] homePlayer = new Player[1];
    private Player[] awayPlayer = new Player[1];

    public SingleGame(Player homePlayer, int homeScore, Player awayPlayer, int awayScore) {
        super(homeScore, awayScore);
        setHomePlayer(homePlayer);
        setAwayPlayer(awayPlayer);
    }

    public void setHomePlayer(Player player) {
       this.homePlayer[0] = player;
    }
    public Player[] getHomePlayer() {
       return this.homePlayer;
    }
    public void setAwayPlayer(Player player) {
       this.awayPlayer[0] = player; 
    }
    public Player[] getAwayPlayer() {
       return this.awayPlayer;
    }
    
    

}
