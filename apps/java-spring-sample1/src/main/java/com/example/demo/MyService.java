package com.example.demo;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;

import org.springframework.stereotype.Service;

@Service
public class MyService {

   public static final String METRIC_MYSERVICE_EXECUTE_TIMED = "myservice.execute.timed";

   @Timed(METRIC_MYSERVICE_EXECUTE_TIMED)
   public void execute() {
      try {
         Thread.sleep(500);
      } catch (InterruptedException e) {
         throw new RuntimeException(e);
      }
   }

}
