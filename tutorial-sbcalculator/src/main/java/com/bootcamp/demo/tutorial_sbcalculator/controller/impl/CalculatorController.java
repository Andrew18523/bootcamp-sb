package com.bootcamp.demo.tutorial_sbcalculator.controller.impl;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.tutorial_sbcalculator.controller.CalculatorOperation;
import com.bootcamp.demo.tutorial_sbcalculator.model.APIRequest;
import com.bootcamp.demo.tutorial_sbcalculator.model.APIResponse;
import com.bootcamp.demo.tutorial_sbcalculator.services.CalculatorServices;

@RestController
public class CalculatorController implements CalculatorOperation {
  
  @Autowired
  CalculatorServices calculatorServices;

  public APIResponse calculator (String x,String y,String operation){
    return calculatorServices.calculator(BigDecimal.valueOf(Double.valueOf(x)), BigDecimal.valueOf(Double.valueOf(y)), operation);
  }

  public APIResponse calculator2 (String x,String y,String operation){
    return calculatorServices.calculator(BigDecimal.valueOf(Double.valueOf(x)), BigDecimal.valueOf(Double.valueOf(y)), operation);
  }

  public APIResponse calculator3(APIRequest apiRequest){
    return calculatorServices.calculator(BigDecimal.valueOf(Double.valueOf(apiRequest.getX()))
      , BigDecimal.valueOf(Double.valueOf(apiRequest.getY())),
      apiRequest.getOperation());
  }
}
