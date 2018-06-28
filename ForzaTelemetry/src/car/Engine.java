package car;

public class Engine {
	// {{ Variables
    private float engineMaxRpm = 0.0F;
    private float engineIdleRpm = 0.0F;
    private float currentEngineRpm = 0.0F;
    private float maxReachedRpm = 0;
    private String drivetrainType = "N/A"; //Corresponds to DrivetrainType; 0 = FWD, 1 = RWD, 2 = AWD
    private int numCylinders = 0; //Number of cylinders in the engine
    // }} Variables

    // {{ Getters and Setters
    /**
     * @return the engineMaxRpm
     */
    public float getEngineMaxRpm() {
        return engineMaxRpm;
    }

    /**
     * @param engineMaxRpm the engineMaxRpm to set
     */
    public void setEngineMaxRpm(float engineMaxRpm) {
        this.engineMaxRpm = engineMaxRpm;
    }

    /**
     * @return the engineIdleRpm
     */
    public float getEngineIdleRpm() {
        return engineIdleRpm;
    }

    /**
     * @param engineIdleRpm the engineIdleRpm to set
     */
    public void setEngineIdleRpm(float engineIdleRpm) {
        this.engineIdleRpm = engineIdleRpm;
    }

    /**
     * @return the currentEngineRpm
     */
    public float getCurrentEngineRpm() {
        return currentEngineRpm;
    }

    /**
     * @param currentEngineRpm the currentEngineRpm to set
     */
    public void setCurrentEngineRpm(float currentEngineRpm) {
        this.currentEngineRpm = currentEngineRpm;
    	setMaxReachedRpm(currentEngineRpm > getMaxReachedRpm() ? currentEngineRpm : getMaxReachedRpm());
    }

	/**
	 * @return the maxReachedRpm
	 */
	public float getMaxReachedRpm() {
		return maxReachedRpm;
	}

	/**
	 * @param maxReachedRpm the maxReachedRpm to set
	 */
	private void setMaxReachedRpm(float maxReachedRpm) {
		this.maxReachedRpm = maxReachedRpm;
	}

    /**
     * @return the drivetrainType
     */
    public String getDrivetrainType() {
    	return drivetrainType;
    }

    /**
     * @param drivetrainType the drivetrainType to set
     */
    public void setDrivetrainType(int drivetrainType) {
        switch (drivetrainType) {
            case 0:
                this.drivetrainType = "FWD";
                break;
            case 1:
                this.drivetrainType = "RWD";
                break;
            case 2:
                this.drivetrainType = "AWD";
                break;
            default:
                System.out.println("Drivetype '" + drivetrainType + "' is invalid, must be FWD, RWD, or AWD");
        }
    }

    /**
     * @param drivetrainType the drivetrainType to set
     */
    public void setDrivetrainType(String drivetrainType) {
        switch (drivetrainType) {
            case "FWD":
            case "RWD":
            case "AWD":
                this.drivetrainType = drivetrainType;
                break;
            default:
                System.out.println("Drivetype '" + drivetrainType + "' is invalid, must be FWD, RWD, or AWD");
        }
    }

    /**
     * @return the numCylinders
     */
    public int getNumCylinders() {
        return numCylinders;
    }

    /**
     * @param numCylinders the numCylinders to set
     */
    public void setNumCylinders(int numCylinders) {
        this.numCylinders = numCylinders;
    }
    // }} Getters and Setters
}
