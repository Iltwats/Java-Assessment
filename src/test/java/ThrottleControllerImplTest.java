import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        final Integer throttleControlValue = throttleController.calculateThrottle(getCurrentSpeed);
        Assertions.assertEquals(throttleControlValue, 0);
    }

    @DisplayName("Test for Corner Cases(more than 70)")
    @Test
    public void cornerCasesForMoreThanSeventy() {
        Integer getCurrentSpeed = 74;
        final Integer throttleControlValue = throttleController.calculateThrottle(getCurrentSpeed);
        Assertions.assertEquals(throttleControlValue, 7);
    }

    @DisplayName("Test for Hysteresis")
    @Test
    public void hysteresisOne() {
        Integer getCurrentSpeed = 9;
        final Integer throttleControlValue = throttleController.calculateThrottle(getCurrentSpeed);
        Assertions.assertEquals(throttleControlValue, 1);
    }

    @DisplayName("Test for Hysteresis")
    @Test
    public void hysteresisTwo() {
        Integer getCurrentSpeed = 12;
        final Integer throttleControlValue = throttleController.calculateThrottle(getCurrentSpeed);
        Assertions.assertEquals(throttleControlValue, 1);
    }


    @DisplayName("Test for Random speed")
    @Test
    public void randomSpeed() {
        Integer getCurrentSpeed = 45;
        final Integer throttleControlValue = throttleController.calculateThrottle(getCurrentSpeed);
        Assertions.assertEquals(throttleControlValue, 5);
    }

    @DisplayName("Test for Random speed 1")
    @Test
    public void randomSpeedAgain() {
        Integer getCurrentSpeed = 33;
        final Integer throttleControlValue = throttleController.calculateThrottle(getCurrentSpeed);
        Assertions.assertEquals(throttleControlValue, 4);
    }


}