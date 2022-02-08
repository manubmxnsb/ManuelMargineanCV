package ex4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Robot> robotList = new ArrayList<>(10);
        initializareRobots(robotList);
        SetterThread setterThread = new SetterThread(robotList);
        VerifyThread verifyThread = new VerifyThread(robotList);

        setterThread.start();
        verifyThread.start();
    }

    private static void initializareRobots(List<Robot> robotList) {
        for(int i = 0; i < 10; i++) {
            robotList.add(new Robot(i,i*2));
        }
    }
}
