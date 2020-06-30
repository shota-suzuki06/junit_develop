package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;

@RestController
@RequestMapping(value = "/api/user")
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping()
	public List<UserEntity> findAll() {
		return userService.findAll();
	}
	
	@GetMapping("/{user_id}")
	public UserEntity getById(@PathVariable("user_id")Integer userId) {
		return userService.getById(userId);
	}

}