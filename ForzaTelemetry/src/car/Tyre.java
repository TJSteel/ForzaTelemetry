package car;

public class Tyre {
	// {{ Variables
    private float tyreSlipRatioFrontLeft = 0.0F; // Tyre normalized slip ratio, = 0 means 100% grip and |ratio| > 1.0 means loss of grip.
    private float tyreSlipRatioFrontRight = 0.0F;
    private float tyreSlipRatioRearLeft = 0.0F;
    private float tyreSlipRatioRearRight = 0.0F;
    private float tyreSlipAngleFrontLeft = 0.0F; // Tyre normalized slip angle, = 0 means 100% grip and |angle| > 1.0 means loss of grip.
    private float tyreSlipAngleFrontRight = 0.0F;
    private float tyreSlipAngleRearLeft = 0.0F;
    private float tyreSlipAngleRearRight = 0.0F;
    private float tyreCombinedSlipFrontLeft = 0.0F; // Tyre normalized combined slip, = 0 means 100% grip and |slip| > 1.0 means loss of grip.
    private float tyreCombinedSlipFrontRight = 0.0F;
    private float tyreCombinedSlipRearLeft = 0.0F;
    private float tyreCombinedSlipRearRight = 0.0F;
    private float tyreTempFrontLeft = 0.0F; // Tyre normalized combined slip, = 0 means 100% grip and |slip| > 1.0 means loss of grip.
    private float tyreTempFrontRight = 0.0F;
    private float tyreTempRearLeft = 0.0F;
    private float tyreTempRearRight = 0.0F;
    // }} Variables

    // {{ Getters and Setters
    /**
     * @return the tyreSlipRatioFrontLeft
     */
    public float getTyreSlipRatioFrontLeft() {
        return tyreSlipRatioFrontLeft;
    }

    /**
     * @param tyreSlipRatioFrontLeft the tyreSlipRatioFrontLeft to set
     */
    public void setTyreSlipRatioFrontLeft(float tyreSlipRatioFrontLeft) {
        this.tyreSlipRatioFrontLeft = tyreSlipRatioFrontLeft;
    }

    /**
     * @return the tyreSlipRatioFrontRight
     */
    public float getTyreSlipRatioFrontRight() {
        return tyreSlipRatioFrontRight;
    }

    /**
     * @param tyreSlipRatioFrontRight the tyreSlipRatioFrontRight to set
     */
    public void setTyreSlipRatioFrontRight(float tyreSlipRatioFrontRight) {
        this.tyreSlipRatioFrontRight = tyreSlipRatioFrontRight;
    }

    /**
     * @return the tyreSlipRatioRearLeft
     */
    public float getTyreSlipRatioRearLeft() {
        return tyreSlipRatioRearLeft;
    }

    /**
     * @param tyreSlipRatioRearLeft the tyreSlipRatioRearLeft to set
     */
    public void setTyreSlipRatioRearLeft(float tyreSlipRatioRearLeft) {
        this.tyreSlipRatioRearLeft = tyreSlipRatioRearLeft;
    }

    /**
     * @return the tyreSlipRatioRearRight
     */
    public float getTyreSlipRatioRearRight() {
        return tyreSlipRatioRearRight;
    }

    /**
     * @param tyreSlipRatioRearRight the tyreSlipRatioRearRight to set
     */
    public void setTyreSlipRatioRearRight(float tyreSlipRatioRearRight) {
        this.tyreSlipRatioRearRight = tyreSlipRatioRearRight;
    }


    /**
     * @return the tyreSlipAngleFrontLeft
     */
    public float getTyreSlipAngleFrontLeft() {
        return tyreSlipAngleFrontLeft;
    }

    /**
     * @param tyreSlipAngleFrontLeft the tyreSlipAngleFrontLeft to set
     */
    public void setTyreSlipAngleFrontLeft(float tyreSlipAngleFrontLeft) {
        this.tyreSlipAngleFrontLeft = tyreSlipAngleFrontLeft;
    }

    /**
     * @return the tyreSlipAngleFrontRight
     */
    public float getTyreSlipAngleFrontRight() {
        return tyreSlipAngleFrontRight;
    }

    /**
     * @param tyreSlipAngleFrontRight the tyreSlipAngleFrontRight to set
     */
    public void setTyreSlipAngleFrontRight(float tyreSlipAngleFrontRight) {
        this.tyreSlipAngleFrontRight = tyreSlipAngleFrontRight;
    }

    /**
     * @return the tyreSlipAngleRearLeft
     */
    public float getTyreSlipAngleRearLeft() {
        return tyreSlipAngleRearLeft;
    }

    /**
     * @param tyreSlipAngleRearLeft the tyreSlipAngleRearLeft to set
     */
    public void setTyreSlipAngleRearLeft(float tyreSlipAngleRearLeft) {
        this.tyreSlipAngleRearLeft = tyreSlipAngleRearLeft;
    }

    /**
     * @return the tyreSlipAngleRearRight
     */
    public float getTyreSlipAngleRearRight() {
        return tyreSlipAngleRearRight;
    }

    /**
     * @param tyreSlipAngleRearRight the tyreSlipAngleRearRight to set
     */
    public void setTyreSlipAngleRearRight(float tyreSlipAngleRearRight) {
        this.tyreSlipAngleRearRight = tyreSlipAngleRearRight;
    }

    /**
     * @return the tyreCombinedSlipFrontLeft
     */
    public float getTyreCombinedSlipFrontLeft() {
        return tyreCombinedSlipFrontLeft;
    }

    /**
     * @param tyreCombinedSlipFrontLeft the tyreCombinedSlipFrontLeft to set
     */
    public void setTyreCombinedSlipFrontLeft(float tyreCombinedSlipFrontLeft) {
        this.tyreCombinedSlipFrontLeft = tyreCombinedSlipFrontLeft;
    }

    /**
     * @return the tyreCombinedSlipFrontRight
     */
    public float getTyreCombinedSlipFrontRight() {
        return tyreCombinedSlipFrontRight;
    }

    /**
     * @param tyreCombinedSlipFrontRight the tyreCombinedSlipFrontRight to set
     */
    public void setTyreCombinedSlipFrontRight(float tyreCombinedSlipFrontRight) {
        this.tyreCombinedSlipFrontRight = tyreCombinedSlipFrontRight;
    }

    /**
     * @return the tyreCombinedSlipRearLeft
     */
    public float getTyreCombinedSlipRearLeft() {
        return tyreCombinedSlipRearLeft;
    }

    /**
     * @param tyreCombinedSlipRearLeft the tyreCombinedSlipRearLeft to set
     */
    public void setTyreCombinedSlipRearLeft(float tyreCombinedSlipRearLeft) {
        this.tyreCombinedSlipRearLeft = tyreCombinedSlipRearLeft;
    }

    /**
     * @return the tyreCombinedSlipRearRight
     */
    public float getTyreCombinedSlipRearRight() {
        return tyreCombinedSlipRearRight;
    }

    /**
     * @param tyreCombinedSlipRearRight the tyreCombinedSlipRearRight to set
     */
    public void setTyreCombinedSlipRearRight(float tyreCombinedSlipRearRight) {
        this.tyreCombinedSlipRearRight = tyreCombinedSlipRearRight;
    }
    
	/**
	 * @return the tyreTempFrontLeft
	 */
	public float getTyreTempFrontLeft() {
		return tyreTempFrontLeft;
	}

	/**
	 * @param tyreTempFrontLeft the tyreTempFrontLeft to set
	 */
	public void setTyreTempFrontLeft(float tyreTempFrontLeft) {
		this.tyreTempFrontLeft = tyreTempFrontLeft;
	}

	/**
	 * @return the tyreTempFrontRight
	 */
	public float getTyreTempFrontRight() {
		return tyreTempFrontRight;
	}

	/**
	 * @param tyreTempFrontRight the tyreTempFrontRight to set
	 */
	public void setTyreTempFrontRight(float tyreTempFrontRight) {
		this.tyreTempFrontRight = tyreTempFrontRight;
	}

	/**
	 * @return the tyreTempRearLeft
	 */
	public float getTyreTempRearLeft() {
		return tyreTempRearLeft;
	}

	/**
	 * @param tyreTempRearLeft the tyreTempRearLeft to set
	 */
	public void setTyreTempRearLeft(float tyreTempRearLeft) {
		this.tyreTempRearLeft = tyreTempRearLeft;
	}

	/**
	 * @return the tyreTempRearRight
	 */
	public float getTyreTempRearRight() {
		return tyreTempRearRight;
	}

	/**
	 * @param tyreTempRearRight the tyreTempRearRight to set
	 */
	public void setTyreTempRearRight(float tyreTempRearRight) {
		this.tyreTempRearRight = tyreTempRearRight;
	}
    // }} Getters and Setters
}
