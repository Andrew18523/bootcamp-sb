package com.bootcamp.demo.tutorial_sbcalculator.exception;

public class InvalidOperationException extends IllegalArgumentException {
  private String messgae;

  public InvalidOperationException (String message){
    this.messgae = message;
  }
}
