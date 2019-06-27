package org.kingpin.core.trigger;


import org.apache.logging.log4j.util.Strings;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Acts as a weight of the edge in the transition graph
 */
public class Trigger implements Serializable {
    private static final long serialVersionUID = 7681743810230824898L;
    private final String name;

    private final Map<String, Object> metaData;

    private final List<Trigger> triggers;

    public Trigger(String name, Map<String, Object> metaData, List<Trigger> triggers) {
        if (Strings.isBlank(name)) {
            throw new IllegalArgumentException("Trigger name cannot be blank");
        }
        this.name = name;
        this.metaData = (metaData == null || metaData.isEmpty()) ? Collections.emptyMap() : Collections.unmodifiableMap(metaData);
        this.triggers = (triggers == null || triggers.isEmpty()) ? Collections.emptyList() : Collections.unmodifiableList(triggers);
    }

    public Trigger(String name) {
        this(name, Collections.emptyMap(), Collections.emptyList());
    }

    public String getName() {
        return name;
    }

    public Map<String, Object> getMetaData() {
        return metaData;
    }

    public List<Trigger> getTriggers() {
        return triggers;
    }

    @Override
    public String toString() {
        return "Trigger{" +
                "name='" + name + '\'' +
                ", metaData=" + metaData +
                '}';
    }
}
