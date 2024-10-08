package com.bootcamp.demo.demo_sb_calculator.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo.demo_sb_calculator.controller.CatOperation;
import com.bootcamp.demo.demo_sb_calculator.model.Cat;

@Controller
@ResponseBody
public class CatController implements CatOperation {
  
  @Autowired
  @Qualifier(value = "peter")
  private Cat cat; //object address -> spring context 'a cat object'
  @Override
  public String getCatName(){
    return this.cat.getName();
  }

  public Cat updateCatName(String newName){
    this.cat.setName(newName);
    return this.cat;
  }
}
