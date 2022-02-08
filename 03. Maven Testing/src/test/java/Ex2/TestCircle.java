package Ex2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCircle {
    @Test
    void testCircleNoArgs() {
        Circle circle = new Circle();
        assertEquals(1.0,circle.getRadius());
        assertEquals("red",circle.getColor());
        assertEquals(3.141592653589793,circle.getArea());
    }
    @Test
    void testCircleWithArgs() {
        Circle circle = new Circle(2);
        assertEquals(2.0,circle.getRadius());
        assertEquals("red",circle.getColor());
    }
}
