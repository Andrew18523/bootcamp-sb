package com.bootcamp.demo.demo_sb_calculator.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@ResponseBody
public class CalculatorController {
  
  @GetMapping(value = "/sum/{x}/{y}")
  public int sum (@PathVariable int x,@PathVariable int y){
    return x+y;
  }
  @GetMapping(value = "/substract/{b}/{c}")
  public String substract (@PathVariable(value = "b") String x,@PathVariable(value = "c") String y){
    try {
      return String.valueOf(Long.parseLong(x)-Long.parseLong(y));
    } catch (NumberFormatException e){
      return "The input must be a Number";
    }
  }
  @GetMapping(value = "/multiply/{x}/{y}")
  public int multiply (@PathVariable int x,@PathVariable int y){
    return x*y;
  }
  @GetMapping(value = "/divide/{x}/{y}")
  public String divide (@PathVariable int x,@PathVariable int y){
    try{
      return String.valueOf(x/y);
    } catch (ArithmeticException e){
      return "Not Support by zero";
    }
    
  }
}
