package org.kingpin.server.converter;

import org.kingpin.server.common.CorrelationId;
import org.kingpin.server.entity.WorkflowEntity;
import org.kingpin.server.workflow.Workflow;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class WorkflowEntityToWorkflow implements Converter<WorkflowEntity, Workflow> {

    @Override
    public Workflow convert(WorkflowEntity entity) {
        return new Workflow(new CorrelationId(entity.getCorrelationId()), entity.getWorkflowImage());
    }
}
