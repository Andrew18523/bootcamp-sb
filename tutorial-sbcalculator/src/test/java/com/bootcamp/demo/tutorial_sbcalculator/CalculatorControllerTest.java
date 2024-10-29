package com.bootcamp.demo.tutorial_sbcalculator;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.bootcamp.demo.tutorial_sbcalculator.controller.impl.CalculatorController;
import com.bootcamp.demo.tutorial_sbcalculator.model.APIRequest;
import com.bootcamp.demo.tutorial_sbcalculator.model.APIResponse;
import com.bootcamp.demo.tutorial_sbcalculator.services.CalculatorServices;
import com.fasterxml.jackson.databind.ObjectMapper;

//@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CalculatorServices calculatorServices;

  @Test
  void testCalculate3Add() throws Exception{
    APIRequest mockApiRequest = APIRequest.builder()
                                          .x("1")
                                          .y("2")
                                          .operation("add")
                                          .build();

    APIResponse mockApiResponse = APIResponse.builder()
                                          .x("1")
                                          .y("2")
                                          .operation("add")
                                          .result("3")
                                          .build();

    BigDecimal convertx = BigDecimal.valueOf(Double.valueOf(mockApiRequest.getX()));
    BigDecimal converty = BigDecimal.valueOf(Double.valueOf(mockApiRequest.getY()));

    Mockito.when(calculatorServices.calculator(convertx, converty, mockApiRequest.getOperation()))
      .thenReturn(mockApiResponse);

    mockMvc.perform(//
        MockMvcRequestBuilders.post("/operation")//
            .contentType(MediaType.APPLICATION_JSON_VALUE)//
            .content(//
                new ObjectMapper().writeValueAsString(mockApiRequest)))//
        .andExpect(MockMvcResultMatchers.jsonPath("$.x").value("1"))//
        .andExpect(MockMvcResultMatchers.jsonPath("$.y").value("2"))//
        .andExpect(MockMvcResultMatchers.jsonPath("$.operation").value("add"))//
        .andExpect(MockMvcResultMatchers.jsonPath("$.result").value("3.0"))//
        .andExpect(MockMvcResultMatchers.status().isOk())//
        .andExpect(MockMvcResultMatchers.content().json(
            "{\"x\":\"1\",\"y\":\"2\",\"operation\":\"add\",\"result\":\"3.0\"}"));
    
  }
}
