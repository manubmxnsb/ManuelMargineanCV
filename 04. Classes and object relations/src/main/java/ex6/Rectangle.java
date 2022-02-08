package ex6;

class Rectangle extends Shape {
    private double width;
    private double length;
    public Rectangle() {
        this.width = 1.0;
        this.length = 1.0;
    }
    public Rectangle(double width, double length) {
        this.length = length;
        this.width = width;
    }
    public  Rectangle(double width, double length, String color, boolean filled) {
        super(color,filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setLength(double length) {
        this.length = length;
    }
    public double getArea() {
        return this.length * this.width;
    }
    public double getPerimeter() {
        return 2 * (this.width + this.length);
    }
    @Override
    public String toString() {
        super.toString();
        return("A rectangle with width of " + this.width + " and length of " + this.length +  " which is a subclass of " + super.toString());
    }
}
