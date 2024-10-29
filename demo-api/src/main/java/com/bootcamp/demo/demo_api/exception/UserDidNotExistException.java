package com.bootcamp.demo.demo_api.exception;

public class UserDidNotExistException extends BusinessException {
  private int code;

  public UserDidNotExistException(ErrorCode errorCode) {
    super(errorCode);
    this.code=errorCode.getCode();
  }
}
