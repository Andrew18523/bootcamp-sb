package com.bootcamp.demo.tutorial_sbcalculator.services.impl;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.tutorial_sbcalculator.exception.InvalidOperationException;
import com.bootcamp.demo.tutorial_sbcalculator.model.APIResponse;
import com.bootcamp.demo.tutorial_sbcalculator.services.CalculatorServices;
import com.bootcamp.demo.tutorial_sbcalculator.util.ErrorCode;
import com.bootcamp.demo.tutorial_sbcalculator.util.Operation;

@Service
public class CalculatorServicesHolder implements CalculatorServices {

  @Override
  public APIResponse calculator (BigDecimal x,BigDecimal y,String operation){
    Operation op = this.map(operation);
    return APIResponse.builder()
            .x(String.valueOf(x))
            .y(String.valueOf(y))
            .operation(op.getOperator())//
            .result(op.calculate(x, y))
            .build();
  }

  private Operation map(String operator){
    for (Operation op: Operation.values()){
      if (op.getOperator().equals(operator)){
        return op;
      }
    }
    throw new InvalidOperationException(ErrorCode.INVALID_OPERATOR.getMessage());
  }

}
