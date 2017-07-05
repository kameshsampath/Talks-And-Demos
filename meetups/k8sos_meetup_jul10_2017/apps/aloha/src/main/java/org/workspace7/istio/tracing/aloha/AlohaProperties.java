package org.workspace7.istio.tracing.aloha;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author kameshs
 */
@Configuration
@ConfigurationProperties(prefix = "aloha")
@Primary
public class AlohaProperties {

    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
