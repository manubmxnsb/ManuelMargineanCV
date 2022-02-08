package Ex4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMyPoint {

    @Test
    void testConstructorNoArgs() {
    MyPoint myPoint = new MyPoint();
    assertEquals(0,myPoint.getX());
    assertEquals(0,myPoint.getY());
    }
    @Test
    void testConstructorWithArgs() {
    MyPoint myPoint = new MyPoint(2,2);
    assertEquals(2,myPoint.getX());
    assertEquals(2,myPoint.getY());
    }
    @Test
    void testDistance() {
    MyPoint myPoint = new MyPoint(1,1);
    assertEquals(1.4142135623730951,myPoint.distance(0,0));
    }
    @Test
    void testDistanceToAnother() {
    MyPoint myPoint = new MyPoint(0,0);
    MyPoint myPoint1 = new MyPoint(1,1);
    assertEquals(1.4142135623730951,myPoint.distanceToAnother(myPoint1));
    }
}
