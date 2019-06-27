package org.kingpin.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "org.kingpin.server")
@EnableScheduling
public class KingpinServer {
    public static void main(String[] args) {
        new SpringApplicationBuilder(KingpinServer.class).build().run(args);
    }
}
