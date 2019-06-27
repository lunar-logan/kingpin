package org.kingpin.core.statemachine.entity;

import org.kingpin.core.common.LifecycleEvent;
import org.kingpin.core.statemachine.dto.DefinitionDto;
import org.kingpin.core.statemachine.dto.Event;
import org.kingpin.core.statemachine.dto.State;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Instance implements Serializable {

    private static final long serialVersionUID = -1543046509410701285L;

    @Id
    private String id;

    private DefinitionDto def;

    @Version
    private Long version;

    private State state;

    private Map<String, Object> metaData;

    private List<Event> events;

    private LifecycleEvent.State lifecycleState;

    private List<LifecycleEvent> lifecycleEvents;

    @Indexed
    private Set<String> tags;

    private Date created;

    private Date updated;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DefinitionDto getDef() {
        return def;
    }

    public void setDef(DefinitionDto def) {
        this.def = def;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Map<String, Object> getMetaData() {
        return metaData;
    }

    public void setMetaData(Map<String, Object> metaData) {
        this.metaData = metaData;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public LifecycleEvent.State getLifecycleState() {
        return lifecycleState;
    }

    public void setLifecycleState(LifecycleEvent.State lifecycleState) {
        this.lifecycleState = lifecycleState;
    }

    public List<LifecycleEvent> getLifecycleEvents() {
        return lifecycleEvents;
    }

    public void setLifecycleEvents(List<LifecycleEvent> lifecycleEvents) {
        this.lifecycleEvents = lifecycleEvents;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Instance{" +
                "id='" + id + '\'' +
                ", def=" + def +
                ", version=" + version +
                ", state=" + state +
                ", metaData=" + metaData +
                ", events=" + events +
                ", lifecycleState=" + lifecycleState +
                ", lifecycleEvents=" + lifecycleEvents +
                ", tags=" + tags +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
