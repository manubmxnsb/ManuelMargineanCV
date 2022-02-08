package ex3;

import java.sql.SQLOutput;

public class Controller {
    private TemperatureSensor temperatureSensor;
    private LightSensor lightSensor;

    public Controller() {
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
