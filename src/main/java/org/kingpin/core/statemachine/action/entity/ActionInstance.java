package org.kingpin.core.statemachine.action.entity;

import org.kingpin.core.statemachine.action.common.ActionOperation;
import org.kingpin.core.statemachine.action.common.ActionResult;
import org.kingpin.core.statemachine.action.common.ActionState;
import org.kingpin.core.statemachine.action.dto.ActionDefSnapshot;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;
import java.util.Date;

public class ActionInstance implements Serializable {
    private static final long serialVersionUID = 8300393350735696910L;

    @Id
    private String id;

    @Indexed
    private String correlationId;

    private ActionDefSnapshot def;

    private String topic;

    private ActionResult result;

    private ActionState state;

    private ActionOperation nextOperation;

    private Date nextOperationAt;

    private Date created;

    private Date updated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public ActionDefSnapshot getDef() {
        return def;
    }

    public void setDef(ActionDefSnapshot def) {
        this.def = def;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public ActionResult getResult() {
        return result;
    }

    public void setResult(ActionResult result) {
        this.result = result;
    }

    public ActionState getState() {
        return state;
    }

    public void setState(ActionState state) {
        this.state = state;
    }

    public ActionOperation getNextOperation() {
        return nextOperation;
    }

    public void setNextOperation(ActionOperation nextOperation) {
        this.nextOperation = nextOperation;
    }

    public Date getNextOperationAt() {
        return nextOperationAt;
    }

    public void setNextOperationAt(Date nextOperationAt) {
        this.nextOperationAt = nextOperationAt;
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
        return "ActionInstance{" +
                "id='" + id + '\'' +
                ", correlationId='" + correlationId + '\'' +
                ", def=" + def +
                ", topic='" + topic + '\'' +
                ", result=" + result +
                ", state=" + state +
                ", nextOperation=" + nextOperation +
                ", nextOperationAt=" + nextOperationAt +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
