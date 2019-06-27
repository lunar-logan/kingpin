package org.kingpin.core.statemachine.action.dao;

import org.kingpin.core.statemachine.action.entity.ActionInstance;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActionInstanceRepository extends MongoRepository<ActionInstance, String> {
}
