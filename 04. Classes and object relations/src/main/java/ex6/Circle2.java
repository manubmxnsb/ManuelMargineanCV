package ex6;

class Circle2 extends Shape{
    private double radius;
    private String color;

    public Circle2() {
        this.radius = 1.0;
        this.color = "red";
    }

    public Circle2(double r) {
        this.radius = r;
        this.color = "red";
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }
    @Override
    public String toString() {
        super.toString();
        return("A Circle with radius of " + this.radius + " which is a subclass of " + super.toString());
    }
}