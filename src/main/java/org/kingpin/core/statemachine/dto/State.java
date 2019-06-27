package org.kingpin.core.statemachine.dto;

import java.io.Serializable;
import java.util.Set;

public class State implements Serializable {
    private static final long serialVersionUID = 3834496380766890510L;

    private String previous;
    private String current;
    private Set<String> ephemeralStates;

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public Set<String> getEphemeralStates() {
        return ephemeralStates;
    }

    public void setEphemeralStates(Set<String> ephemeralStates) {
        this.ephemeralStates = ephemeralStates;
    }

    @Override
    public String toString() {
        return "State{" +
                "previous='" + previous + '\'' +
                ", current='" + current + '\'' +
                ", ephemeralStates=" + ephemeralStates +
                '}';
    }
}