package org.kingpin.server.converter;

import org.kingpin.server.entity.WorkflowEntity;
import org.kingpin.server.workflow.Workflow;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class WorkflowToWorkflowEntity implements Converter<Workflow, WorkflowEntity> {

    @Override
    public WorkflowEntity convert(Workflow workflow) {
        WorkflowEntity entity = new WorkflowEntity();
        entity.setCorrelationId(workflow.getCorrelationId().toString());
        entity.setStarted(workflow.getStarted());
        entity.setState(workflow.getState().name());
        entity.setUpdated(new Date());
        entity.setWorkflowImage(workflow.getWorkflowImage());
        return entity;
    }
}
