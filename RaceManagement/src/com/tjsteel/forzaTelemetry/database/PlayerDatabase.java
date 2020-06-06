/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tjsteel.forzaTelemetry.database;

import java.util.*;

import com.tjsteel.forzaTelemetry.forza.Player;

/**
 *
 * @author Jay
 */
public class PlayerDatabase {

    private final ArrayList<Player> players;

    public PlayerDatabase() {
        players = new ArrayList<Player>();
        players.add(new Player("192.168.1.4", "TJSteel"));
    }
    
    public ArrayList<Player> getPlayers(){
        return this.players;
    }
}
