/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.*;
import forza.Player;

/**
 *
 * @author Jay
 */
public class PlayerDatabase {

    private final ArrayList<Player> players;

    public PlayerDatabase() {
        players = new ArrayList<Player>();
        players.add(new Player("192.168.1.18", "HCR TJSteel"));
    }
    
    public ArrayList<Player> getPlayers(){
        return this.players;
    }
}
