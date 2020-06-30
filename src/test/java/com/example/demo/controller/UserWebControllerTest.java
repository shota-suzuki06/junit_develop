package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.form.UserForm;

public class UserWebControllerTest {
	
	private MockMvc mockMvc;
	
	private UserForm checkUserForm;
	
	@Before
	public void init() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new UserWebController())
									  .build();
		checkUserForm = new UserForm();
	}
	
	/**
	 * 1, 指定したリクエストにアクセス
	 * 2, 指定したview
	 * 3, modelに正しい値を詰められているか
	 */
	@Test
	public void index() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/user"))        // GETで /user にアクセスする
			   .andExpect(status().isOk())                          // レスポンスのステータスコードが 200 であることを検証する
			   .andExpect(view().name("user/index"))                // レスポンスVIEWが user/index であることを検証する
			   .andExpect(model().attribute("title", "ユーザ一覧"))    // 以下 modelに正しい値が詰められているか検証する
			   .andExpect(model().attribute("msg", "ユーザ一覧画面"));
	}
	
	@Test
	public void create() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/user/create"))
								  .andExpect(view().name("user/edit"))
								  .andExpect(model().attribute("title", "ユーザ新規作成"))
								  .andExpect(model().attribute("msg", "ユーザ新規作成画面"))
								  .andReturn();

		checkUserForm.setUserId(1);
		UserForm userForm = (UserForm) result.getModelAndView().getModel().get("user");
		assertEquals(userForm.getUserId(), checkUserForm.getUserId());
	}
	
}
