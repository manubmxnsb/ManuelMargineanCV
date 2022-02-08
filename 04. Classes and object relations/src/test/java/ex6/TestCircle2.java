package ex6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCircle2 {
    @Test
    void testCircleNoArgs() {
        Circle2 circle = new Circle2();
        assertEquals(1.0,circle.getRadius());
        assertEquals(3.141592653589793,circle.getArea());
    }
    @Test
    void testCircleWithArgs() {
        Circle2 circle = new Circle2(2);
        assertEquals(2.0,circle.getRadius());
        assertEquals(12.566370614359172,circle.getArea());
        assertEquals("A Circle with radius of 2.0 which is a subclass of A Shape with color of red and filled",circle.toString());
    }
}
