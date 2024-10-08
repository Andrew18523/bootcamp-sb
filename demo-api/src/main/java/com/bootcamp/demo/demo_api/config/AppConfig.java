package com.bootcamp.demo.demo_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration // -> @Bean -> SpringContext -> Autowired
public class AppConfig {
  
  // Call API
  @Bean //became unique object
  RestTemplate restTemplate(){
    return new RestTemplate();
  }
}
