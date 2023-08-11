package br.com.helpdev;

import io.micrometer.core.instrument.MeterRegistry;

import io.micrometer.core.instrument.Tag;
import java.util.Collections;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/hello")
public class GreetingResource {
  @Inject
  @RestClient
  OtherServiceClient otherServiceClient;
  @Inject
  MeterRegistry registry;

  @ConfigProperty(name = "rule.call-other-service.enabled", defaultValue = "false")
  boolean callOtherServiceEnabled;

  @ConfigProperty(name = "quarkus.application.name")
  String applicationName;

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String hello() {
    registry.counter("hello_count", Collections.singletonList(Tag.of("app", applicationName))).increment();

    if (callOtherServiceEnabled) {
      return "(" + otherServiceClient.getHello() + ")-> from: " + applicationName;
    }
    return "(Hello)-> from: " + applicationName;
  }
}