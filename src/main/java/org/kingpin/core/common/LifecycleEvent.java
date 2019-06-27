package org.kingpin.core.common;

import java.io.Serializable;
import java.util.Date;

public class LifecycleEvent implements Serializable {
    private final State state;
    private final Date timestamp;
    private final String reason;

    public LifecycleEvent(State state, Date timestamp, String reason) {
        this.state = state;
        this.timestamp = timestamp;
        this.reason = reason;
    }

    public State getState() {
        return state;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getReason() {
        return reason;
    }

    public enum State {
        INITIALIZED,
        RUNNING,
        PAUSED,
        STOPPED,
        COMPLETED
    }

    @Override
    public String toString() {
        return "LifecycleEvent{" +
                "state=" + state +
                ", timestamp=" + timestamp +
                ", reason='" + reason + '\'' +
                '}';
    }
}
