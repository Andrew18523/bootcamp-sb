package com.bootcamp.demo.demo_restapi.util;

import java.util.ArrayList;
import java.util.List;
import com.bootcamp.demo.demo_restapi.model.dto.UserDto;

public class GeneralResponse<T> {
  private String code;
  private String message;
  private List<T> data;


  public static <U> Builder<U> builder(){
    return new Builder<>();
  }

  private GeneralResponse(Builder<T> builder){
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  public String getcode(){
    return this.code;
  }

  public String getMessage(){
    return this.message;
  }

  public List<T> getData(){
    return this.data;
  }

  public static class Builder<T>{
    private String code;
    private String message;
    private List<T> data;

    public Builder<T> status (SysCode sysCode){
      this.code = sysCode.getCode();
      this.message = sysCode.getMessage();
      if (sysCode == SysCode.FAIL){
        this.data = new ArrayList<>();
      }
      return this;
    }

    // public Builder<T> code (String code){
    //   this.code = code;
    //   return this;
    // }

    // public Builder<T> message (String message){
    //   this.message = message;
    //   return this;
    // }

    public Builder<T> data (List<T> data){
      this.data = data;
      return this;
    }

    public GeneralResponse<T> build(){
      if (this.code == null || this.message == null)
        throw new IllegalArgumentException();
      return new GeneralResponse<>(this);
    }
  }
  @Override
  public String toString(){
    return "GeneralResponse("
      + "code=" + this.code
      + "message=" + this.message
      + "data=" + this.data
      + ")";
  }

  public static void main(String[] args) {
    GeneralResponse<UserDto> response = GeneralResponse.<UserDto>builder() // define the type of static method with Generic
      .status(SysCode.FAIL)
      .data(List.of(new UserDto()))
      .build();

      System.out.println(response);
  }
}
