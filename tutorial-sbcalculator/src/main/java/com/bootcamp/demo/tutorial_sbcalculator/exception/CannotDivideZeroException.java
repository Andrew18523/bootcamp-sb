package com.bootcamp.demo.tutorial_sbcalculator.exception;

import lombok.Getter;

@Getter
public class CannotDivideZeroException extends IllegalArgumentException {
  private String messgae;

  public CannotDivideZeroException (String message){
    this.messgae = message;
  }

}
