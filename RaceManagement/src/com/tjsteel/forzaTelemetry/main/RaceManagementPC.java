/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. collaborator trying to push to master, should be denied!
 */
package com.tjsteel.forzaTelemetry.main;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.tjsteel.forzaTelemetry.database.CarTypeDatabase;
import com.tjsteel.forzaTelemetry.forza.Player;
import com.tjsteel.forzaTelemetry.network.TrafficReceiver;
import com.tjsteel.forzaTelemetry.ui.MainMenu;

/**
 * @author Jay
 */
public class RaceManagementPC {
	// {{ Variables
	public CarTypeDatabase carTypeDB;
	public Player player;
	private ReadWriteLock playersReadWriteLock = new ReentrantReadWriteLock();
	public TrafficReceiver traffic;
	public MainMenu ui;
	// }} Variables

	public void initialize() {

		carTypeDB = new CarTypeDatabase();
		player = new Player();

		traffic = new TrafficReceiver();
		traffic.initialize(50000);

		ui = new MainMenu(this.player, this.getPlayersReadWriteLock());
		ui.setVisible(true);
	}

	public void run() {
		while (true) {
			traffic.receiveTraffic();
			getPlayersReadWriteLock().writeLock().lock();

			try {
				player.addTelemetryPacket();
				player.getTelemetryPacket().processDataPacket(traffic.getDataPack());
				if (!player.getTelemetryPacket().isRaceOn())
					player.getTelemetryPackets().remove(player.getTelemetryPackets().size() - 1);
				if (player.getTelemetryPacket() == null)
					break;
				if (player.getTelemetryPacket().isRaceOn()) {
					player.printValues();

					// used for debugging
					// System.out.println(currPlayer.getTelemetryPacket().getTrack().getLapNumber());
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
