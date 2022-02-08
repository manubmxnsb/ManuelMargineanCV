package ex6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSquare {
    @Test
    void testSquareNoArgs() {
        Square square = new Square();
        assertEquals(1.0,square.getLength());
        assertEquals(1.0,square.getWidth());
    }
    @Test
    void testSquare1Args() {
        Square square = new Square(2.0);
        assertEquals(2.0,square.getLength());
        assertEquals(2.0,square.getWidth());
        assertEquals(2.0,square.getSide());
    }
    @Test
    void testSquare3Args() {
        Square square = new Square(2.0,"red",true);
        assertEquals(2.0,square.getLength());
        assertEquals(2.0,square.getWidth());
        assertEquals(2.0,square.getSide());
        assertEquals("red",square.getColor());
        assertEquals(true,square.isFilled());
        square.setColor("yellow");
        assertEquals("yellow", square.getColor());
        square.setSide(3.0);
        assertEquals(3.0,square.getLength());
        assertEquals(3.0,square.getWidth());
        assertEquals(3.0,square.getSide());
        assertEquals("A Square with side of 3.0 which is a subclass of A rectangle with width of 3.0 and length of 3.0 which is a subclass of A Shape with color of yellow and filled",square.toString());

    }
}
