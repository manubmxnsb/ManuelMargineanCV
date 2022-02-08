package ex4.units;

import ex4.Home;
import ex4.events.Event;
import ex4.events.FireEvent;
import ex4.events.TemperatureEvent;
import ex4.sensors.FireSensor;
import ex4.sensors.Sensor;
import ex4.sensors.TemperatureSensor;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Controller extends Home implements Unit {
    public static final Logger LOGGER = Logger.getLogger(Controller.class);
    private final Unit gsmUnit = new GsmUnit();
    private final Unit alarmUnit = new AlarmUnit();
    private final Unit heatingUnit = new HeatingUnit();
    private final Unit coolingUnit = new CoolingUnit();
    public static final int PRESET_TEMP_VALUE = 22;
    Sensor temperatureSensor = new TemperatureSensor();
    List<Sensor> fireSensors = new ArrayList<>();
    private static Controller instance;

    private Controller() {
        for (int i = 0; i < 5; i++) {
            fireSensors.add(new FireSensor());
        }
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    @Override
    protected void setValueInEnvironment(Event event) {
        switch (event.getType()) {
            case TEMPERATURE:
                this.temperatureSensor.setValue(((TemperatureEvent)event).getValue());
                break;
            case FIRE:
                this.fireSensors.get(rand.nextInt((fireSensors.size()))).setValue(((FireEvent)event).isSmoke() ? 1 : 0);
                break;
            case NONE:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + event.getType());
        }
    }

    @Override
    protected void controlStep() {
        LOGGER.info("Control step: ");
        fireSensors.stream()
                .filter(sensor -> sensor.getValue() == 1)
                .findAny()
                .ifPresent(sensor -> {
                    alarmUnit.execute();
                    gsmUnit.execute();
                });
        if (temperatureSensor.getValue() < PRESET_TEMP_VALUE) {
            heatingUnit.execute();
        } else {
            coolingUnit.execute();
        }
        LOGGER.info("");
        fireSensors.forEach(sensor -> sensor.setValue(0));
    }

    @Override
    public void execute() {
        super.simulate();
    }
}

