package org.kingpin.core.statemachine.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class DefinitionDto implements Serializable {
    private static final long serialVersionUID = 3274618375547368486L;

    private DefId defId;

    private String description;

    private List<Transition> transitions;

    private String startState;

    private Set<String> terminalStates;

    public DefId getDefId() {
        return defId;
    }

    public void setDefId(DefId defId) {
        this.defId = defId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<Transition> transitions) {
        this.transitions = transitions;
    }

    public String getStartState() {
        return startState;
    }

    public void setStartState(String startState) {
        this.startState = startState;
    }

    public Set<String> getTerminalStates() {
        return terminalStates;
    }

    public void setTerminalStates(Set<String> terminalStates) {
        this.terminalStates = terminalStates;
    }

    @Override
    public String toString() {
        return "DefinitionDto{" +
                "defId=" + defId +
                ", description='" + description + '\'' +
                ", transitions=" + transitions +
                ", startState='" + startState + '\'' +
                ", terminalStates=" + terminalStates +
                '}';
    }
}
