package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.UserEntity;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<UserEntity> findAll() {
		return userRepository.findAll();
	}
	
	public UserEntity getById(Integer userId) {
		return userRepository.getOne(userId);
	}

}