package com.bootcamp.demo.tutorial_sbcalculator.services;

import java.math.BigDecimal;
import com.bootcamp.demo.tutorial_sbcalculator.model.APIRequest;
import com.bootcamp.demo.tutorial_sbcalculator.model.APIResponse;

public interface CalculatorServices {

  APIResponse calculator (BigDecimal x,BigDecimal y,String operation);
}
