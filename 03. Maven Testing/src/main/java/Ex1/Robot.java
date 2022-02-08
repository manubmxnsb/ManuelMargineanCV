package Ex1;

public class Robot {
    private int x = 1;

    public Robot() {
        this.x = 1;
    }

    public int change(int k) {
        if (k >= 1) {
            this.x = this.x + k;
        }
        return x;
    }

    public int getX() {
        return x;
    }

    public String toString() {
        return String.valueOf(x);
    }
}
