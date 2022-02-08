package Ex1_Robot;

public class TestRobot {
    public static void main(String[] args) {
        Robot r1 = new Robot();
        System.out.println("My robot has the position of " + r1.toString());
        r1.change(9);
        System.out.println("My robot moved to " +r1.toString());
    }
}
