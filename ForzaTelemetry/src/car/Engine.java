package car;

import enums.Drivetrain;

public class Engine {
	// {{ Variables
    private float engineMaxRpm = 0.0F;
    private float engineIdleRpm = 0.0F;
    private float currentEngineRpm = 0.0F;
    private Drivetrain drivetrainType = Drivetrain.NONE; //Corresponds to DrivetrainType; 0 = FWD, 1 = RWD, 2 = AWD
    private int numCylinders = 0; //Number of cylinders in the engine
    private float power = 0.0F; //watts
    private float torque = 0.0F; //newton meters
    private float boost = 0.0F; 
    private float fuel = 0.0F; //percentage full from 0.0F to 100.0F
    private short gear = 0; //0 = reverse, anything positive = gear
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
    }

    /**
     * @return the drivetrainType
     */
    public Drivetrain getDrivetrainType() {
    	return drivetrainType;
    }

    /**
     * @param drivetrainType the drivetrainType to set
     */
    public void setDrivetrainType(int drivetrainType) {
        switch (drivetrainType) {
            case 0:
                this.drivetrainType = Drivetrain.FWD;
                break;
            case 1:
                this.drivetrainType = Drivetrain.RWD;
                break;
            case 2:
                this.drivetrainType = Drivetrain.AWD;
                break;
            case 3:
                this.drivetrainType = Drivetrain.NONE;
                break;
            default:
                System.out.println("Drivetype '" + drivetrainType + "' is invalid, must be FWD (0), RWD (1), AWD (2), or NONE (3)");
        }
    }

    /**
     * @param drivetrainType the drivetrainType to set
     */
    public void setDrivetrainType(Drivetrain drivetrainType) {
    	this.drivetrainType = drivetrainType;
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

	/**
	 * @return the power
	 */
	public float getPower() {
		return power;
	}

	/**
	 * @param power the power to set
	 */
	public void setPower(float power) {
		this.power = power;
	}

	/**
	 * @return the torque
	 */
	public float getTorque() {
		return torque;
	}

	/**
	 * @param torque the torque to set
	 */
	public void setTorque(float torque) {
		this.torque = torque;
	}

	/**
	 * @return the boost
	 */
	public float getBoost() {
		return boost;
	}

	/**
	 * @param boost the boost to set
	 */
	public void setBoost(float boost) {
		this.boost = boost;
	}

	/**
	 * @return the fuel
	 */
	public float getFuel() {
		return fuel;
	}

	/**
	 * @param fuel the fuel to set
	 */
	public void setFuel(float fuel) {
		this.fuel = fuel;
	}

	/**
	 * @return the gear
	 */
	public short getGear() {
		return gear;
	}

	/**
	 * @param gear the gear to set
	 */
	public void setGear(short gear) {
		this.gear = gear;
	}
    // }} Getters and Setters    
}
