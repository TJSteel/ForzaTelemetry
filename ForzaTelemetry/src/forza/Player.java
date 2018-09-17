/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forza;

import java.util.ArrayList;

import telemetry.TelemetryPacket;

public class Player {

	// {{ Variables
    private String ipAddress = "";
    private String gamertag = "";
    private ArrayList<TelemetryPacket> telemetryPackets;
    // }} Variables

    // Constructor
    public Player(String ipAddress, String gamertag) {
        this.setIpAddress(ipAddress);
        this.setGamertag(gamertag);
        this.telemetryPackets = new  ArrayList<TelemetryPacket>();
    }
    public Player() {
        this.telemetryPackets = new ArrayList<TelemetryPacket>();
    }
    
    // {{ Getters and Setters
    /**
     * @return the ipAddress
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * @param ipAddress the ipAddress to set
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    /**
     * @return the gamertag
     */
    public String getGamertag() {
        return gamertag;
    }

    /**
     * @param gamertag the gamertag to set
     */
    public void setGamertag(String gamertag) {
        this.gamertag = gamertag;
    }

    /**
     * @return the telemetryPackets
     */
    public ArrayList<TelemetryPacket> getTelemetryPackets() {
        return telemetryPackets;
    }
    /**
     * @return the telemetryPackets
     */
    public TelemetryPacket getTelemetryPacket() {
        return telemetryPackets.size() > 0 ? telemetryPackets.get(telemetryPackets.size()-1) : new TelemetryPacket();
    }

    public void addTelemetryPacket() {
    	telemetryPackets.add(new TelemetryPacket());
    }
    // }} Getters and Setters

    public void reset() {
    	this.getTelemetryPacket().reset();
    }
}
