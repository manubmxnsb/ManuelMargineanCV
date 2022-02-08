package ex4.events;

import ex4.events.Event;
import ex4.events.EventType;

public class NoEvent extends Event {

    public NoEvent() {
        super(EventType.NONE);
    }

    @Override
    public String toString() {
        return "NoEvent{}";
    }
}
