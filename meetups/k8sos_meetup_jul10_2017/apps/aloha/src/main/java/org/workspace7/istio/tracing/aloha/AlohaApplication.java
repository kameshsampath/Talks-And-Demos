package org.workspace7.istio.tracing.aloha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AlohaProperties.class)
public class AlohaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlohaApplication.class, args);
    }

}
