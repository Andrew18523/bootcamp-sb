package com.bootcamp.demo.demo_restapi.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


// somewhere there is a program Autowired CommandLineRunner
// @Autowired(required = false)
// private CommandLineRunner commandLineRunner;

// if (commendLineRunner != null)
//    commendLineRunner.run();

@Component // create bean for AppStartRunner.class but it is not controller, services or configuration
public class AppStartRunner implements CommandLineRunner {
  // ! CommendLineRunner is used for something must be done before server starts

  @Override
  public void run(String... args) throws Exception{
    System.out.println("Hello world!!!!!");
    // throw new Exception();
  }
}
