package com.bootcamp.demo.demo_helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class helloworldController {
  
  @GetMapping(value = "/hello")
  public String greeting(){
    System.out.println("this is greeting!!"); // Log in the cmd which mean the function was run once, you wouldn't see in client side
    return "Hello World!!!!";
  }

  @GetMapping(value = "/goodbye")// path cannot be duplicated
  public String goodbye(){
    return "GoodBye!!!!!!!!";
  }
}
