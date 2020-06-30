package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.common.AbstractUsingDBServiceTest;
import com.example.demo.entity.UserEntity;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest extends AbstractUsingDBServiceTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	@DatabaseSetup(value = "/testData/")
	public void findAll() {
		List<UserEntity> userList = userService.findAll();
		userList.stream().forEach(System.out::println);
		
		assertThat(userList.size()).isEqualTo(1);
	}
	
	@Test
	@DatabaseSetup(value = "/testData/")
	public void getById() {
		UserEntity user = userService.getById(1);
		System.out.println(user);
		
		UserEntity userEntity = new UserEntity();
		userEntity.setEmail("suzuki@example.com");
		
		assertThat(user.getEmail()).isEqualTo(userEntity.getEmail());
	}

}
