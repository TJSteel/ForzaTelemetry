/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forza;

import java.util.ArrayList;
import database.CarTypeDatabase;
import database.PlayerDatabase;
import network.TrafficReceiver;
import ui.TelemetryUI;

/**
 * @author Jay
 */
public class ForzaTelemetry {
	// {{ Variables
	public PlayerDatabase playerDB;
	@SuppressWarnings("unused")
	public CarTypeDatabase carTypeDB;
	public ArrayList<Player> players;
	public TrafficReceiver traffic;
	public TelemetryUI ui;
	// }} Variables

    public void initialize() {
    	
        playerDB = new PlayerDatabase();
        carTypeDB = new CarTypeDatabase();
        players = playerDB.getPlayers();

        traffic = new TrafficReceiver();
        traffic.initialize(50000);
        
        ui = new TelemetryUI(this.players);
        ui.setVisible(true);
    }
    
    public void run() {
        ui.setReceivingTraffic(false);
        while (true) {
            traffic.receiveTraffic();
            
            boolean playerExists = false;

            for (Player currPlayer : players) {
                if (traffic.getAddress().toString().contains(currPlayer.getIpAddress())) {
                	currPlayer.addTelemetryPacket();
                    currPlayer.getTelemetryPacket().processDataPacket(traffic.getDataPack());
                    playerExists = true;
                    if (currPlayer.getTelemetryPacket().isRaceOn()) {
                    	ui.updateFields();
                    	currPlayer.printValues();

                    	//used for debugging
                    	System.out.print(currPlayer.getTelemetryPacket().getEngine().getGear());
                    }
                    break;
                }
            }
            
            //if you've checked all players and they don't exist, create a new player
            if (!playerExists) {
                Player currPlayer;
				currPlayer = new Player(traffic.getDataPack().getAddress().toString(), "Driver " + traffic.getDataPack().getAddress().toString());
                currPlayer.getTelemetryPacket().processDataPacket(traffic.getDataPack());
                players.add(currPlayer);
            }
            ui.setReceivingTraffic(true);
        }

    }

}
