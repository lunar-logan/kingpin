package org.kingpin.server.metadata;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HealthCheckDTO implements Serializable {
    private static final long serialVersionUID = -4378220400697830810L;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HealthCheckDTO{" +
                "status='" + status + '\'' +
                '}';
    }
}
