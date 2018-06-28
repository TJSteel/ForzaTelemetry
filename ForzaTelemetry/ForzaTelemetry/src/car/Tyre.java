package car;

public class Tyre {
	// {{ Variables
    private float tireSlipRatioFrontLeft = 0.0F; // Tire normalized slip ratio, = 0 means 100% grip and |ratio| > 1.0 means loss of grip.
    private float tireSlipRatioFrontRight = 0.0F;
    private float tireSlipRatioRearLeft = 0.0F;
    private float tireSlipRatioRearRight = 0.0F;
    private float tireSlipAngleFrontLeft = 0.0F; // Tire normalized slip angle, = 0 means 100% grip and |angle| > 1.0 means loss of grip.
    private float tireSlipAngleFrontRight = 0.0F;
    private float tireSlipAngleRearLeft = 0.0F;
    private float tireSlipAngleRearRight = 0.0F;
    private float tireCombinedSlipFrontLeft = 0.0F; // Tire normalized combined slip, = 0 means 100% grip and |slip| > 1.0 means loss of grip.
    private float tireCombinedSlipFrontRight = 0.0F;
    private float tireCombinedSlipRearLeft = 0.0F;
    private float tireCombinedSlipRearRight = 0.0F;
    // }} Variables

    // {{ Getters and Setters
    /**
     * @return the tireSlipRatioFrontLeft
     */
    public float getTireSlipRatioFrontLeft() {
        return tireSlipRatioFrontLeft;
    }

    /**
     * @param tireSlipRatioFrontLeft the tireSlipRatioFrontLeft to set
     */
    public void setTireSlipRatioFrontLeft(float tireSlipRatioFrontLeft) {
        this.tireSlipRatioFrontLeft = tireSlipRatioFrontLeft;
    }

    /**
     * @return the tireSlipRatioFrontRight
     */
    public float getTireSlipRatioFrontRight() {
        return tireSlipRatioFrontRight;
    }

    /**
     * @param tireSlipRatioFrontRight the tireSlipRatioFrontRight to set
     */
    public void setTireSlipRatioFrontRight(float tireSlipRatioFrontRight) {
        this.tireSlipRatioFrontRight = tireSlipRatioFrontRight;
    }

    /**
     * @return the tireSlipRatioRearLeft
     */
    public float getTireSlipRatioRearLeft() {
        return tireSlipRatioRearLeft;
    }

    /**
     * @param tireSlipRatioRearLeft the tireSlipRatioRearLeft to set
     */
    public void setTireSlipRatioRearLeft(float tireSlipRatioRearLeft) {
        this.tireSlipRatioRearLeft = tireSlipRatioRearLeft;
    }

    /**
     * @return the tireSlipRatioRearRight
     */
    public float getTireSlipRatioRearRight() {
        return tireSlipRatioRearRight;
    }

    /**
     * @param tireSlipRatioRearRight the tireSlipRatioRearRight to set
     */
    public void setTireSlipRatioRearRight(float tireSlipRatioRearRight) {
        this.tireSlipRatioRearRight = tireSlipRatioRearRight;
    }


    /**
     * @return the tireSlipAngleFrontLeft
     */
    public float getTireSlipAngleFrontLeft() {
        return tireSlipAngleFrontLeft;
    }

    /**
     * @param tireSlipAngleFrontLeft the tireSlipAngleFrontLeft to set
     */
    public void setTireSlipAngleFrontLeft(float tireSlipAngleFrontLeft) {
        this.tireSlipAngleFrontLeft = tireSlipAngleFrontLeft;
    }

    /**
     * @return the tireSlipAngleFrontRight
     */
    public float getTireSlipAngleFrontRight() {
        return tireSlipAngleFrontRight;
    }

    /**
     * @param tireSlipAngleFrontRight the tireSlipAngleFrontRight to set
     */
    public void setTireSlipAngleFrontRight(float tireSlipAngleFrontRight) {
        this.tireSlipAngleFrontRight = tireSlipAngleFrontRight;
    }

    /**
     * @return the tireSlipAngleRearLeft
     */
    public float getTireSlipAngleRearLeft() {
        return tireSlipAngleRearLeft;
    }

    /**
     * @param tireSlipAngleRearLeft the tireSlipAngleRearLeft to set
     */
    public void setTireSlipAngleRearLeft(float tireSlipAngleRearLeft) {
        this.tireSlipAngleRearLeft = tireSlipAngleRearLeft;
    }

    /**
     * @return the tireSlipAngleRearRight
     */
    public float getTireSlipAngleRearRight() {
        return tireSlipAngleRearRight;
    }

    /**
     * @param tireSlipAngleRearRight the tireSlipAngleRearRight to set
     */
    public void setTireSlipAngleRearRight(float tireSlipAngleRearRight) {
        this.tireSlipAngleRearRight = tireSlipAngleRearRight;
    }

    /**
     * @return the tireCombinedSlipFrontLeft
     */
    public float getTireCombinedSlipFrontLeft() {
        return tireCombinedSlipFrontLeft;
    }

    /**
     * @param tireCombinedSlipFrontLeft the tireCombinedSlipFrontLeft to set
     */
    public void setTireCombinedSlipFrontLeft(float tireCombinedSlipFrontLeft) {
        this.tireCombinedSlipFrontLeft = tireCombinedSlipFrontLeft;
    }

    /**
     * @return the tireCombinedSlipFrontRight
     */
    public float getTireCombinedSlipFrontRight() {
        return tireCombinedSlipFrontRight;
    }

    /**
     * @param tireCombinedSlipFrontRight the tireCombinedSlipFrontRight to set
     */
    public void setTireCombinedSlipFrontRight(float tireCombinedSlipFrontRight) {
        this.tireCombinedSlipFrontRight = tireCombinedSlipFrontRight;
    }

    /**
     * @return the tireCombinedSlipRearLeft
     */
    public float getTireCombinedSlipRearLeft() {
        return tireCombinedSlipRearLeft;
    }

    /**
     * @param tireCombinedSlipRearLeft the tireCombinedSlipRearLeft to set
     */
    public void setTireCombinedSlipRearLeft(float tireCombinedSlipRearLeft) {
        this.tireCombinedSlipRearLeft = tireCombinedSlipRearLeft;
    }

    /**
     * @return the tireCombinedSlipRearRight
     */
    public float getTireCombinedSlipRearRight() {
        return tireCombinedSlipRearRight;
    }

    /**
     * @param tireCombinedSlipRearRight the tireCombinedSlipRearRight to set
     */
    public void setTireCombinedSlipRearRight(float tireCombinedSlipRearRight) {
        this.tireCombinedSlipRearRight = tireCombinedSlipRearRight;
    }
    // }} Getters and Setters
}
