package org.kingpin.server.workflow;

import org.kingpin.server.task.TaskImage;

import java.util.List;

public class WorkflowImage {
    private final String name;
    private final List<TaskImage> tasks;

    public WorkflowImage(String name, List<TaskImage> tasks) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Workflow name cannot be null or blank");
        }

        if (tasks == null) {
            throw new IllegalArgumentException("Tasks cannot be null");
        }
        this.name = name;
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public List<TaskImage> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        return "WorkflowImage{" +
                "name='" + name + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
