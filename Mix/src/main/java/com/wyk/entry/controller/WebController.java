package com.wyk.entry.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	@GetMapping("/index")
	public String showIndex() {
		return "sys/index";
	}

	@GetMapping("/sys/user/index")
	public String showUserIndex() {
		return "sys/user/index";
	}

	@RequestMapping("/login")
	public String showLogin() {
		return "sys/login";
	}

	@RequestMapping("/register")
	public String showRegister() {
		return "sys/register";
	}
	
	@GetMapping("/logout")
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login";
	}
}
