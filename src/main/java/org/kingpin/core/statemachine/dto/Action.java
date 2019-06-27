package org.kingpin.core.statemachine.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Action to be fired after a transition
 */
public class Action implements Serializable {
    private static final long serialVersionUID = -3742286599172251828L;



    private List<String> topics;

    private String trigger;

    private Map<String, Object> metaData;

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public Map<String, Object> getMetaData() {
        return metaData;
    }

    public void setMetaData(Map<String, Object> metaData) {
        this.metaData = metaData;
    }

    @Override
    public String toString() {
        return "Action{" +
                "topics=" + topics +
                ", trigger='" + trigger + '\'' +
                ", metaData=" + metaData +
                '}';
    }
}
