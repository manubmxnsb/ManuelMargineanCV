package Ex1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRobot {
    @Test
    void testRobotNoArgs() {
        Robot robot = new Robot();
        assertEquals(1,robot.getX());
    }
    @Test
    void testChange() {
        Robot robot = new Robot();
        assertEquals(2,robot.change(2));
    }
    @Test
    void testToString() {
        Robot robot = new Robot();
        assertEquals("1",robot.toString());
    }
}
