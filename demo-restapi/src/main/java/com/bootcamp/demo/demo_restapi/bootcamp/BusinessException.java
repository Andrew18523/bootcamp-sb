package com.bootcamp.demo.demo_restapi.bootcamp;


//借 RuntimeException 來用

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
  private int code;

  public BusinessException (ErrorCode errorCode){
    this(errorCode.getCode(),errorCode.getMessage());
  }


  private BusinessException (int code, String message){
    super(message);
    this.code=code;
  }


}
