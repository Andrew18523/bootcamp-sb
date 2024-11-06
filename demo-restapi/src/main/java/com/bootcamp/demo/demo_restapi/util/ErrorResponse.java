package com.bootcamp.demo.demo_restapi.util;

//用呢一個CLASS 去THROW 出去

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {
  private int code;
  private String message;
}
