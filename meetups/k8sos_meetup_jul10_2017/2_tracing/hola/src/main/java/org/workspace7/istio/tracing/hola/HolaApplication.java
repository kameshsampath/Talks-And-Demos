package org.workspace7.istio.tracing.hola;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(HolaProperties.class)
public class HolaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HolaApplication.class, args);
    }

}
