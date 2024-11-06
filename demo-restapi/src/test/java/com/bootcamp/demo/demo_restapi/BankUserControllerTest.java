package com.bootcamp.demo.demo_restapi;


import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.bootcamp.demo.demo_restapi.controller.impl.BankUserController;
import com.bootcamp.demo.demo_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_restapi.mapper.BankMapper;
import com.bootcamp.demo.demo_restapi.services.UserServices;

//@SpringBootTest // @SpringBootTest is full Scale of Spring Context which test @Controller @Service etc.
@WebMvcTest // @WebMvcTest is not a full Scale test. A test spring enviroment
// consist of controller beans (web related) + some other bean for test (e.g MockMvc)
public class BankUserControllerTest {

  @Autowired
  private MockMvc mockMvc;

  // ! @Mock, @Autowired
  @MockBean
  private UserServices userServices;

  @SpyBean //我唔打算MOCK BANKMAPPER 嘅行為，而係直接用BANKMAPPER 嘅行為。所以用SPYBEAN
  private BankMapper bankMapper;

  @Test
  void testGetUserByUserName() throws Exception{
    // Postman -> URL - > Spring Boot Controller -> Service
    // MockMvc is similiar to Postman

    //Assumption
    UserEntity userEntity = UserEntity.builder().name("Betty").website("Betty.com").build();
    Mockito.when(userServices.getUserByUsername("John")).thenReturn(userEntity);

    // Test
    // this.mockMvc.perform(get("/user").param("username","John"))
    //   .andExpect(MockMvcResultMatchers.status().isOk())
    //   .andExpect(MockMvcResultMatchers.jsonPath("$.code", Matchers.is("000000")))
    //   .andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("Success.")))
    //   .andExpect(MockMvcResultMatchers.jsonPath("$.data.[*].name").value(Matchers.hasItem("Betty")))
    //   .andExpect(MockMvcResultMatchers.jsonPath("$.data.[*].website").value(Matchers.hasItem("Betty.com")));

    //After Static Inport
    this.mockMvc.perform(get("/user").param("username","John"))
    .andExpect(status().isOk())
    .andExpect(jsonPath("$.code", is("000000")))
    .andExpect(jsonPath("$.message", is("Success.")))
    .andExpect(jsonPath("$.data.[*].name").value(hasItem("Betty")))
    .andExpect(jsonPath("$.data.[*].website").value(hasItem("Betty.com")));
  }
}
