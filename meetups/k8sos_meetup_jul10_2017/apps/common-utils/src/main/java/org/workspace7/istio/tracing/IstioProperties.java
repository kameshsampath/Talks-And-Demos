package org.workspace7.istio.tracing;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author kameshs
 */
@Configuration
@ConfigurationProperties(prefix = "istio")
public class IstioProperties {

    private List<String> tracingHeaders;

    public List<String> getTracingHeaders() {
        return tracingHeaders;
    }

    public void setTracingHeaders(List<String> tracingHeaders) {
        this.tracingHeaders = tracingHeaders;
    }
}
