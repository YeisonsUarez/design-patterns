package com.aprender.designpatterns.methodfactory.config;

import com.aprender.designpatterns.methodfactory.dto.ConfigurationDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Objects;

@Configuration
public class NotificationConfig {


    @Bean
    public ConfigurationDTO getConfigurationDTO(ObjectMapper objectMapper) throws IOException {
        // Cargar el archivo JSON desde resources
        ClassPathResource resource = new ClassPathResource("configuration.json");

        // Deserializar el archivo JSON a un objeto Persona
        return objectMapper.readValue(resource.getFile(), ConfigurationDTO.class);

    }

}
