package pl.kfd.atlas.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "api.properties")
public class PropertiesConfig {
}
