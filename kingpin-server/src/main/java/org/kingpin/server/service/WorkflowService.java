package org.kingpin.server.service;

import org.kingpin.server.common.CorrelationId;
import org.kingpin.server.common.Trigger;
import org.kingpin.server.task.Task;
import org.kingpin.server.task.TaskImage;
import org.kingpin.server.workflow.Workflow;
import org.kingpin.server.workflow.WorkflowImage;

import java.util.List;
import java.util.Optional;

public interface WorkflowService {
    WorkflowImage createWorkflowImage(String name, List<TaskImage> tasks);

    Workflow createWorkflow(WorkflowImage image, CorrelationId correlationId);

    Optional<Workflow> fetchWorkflowByCorrelationId(CorrelationId correlationId);

    Optional<WorkflowImage> fetchWorkflowImageByImageName(String imageName);

    void pauseWorkflow(Workflow workflow);

    void stopWorkflow(Workflow workflow);

    void startWorkflow(Workflow workflow);

    Workflow updateWorkflowState(Workflow workflow, Workflow.State state);

    void processTrigger(Trigger event);

    Optional<Task> getNextTask(Workflow workflow);
}
