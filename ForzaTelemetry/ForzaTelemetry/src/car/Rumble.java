package car;

public class Rumble {
	// {{ Variables
    private float surfaceRumbleFrontLeft = 0.0F; // Non-dimensional surface rumble values passed to controller force feedback
    private float surfaceRumbleFrontRight = 0.0F;
    private float surfaceRumbleRearLeft = 0.0F;
    private float surfaceRumbleRearRight = 0.0F;
    // }} Variables

    // {{ Getters and Setters
    /**
     * @return the surfaceRumbleFrontLeft
     */
    public float getSurfaceRumbleFrontLeft() {
        return surfaceRumbleFrontLeft;
    }

    /**
     * @param surfaceRumbleFrontLeft the surfaceRumbleFrontLeft to set
     */
    public void setSurfaceRumbleFrontLeft(float surfaceRumbleFrontLeft) {
        this.surfaceRumbleFrontLeft = surfaceRumbleFrontLeft;
    }

    /**
     * @return the surfaceRumbleFrontRight
     */
    public float getSurfaceRumbleFrontRight() {
        return surfaceRumbleFrontRight;
    }

    /**
     * @param surfaceRumbleFrontRight the surfaceRumbleFrontRight to set
     */
    public void setSurfaceRumbleFrontRight(float surfaceRumbleFrontRight) {
        this.surfaceRumbleFrontRight = surfaceRumbleFrontRight;
    }

    /**
     * @return the surfaceRumbleRearLeft
     */
    public float getSurfaceRumbleRearLeft() {
        return surfaceRumbleRearLeft;
    }

    /**
     * @param surfaceRumbleRearLeft the surfaceRumbleRearLeft to set
     */
    public void setSurfaceRumbleRearLeft(float surfaceRumbleRearLeft) {
        this.surfaceRumbleRearLeft = surfaceRumbleRearLeft;
    }

    /**
     * @return the surfaceRumbleRearRight
     */
    public float getSurfaceRumbleRearRight() {
        return surfaceRumbleRearRight;
    }

    /**
     * @param surfaceRumbleRearRight the surfaceRumbleRearRight to set
     */
    public void setSurfaceRumbleRearRight(float surfaceRumbleRearRight) {
        this.surfaceRumbleRearRight = surfaceRumbleRearRight;
    }
    // }} Getters and Setters
}
