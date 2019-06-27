package org.kingpin.server.service.impl;

import org.kingpin.server.common.CorrelationId;
import org.kingpin.server.common.TaskStatus;
import org.kingpin.server.common.Trigger;
import org.kingpin.server.dao.WorkflowDAO;
import org.kingpin.server.dao.WorkflowImageDAO;
import org.kingpin.server.entity.WorkflowEntity;
import org.kingpin.server.exception.NoSuchWorkflowException;
import org.kingpin.server.exception.NoSuchWorkflowImageException;
import org.kingpin.server.service.TaskService;
import org.kingpin.server.service.WorkflowService;
import org.kingpin.server.task.Task;
import org.kingpin.server.task.TaskResult;
import org.kingpin.server.task.TaskImage;
import org.kingpin.server.workflow.Workflow;
import org.kingpin.server.workflow.WorkflowImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionService;

import java.lang.invoke.MethodHandles;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class WorkflowServiceImpl implements WorkflowService {
    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final WorkflowImageDAO workflowImageDAO;

    private final WorkflowDAO workflowDAO;

    private final TaskService taskService;

    private final ConversionService conversionService;

    public WorkflowServiceImpl(WorkflowImageDAO workflowImageDAO, WorkflowDAO workflowDAO, TaskService taskService, ConversionService conversionService) {
        this.workflowImageDAO = workflowImageDAO;
        this.workflowDAO = workflowDAO;
        this.taskService = taskService;
        this.conversionService = conversionService;
    }

    @Override
    public WorkflowImage createWorkflowImage(String name, List<TaskImage> tasks) {
        WorkflowImage img = new WorkflowImage(name, tasks);
        return workflowImageDAO.save(img);
    }

    @Override
    public Workflow createWorkflow(WorkflowImage image, CorrelationId correlationId) {
        WorkflowEntity entity = new WorkflowEntity();
        entity.setCorrelationId(CorrelationId.randomCorrelationId().toString());
        entity.setWorkflowImage(image.getName());
        entity.setState(Workflow.State.Initialized.name());
        entity.setCreated(new Date());
        return conversionService.convert(workflowDAO.save(entity), Workflow.class);
    }

    @Override
    public Optional<Workflow> fetchWorkflowByCorrelationId(CorrelationId correlationId) {
        return Optional.empty();
    }

    @Override
    public Optional<WorkflowImage> fetchWorkflowImageByImageName(String imageName) {
        return Optional.empty();
    }

    @Override
    public void pauseWorkflow(Workflow workflow) {

    }

    @Override
    public void stopWorkflow(Workflow workflow) {

    }

    @Override
    public void startWorkflow(Workflow workflow) {

    }

    @Override
    public Workflow updateWorkflowState(Workflow workflow, Workflow.State state) {
        WorkflowEntity entity = conversionService.convert(workflow, WorkflowEntity.class);
        entity.setState(state.name());
        return conversionService.convert(workflowDAO.save(entity), Workflow.class);
    }

    @Override
    public void processTrigger(Trigger trigger) {
        logger.info("Handling trigger: {}", trigger);

        Workflow workflow = fetchWorkflowByCorrelationId(trigger.getCorrelationId()).orElseThrow(NoSuchWorkflowException::new);
        logger.info("Workflow: {}", workflow);

        Task task = taskService.fetchTask(trigger.getTaskId()).orElseThrow();
        logger.info("Task: {}", task);

        TaskStatus taskStatus = taskService.handleTaskResult(task, new TaskResult(trigger.getCorrelationId(), trigger.getTaskId(), trigger.getTaskStatus(), trigger.getTaskResult()));
        logger.info("Task status: {}", taskStatus);

        if (taskStatus == TaskStatus.Completed) {
            getNextTask(workflow).ifPresentOrElse(
                    polledTask -> taskService.executeTask(polledTask, workflow),
                    () -> updateWorkflowState(workflow, Workflow.State.Completed)
            );
        } else if (taskStatus == TaskStatus.Failed) {
            logger.info("Task '{}' has failed, pausing workflow", trigger.getTaskId());
            pauseWorkflow(workflow);

        } else if (taskStatus == TaskStatus.Retryable_Failed) {
            taskService.executeTask(task, workflow);
        }
    }

    @Override
    public Optional<Task> getNextTask(Workflow workflow) {
        WorkflowImage workflowImage = fetchWorkflowImageByImageName(workflow.getWorkflowImage()).orElseThrow(NoSuchWorkflowImageException::new);
        List<TaskImage> taskImages = workflowImage.getTasks();
        List<Task> tasks = taskService.fetchTaskByCorrelationId(workflow.getCorrelationId().toString());

        return Optional.empty();
    }
}
