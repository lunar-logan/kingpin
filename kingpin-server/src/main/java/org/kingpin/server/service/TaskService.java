package org.kingpin.server.service;

import org.kingpin.server.common.CorrelationId;
import org.kingpin.server.common.TaskStatus;
import org.kingpin.server.task.TaskResult;
import org.kingpin.server.task.RetryConfig;
import org.kingpin.server.task.Task;
import org.kingpin.server.task.TaskImage;
import org.kingpin.server.workflow.Workflow;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface TaskService {
    Optional<TaskImage> fetchTaskImage(String name);

    Optional<Task> fetchTask(String taskId);

    List<Task> fetchTaskByCorrelationId(String correlationId);

    TaskImage createImage(String name, String queue, RetryConfig retryConfig);

    Task createTask(TaskImage img, CorrelationId correlationId);

    void pauseTask(Task task);

    void startTask(Task task);

    void stopTask(Task task);

    void updateTask(Task task, TaskImage.Status newStatus, Map<String, Object> metaData);

    void executeTask(Task task, Workflow workflow);

    TaskStatus handleTaskResult(Task task, TaskResult result);
}
