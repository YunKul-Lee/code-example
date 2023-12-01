package com.jake.actuator.config;

import com.jake.actuator.custom.LibraryInfoEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LibraryInfoEndpointConfig {

    @Bean
    public LibraryInfoEndpoint libraryInfoEndpoint() {
        return new LibraryInfoEndpoint();
    }
}
