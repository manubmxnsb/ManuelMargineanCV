package ex4.units;

import org.apache.log4j.Logger;

public class AlarmUnit implements Unit {
    private static final Logger LOGGER = Logger.getLogger(AlarmUnit.class);
    @Override
    public void execute() {
        LOGGER.info("Alarm activated!");
    }
}
