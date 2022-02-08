package ex4;

import ex4.events.Event;
import ex4.events.FireEvent;
import ex4.events.NoEvent;
import ex4.events.TemperatureEvent;

import java.util.Random;

public abstract class Home {
    private final int SIMULATION_STEPS = 20;
    protected static final Random rand = new Random();

    protected abstract void setValueInEnvironment(Event event);

    protected abstract void controlStep();

    private Event getHomeEvent() {
        //randomly generate a new event;
        int k = rand.nextInt(100);
        if (k < 30)
            return new NoEvent();
        else if (k < 60)
            return new FireEvent(rand.nextBoolean());
        else
            return new TemperatureEvent(rand.nextInt(50));
    }

    public void simulate() {
        int k = 0;
        while (k < SIMULATION_STEPS) {
            Event event = this.getHomeEvent();
            setValueInEnvironment(event);
            controlStep();

            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            k++;
        }
    }

}