package com.example.demo;

import java.util.Collections;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestSample {

   private final MeterRegistry registry;

   private final String applicationName;

   RestSample(MeterRegistry registry, @Value("${spring.application.name}") String applicationName) {
      this.registry = registry;
      this.applicationName = applicationName;
   }

   @GetMapping(path = "/hello")
   String hello(){
      registry.counter("hello_count", Collections.singletonList(Tag.of("app", applicationName))).increment();
      return "(Hello)-> from: " + applicationName;
   }

}
