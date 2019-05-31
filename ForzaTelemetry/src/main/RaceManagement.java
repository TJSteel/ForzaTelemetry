/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. collaborator trying to push to master, should be denied!
 */
package main;

import java.util.ArrayList;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import database.CarTypeDatabase;
import database.PlayerDatabase;
import forza.Player;
import network.TrafficReceiver;
import ui.MainMenu;

/**
 * @author Jay
 */
public class RaceManagement {
	// {{ Variables
	public PlayerDatabase playerDB;
	@SuppressWarnings("unused")
	public CarTypeDatabase carTypeDB;
	public ArrayList<Player> players;
	private ReadWriteLock playersReadWriteLock = new ReentrantReadWriteLock();
	public TrafficReceiver traffic;
	public MainMenu ui;
	// }} Variables

    public void initialize() {
    	
        playerDB = new PlayerDatabase();
        carTypeDB = new CarTypeDatabase();
        players = playerDB.getPlayers();

        traffic = new TrafficReceiver();
        traffic.initialize(50000);
        
        ui = new MainMenu(this.players, this.getPlayersReadWriteLock());
        ui.setVisible(true);
    }
    
    public void run() {
        while (true) {
            traffic.receiveTraffic();
            getPlayersReadWriteLock().writeLock().lock();
            
            try {
                boolean playerExists = false;
                
                for (Player currPlayer : players) {
                    if (traffic.getAddress().toString().contains(currPlayer.getIpAddress())) {
                    	currPlayer.addTelemetryPacket();
                        currPlayer.getTelemetryPacket().processDataPacket(traffic.getDataPack());
                        if (!currPlayer.getTelemetryPacket().isRaceOn()) currPlayer.getTelemetryPackets().remove(currPlayer.getTelemetryPackets().size()-1);
                        if (currPlayer.getTelemetryPacket()==null) break;
                        playerExists = true;
                        if (currPlayer.getTelemetryPacket().isRaceOn()) {
                        	currPlayer.printValues();

                        	//used for debugging
                        	//System.out.println(currPlayer.getTelemetryPacket().getTrack().getLapNumber());
                        }
                        break;
                    }
                }
                
                //if you've checked all players and they don't exist, create a new player
                if (!playerExists) {
                    Player currPlayer;
    				currPlayer = new Player(traffic.getDataPack().getAddress().toString(), "Driver " + traffic.getDataPack().getAddress().toString());
                	currPlayer.addTelemetryPacket();
                    currPlayer.getTelemetryPacket().processDataPacket(traffic.getDataPack());
                    players.add(currPlayer);
                }
            	
            } finally {
            	getPlayersReadWriteLock().writeLock().unlock();
            }
        }
    }

	/**
	 * @return the playersReadWriteLock
	 */
	public ReadWriteLock getPlayersReadWriteLock() {
		return playersReadWriteLock;
	}

	/**
	 * @param playersReadWriteLock the playersReadWriteLock to set
	 */
	public void setPlayersReadWriteLock(ReadWriteLock playersReadWriteLock) {
		this.playersReadWriteLock = playersReadWriteLock;
	}
}
