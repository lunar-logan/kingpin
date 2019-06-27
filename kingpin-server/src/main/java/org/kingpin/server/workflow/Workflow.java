package org.kingpin.server.workflow;

import org.kingpin.server.common.CorrelationId;

import java.util.Date;

public class Workflow {
    public enum State {
        Initialized,
        Running,
        Completed,
        Stopped,
        Paused
    }

    private final CorrelationId correlationId;

    private final String workflowImage;

    private Date started;

    private State state;

    private Date updated;

    public Workflow(CorrelationId correlationId, String workflowImage) {
        if (correlationId == null) {
            throw new IllegalArgumentException("Correlation Id cannot be null");
        }

        if (workflowImage == null || workflowImage.isBlank()) {
            throw new IllegalArgumentException("Workflow image name cannot be null or blank");
        }
        this.correlationId = correlationId;
        this.workflowImage = workflowImage;
    }

    public CorrelationId getCorrelationId() {
        return correlationId;
    }

    public String getWorkflowImage() {
        return workflowImage;
    }

    public Date getStarted() {
        return started;
    }

    public State getState() {
        return state;
    }

    public Date getUpdated() {
        return updated;
    }
}
