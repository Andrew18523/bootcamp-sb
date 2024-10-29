package com.bootcamp.demo.demo_api.exception;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class ErrorResponse  {
  private int code;
  private String message;
}
