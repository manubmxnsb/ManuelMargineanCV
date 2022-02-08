package ex4;

import java.util.ArrayList;
import java.util.List;

public class VerifyThread extends Thread {
    private final List<Robot> robots;

    public VerifyThread(List<Robot> robots) {
        this.robots = robots;
    }

    @Override
    public void run() {
        while (!robots.isEmpty()) {
            synchronized (robots) {
                List<ex4.Robot> robotsToBeRemoved = new ArrayList<>();
                for (int i = 0; i < robots.size(); i++) {
                    for (int j = i + 1; j < robots.size(); j++) {
                        if (robots.get(j).equals(robots.get(i))) {
                            robotsToBeRemoved.add(robots.get(j));
                        }
                    }
                }
                System.out.println("Robots to be removed: " + robotsToBeRemoved);
                robots.removeAll(robotsToBeRemoved);
            }
            try {
                Thread.sleep(90);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
}
