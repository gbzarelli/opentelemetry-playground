package com.example.demo;

import java.util.Collections;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestSample {

   public static final String METRIC_HELLO_COUNT = "hello.count";

   public static final String METRIC_DO_PROCESS_TIMED = "do.process.timed";

   private final MeterRegistry registry;

   private final String applicationName;

   private final MyService myService;

   RestSample(MeterRegistry registry, @Value("${spring.application.name}") String applicationName, MyService myService) {
      this.registry = registry;
      this.applicationName = applicationName;
      this.myService = myService;
   }

   @GetMapping(path = "/hello")
   String hello() throws InterruptedException {

      //sample with counter metric:
      registry.counter(METRIC_HELLO_COUNT, Collections.singletonList(Tag.of("app", applicationName))).increment();
      //sample with timed metric:
      registry.timer(METRIC_DO_PROCESS_TIMED).record(this::doProcess);

      myService.execute();

      return "(Hello)-> from: " + applicationName;
   }

   void doProcess() {
      try {
         Thread.sleep(1000);
      } catch (InterruptedException e) {
         throw new RuntimeException(e);
      }
   }

}
