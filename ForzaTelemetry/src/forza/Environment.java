/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forza;

import java.util.ArrayList;
import java.awt.geom.*;

public class Environment {

	// {{ Variables
    private String trackName = "";
    private float trackLength = 0.0f;
    private ArrayList<Point2D> trackLayoutOuter;
    private ArrayList<Point2D> trackLayoutInner;
    // }} Variables

    // Constructor
    public Environment(String trackName, float trackLength, ArrayList<Point2D> trackLayoutOuter,ArrayList<Point2D> trackLayoutInner) {
        this.setTrackName(trackName);
        this.setTrackLength(trackLength);
        this.setTrackLayoutOuter(trackLayoutOuter);
        this.setTrackLayoutInner(trackLayoutInner);
    }
    public Environment(String trackName, float trackLength) {
        this.setTrackName(trackName);
        this.setTrackLength(trackLength);
    }
    
    // {{ Getters and Setters
    /**
     * @return the ipAddress
     */

    // }} Getters and Setters

	/**
	 * @return the trackName
	 */
	public String getTrackName() {
		return trackName;
	}
	/**
	 * @param trackName the trackName to set
	 */
	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}
	/**
	 * @return the trackLength
	 */
	public float getTrackLength() {
		return trackLength;
	}
	/**
	 * @param trackLength the trackLength to set
	 */
	public void setTrackLength(float trackLength) {
		this.trackLength = trackLength;
	}
	/**
	 * @return the trackLayoutOuter
	 */
	public ArrayList<Point2D> getTrackLayoutOuter() {
		return trackLayoutOuter;
	}
	/**
	 * @param trackLayoutOuter the trackLayoutOuter to set
	 */
	public void setTrackLayoutOuter(ArrayList<Point2D> trackLayoutOuter) {
		this.trackLayoutOuter = trackLayoutOuter;
	}
	/**
	 * @return the trackLayoutInner
	 */
	public ArrayList<Point2D> getTrackLayoutInner() {
		return trackLayoutInner;
	}
	/**
	 * @param trackLayoutInner the trackLayoutInner to set
	 */
	public void setTrackLayoutInner(ArrayList<Point2D> trackLayoutInner) {
		this.trackLayoutInner = trackLayoutInner;
	}
}
