package com.bootcamp.demo.demo_restapi.bootcamp;

import lombok.Getter;

public enum SysCode {
  OK("000000","Success."),
  FAIL("900000","Fail."),
  ;

  private String code;
  private String message;

  private SysCode (String code, String message){
    this.code = code;
    this.message = message;
  }

  public String getCode(){
    return this.code;
  }
  public String getMessage(){
    return this.message;
  }
}
