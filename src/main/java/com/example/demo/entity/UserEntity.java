package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Table(name = "user")
@Entity
public class UserEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "user_id", updatable = false)
	@Getter
	@Setter
	private Integer userId;
	
	@Column(name = "name")
	@Getter
	@Setter
	private String name;
	
	@Column(name = "email")
	@Getter
	@Setter
	private String email;
	
	@Column(name = "password")
	@Getter
	@Setter
	private String password;

}