/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forza;

import car.Car;

public class Player {

	// {{ Variables
    private String ipAddress = "";
    private String gamertag = "";
    private Car car;
    // }} Variables

    // Constructor
    public Player(String ipAddress, String gamertag) {
        this.setIpAddress(ipAddress);
        this.setGamertag(gamertag);
        this.car = new Car();
    }
    public Player() {
        this.car = new Car();
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
     * @return the car
     */
    public Car getCar() {
        return car;
    }
    // }} Getters and Setters

    public void reset() {
    	this.getCar().reset();
    }
}
