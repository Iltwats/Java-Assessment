/**
 * Driver Code for Testing the Throttle Implementation
 *
 * @author Atul Sharma
 * @since 13-10-21
 */
public class Main {
    public static void main(String[] args) {
        ThrottleController throttleController = new ThrottleControllerImpl();
        Integer getCurrentSpeed = 14;
        throttleController.setCruiseSpeed(getCurrentSpeed);
        final Integer throttleControlValue = throttleController.calculateThrottle(getCurrentSpeed);
        System.out.println(throttleControlValue);

        // set the current throttle value
        throttleController.setThrottleValue(throttleControlValue);
        Integer getCurrentSpeed1 = 7;

        // after speed changes again calculate throttle value
        final Integer throttleControlValue1 = throttleController.calculateThrottle(getCurrentSpeed1);

        // sets new cruise speed of vehicle after throttle value changes
        throttleController.setCruiseSpeed(getCurrentSpeed1);
        System.out.println(throttleControlValue1);
    }
}
