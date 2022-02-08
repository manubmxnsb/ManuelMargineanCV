package Ex4;

public class MyPoint {
    private int x;
    private int y;

    public MyPoint() {
        x = 0;
        y = 0;
    }

    public MyPoint(int x1, int y1) {
        x = x1;
        y = y1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return " (" + x + "," + y + ") ";
    }

    public double distance(int x2, int y2) {
        return Math.sqrt(Math.pow((y2 - y), 2) + Math.pow((x2 - x), 2));
    }

    public double distanceToAnother(MyPoint another) {
        return Math.sqrt(Math.pow((another.y - y), 2) + Math.pow((another.x - x), 2));
    }
}
