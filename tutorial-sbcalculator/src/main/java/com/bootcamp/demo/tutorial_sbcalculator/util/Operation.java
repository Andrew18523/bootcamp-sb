package com.bootcamp.demo.tutorial_sbcalculator.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import com.bootcamp.demo.tutorial_sbcalculator.exception.CannotDivideZeroException;
import com.bootcamp.demo.tutorial_sbcalculator.exception.InvalidInputException;
import lombok.Getter;

@Getter
public enum Operation {
  ADD("add"),
  SUBTRACT("sub"),
  MULTIPLY("mul"),
  DIVIDE("div");

  private String operator;

  private Operation (String operator){
    this.operator = operator;
  }

  public String calculate (BigDecimal x, BigDecimal y){
  return switch (this){
    case ADD -> x.add(y).setScale(5).toString();
    case SUBTRACT -> x.subtract(y).setScale(5).toString();
    case MULTIPLY ->x.multiply(y).setScale(5).toString();
    case DIVIDE -> {
      if (BigDecimal.ZERO.equals(y)){
      throw new CannotDivideZeroException(ErrorCode.CANNOT_DIVIDE_ZERO.getMessage());
      }
      yield x.divide(y,5,RoundingMode.HALF_UP).toString();
    }
    default ->
    throw new InvalidInputException(ErrorCode.INVALID_INPUT.getMessage());
    };
  }
}
