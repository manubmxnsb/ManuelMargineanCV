package ex6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRectangle {
    @Test
    void testRectangleNoArgs() {
        Rectangle rectangle = new Rectangle();
        assertEquals(1.0,rectangle.getWidth());
        assertEquals(1.0,rectangle.getLength());
    }
    @Test
    void testRectangle2Args() {
        Rectangle rectangle = new Rectangle(2.0,2.0);
        assertEquals(2.0,rectangle.getWidth());
        assertEquals(2.0,rectangle.getLength());
    }
    @Test
    void testRectangle4Args() {
        Rectangle rectangle = new Rectangle(2.0,2.0,"red",true);
        assertEquals(2.0,rectangle.getWidth());
        assertEquals(2.0,rectangle.getLength());
        assertEquals(true,rectangle.isFilled());
        assertEquals("red",rectangle.getColor());
        rectangle.setLength(3.0);
        rectangle.setWidth(4.0);
        assertEquals(4.0,rectangle.getWidth());
        assertEquals(3.0,rectangle.getLength());
        assertEquals(14.0,rectangle.getPerimeter());
        assertEquals(12.0,rectangle.getArea());
        assertEquals("A rectangle with width of 4.0 and length of 3.0 which is a subclass of A Shape with color of red and filled",rectangle.toString());
    }
}
