package com.bootcamp.demo.demo_restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoRestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoRestapiApplication.class, args);
	}

}
