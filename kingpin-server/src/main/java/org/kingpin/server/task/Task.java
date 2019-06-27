package org.kingpin.server.task;

import org.kingpin.server.common.CorrelationId;

public class Task {
    private final String id;

    private final CorrelationId correlationId;

    private final String taskImage;

    private TaskImage.Status status;


    /**
     * The current retry count
     */
    private int retryCount;

    public Task(String id, CorrelationId correlationId, String taskImage) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Task ID cannot be null or blank");
        }

        if (correlationId == null) {
            throw new IllegalArgumentException("Correlation Id cannot be null");
        }

        if (taskImage == null) {
            throw new IllegalArgumentException("Task image name cannot be null");
        }

        this.id = id;
        this.correlationId = correlationId;
        this.taskImage = taskImage;
    }

    public String getId() {
        return id;
    }

    public CorrelationId getCorrelationId() {
        return correlationId;
    }

    public String getTaskImage() {
        return taskImage;
    }

    public TaskImage.Status getStatus() {
        return status;
    }

    public int getRetryCount() {
        return retryCount;
    }
}
