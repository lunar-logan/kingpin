package org.kingpin.core.statemachine.dto;

import org.kingpin.core.trigger.Trigger;

import java.io.Serializable;
import java.util.List;

public class Transition implements Serializable {
    private static final long serialVersionUID = -5047228261308484073L;

    private String from;
    private List<Trigger> paths;
    private String to;
    private List<Action> actions;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<Trigger> getPaths() {
        return paths;
    }

    public void setPaths(List<Trigger> paths) {
        this.paths = paths;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    @Override
    public String toString() {
        return "Transition{" +
                "from='" + from + '\'' +
                ", paths=" + paths +
                ", to='" + to + '\'' +
                ", actions=" + actions +
                '}';
    }
}
