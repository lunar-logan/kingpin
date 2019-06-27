package org.kingpin.server.task;

import org.kingpin.server.common.CorrelationId;
import org.kingpin.server.common.TaskStatus;

import java.util.Collections;
import java.util.Map;

public class TaskResult {
    private final CorrelationId correlationId;
    private final String taskId;
    private final TaskStatus status;
    private final Map<String, Object> data;

    public TaskResult(CorrelationId correlationId, String taskId, TaskStatus status, Map<String, Object> data) {
        if (correlationId == null) {
            throw new IllegalArgumentException("Correlation ID cannot be null or blank");
        }
        if (status == null) {
            throw new IllegalArgumentException("Task status cannot be null");
        }

        if (taskId == null || taskId.isBlank()) {
            throw new IllegalArgumentException("Task name cannot be null or empty");
        }


        this.correlationId = correlationId;
        this.status = status;
        this.data = data == null ? Collections.emptyMap() : Map.copyOf(data);
        this.taskId = taskId;
    }

    public CorrelationId getCorrelationId() {
        return correlationId;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public String getTaskId() {
        return taskId;
    }

    @Override
    public String toString() {
        return "TaskResult{" +
                "correlationId=" + correlationId +
                ", taskId='" + taskId + '\'' +
                ", status=" + status +
                ", data=" + data +
                '}';
    }
}