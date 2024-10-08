package com.bootcamp.demo.demo_sb_calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication // Include below 3 
// ! 1. @SpringBootConfiguration
// ! 2. @EnableAutoConfiguration
// ! 3. @ComponentScan
	// - What is Bean?
		// The object lifecycle is managed by someone, but not you. *Lifecycle -> from new object to disapper from memory
		// In Spring, most of the beams are created during the server start.
	// - What is Component? 
		// A class that used to create Beam, we call it componet. e.g. @Controller
    // When server starts, scan the whole spring project, to find any class with
// component annotation
// Component annotations: @Controller, @Service, @Configuration, @Repository
public class DemoSbCalculatorApplication {

  public static ConfigurableApplicationContext context;

  public static void main(String[] args) {
    //String s = "abc"; // String objec (heap memory)
    // static method

    DemoSbCalculatorApplication.context = 
      SpringApplication.run(DemoSbCalculatorApplication.class, args);
  }

  // Spring Boot Application
  // 1. main code compile OK
  // ! 2. Server Start -> Component Scan, Create Component, Prepare SpringContext
  // 3. Runtime - Client (browser able to call the server)

  // Spring = DI (Dependency Injection) +IOC (Inverse of Control)
  // DI SPRING 會跟據ANNOTATION 去起OBJECT
  // IOC SPRINGBOOT 唔使再自己去NEW OBJECT
}
