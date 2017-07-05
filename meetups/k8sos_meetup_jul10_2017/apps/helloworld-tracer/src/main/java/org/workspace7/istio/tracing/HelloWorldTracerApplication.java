package org.workspace7.istio.tracing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldTracerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldTracerApplication.class, args);
    }
}
