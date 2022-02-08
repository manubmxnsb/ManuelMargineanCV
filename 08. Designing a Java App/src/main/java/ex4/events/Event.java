package ex4.events;

import ex4.events.EventType;

public abstract class Event {

    private EventType type;

    Event(EventType type) {
        this.type = type;
    }

    public EventType getType() {
        return this.type;
    }

}