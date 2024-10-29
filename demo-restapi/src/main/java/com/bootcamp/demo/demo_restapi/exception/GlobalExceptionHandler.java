package com.bootcamp.demo.demo_restapi.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.bootcamp.demo.demo_restapi.bootcamp.BusinessException;
import com.bootcamp.demo.demo_restapi.bootcamp.GeneralResponse;
import com.bootcamp.demo.demo_restapi.bootcamp.SysCode;

// Happy Flow: Method A call Method B call Method C to return C then B then return A
// Exception: Method A call Method B call Method C -> throw exception -> B handle exception
// For example, divided 0, it might happen many time. For Java, we have to try catch in lots of method.
// We can use Framework to handle all similiar exception (B-> Framework handle exception ->A, D-> Framework handle exception ->C)

@RestControllerAdvice //bean
public class GlobalExceptionHandler {
  
  //instrad of doing try catch in Controller, you are only able to return the same thing in the method.
  @ExceptionHandler(BusinessException.class)
  public ErrorResponse businessExceptionHandler (BusinessException e){
    return ErrorResponse.builder()
      .code(0)
      .message(e.getMessage())
      .build();
  }

  // 包括其他未知的EXCEPTION
  @ExceptionHandler(Exception.class)
  public GeneralResponse<Object> exceptionHandler (Exception e){
    return GeneralResponse.<Object>builder()
      .status(SysCode.FAIL)
      .build();
  }
}
