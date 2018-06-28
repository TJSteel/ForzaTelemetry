package car;

import utility.Calc;

public class Wheel {
	// {{ Variables
    private float wheelRotationSpeedFrontLeft = 0.0F; // Wheel rotation speed radians/sec. 
    private float wheelRotationSpeedFrontRight = 0.0F;
    private float wheelRotationSpeedRearLeft = 0.0F;
    private float wheelRotationSpeedRearRight = 0.0F;
    private int wheelOnRumbleStripFrontLeft = 0; // = 1 when wheel is on rumble strip, = 0 when off.
    private int wheelOnRumbleStripFrontRight = 0;
    private int wheelOnRumbleStripRearLeft = 0;
    private int wheelOnRumbleStripRearRight = 0;
    private float wheelInPuddleDepthFrontLeft = 0.0F; // = from 0 to 1, where 1 is the deepest puddle
    private float wheelInPuddleDepthFrontRight = 0.0F;
    private float wheelInPuddleDepthRearLeft = 0.0F;
    private float wheelInPuddleDepthRearRight = 0.0F;
    // }} Variables

    // {{ Setters and Getters
    /**
     * @return the wheelRotationSpeedFrontLeft
     */
    public float getWheelRotationSpeedFrontLeft() {
        return wheelRotationSpeedFrontLeft;
    }

    /**
     * @param wheelRotationSpeedFrontLeft the wheelRotationSpeedFrontLeft to set
     */
    public void setWheelRotationSpeedFrontLeft(float wheelRotationSpeedFrontLeft) {
        this.wheelRotationSpeedFrontLeft = wheelRotationSpeedFrontLeft;
    }

    /**
     * @return the wheelRotationSpeedFrontRight
     */
    public float getWheelRotationSpeedFrontRight() {
        return wheelRotationSpeedFrontRight;
    }

    /**
     * @param wheelRotationSpeedFrontRight the wheelRotationSpeedFrontRight to
     * set
     */
    public void setWheelRotationSpeedFrontRight(float wheelRotationSpeedFrontRight) {
        this.wheelRotationSpeedFrontRight = wheelRotationSpeedFrontRight;
    }

    /**
     * @return the wheelRotationSpeedRearLeft
     */
    public float getWheelRotationSpeedRearLeft() {
        return wheelRotationSpeedRearLeft;
    }

    /**
     * @param wheelRotationSpeedRearLeft the wheelRotationSpeedRearLeft to set
     */
    public void setWheelRotationSpeedRearLeft(float wheelRotationSpeedRearLeft) {
        this.wheelRotationSpeedRearLeft = wheelRotationSpeedRearLeft;
    }

    /**
     * @return the wheelRotationSpeedRearRight
     */
    public float getWheelRotationSpeedRearRight() {
        return wheelRotationSpeedRearRight;
    }

    /**
     * @param wheelRotationSpeedRearRight the wheelRotationSpeedRearRight to set
     */
    public void setWheelRotationSpeedRearRight(float wheelRotationSpeedRearRight) {
        this.wheelRotationSpeedRearRight = wheelRotationSpeedRearRight;
    }

    /**
     * @return the wheelOnRumbleStripFrontLeft
     */
    public int getWheelOnRumbleStripFrontLeft() {
        return wheelOnRumbleStripFrontLeft;
    }

    /**
     * @param wheelOnRumbleStripFrontLeft the wheelOnRumbleStripFrontLeft to set
     */
    public void setWheelOnRumbleStripFrontLeft(int wheelOnRumbleStripFrontLeft) {
        this.wheelOnRumbleStripFrontLeft = wheelOnRumbleStripFrontLeft;
    }

    /**
     * @return the wheelOnRumbleStripFrontRight
     */
    public int getWheelOnRumbleStripFrontRight() {
        return wheelOnRumbleStripFrontRight;
    }

    /**
     * @param wheelOnRumbleStripFrontRight the wheelOnRumbleStripFrontRight to
     * set
     */
    public void setWheelOnRumbleStripFrontRight(int wheelOnRumbleStripFrontRight) {
        this.wheelOnRumbleStripFrontRight = wheelOnRumbleStripFrontRight;
    }

    /**
     * @return the wheelOnRumbleStripRearLeft
     */
    public int getWheelOnRumbleStripRearLeft() {
        return wheelOnRumbleStripRearLeft;
    }

    /**
     * @param wheelOnRumbleStripRearLeft the wheelOnRumbleStripRearLeft to set
     */
    public void setWheelOnRumbleStripRearLeft(int wheelOnRumbleStripRearLeft) {
        this.wheelOnRumbleStripRearLeft = wheelOnRumbleStripRearLeft;
    }

    /**
     * @return the wheelOnRumbleStripRearRight
     */
    public int getWheelOnRumbleStripRearRight() {
        return wheelOnRumbleStripRearRight;
    }

    /**
     * @param wheelOnRumbleStripRearRight the wheelOnRumbleStripRearRight to set
     */
    public void setWheelOnRumbleStripRearRight(int wheelOnRumbleStripRearRight) {
        this.wheelOnRumbleStripRearRight = wheelOnRumbleStripRearRight;
    }

    /**
     * @return the wheelInPuddleDepthFrontLeft
     */
    public float getWheelInPuddleDepthFrontLeft() {
        return wheelInPuddleDepthFrontLeft;
    }

    /**
     * @param wheelInPuddleDepthFrontLeft the wheelInPuddleDepthFrontLeft to set
     */
    public void setWheelInPuddleDepthFrontLeft(float wheelInPuddleDepthFrontLeft) {
        this.wheelInPuddleDepthFrontLeft = wheelInPuddleDepthFrontLeft;
    }

    /**
     * @return the wheelInPuddleDepthFrontRight
     */
    public float getWheelInPuddleDepthFrontRight() {
        return wheelInPuddleDepthFrontRight;
    }

    /**
     * @param wheelInPuddleDepthFrontRight the wheelInPuddleDepthFrontRight to
     * set
     */
    public void setWheelInPuddleDepthFrontRight(float wheelInPuddleDepthFrontRight) {
        this.wheelInPuddleDepthFrontRight = wheelInPuddleDepthFrontRight;
    }

    /**
     * @return the wheelInPuddleDepthRearLeft
     */
    public float getWheelInPuddleDepthRearLeft() {
        return wheelInPuddleDepthRearLeft;
    }

    /**
     * @param wheelInPuddleDepthRearLeft the wheelInPuddleDepthRearLeft to set
     */
    public void setWheelInPuddleDepthRearLeft(float wheelInPuddleDepthRearLeft) {
        this.wheelInPuddleDepthRearLeft = wheelInPuddleDepthRearLeft;
    }

    /**
     * @return the wheelInPuddleDepthRearRight
     */
    public float getWheelInPuddleDepthRearRight() {
        return wheelInPuddleDepthRearRight;
    }

    /**
     * @param wheelInPuddleDepthRearRight the wheelInPuddleDepthRearRight to set
     */
    public void setWheelInPuddleDepthRearRight(float wheelInPuddleDepthRearRight) {
        this.wheelInPuddleDepthRearRight = wheelInPuddleDepthRearRight;
    }
    // }} Setters and Getters
    
	public double getDrivenWheelSpeed(String units, String driveTrain) {
		//for this I'm going to calculate only on driven wheels, slipping doesn't matter as wheel spin would increase RPM
		int wheelCount = 0;
		float wheelSpeed = 0;
		
		if (driveTrain.equals("FWD") || driveTrain.equals("AWD")) {
			wheelSpeed += this.getWheelRotationSpeedFrontLeft();
			wheelCount ++;
		}
		if (driveTrain.equals("FWD") || driveTrain.equals("AWD")) {
			wheelSpeed += this.getWheelRotationSpeedFrontRight();
			wheelCount ++;
		}
		if (driveTrain.equals("RWD") || driveTrain.equals("AWD")) {
			wheelSpeed += this.getWheelRotationSpeedRearLeft();
			wheelCount ++;
		}
		if (driveTrain.equals("RWD") || driveTrain.equals("AWD")) {
			wheelSpeed += this.getWheelRotationSpeedRearRight();
			wheelCount ++;
		}
		if (wheelCount == 0) {
			return 0;
		} else {
			switch (units) {
			case "RPM":
				return Calc.radiansPerSecondToRPM(wheelSpeed / wheelCount);
			default:
				return (wheelSpeed / wheelCount);
			}
		}
	}
}
