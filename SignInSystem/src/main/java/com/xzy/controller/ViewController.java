package com.xzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
	@RequestMapping("/login.view")
	public String loginView() {
		return "login";
	}

	@RequestMapping("/save.view")
	public String saveView() {
		return "save";
	}

	@RequestMapping("/error.view")
	public String errorView() {
		return "error";
	}
}
