import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit Test for {@link ThrottleControllerImpl} class
 * @author Atul Sharma
 * @since 13-10-21
 */
class ThrottleControllerImplTest {
    ThrottleController throttleController;

    @BeforeEach
    @DisplayName("Initialize Throttle Implementation")
    public void initializeClass() {
        throttleController = new ThrottleControllerImpl();
    }


    @DisplayName("Test for Corner Cases(-ve)")
    @Test
    public void cornerCasesForNegative() {
        Integer getCurrentSpeed = -34;
        throttleController.setCruiseSpeed(getCurrentSpeed);
        final Integer throttleControlValue = throttleController.calculateThrottle(getCurrentSpeed);
        Assertions.assertEquals(throttleControlValue, 0);
    }

    @DisplayName("Test for Corner Cases(more than 70)")
    @Test
    public void cornerCasesForMoreThanSeventy() {
        Integer getCurrentSpeed = 74;
        throttleController.setCruiseSpeed(getCurrentSpeed);
        final Integer throttleControlValue = throttleController.calculateThrottle(getCurrentSpeed);
        Assertions.assertEquals(throttleControlValue, 7);
    }

    @DisplayName("Test for Hysteresis")
    @Test
    public void hysteresisOne() {
        Integer getCurrentSpeed = 9;
        throttleController.setCruiseSpeed(getCurrentSpeed);
        final Integer throttleControlValue = throttleController.calculateThrottle(getCurrentSpeed);
        throttleController.setThrottleValue(throttleControlValue);
        Assertions.assertEquals(throttleControlValue, 1);
    }

    @DisplayName("Test for Hysteresis")
    @Test
    public void hysteresisTwo() {
        Integer getCurrentSpeed = 12;
        throttleController.setCruiseSpeed(getCurrentSpeed);
        final Integer throttleControlValue = throttleController.calculateThrottle(getCurrentSpeed);
        throttleController.setThrottleValue(throttleControlValue);
        Assertions.assertEquals(throttleControlValue, 1);
    }

    @DisplayName("Test for Hysteresis based on previous throttle value")
    @Test
    public void hysteresisThree() {
        Integer getCurrentSpeed = 12;
        throttleController.setCruiseSpeed(getCurrentSpeed);
        final Integer throttleControlValue = throttleController.calculateThrottle(getCurrentSpeed);
        throttleController.setThrottleValue(throttleControlValue);
        Integer getCurrentSpeed1 = 14;
        final Integer throttleControlValue1 = throttleController.calculateThrottle(getCurrentSpeed1);
        Assertions.assertEquals(throttleControlValue1, 2);
    }

    @DisplayName("Test for Hysteresis based on previous throttle value")
    @Test
    public void hysteresisFour() {
        Integer getCurrentSpeed = 13;
        throttleController.setCruiseSpeed(getCurrentSpeed);
        final Integer throttleControlValue = throttleController.calculateThrottle(getCurrentSpeed);
        throttleController.setThrottleValue(throttleControlValue);
        Integer getCurrentSpeed1 = 8;
        final Integer throttleControlValue1 = throttleController.calculateThrottle(getCurrentSpeed1);
        Assertions.assertEquals(throttleControlValue1, 2);
    }

    @DisplayName("Test for Hysteresis based on previous throttle value")
    @Test
    public void hysteresisFive() {
        Integer getCurrentSpeed = 13;
        throttleController.setCruiseSpeed(getCurrentSpeed);
        final Integer throttleControlValue = throttleController.calculateThrottle(getCurrentSpeed);
        throttleController.setThrottleValue(throttleControlValue);
        Integer getCurrentSpeed1 = 9;
        final Integer throttleControlValue1 = throttleController.calculateThrottle(getCurrentSpeed1);
        Assertions.assertEquals(throttleControlValue1, 2);
    }

    @DisplayName("Test for Hysteresis based on previous throttle value")
    @Test
    public void hysteresisSix() {
        Integer getCurrentSpeed = 7;
        throttleController.setCruiseSpeed(getCurrentSpeed);
        final Integer throttleControlValue = throttleController.calculateThrottle(getCurrentSpeed);
        throttleController.setThrottleValue(throttleControlValue);
        Integer getCurrentSpeed1 = 12;
        final Integer throttleControlValue1 = throttleController.calculateThrottle(getCurrentSpeed1);
        throttleController.setCruiseSpeed(getCurrentSpeed1);
        Assertions.assertEquals(throttleControlValue1, 1);
    }

    @DisplayName("Test for Random speed")
    @Test
    public void randomSpeed() {
        Integer getCurrentSpeed = 45;
        throttleController.setCruiseSpeed(getCurrentSpeed);
        final Integer throttleControlValue = throttleController.calculateThrottle(getCurrentSpeed);
        Assertions.assertEquals(throttleControlValue, 5);
    }

    @DisplayName("Test for Random speed 1")
    @Test
    public void randomSpeedAgain() {
        Integer getCurrentSpeed = 33;
        throttleController.setCruiseSpeed(getCurrentSpeed);
        final Integer throttleControlValue = throttleController.calculateThrottle(getCurrentSpeed);
        Assertions.assertEquals(throttleControlValue, 4);
    }


}