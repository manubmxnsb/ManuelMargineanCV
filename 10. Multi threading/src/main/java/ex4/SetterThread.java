package ex4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class SetterThread extends Thread {
    private final List<Robot> robots;
    private static final Random RANDOM = new Random();

    public SetterThread(List<Robot> robots) {
        this.robots = robots;
    }

    @Override
    public void run() {
        while (!robots.isEmpty()) {
            synchronized (robots) {
                for (Robot robot : robots) {
                    int x = RANDOM.nextInt(10);
                    int y = RANDOM.nextInt(10);
                    robot.setX(x);
                    robot.setY(y);
                    System.out.println("Set new values: x= " + x + " y= " + y);
                }

                System.out.println("New values: " + robots);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
}

