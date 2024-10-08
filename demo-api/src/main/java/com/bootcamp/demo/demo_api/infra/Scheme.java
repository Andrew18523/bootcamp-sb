package com.bootcamp.demo.demo_api.infra;

import lombok.Getter;

@Getter
public enum Scheme {
  HTTP("http"), //
  HTTPS("https"), //
  ;

  private String protocol;

  Scheme(String protocol) {
    this.protocol = protocol;
  }
}
