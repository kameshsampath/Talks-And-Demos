package org.workspace7.istio.tracing.namaste;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author kameshs
 */
@Configuration
@ConfigurationProperties(prefix = "namaste")
@Primary
public class NamasteProperties {

    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
