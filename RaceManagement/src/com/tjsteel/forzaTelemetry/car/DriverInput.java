package com.tjsteel.forzaTelemetry.car;

public class DriverInput {
	// {{ Variables
    private short accel = 0;
    private short brake = 0;
    private short clutch = 0;
    private short handbrake = 0;
    private byte steer = 0;
    private byte normalizedDrivingLine = 0;
    private byte normalizedAIBrakeDifference = 0;

    // }} Variables

    // {{ Setters and Getters
	/**
	 * @return the accel
	 */
	public short getAccel() {
		return accel;
	}

	/**
	 * @param accel the accel to set
	 */
	public void setAccel(short accel) {
		this.accel = accel;
	}

	/**
	 * @return the brake
	 */
	public short getBrake() {
		return brake;
	}

	/**
	 * @param brake the brake to set
	 */
	public void setBrake(short brake) {
		this.brake = brake;
	}

	/**
	 * @return the clutch
	 */
	public short getClutch() {
		return clutch;
	}

	/**
	 * @param clutch the clutch to set
	 */
	public void setClutch(short clutch) {
		this.clutch = clutch;
	}

	/**
	 * @return the handbrake
	 */
	public short getHandbrake() {
		return handbrake;
	}

	/**
	 * @param handbrake the handbrake to set
	 */
	public void setHandbrake(short handbrake) {
		this.handbrake = handbrake;
	}

	/**
	 * @return the steer
	 */
	public byte getSteer() {
		return steer;
	}

	/**
	 * @param steer the steer to set
	 */
	public void setSteer(byte steer) {
		this.steer = steer;
	}

	/**
	 * @return the normalizedDrivingLine
	 */
	public byte getNormalizedDrivingLine() {
		return normalizedDrivingLine;
	}

	/**
	 * @param normalizedDrivingLine the normalizedDrivingLine to set
	 */
	public void setNormalizedDrivingLine(byte normalizedDrivingLine) {
		this.normalizedDrivingLine = normalizedDrivingLine;
	}
	
	/**
	 * @return the normalizedAIBrakeDifference
	 */
	public byte getNormalizedAIBrakeDifference() {
		return normalizedAIBrakeDifference;
	}

	/**
	 * @param normalizedAIBrakeDifference the normalizedAIBrakeDifference to set
	 */
	public void setNormalizedAIBrakeDifference(byte normalizedAIBrakeDifference) {
		this.normalizedAIBrakeDifference = normalizedAIBrakeDifference;
	}
    // }} Setters and Getters
    
    // {{ Calculated Fields


    // }} Calculated Fields

}
