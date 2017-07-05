package org.workspace7.istio.tracing.hola;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author kameshs
 */
@Configuration
@ConfigurationProperties(prefix = "hola")
@Primary
public class HolaProperties {

    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
