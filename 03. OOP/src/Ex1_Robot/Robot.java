package Ex1_Robot;

public class Robot {
    private int x = 1;

    public Robot() {
        this.x = 1;
    }

    public void change(int k) {
        if (k >= 1) {
            this.x = this.x + k;
        }
    }

    public String toString() {
        return String.valueOf(x);
    }
}
