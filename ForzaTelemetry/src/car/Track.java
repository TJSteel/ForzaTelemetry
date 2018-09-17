package car;

import java.util.ArrayList;

public class Track {
	// {{ variables
    private float positionX = 0.0F; //I think this is the car in the tracks local space
    private float positionY = 0.0F; //Height/Altitude
    private float positionZ = 0.0F;
    private float distanceTraveled = 0.0F; //need to calculate which units it's using
    private float bestLap = 0.0F; //seconds
    private float lastLap = 0.0F; //seconds
    private float currentLap = 0.0F; //seconds
    private float currentRaceTime = 0.0F; //seconds
    private short lapNumber = 0; 
    private short racePosition = 0;
    private ArrayList<Float> lapTimes = new ArrayList<Float>();

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
		if (this.lapNumber < lapNumber) {
			//calculate new lap stuff
			lapTimes.add(this.getLastLap());
		}
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

	// {{ Calculated fields
	public float getAverageLap() {
		float totalTime = 0.0f;
		for (float lap: this.lapTimes) {
			totalTime += lap;
		}
		return this.lapTimes.size() == 0 ? totalTime : totalTime / this.lapTimes.size();
	}
	
	public float getLastLapDelta() {
		//make sure there is data in the array list
		if (this.lapTimes.size()>0) {
			float currentLap = this.lapTimes.get(this.lapTimes.size()-1);
			float bestLap = this.getBestLap();
			
			// if a new best lap has just been set and it's not the only lap, we want to find the split from the previous best lap
			if (currentLap == bestLap && this.lapTimes.size() > 1) {
				// set previous best to the lap previous to the last lap
				float previousBestLap = this.lapTimes.get(this.lapTimes.size()-2);
				
				// loop through the arraylist skipping the previous lap and updating with the best time
				for (int i = this.lapTimes.size()-2; i >= 0; i--) {
					if (this.lapTimes.get(i) < previousBestLap) previousBestLap = this.lapTimes.get(i);
				}
				
				return currentLap - previousBestLap;
			} else {
				return currentLap - bestLap;
			}
		} else {
			return 0.0f;
		}
	}
	
	// }} Calculated fields

    public void reset() {
    	this.lapTimes.clear();
    }


}
