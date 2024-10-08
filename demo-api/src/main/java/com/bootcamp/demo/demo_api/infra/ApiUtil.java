package com.bootcamp.demo.demo_api.infra;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UriComponentsBuilder;

@Configuration
public class ApiUtil {
  
  @Value("${api.domain}") // before server start, base on the path , 
  String domain;

  public String getUrl(Scheme scheme, String endpoint){
  String url = UriComponentsBuilder.newInstance()
  .scheme(scheme.name())
  .host(domain)
  .path(endpoint)
  .toUriString();
  System.out.println("CHECK " + url);
  return UriComponentsBuilder.newInstance()
  .scheme(scheme.name()) //http/https
  .host(domain) //xxx.com
  .path(endpoint)
  .build(false)
  .toUriString(); //組合API

  // public String getUrl(Scheme scheme, String endpoint, Map<String,String> requestParam){
  //   String url = UriComponentsBuilder.newInstance()
  //   .scheme(scheme.name())
  //   .host(domain)
  //   .path(endpoint)
  //   .toUriString();
  //     return UriComponentsBuilder.newInstance()
  //   .scheme(scheme.name())
  //   .host(domain)
  //   .path(endpoint)
  //   .queryParam("", requestParam.get(""))
  //   .toUriString(); //組合API
  // }
}
}
