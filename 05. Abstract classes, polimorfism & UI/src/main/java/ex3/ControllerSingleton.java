package ex3;

import java.sql.SQLOutput;

public class ControllerSingleton {
    private TemperatureSensor temperatureSensor;
    private LightSensor lightSensor;
    private static ControllerSingleton controllerSingleton = null;

    public static ControllerSingleton getInstance() {
        if (controllerSingleton == null) {
            controllerSingleton = new ControllerSingleton();
        }
        return controllerSingleton;
    }

    private ControllerSingleton() {
        this.lightSensor = new LightSensor();
        this.temperatureSensor = new TemperatureSensor();
    }

    public void control() throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            System.out.println("Temperature is " + this.temperatureSensor.readValue() + " and light is " + this.lightSensor.readValue());
            Thread.sleep(1000);
        }
    }
}
