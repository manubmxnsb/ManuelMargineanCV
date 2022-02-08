package Ex5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFlower {
    @Test
    void testFlower() {
        Flower flower = new Flower(3);
        assertEquals(3,flower.getPetal());
        Flower flower2 = new Flower(3);
        Flower flower3 = new Flower(3);
        assertEquals(3,Flower.getNoOfObjects());
    }
}
