package com.example.demo.form;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Before;
import org.junit.Test;

public class UserFormTest {
	
	private UserForm userForm;
	private Validator validator;
	private Set<ConstraintViolation<UserForm>> violations;
	
	// 61文字
	private static final String MAX_OVER_LIMIT_TEXT_61 = "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHI";
	
	@Before
	public void init() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
		
		userForm = new UserForm();
		userForm.setName("suzuki");
		userForm.setEmail("suzuki@example.com");
		userForm.setPassword("suzuki123!");
	}
	
	
	@Test
	public void success() {
		violations = validator.validate(userForm);
		assertTrue( violations.isEmpty() );
	}
	
	
	// property : name -- NG Pattern --
	@Test
	public void failureNameNotNull() {
		userForm.setName(null);
		violations = validator.validate(userForm);
		assertFalse( violations.isEmpty() );
	}
	
	@Test
	public void failureNameSizeMin() {
		userForm.setName("");
		violations = validator.validate(userForm);
		assertFalse( violations.isEmpty() );
	}
	
	@Test
	public void failureNameSizeMax() {
		userForm.setName(MAX_OVER_LIMIT_TEXT_61);
		violations = validator.validate(userForm);
		assertFalse( violations.isEmpty() );
	}
	
	
	// property : email -- NG Pattern --
	@Test
	public void failureEmailNotNull() {
		userForm.setEmail(null);
		violations = validator.validate(userForm);
		assertFalse( violations.isEmpty() );
	}
	
	@Test
	public void failureEmailSizeMin() {
		userForm.setEmail("");
		violations = validator.validate(userForm);
		assertFalse( violations.isEmpty() );
	}
	
	@Test
	public void failureEmailSizeMax() {
		userForm.setEmail(MAX_OVER_LIMIT_TEXT_61);
		violations = validator.validate(userForm);
		assertFalse( violations.isEmpty() );
	}
	
	@Test
	public void failureEmailNotEmail() {
		userForm.setEmail("suzuki");
		violations = validator.validate(userForm);
		assertFalse( violations.isEmpty() );
	}
	
	
	// property : password -- NG Pattern --
	@Test
	public void failurePasswordNotNull() {
		userForm.setPassword(null);
		violations = validator.validate(userForm);
		assertFalse( violations.isEmpty() );
	}
	
	@Test
	public void failurePasswordSizeMin() {
		userForm.setPassword("12345");
		violations = validator.validate(userForm);
		assertFalse( violations.isEmpty() );
	}
	
	@Test
	public void failurePasswordSizeMax() {
		userForm.setPassword(MAX_OVER_LIMIT_TEXT_61);
		violations = validator.validate(userForm);
		assertFalse( violations.isEmpty() );
	}
	
}
