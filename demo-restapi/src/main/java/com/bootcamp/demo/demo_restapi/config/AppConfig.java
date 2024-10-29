package com.bootcamp.demo.demo_restapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class AppConfig {
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  RedisTemplate<String, String> redisTemplate(){
    return new RedisTemplate<>();
  }

  @Bean
  ObjectMapper objectMapper(){
    return new ObjectMapper();
  }
}
