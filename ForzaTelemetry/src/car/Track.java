package car;

public class Track {
	// {{ variables
    private float positionX = 0.0F; //I think this is the car in the tracks local space
    private float positionY = 0.0F; //Height/Altitude
    private float positionZ = 0.0F;
    private float distanceTraveled = 0.0F; //need to calcualte which units it's using
    private float bestLap = 0.0F; //guessing in milliseconds
    private float lastLap = 0.0F; //guessing in milliseconds
    private float currentLap = 0.0F; //guessing in milliseconds
    private float currentRaceTime = 0.0F; //guessing in milliseconds
    private short lapNumber = 0; //guessing in milliseconds
    private short racePosition = 0; //guessing in milliseconds

	// }} variables

	// {{ Getters and Setters
    /**
     * @return the positionX
     */
    public float getPositionX() {
        return positionX;
    }

    /**
     * @param positionX the positionX to set
     */
    public void setPositionX(float positionX) {
        this.positionX = positionX;
    }

    /**
     * @return the positionY
     */
    public float getPositionY() {
        return positionY;
    }

    /**
     * @param positionY the positionY to set
     */
    public void setPositionY(float positionY) {
        this.positionY = positionY;
    }

    /**
     * @return the positionZ
     */
    public float getPositionZ() {
        return positionZ;
    }

    /**
     * @param positionZ the positionZ to set
     */
    public void setPositionZ(float positionZ) {
        this.positionZ = positionZ;
    }


    /**
     * @return the distanceTraveled
     */
    public float getDistanceTraveled() {
        return distanceTraveled;
    }

    /**
     * @param distanceTraveled the distanceTraveled to set
     */
    public void setDistanceTraveled(float distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

	/**
	 * @return the bestLap
	 */
	public float getBestLap() {
		return bestLap;
	}

	/**
	 * @param bestLap the bestLap to set
	 */
	public void setBestLap(float bestLap) {
		this.bestLap = bestLap;
	}

	/**
	 * @return the lastLap
	 */
	public float getLastLap() {
		return lastLap;
	}

	/**
	 * @param lastLap the lastLap to set
	 */
	public void setLastLap(float lastLap) {
		this.lastLap = lastLap;
	}

	/**
	 * @return the currentLap
	 */
	public float getCurrentLap() {
		return currentLap;
	}

	/**
	 * @param currentLap the currentLap to set
	 */
	public void setCurrentLap(float currentLap) {
		this.currentLap = currentLap;
	}

	/**
	 * @return the currentRaceTime
	 */
	public float getCurrentRaceTime() {
		return currentRaceTime;
	}

	/**
	 * @param currentRaceTime the currentRaceTime to set
	 */
	public void setCurrentRaceTime(float currentRaceTime) {
		this.currentRaceTime = currentRaceTime;
	}

	/**
	 * @return the lapNumber
	 */
	public short getLapNumber() {
		return lapNumber;
	}

	/**
	 * @param lapNumber the lapNumber to set
	 */
	public void setLapNumber(short lapNumber) {
		this.lapNumber = lapNumber;
	}

	/**
	 * @return the racePosition
	 */
	public short getRacePosition() {
		return racePosition;
	}

	/**
	 * @param racePosition the racePosition to set
	 */
	public void setRacePosition(short racePosition) {
		this.racePosition = racePosition;
	}


	// }} Getters and Setters

    public void reset() {
    	
    }	
}
