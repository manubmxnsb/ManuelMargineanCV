package ex3;

public class TemperatureSensor extends Sensor {
    @Override
    int readValue() {
        return (int) (Math.random() * 100);
    }
}
