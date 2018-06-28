package car;

import java.net.DatagramPacket;
import java.nio.ByteBuffer;

/**
 *
 * @author Jay
 */
public class Car {
	// {{ variables from Forza 7
    private Engine engine = new Engine();
    private Velocity velocity = new Velocity();
    private Suspension suspension = new Suspension();
    private Tyre tyre = new Tyre();
    private Wheel wheel = new Wheel();
    private Rumble rumble = new Rumble();
    private boolean raceOn = false; // = 1 when race is on. = 0 when in menus/race stopped …
    private int timestampMS = 0; //Can overflow to 0 eventually
    private int carOrdinal = 0; //Unique ID of the car make/model
    private char carClass = 'U'; //Between 0 (D -- worst cars) and 7 (X class -- best cars) inclusive 
    private int carPerformanceIndex = 0; //Between 100 (slowest car) and 999 (fastest car) inclusive
    
    // process a received packet of data
    public void processDataPacket(DatagramPacket dataPack) {

        byte[] receivedDataPacket = dataPack.getData();

        for (int i = 0; i < 58; i++) {
            //read input stream and convert byte sequence into a 32bit int
            //start by sticking the current int we want into an array
            byte[] receivedBytes = {receivedDataPacket[(i * 4) + 3], 
                                    receivedDataPacket[(i * 4) + 2], 
                                    receivedDataPacket[(i * 4) + 1], 
                                    receivedDataPacket[i * 4]};

            //wrap this array into a ByteBuffer which we can then get in / float from
            ByteBuffer bb = ByteBuffer.wrap(receivedBytes);

            // put data into relevant variables
            switch (i) {
                case 0:
                    this.setRaceOn(bb.getInt());
                    break;
                case 1:
                    this.setTimestampMS(bb.getInt());
                    break;
                case 2:
                    this.engine.setEngineMaxRpm(bb.getFloat());
                    break;
                case 3:
                    this.engine.setEngineIdleRpm(bb.getFloat());
                    break;
                case 4:
                    this.engine.setCurrentEngineRpm(bb.getFloat());
                    break;
                case 5:
                    this.velocity.setAccelerationX(bb.getFloat());
                    break;
                case 6:
                    this.velocity.setAccelerationY(bb.getFloat());
                    break;
                case 7:
                    this.velocity.setAccelerationZ(bb.getFloat());
                    break;
                case 8:
                    this.velocity.setVelocityX(bb.getFloat());
                    break;
                case 9:
                    this.velocity.setVelocityY(bb.getFloat());
                    break;
                case 10:
                    this.velocity.setVelocityZ(bb.getFloat());
                    break;
                case 11:
                    this.velocity.setAngularVelocityX(bb.getFloat());
                    break;
                case 12:
                    this.velocity.setAngularVelocityY(bb.getFloat());
                    break;
                case 13:
                    this.velocity.setAngularVelocityZ(bb.getFloat());
                    break;
                case 14:
                    this.velocity.setYaw(bb.getFloat());
                    break;
                case 15:
                    this.velocity.setPitch(bb.getFloat());
                    break;
                case 16:
                    this.velocity.setRoll(bb.getFloat());
                    break;
                case 17:
                    this.suspension.setNormalizedSuspensionTravelFrontLeft(bb.getFloat());
                    break;
                case 18:
                    this.suspension.setNormalizedSuspensionTravelFrontRight(bb.getFloat());
                    break;
                case 19:
                    this.suspension.setNormalizedSuspensionTravelRearLeft(bb.getFloat());
                    break;
                case 20:
                    this.suspension.setNormalizedSuspensionTravelRearRight(bb.getFloat());
                    break;
                case 21:
                    this.tyre.setTireSlipRatioFrontLeft(bb.getFloat());
                    break;
                case 22:
                    this.tyre.setTireSlipRatioFrontRight(bb.getFloat());
                    break;
                case 23:
                    this.tyre.setTireSlipRatioRearLeft(bb.getFloat());
                    break;
                case 24:
                    this.tyre.setTireSlipRatioRearRight(bb.getFloat());
                    break;
                case 25:
                    this.wheel.setWheelRotationSpeedFrontLeft(bb.getFloat());
                    break;
                case 26:
                    this.wheel.setWheelRotationSpeedFrontRight(bb.getFloat());
                    break;
                case 27:
                    this.wheel.setWheelRotationSpeedRearLeft(bb.getFloat());
                    break;
                case 28:
                    this.wheel.setWheelRotationSpeedRearRight(bb.getFloat());
                    break;
                case 29:
                    this.wheel.setWheelOnRumbleStripFrontLeft(bb.getInt());
                    break;
                case 30:
                    this.wheel.setWheelOnRumbleStripFrontRight(bb.getInt());
                    break;
                case 31:
                    this.wheel.setWheelOnRumbleStripRearLeft(bb.getInt());
                    break;
                case 32:
                    this.wheel.setWheelOnRumbleStripRearRight(bb.getInt());
                    break;
                case 33:
                    this.wheel.setWheelInPuddleDepthFrontLeft(bb.getFloat());
                    break;
                case 34:
                    this.wheel.setWheelInPuddleDepthFrontRight(bb.getFloat());
                    break;
                case 35:
                    this.wheel.setWheelInPuddleDepthRearLeft(bb.getFloat());
                    break;
                case 36:
                    this.wheel.setWheelInPuddleDepthRearRight(bb.getFloat());
                    break;
                case 37:
                    this.rumble.setSurfaceRumbleFrontLeft(bb.getFloat());
                    break;
                case 38:
                    this.rumble.setSurfaceRumbleFrontRight(bb.getFloat());
                    break;
                case 39:
                    this.rumble.setSurfaceRumbleRearLeft(bb.getFloat());
                    break;
                case 40:
                    this.rumble.setSurfaceRumbleRearRight(bb.getFloat());
                    break;
                case 41:
                    this.tyre.setTireSlipAngleFrontLeft(bb.getFloat());
                    break;
                case 42:
                    this.tyre.setTireSlipAngleFrontRight(bb.getFloat());
                    break;
                case 43:
                    this.tyre.setTireSlipAngleRearLeft(bb.getFloat());
                    break;
                case 44:
                    this.tyre.setTireSlipAngleRearRight(bb.getFloat());
                    break;
                case 45:
                    this.tyre.setTireCombinedSlipFrontLeft(bb.getFloat());
                    break;
                case 46:
                    this.tyre.setTireCombinedSlipFrontRight(bb.getFloat());
                    break;
                case 47:
                    this.tyre.setTireCombinedSlipRearLeft(bb.getFloat());
                    break;
                case 48:
                    this.tyre.setTireCombinedSlipRearRight(bb.getFloat());
                    break;
                case 49:
                    this.suspension.setSuspensionTravelMetersFrontLeft(bb.getFloat());
                    break;
                case 50:
                    this.suspension.setSuspensionTravelMetersFrontRight(bb.getFloat());
                    break;
                case 51:
                    this.suspension.setSuspensionTravelMetersRearLeft(bb.getFloat());
                    break;
                case 52:
                    this.suspension.setSuspensionTravelMetersRearRight(bb.getFloat());
                    break;
                case 53:
                    this.setCarOrdinal(bb.getInt());
                    break;
                case 54:
                    this.setCarClass(bb.getInt());
                    break;
                case 55:
                    this.setCarPerformanceIndex(bb.getInt());
                    break;
                case 56:
                    this.engine.setDrivetrainType(bb.getInt());
                    break;
                case 57:
                    this.engine.setNumCylinders(bb.getInt());
                    break;
            }
        }
        //set calculated fields here once processed new data
        this.velocity.updateMaxSpeed();
    }
    
    //print stored data
    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        //if (this.isRaceOn()) {
            returnString.append("Car = ");
            returnString.append(this.getCarOrdinal());
            returnString.append(", Class = ");
            returnString.append(this.getCarClass());
            returnString.append(", PI = ");
            returnString.append(this.getCarPerformanceIndex());
            returnString.append(", Drivetrain = ");
            returnString.append(this.isRaceOn() ? this.engine.getDrivetrainType() : "N/A");
            returnString.append(", Cylinders = ");
            returnString.append(this.engine.getNumCylinders());
            returnString.append(", Rpm = ");
            returnString.append(Math.round(this.getEngine().getCurrentEngineRpm()));
            returnString.append(", Speed = ");
            returnString.append((this.velocity.getSpeed("MPH")));
            returnString.append(", Max Speed = ");
            returnString.append((this.velocity.getMaxSpeed("MPH")));
        /*} else {
            returnString.append("Car inactive");
        }*/
        return returnString.toString();
    }

    
    // {{ Setters and Getters, Standard Forza 7 outputs

    /**
     * @return the raceOn
     */
    public boolean isRaceOn() {
        return raceOn;
    }

    /**
     * @param raceOn the raceOn to set
     */
    public void setRaceOn(int raceOn) {
        this.raceOn = raceOn == 1;
    }

    /**
     * @return the timestampMS
     */
    public int getTimestampMS() {
        return timestampMS;
    }

    /**
     * @param timestampMS the timestampMS to set
     */
    public void setTimestampMS(int timestampMS) {
        this.timestampMS = timestampMS;
    }




    /**
     * @return the carOrdinal
     */
    public int getCarOrdinal() {
        return carOrdinal;
    }

    /**
     * @param carOrdinal the carOrdinal to set
     */
    public void setCarOrdinal(int carOrdinal) {
        this.carOrdinal = carOrdinal;
    }

    /**
     * @return the carClass
     */
    public char getCarClass() {
        return this.isRaceOn() ? carClass : '0';
    }

    /**
     * @param carClass the carClass to set
     */
    public void setCarClass(int carClass) {
        switch (carClass) {
            case 0:
                this.carClass = 'E';
                break;
            case 1:
                this.carClass = 'D';
                break;
            case 2:
                this.carClass = 'C';
                break;
            case 3:
                this.carClass = 'B';
                break;
            case 4:
                this.carClass = 'A';
                break;
            case 5:
                this.carClass = 'S';
                break;
            case 6:
                this.carClass = 'R';
                break;
            case 7:
                this.carClass = 'P';
                break;
            case 8:
                this.carClass = 'X';
                break;
            default:
                System.out.println("Car class '" + carClass + "' is invalid!, valid range is 0-8");
        }
    }

    /**
     * @param carClass the carClass to set
     */
    public void setCarClass(char carClass) {
        switch (carClass) {
            case 'E':
            case 'D':
            case 'C':
            case 'B':
            case 'A':
            case 'S':
            case 'R':
            case 'P':
            case 'X':
                this.carClass = carClass;
                break;
            default:
                System.out.println("Car class '" + carClass + "' is invalid!, must be E, D, C, B, A, S, R, P, or X");
        }
    }

    /**
     * @return the carPerformanceIndex
     */
    public int getCarPerformanceIndex() {
        return carPerformanceIndex;
    }

    /**
     * @param carPerformanceIndex the carPerformanceIndex to set
     */
    public void setCarPerformanceIndex(int carPerformanceIndex) {
        this.carPerformanceIndex = carPerformanceIndex;
    }



    // }} Setters and Getters for speed

    // {{ Gear ratio calculations
    
	/**
	 * @return the gearRatio
	 */
	public double getGearRatio(double finalDrive) {
		/* 	To Calc the ratio we don't need wheel size or speed, just prop RPM and engine RPM
    		propRPM = finalDrive * wheelRPM
    		ratio = engineRPM / propRPM */
		double propRPM = finalDrive * this.wheel.getDrivenWheelSpeed("RPM", this.engine.getDrivetrainType());
		return (double) this.engine.getCurrentEngineRpm() / propRPM;
	}



	/**
	 * @return the engine
	 */
	public Engine getEngine() {
		return engine;
	}

	/**
	 * @param engine the engine to set
	 */
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	/**
	 * @return the velocity
	 */
	public Velocity getVelocity() {
		return velocity;
	}

	/**
	 * @param velocity the velocity to set
	 */
	public void setVelocity(Velocity velocity) {
		this.velocity = velocity;
	}

	/**
	 * @return the suspension
	 */
	public Suspension getSuspension() {
		return suspension;
	}

	/**
	 * @param suspension the suspension to set
	 */
	public void setSuspension(Suspension suspension) {
		this.suspension = suspension;
	}

	/**
	 * @return the tyre
	 */
	public Tyre getTyre() {
		return tyre;
	}

	/**
	 * @param tyre the tyre to set
	 */
	public void setTyre(Tyre tyre) {
		this.tyre = tyre;
	}

	/**
	 * @return the wheel
	 */
	public Wheel getWheel() {
		return wheel;
	}

	/**
	 * @param wheel the wheel to set
	 */
	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}

	/**
	 * @return the rumble
	 */
	public Rumble getRumble() {
		return rumble;
	}

	/**
	 * @param rumble the rumble to set
	 */
	public void setRumble(Rumble rumble) {
		this.rumble = rumble;
	}

    // }}
}
