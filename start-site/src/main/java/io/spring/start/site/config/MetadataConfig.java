package io.spring.start.site.config;

import io.spring.initializr.metadata.InitializrMetadata;
import io.spring.initializr.metadata.InitializrMetadataBuilder;
import io.spring.initializr.metadata.InitializrMetadataProvider;
import io.spring.initializr.metadata.InitializrProperties;
import io.spring.initializr.web.support.DefaultInitializrMetadataProvider;
import io.spring.initializr.web.support.InitializrMetadataUpdateStrategy;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * MetadataConfig
 *
 * Created by master on 2020-04-17T13:28:00+0800
 */
@Configuration
@EnableConfigurationProperties(WebProperties.class)
public class MetadataConfig {
    
    
    @Primary
    @Bean
    public InitializrMetadataProvider initializrMetadataProvider(InitializrProperties properties,
            InitializrMetadataUpdateStrategy initializrMetadataUpdateStrategy, WebProperties webProperties) {
        InitializrMetadata metadata = InitializrMetadataBuilder.fromInitializrProperties(properties).build();
        metadata.getArtifactId().setContent(webProperties.getArtifactId());
        metadata.getVersion().setContent(webProperties.getVersion());
        metadata.getGroupId().setContent(webProperties.getGroupId());
        return new DefaultInitializrMetadataProvider(metadata, initializrMetadataUpdateStrategy);
    }
}
