package org.kingpin.server.controller.v1;

import org.kingpin.server.metadata.HealthCheckDTO;
import org.kingpin.server.service.HealthCheckService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class HealthCheckController {

    private final HealthCheckService service;

    public HealthCheckController(HealthCheckService service) {
        this.service = service;
    }

    @GetMapping("/health")
    public ResponseEntity<HealthCheckDTO> diagnose() {
        return ResponseEntity.ok(service.diagnoseSystem());
    }
}
