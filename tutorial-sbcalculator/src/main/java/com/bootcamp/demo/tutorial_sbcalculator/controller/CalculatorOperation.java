package com.bootcamp.demo.tutorial_sbcalculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.tutorial_sbcalculator.model.APIRequest;
import com.bootcamp.demo.tutorial_sbcalculator.model.APIResponse;

public interface CalculatorOperation {

  @GetMapping(value = "/operation")
  APIResponse calculator (@RequestParam String x,@RequestParam String y,@RequestParam String operation);

  @GetMapping(value = "/operation/{x}/{y}/{operation}")
  APIResponse calculator2 (@PathVariable String x,@PathVariable String y,@PathVariable String operation);

  @PostMapping(value = "/operation")
  APIResponse calculator3(@RequestBody APIRequest apiRequest);
}