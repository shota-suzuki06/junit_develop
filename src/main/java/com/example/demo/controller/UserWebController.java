package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.UserForm;

@Controller
@RequestMapping(value = "/user")
public class UserWebController {
	
	@GetMapping()
	public String index(Model model) {
		model.addAttribute("title", "ユーザ一覧");
		model.addAttribute("msg", "ユーザ一覧画面");
		return "user/index";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("title", "ユーザ新規作成");
		model.addAttribute("msg", "ユーザ新規作成画面");
		UserForm userForm = new UserForm();
		userForm.setUserId(1);
		model.addAttribute("user", userForm);
		return "user/edit";
	}

}
