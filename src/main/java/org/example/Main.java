package org.example;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import org.example.configuration.ApplicationConfiguration;
import org.example.resource.HelloWorldResource;

public class Main extends Application<ApplicationConfiguration> {
    public static void main(String[] args) throws Exception {
        new Main().run(args);
    }

    @Override
    public void run(ApplicationConfiguration applicationConfiguration, Environment environment) throws Exception {
        HelloWorldResource resource = new HelloWorldResource(
                applicationConfiguration.getMessage()
        );
        environment.jersey().register(resource);
    }

    @Override
    public void initialize(Bootstrap<ApplicationConfiguration> bootstrap) {
        // nothing to do yet
    }
}