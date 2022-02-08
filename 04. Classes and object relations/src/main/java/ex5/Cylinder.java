package ex5;

import ex1.Circle;

class Cylinder extends Circle {
    private double height;

    public Cylinder() {
    }

    public Cylinder(double radius) {
        super(radius);

    }

    public Cylinder(double radius, double height) {
        super(radius); this.height = height;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return 2* super.getArea() + 2 *Math.PI * this.getRadius() * height;
    }

    public double getVolume() {
        return super.getArea() * this.height;
    }
}
