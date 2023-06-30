package org.example.resource;

import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import io.dropwizard.testing.junit5.ResourceExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(DropwizardExtensionsSupport.class)
class HelloWorldResourceTest {
    private static final ResourceExtension resourceExtension = ResourceExtension.builder()
            .addResource(new HelloWorldResource("message"))
            .build();

    @Test
    public void shouldReturnResponseForTheEndpoint(){
        String message = resourceExtension.target("/hello").request().get(String.class);

        Assertions.assertEquals(message, "message");
    }

}