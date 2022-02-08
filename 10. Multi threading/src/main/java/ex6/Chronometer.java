package ex6;

public class Chronometer {
    public boolean runTimer;
    public boolean resetTimer;
    private long hours;
    private long minutes;
    private long seconds;

    public Chronometer(long currentTime) {
        this.hours = currentTime / 1000 / 60 / 60 / 60;
        this.minutes = (currentTime - this.hours) / 1000 / 60 / 60;
        this.seconds = (currentTime - this.hours - this.minutes) / 1000 / 60 ;
        this.runTimer = false;
        this.resetTimer = false;
    }
    public void updateTime(long currentTime) {
        this.hours = currentTime / 1000 / 60 / 60 / 60;
        this.minutes = (currentTime - this.hours) / 1000 / 60 / 60;
        this.seconds = (currentTime - this.hours - this.minutes) / 1000 / 60 ;
    }

    public long getMinutes() {
        return minutes;
    }

    public long getSeconds() {
        return seconds;
    }

    public long getHours() { return hours; }

    public void setMinutes(long currentTime) {
        this.minutes = (int)currentTime / 1000 / 60 / 60;
    }

    public void setSeconds(long currentTime) {
        this.seconds = (int)currentTime / 1000 / 60 ;
    }

    public void setHours(long currentTime) {
        this.hours = (int)currentTime / 1000 / 60 / 60 / 60 ;
    }

    public void setResetTimer(boolean resetTimer) {
        this.resetTimer = resetTimer;
    }

    public void setRunTimer(boolean runTimer) {
        this.runTimer = runTimer;
    }

    @Override
    public String toString() {
        return this.hours + ":" + this.minutes + ":" + this.seconds + "";
    }
}
