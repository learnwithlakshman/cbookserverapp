package com.careerit.cbook.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthController {
	@PostMapping("/login")
	public String login() {
		return "Welcome to user";
	}

}
