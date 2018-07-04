package car;

import utility.Calc;

public class Velocity {
	// {{ variables
    private float accelerationX = 0.0F; //In the car's local space; X = right, Y = up, Z = forward
    private float accelerationY = 0.0F;
    private float accelerationZ = 0.0F;
    private float velocityX = 0.0F; //In the car's local space; X = right, Y = up, Z = forward
    private float velocityY = 0.0F;
    private float velocityZ = 0.0F;
    private float angularVelocityX = 0.0F; //In the car's local space; X = pitch, Y = yaw, Z = roll
    private float angularVelocityY = 0.0F;
    private float angularVelocityZ = 0.0F;
    private float yaw = 0.0F; //turning left / right
    private float pitch = 0.0F; //wheelie / endo
    private float roll = 0.0F; //body roll

	private double maxSpeed = 200;
	// }} variables

	// {{ Getters and Setters
    /**
     * @return the accelerationX
     */
    public float getAccelerationX() {
        return accelerationX;
    }

    /**
     * @param accelerationX the accelerationX to set
     */
    public void setAccelerationX(float accelerationX) {
        this.accelerationX = accelerationX;
    }

    /**
     * @return the accelerationY
     */
    public float getAccelerationY() {
        return accelerationY;
    }

    /**
     * @param accelerationY the accelerationY to set
     */
    public void setAccelerationY(float accelerationY) {
        this.accelerationY = accelerationY;
    }

    /**
     * @return the accelerationZ
     */
    public float getAccelerationZ() {
        return accelerationZ;
    }

    /**
     * @param accelerationZ the accelerationZ to set
     */
    public void setAccelerationZ(float accelerationZ) {
        this.accelerationZ = accelerationZ;
    }

    /**
     * @return the velocityX
     */
    public float getVelocityX() {
        return velocityX;
    }

    /**
     * @param velocityX the velocityX to set
     */
    public void setVelocityX(float velocityX) {
        this.velocityX = velocityX;
    }

    /**
     * @return the velocityY
     */
    public float getVelocityY() {
        return velocityY;
    }

    /**
     * @param velocityY the velocityY to set
     */
    public void setVelocityY(float velocityY) {
        this.velocityY = velocityY;
    }

    /**
     * @return the velocityZ
     */
    public float getVelocityZ() {
        return velocityZ;
    }

    /**
     * @param velocityZ the velocityZ to set
     */
    public void setVelocityZ(float velocityZ) {
        this.velocityZ = velocityZ;
    }

    /**
     * @return the angularVelocityX
     */
    public float getAngularVelocityX() {
        return angularVelocityX;
    }

    /**
     * @param angularVelocityX the angularVelocityX to set
     */
    public void setAngularVelocityX(float angularVelocityX) {
        this.angularVelocityX = angularVelocityX;
    }

    /**
     * @return the angularVelocityY
     */
    public float getAngularVelocityY() {
        return angularVelocityY;
    }

    /**
     * @param angularVelocityY the angularVelocityY to set
     */
    public void setAngularVelocityY(float angularVelocityY) {
        this.angularVelocityY = angularVelocityY;
    }

    /**
     * @return the angularVelocityZ
     */
    public float getAngularVelocityZ() {
        return angularVelocityZ;
    }

    /**
     * @param angularVelocityZ the angularVelocityZ to set
     */
    public void setAngularVelocityZ(float angularVelocityZ) {
        this.angularVelocityZ = angularVelocityZ;
    }

    /**
     * @return the yaw
     */
    public float getYaw() {
        return yaw;
    }

    /**
     * @param yaw the yaw to set
     */
    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    /**
     * @return the pitch
     */
    public float getPitch() {
        return pitch;
    }

    /**
     * @param pitch the pitch to set
     */
    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    /**
     * @return the roll
     */
    public float getRoll() {
        return roll;
    }

    /**
     * @param roll the roll to set
     */
    public void setRoll(float roll) {
        this.roll = roll;
    }

	// }} Getters and Setters

    // {{ Calculated fields
    //calculate and return the current speed in meters per second
    public double getSpeed(String units) {
    	double speed = Calc.hypotenuse(this.velocityX, this.velocityY, this.velocityZ);
        switch (units){
        case "MPH":
        	return Calc.MPStoMPH(speed);
        case "KPH":
        	return Calc.MPStoKPH(speed);
        default:
            return speed;
        }
    }
    public double getSpeed() {
    	return this.getSpeed("MPS");
    }

    /**
     * @param roll the maxSpeed to set
     */
    private void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    
    /**
     * @param maxSpeed the maxSpeed to set
     */
    public void updateMaxSpeed() {
    	double speed = this.getSpeed();
        this.setMaxSpeed(speed > this.getMaxSpeed() ? speed : this.getMaxSpeed());
    }

    /**
     * @return the maxSpeed
     */
    public double getMaxSpeed(String units) {
        switch (units){
        case "MPH":
        	return Calc.MPStoMPH(this.maxSpeed);
        case "KPH":
        	return Calc.MPStoKPH(this.maxSpeed);
        default:
            return this.maxSpeed;
        }
    }
    public double getMaxSpeed() {
    	return this.getMaxSpeed("MPS");
    }
    // }} Calculated fields

    public void reset() {
    	this.setMaxSpeed(0);
    }
}
