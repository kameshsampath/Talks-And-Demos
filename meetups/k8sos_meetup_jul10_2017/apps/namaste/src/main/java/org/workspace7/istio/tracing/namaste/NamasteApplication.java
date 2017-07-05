package org.workspace7.istio.tracing.namaste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(NamasteProperties.class)
public class NamasteApplication {

    public static void main(String[] args) {
        SpringApplication.run(NamasteApplication.class, args);
    }

}
