package ex6;

public class SetterThread2 extends Thread {
    private final long currentTime = System.currentTimeMillis();
    private final Chronometer chronometer;

    public SetterThread2(Chronometer chronometer) { this.chronometer = chronometer;};

    @Override
    public void run() {
        while(chronometer.runTimer) {
            synchronized (chronometer) {
                chronometer.setMinutes(System.currentTimeMillis() / 1000 / 60);
                chronometer.setSeconds(System.currentTimeMillis() / 1000);
            }
        }
    }

    @Override
    public String toString() {
        return chronometer.getMinutes() + ":" + chronometer.getSeconds() + "";
    }
}
