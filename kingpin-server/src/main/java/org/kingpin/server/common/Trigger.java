package org.kingpin.server.common;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

public class Trigger {
    private final CorrelationId correlationId;

    private final String taskId;

    private final TaskStatus taskStatus;

    private final Map<String, Object> taskResult;

    public Trigger(CorrelationId correlationId, String taskId, TaskStatus taskStatus, Map<String, Object> taskResult) {
        this.correlationId = Objects.requireNonNull(correlationId);
        this.taskId = Objects.requireNonNull(taskId);
        this.taskStatus = Objects.requireNonNull(taskStatus);
        this.taskResult = taskResult == null ? Collections.emptyMap() : Map.copyOf(taskResult);
    }

    public CorrelationId getCorrelationId() {
        return correlationId;
    }

    public String getTaskId() {
        return taskId;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public Map<String, Object> getTaskResult() {
        return taskResult;
    }
}
