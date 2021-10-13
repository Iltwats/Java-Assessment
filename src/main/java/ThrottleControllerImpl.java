/**
 * Implementation of throttleController
 *
 * @author Atul Sharma
 * @see ThrottleController,Quantizer  for Interface definition
 * @since 13-10-21
 */
public class ThrottleControllerImpl implements ThrottleController {

    Integer cruiseSpeed;
    /**
     * Calculate quantized value of throttle
     */
    Quantizer<Integer> quantizer = quantity -> {
        double result = 0;
        if (quantity > 70) result = 7;
        else if (quantity < 0) result = 0;
        else {
            if (quantity % 10 >= 8) {
                result = Math.ceil(quantity / 10f);
            } else if (quantity % 10 <= 2) {
                result = Math.floor(quantity / 10f);
            } else {
                result = Math.ceil(quantity / 10f);
            }
        }
        return (int) result;
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

}
