package org.kingpin.core.statemachine.action;

import org.apache.logging.log4j.util.Strings;
import org.kingpin.core.statemachine.action.common.ActionRetry;
import org.kingpin.core.statemachine.action.common.ActionType;
import org.kingpin.core.statemachine.action.dao.ActionDefRepository;
import org.kingpin.core.statemachine.action.dto.ActionDefSnapshot;
import org.kingpin.core.statemachine.action.entity.ActionDef;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ActionService {
    private final ActionDefRepository definitionDAO;

    public ActionService(ActionDefRepository definitionDAO) {
        this.definitionDAO = definitionDAO;
    }

    public void define(String name, String desc, ActionType type, ActionRetry retry) {
        if (Strings.isBlank(name)) {
            throw new IllegalArgumentException("Action name cannot be null");
        }

        if (type == null) {
            throw new IllegalArgumentException("ActionType cannot be null");
        }

        ActionDef def = new ActionDef();
        def.setName(name);
        def.setDescription(desc);
        def.setType(type);
        def.setRetry(retry);
        def.setCreated(new Date());
        def.setUpdated(new Date());

        definitionDAO.save(def);
    }

    public Optional<ActionDefSnapshot> fetch(String name) {
        return definitionDAO.findById(name)
                .map(def -> {
                    ActionDefSnapshot snapshot = new ActionDefSnapshot();
                    snapshot.setName(def.getName());
                    snapshot.setDescription(def.getDescription());
                    snapshot.setRetry(def.getRetry());
                    snapshot.setType(def.getType());
                    return snapshot;
                });
    }
}
