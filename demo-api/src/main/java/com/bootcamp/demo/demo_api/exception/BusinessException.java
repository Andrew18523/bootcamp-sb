package com.bootcamp.demo.demo_api.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
  private int code;

  public BusinessException(ErrorCode errorCode) {
    this(errorCode.getCode(), errorCode.getMessage());
  }

  public BusinessException(int code, String message) {
    super(message);
    this.code = code;
  }
}
