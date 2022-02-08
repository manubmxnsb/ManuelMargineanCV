package ex3;

public class LightSensor extends Sensor {
    @Override
    int readValue() {
        return (int) (Math.random() * 100);
    }
}
