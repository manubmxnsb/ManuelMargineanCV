package ex5;

import ex1.Circle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCylinder {
    @Test
    void testCylinderNoArgs() {
        Cylinder cylinder = new Cylinder();
        assertEquals(1.0,cylinder.getRadius());
    }
    @Test
    void testCylinder1Arg() {
        Cylinder cylinder = new Cylinder(5.0);
        assertEquals(5.0,cylinder.getRadius());
    }
    @Test
    void testCylinder2Arg() {
        Cylinder cylinder = new Cylinder(5.0,5.0);
        assertEquals(5.0,cylinder.getRadius());
        assertEquals(5.0,cylinder.getHeight());
        assertEquals(314.1592653589793,cylinder.getArea());
        assertEquals(392.69908169872417,cylinder.getVolume());
    }
}
