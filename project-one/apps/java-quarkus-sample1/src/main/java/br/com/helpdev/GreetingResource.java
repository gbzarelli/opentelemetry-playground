package br.com.helpdev;

import io.micrometer.core.instrument.MeterRegistry;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    private final MeterRegistry registry;

    GreetingResource(MeterRegistry registry) {
        this.registry = registry;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        registry.counter("example.prime.number").increment();
        registry.counter("example.secound.number").increment();
        return "Hello from RESTEasy Reactive";
    }
}