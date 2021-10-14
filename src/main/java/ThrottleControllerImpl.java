/**
 * Implementation of throttleController
 * <p>
 * Quantize implementation {@link #quantizer} calculates throttle
 *
 * @author Atul Sharma
 * @since 13-10-21
 */
public class ThrottleControllerImpl implements ThrottleController {

    Integer cruiseSpeed;
    Integer throttleValue = 0;
    /**
     * Calculate quantized value of throttle
     * <p>
     * Also we are considering that speed won't
     * change by more than 5 units in consecutive iteration.
     * For more than that it can been handled.
     *
     * <p>
     * We consider previous throttle value before changing it
     * only when our input is between the hysteresis curve,
     * i.e (currentSpeed +-2)
     *
     * <p>
     * In rest of the case it works normally.
     */
    Quantizer<Integer> quantizer = quantity -> {
        Integer currentDiff = Math.abs(quantity - cruiseSpeed);
        Integer posRange, negRange;
        double throttle;
        if (currentDiff <= 5) {
            posRange = 2;
            negRange = 8;
        } else {
            // which could be decided in future
            posRange = 3;
            negRange = 7;
        }

        if (quantity > 70) throttle = 7;
        else if (quantity <= 0) throttle = 0;
        else {
            if (quantity % 10 >= negRange) {
                double tempThrottleValue = Math.ceil(quantity / 10f);
                throttle = Math.max(tempThrottleValue, throttleValue);
            } else if (quantity % 10 <= posRange) {
                double tempThrottleValue = Math.floor(quantity / 10f);
                throttle = Math.max(tempThrottleValue, throttleValue);
            } else {
                throttle = Math.ceil(quantity / 10f);
            }
        }
        return (int) throttle;
    };


    /**
     * Takes current speed of vehicle and returns the throttle value
     *
     * @param currentSpeed of vehicle
     * @return Integer value
     */
    @Override
    public Integer calculateThrottle(Integer currentSpeed) {
        return quantizer.quantize(currentSpeed);
    }

    /**
     * A setter to set the cruise speed of vehicle
     *
     * @param cruiseSpeed of vehicle
     */
    @Override
    public void setCruiseSpeed(Integer cruiseSpeed) {
        this.cruiseSpeed = cruiseSpeed;
    }

    /**
     * A setter to set current throttle value
     *
     * @param throttleControlValue with current speed
     */
    @Override
    public void setThrottleValue(Integer throttleControlValue) {
        this.throttleValue = throttleControlValue;
    }

}
