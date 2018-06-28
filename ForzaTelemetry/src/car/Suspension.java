package car;

public class Suspension {
	// {{ Variables
    private float normalizedSuspensionTravelFrontLeft = 0.0F; // Suspension travel normalized: 0.0f = max stretch; 1.0 = max compression
    private float normalizedSuspensionTravelFrontRight = 0.0F;
    private float normalizedSuspensionTravelRearLeft = 0.0F;
    private float normalizedSuspensionTravelRearRight = 0.0F;
    private float suspensionTravelMetersFrontLeft = 0.0F; // Actual suspension travel in meters
    private float suspensionTravelMetersFrontRight = 0.0F;
    private float suspensionTravelMetersRearLeft = 0.0F;
    private float suspensionTravelMetersRearRight = 0.0F;
    // }} Variables

    // {{ Getters and Setters    
    /**
     * @return the normalizedSuspensionTravelFrontLeft
     */
    public float getNormalizedSuspensionTravelFrontLeft() {
        return normalizedSuspensionTravelFrontLeft;
    }

    /**
     * @param normalizedSuspensionTravelFrontLeft the
     * normalizedSuspensionTravelFrontLeft to set
     */
    public void setNormalizedSuspensionTravelFrontLeft(float normalizedSuspensionTravelFrontLeft) {
        this.normalizedSuspensionTravelFrontLeft = normalizedSuspensionTravelFrontLeft;
    }

    /**
     * @return the normalizedSuspensionTravelFrontRight
     */
    public float getNormalizedSuspensionTravelFrontRight() {
        return normalizedSuspensionTravelFrontRight;
    }

    /**
     * @param normalizedSuspensionTravelFrontRight the
     * normalizedSuspensionTravelFrontRight to set
     */
    public void setNormalizedSuspensionTravelFrontRight(float normalizedSuspensionTravelFrontRight) {
        this.normalizedSuspensionTravelFrontRight = normalizedSuspensionTravelFrontRight;
    }

    /**
     * @return the normalizedSuspensionTravelRearLeft
     */
    public float getNormalizedSuspensionTravelRearLeft() {
        return normalizedSuspensionTravelRearLeft;
    }

    /**
     * @param normalizedSuspensionTravelRearLeft the
     * normalizedSuspensionTravelRearLeft to set
     */
    public void setNormalizedSuspensionTravelRearLeft(float normalizedSuspensionTravelRearLeft) {
        this.normalizedSuspensionTravelRearLeft = normalizedSuspensionTravelRearLeft;
    }

    /**
     * @return the normalizedSuspensionTravelRearRight
     */
    public float getNormalizedSuspensionTravelRearRight() {
        return normalizedSuspensionTravelRearRight;
    }

    /**
     * @param normalizedSuspensionTravelRearRight the
     * normalizedSuspensionTravelRearRight to set
     */
    public void setNormalizedSuspensionTravelRearRight(float normalizedSuspensionTravelRearRight) {
        this.normalizedSuspensionTravelRearRight = normalizedSuspensionTravelRearRight;
    }


    /**
     * @return the suspensionTravelMetersFrontLeft
     */
    public float getSuspensionTravelMetersFrontLeft() {
        return suspensionTravelMetersFrontLeft;
    }

    /**
     * @param suspensionTravelMetersFrontLeft the
     * suspensionTravelMetersFrontLeft to set
     */
    public void setSuspensionTravelMetersFrontLeft(float suspensionTravelMetersFrontLeft) {
        this.suspensionTravelMetersFrontLeft = suspensionTravelMetersFrontLeft;
    }

    /**
     * @return the suspensionTravelMetersFrontRight
     */
    public float getSuspensionTravelMetersFrontRight() {
        return suspensionTravelMetersFrontRight;
    }

    /**
     * @param suspensionTravelMetersFrontRight the
     * suspensionTravelMetersFrontRight to set
     */
    public void setSuspensionTravelMetersFrontRight(float suspensionTravelMetersFrontRight) {
        this.suspensionTravelMetersFrontRight = suspensionTravelMetersFrontRight;
    }

    /**
     * @return the suspensionTravelMetersRearLeft
     */
    public float getSuspensionTravelMetersRearLeft() {
        return suspensionTravelMetersRearLeft;
    }

    /**
     * @param suspensionTravelMetersRearLeft the suspensionTravelMetersRearLeft
     * to set
     */
    public void setSuspensionTravelMetersRearLeft(float suspensionTravelMetersRearLeft) {
        this.suspensionTravelMetersRearLeft = suspensionTravelMetersRearLeft;
    }

    /**
     * @return the suspensionTravelMetersRearRight
     */
    public float getSuspensionTravelMetersRearRight() {
        return suspensionTravelMetersRearRight;
    }

    /**
     * @param suspensionTravelMetersRearRight the
     * suspensionTravelMetersRearRight to set
     */
    public void setSuspensionTravelMetersRearRight(float suspensionTravelMetersRearRight) {
        this.suspensionTravelMetersRearRight = suspensionTravelMetersRearRight;
    }
    // }} Getters and Setters
}
