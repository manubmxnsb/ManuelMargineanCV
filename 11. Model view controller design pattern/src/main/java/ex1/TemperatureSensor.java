package exercises.ex1;

import java.util.Random;

public class TemperatureSensor extends Observable implements Runnable{
    private Random random = new Random();
    private double temperature;

    public TemperatureSensor(){

    }

    @Override
    public void run() {
        while (true){
            temperature = random.nextInt(100) + 0.2;
            this.changeState(temperature);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }
}
