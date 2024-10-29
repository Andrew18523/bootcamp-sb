package com.bootcamp.demo.demo_restapi;

import static org.hamcrest.Matchers.is;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.bootcamp.demo.demo_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_restapi.repository.UserRepository;
import com.bootcamp.demo.demo_restapi.services.UserServices;

@SpringBootTest
public class UserServiceTest {
  @Autowired
  private UserServices userServices;

  @MockBean
  private UserRepository userRepository;

  @Test
  void testGetUserByUserName(){

    //Assumption
    UserEntity userEntity = UserEntity.builder().name("Betty").website("Betty.com").build();
    Mockito.when(this.userRepository.findByUsername("John")).thenReturn(userEntity);

    //test
    UserEntity result =this.userServices.getUserByUsername("John");
    MatcherAssert.assertThat(result.getName(),is("Betty"));

  }
}
