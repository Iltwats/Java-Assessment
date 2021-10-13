/**
 * Driver Code for Testing the Throttle Implementation
 */
public class Main {
    public static void main(String[] args) {
        ThrottleController throttleController = new ThrottleControllerImpl();
        throttleController.setCruiseSpeed(34);
        Integer getCurrentSpeed = 12;
        final Integer throttleControlValue = throttleController.calculateThrottle(getCurrentSpeed);
        System.out.println(throttleControlValue);
        // setThrottleValue(throttleControlValue);
    }
}
