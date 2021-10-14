public interface ThrottleController {
    /**
     * Takes current speed of vehicle and returns the throttle value
     *
     * @param currentSpeed of vehicle
     * @return Integer value
     */
    Integer calculateThrottle(Integer currentSpeed);

    /**
     * A setter to set the cruise speed of vehicle
     *
     * @param cruiseSpeed of vehicle
     */
    void setCruiseSpeed(Integer cruiseSpeed);

    /**
     * A setter to set current throttle value
     *
     * @param throttleControlValue with current speed
     */
    void setThrottleValue(Integer throttleControlValue);
}
