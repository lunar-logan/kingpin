package org.kingpin.core.statemachine.action.entity;

import org.kingpin.core.statemachine.action.common.ActionRetry;
import org.kingpin.core.statemachine.action.common.ActionType;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

public class ActionDef implements Serializable {
    private static final long serialVersionUID = 6504236485054115967L;

    @Id
    private String name;

    private String description;

    private ActionType type;

    private ActionRetry retry;

    private Date created;

    private Date updated;

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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "ActionDef{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", retry=" + retry +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
