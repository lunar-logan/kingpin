package org.kingpin.core.statemachine.action.dao;

import org.kingpin.core.statemachine.action.entity.ActionDef;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActionDefRepository extends MongoRepository<ActionDef, String> {
}
