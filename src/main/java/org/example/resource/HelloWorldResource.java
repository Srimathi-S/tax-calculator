package org.example.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private String message;

    public HelloWorldResource(String message){
        this.message = message;
    }

    @GET
    public String sayHello(){
        return message;
    }

}
