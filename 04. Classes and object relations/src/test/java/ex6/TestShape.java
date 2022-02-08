package ex6;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestShape {
    @Test
    void testShapeNoArgs() {
        Shape shape = new Shape();
        assertEquals("red",shape.getColor());
        assertEquals(true,shape.isFilled());
    }
    @Test
    void testShape2Args() {
        Shape shape = new Shape("blue",false);
        assertEquals("blue",shape.getColor());
        assertEquals(false,shape.isFilled());
        shape.setColor("yellow");
        shape.setFilled(true);
        assertEquals("yellow",shape.getColor());
        assertEquals(true,shape.isFilled());
        assertEquals("A Shape with color of yellow and filled",shape.toString());
    }
}
