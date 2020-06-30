package com.example.demo.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.UserEntity;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void findAll() {
		List<UserEntity> userList = userRepository.findAll();
		userList.stream().forEach(System.out::println);

		assertThat(userList.size()).isEqualTo(2);
	}
	
	@Test
	public void findOne() {
		UserEntity user = userRepository.getOne(1);
		System.out.println(user);

		UserEntity userEntity = new UserEntity();
		userEntity.setName("suzuki");
		assertThat(user.getName()).isEqualTo(userEntity.getName());
	}

}
