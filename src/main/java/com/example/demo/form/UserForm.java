package com.example.demo.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.sql.Update;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import lombok.Getter;
import lombok.Setter;

public class UserForm {

	@Getter
	@Setter
	private Integer userId;

	@Size(min = 1, max = 60)
	@NotNull
	@Getter
	@Setter
	private String name;

	@Size(min = 1, max = 60)
	@NotNull
	@Email
	@Getter
	@Setter
	private String email;

	@Size(min = 6, max = 60)
	@NotNull
	@Getter
	@Setter
	private String password;

}