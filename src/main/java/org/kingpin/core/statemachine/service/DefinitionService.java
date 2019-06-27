package org.kingpin.core.statemachine.service;

import org.kingpin.core.statemachine.dto.DefinitionDto;
import org.kingpin.core.statemachine.dto.Transition;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface DefinitionService {
    void create(String name, long version, String description, List<Transition> transitions, String startState, Set<String> terminalStates);

    default void create(String name, long version, List<Transition> transitions, String startState, Set<String> terminalStates) {
        create(name, version, null, transitions, startState, terminalStates);
    }

    void delete(String name, long version);

    Optional<DefinitionDto> fetch(String name, long version);

    List<DefinitionDto> fetch(String name);
}
