package exercises.ex1;

public class Main {
    public static void main(String[] args) {
        TemperatureSensor sensor = new TemperatureSensor();
        Interface in = new Interface();
        sensor.register(in);
        new Thread(sensor).start();
    }
}
