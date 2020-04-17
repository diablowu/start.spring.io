package io.spring.start.site.config;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.spring.initializr.metadata.InitializrProperties.SimpleElement;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * WebProperties
 *
 * Created by master on 2020-04-17T14:26:00+0800
 */
@ConfigurationProperties(prefix = "web.initializr")
public class WebProperties {
    
    private String groupId;
    
    private String artifactId;
    
    private String version;
    
    public String getGroupId() {
        return groupId;
    }
    
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    
    public String getArtifactId() {
        return artifactId;
    }
    
    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }
    
    public String getVersion() {
        return version;
    }
    
    public void setVersion(String version) {
        this.version = version;
    }
}
