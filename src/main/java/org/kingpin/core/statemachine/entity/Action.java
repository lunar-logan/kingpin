package org.kingpin.core.statemachine.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Action implements Serializable {
    private static final long serialVersionUID = -819061462205355809L;

    @Id
    private String id;

    private String name;

    private List<String> topics;

    private Type type;

    private Date created;

    private Date updated;

    public enum Type {
        DECISION,
        EXTERNAL
    }

    public enum Result {

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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
        return "Action{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", topics=" + topics +
                ", type=" + type +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
