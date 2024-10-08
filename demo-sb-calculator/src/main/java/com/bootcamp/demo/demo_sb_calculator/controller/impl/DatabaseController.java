package com.bootcamp.demo.demo_sb_calculator.controller.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo.demo_sb_calculator.controller.DatabaseOperation;
import com.bootcamp.demo.demo_sb_calculator.service.DatabaseService;

@Controller
@ResponseBody
public class DatabaseController implements DatabaseOperation {


  @Autowired
  private DatabaseService databaseService;

  @Override
  public String getString(int index){
    try{
    return databaseService.getString(index);
    } catch (NumberFormatException e){
      return "Invalid Index, Please try again";
    }
  }

  @Override
  public String addString (String newString){
    return databaseService.addString(newString);
  }

  @Override
  public List<String> getAllString (){
    return Arrays.stream(databaseService.getAllString())
        .collect(Collectors.toList());
  }

  @Override
  public int getSize (){
    return databaseService.getSize();
  }
}
