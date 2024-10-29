package com.bootcamp.demo.demo_api_practice.infra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UriComponentsBuilder;

@Configuration
public class ApiUtil {
  
  @Value("${api.domain}")
  String domain;

  public String getUrl(Scheme shceme, String endpoint){
    return UriComponentsBuilder.newInstance()
            .scheme(shceme.name())
            .host(domain)
            .path(endpoint)
            .build(false)
            .toUriString();
  }
}
