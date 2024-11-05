package com.bootcamp.demo.bc_forum.util;

public enum Scheme {
  HTTP("http"),
  HTTPS("https"),;

  private String scheme;

  private Scheme(String scheme){
    this.scheme = scheme;
  }
}
