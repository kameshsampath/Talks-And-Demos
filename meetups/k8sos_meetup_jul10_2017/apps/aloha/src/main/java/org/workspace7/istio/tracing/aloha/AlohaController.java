package org.workspace7.istio.tracing.aloha;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author kameshs
 */
@RestController
@Slf4j
public class AlohaController {

    @Autowired
    AlohaProperties namasteProperties;

    @GetMapping("/aloha")
    public String hello() {

        return String.format("[v%s]: Aloha from %s", namasteProperties.getVersion(),
                System.getenv().getOrDefault("HOSTNAME", "Unknown"));
    }

    @GetMapping("/aloha2")
    public String hellooo() {

        log.info("Long Hello Started ...");

        try {
            SECONDS.sleep(10);
        } catch (InterruptedException e) {
        }
        log.info("Long Hello Ended ...");

        return String.format("[v%s]: Long aloha from %s", namasteProperties.getVersion(),
                System.getenv().getOrDefault("HOSTNAME", "Unknown"));
    }


}
