package org.kingpin.core.statemachine.action.dto;

import org.kingpin.core.statemachine.action.common.ActionRetry;
import org.kingpin.core.statemachine.action.common.ActionType;

import java.io.Serializable;

public class ActionDefSnapshot implements Serializable {
    private static final long serialVersionUID = -5692653632841321199L;

    private String name;

    private String description;

    private ActionType type;

    private ActionRetry retry;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ActionType getType() {
        return type;
    }

    public void setType(ActionType type) {
        this.type = type;
    }

    public ActionRetry getRetry() {
        return retry;
    }

    public void setRetry(ActionRetry retry) {
        this.retry = retry;
    }

    @Override
    public String toString() {
        return "ActionDefSnapshot{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", retry=" + retry +
                '}';
    }
}
