package org.workspace7.istio.tracing.namaste;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kameshs
 */
@RestController
@Slf4j
public class NamasteController {

    @Autowired
    NamasteProperties namasteProperties;

    @GetMapping("/namaste")
    public String hello() {

        return String.format("[v%s]: Namaste from %s", namasteProperties.getVersion(),
                System.getenv().getOrDefault("HOSTNAME", "Unknown"));
    }

}
