package ex6;

public class VerifyThread2 extends Thread{
    private final long currentTime = System.currentTimeMillis();
    private final Chronometer chronometer;

    public VerifyThread2(Chronometer chronometer) { this.chronometer = chronometer;};

    @Override
    public void run() {
        while(chronometer.resetTimer) {
            synchronized (chronometer) {
                chronometer.setMinutes(System.currentTimeMillis() / 1000 / 60);
                chronometer.setSeconds(System.currentTimeMillis() / 1000);
                chronometer.resetTimer = false;
                chronometer.runTimer = false;
            }
        }
    }
}
