package org.kingpin.server.entity;

import java.io.Serializable;
import java.util.Date;

public class WorkflowEntity implements Serializable {
    private static final long serialVersionUID = -1323654520343104523L;

    private String correlationId;

    private String workflowImage;

    private String state;

    private Date created;

    private Date started;

    private Date updated;

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getWorkflowImage() {
        return workflowImage;
    }

    public void setWorkflowImage(String workflowImage) {
        this.workflowImage = workflowImage;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getStarted() {
        return started;
    }

    public void setStarted(Date started) {
        this.started = started;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
