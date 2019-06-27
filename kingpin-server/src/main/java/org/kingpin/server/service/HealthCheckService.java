package org.kingpin.server.service;

import org.kingpin.server.metadata.HealthCheckDTO;
import org.springframework.stereotype.Service;

@Service
public class HealthCheckService {

    // todo: make this real
    public HealthCheckDTO diagnoseSystem() {
        HealthCheckDTO response = new HealthCheckDTO();
        response.setStatus("Godspeed!");
        return response;
    }
}
