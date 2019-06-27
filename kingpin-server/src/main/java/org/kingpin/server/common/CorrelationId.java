package org.kingpin.server.common;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class CorrelationId implements Serializable {

    private static final long serialVersionUID = 4265688878258814048L;

    private final String id;

    public CorrelationId(String id) {
        this.id = Objects.requireNonNull(id);
    }

    public static CorrelationId randomCorrelationId() {
        return new CorrelationId(UUID.randomUUID().toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CorrelationId that = (CorrelationId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "CorrelationId{" +
                "id='" + id + '\'' +
                '}';
    }
}
