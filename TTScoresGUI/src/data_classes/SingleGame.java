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

    public SingleGame(Player homePlayer, int homeScore, Player awayPlayer, int awayScore) {
        super(new Player[]{homePlayer}, homeScore, new Player[]{awayPlayer}, awayScore);
    }      

}
