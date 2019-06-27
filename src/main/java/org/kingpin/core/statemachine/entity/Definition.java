package org.kingpin.core.statemachine.entity;

import org.kingpin.core.statemachine.dto.DefId;
import org.kingpin.core.statemachine.dto.Transition;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * DefinitionDto of a state machine
 */
public class Definition implements Serializable {
    private static final long serialVersionUID = 8996198134252722249L;

    @Id
    private DefId id;

    private String description;

    private List<Transition> transitions;

    private String startState;

    private Set<String> terminalStates;

    private String author;

    private Date created;

    public DefId getId() {
        return id;
    }

    public void setId(DefId id) {
        this.id = id;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "DefinitionDto{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", transitions=" + transitions +
                ", startState='" + startState + '\'' +
                ", terminalStates=" + terminalStates +
                ", author='" + author + '\'' +
                ", created=" + created +
                '}';
    }
}