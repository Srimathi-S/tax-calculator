package org.example.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.configuration.ConfigurationException;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.configuration.YamlConfigurationFactory;
import io.dropwizard.jackson.Jackson;
import io.dropwizard.jersey.validation.Validators;
import jakarta.validation.Validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;


class ApplicationConfigurationTest {
    private final ObjectMapper objectMapper = Jackson.newObjectMapper();
    private final Validator validator = Validators.newValidator();
    private final YamlConfigurationFactory<ApplicationConfiguration> factory =
            new YamlConfigurationFactory<>(ApplicationConfiguration.class, validator, objectMapper, "");


    @Test
    public void shouldReturnProperMessageIfPresent() throws ConfigurationException, IOException {
        final ApplicationConfiguration applicationConfiguration = factory.build(new ResourceConfigurationSourceProvider(), "application.yml");

        Assertions.assertEquals(applicationConfiguration.getMessage(), "hello-world");
    }
}