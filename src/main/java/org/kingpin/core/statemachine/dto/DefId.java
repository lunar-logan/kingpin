package org.kingpin.core.statemachine.dto;

import java.io.Serializable;

public class DefId implements Serializable {

    private static final long serialVersionUID = 8763059148711851134L;
    private String name;

    private Long version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "DefId{" +
                "name='" + name + '\'' +
                ", version=" + version +
                '}';
    }
}
