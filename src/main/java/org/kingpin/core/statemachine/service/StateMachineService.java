package org.kingpin.core.statemachine.service;

import org.kingpin.core.trigger.Trigger;

import java.util.Collection;
import java.util.Map;

public interface StateMachineService {
    String start(String name, long version, Map<String, Object> input);

    void pause(String id);

    void stop(String id);

    void resume(String id);

    void applyTrigger(String id, Trigger trigger);

    void applyTriggers(String id, Collection<Trigger> triggers);

    void rollback(String id, long version);
}
