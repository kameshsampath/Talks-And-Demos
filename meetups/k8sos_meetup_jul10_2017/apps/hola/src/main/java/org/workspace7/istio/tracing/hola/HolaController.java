package org.workspace7.istio.tracing.hola;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author kameshs
 */
@RestController
@Slf4j
public class HolaController {

    @Autowired
    HolaProperties namasteProperties;

    @GetMapping("/hola")
    public String hello(HttpServletRequest request) {

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            log.info("HOLA HEADERS {}={}", headerName, request.getHeader(headerName));
        }
        return String.format("[v%s]: Hola from %s", namasteProperties.getVersion(),
                System.getenv().getOrDefault("HOSTNAME", "Unknown"));
    }

}
