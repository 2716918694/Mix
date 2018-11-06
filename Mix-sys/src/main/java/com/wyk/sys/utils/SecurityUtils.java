package com.wyk.sys.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.wyk.sys.entity.User;

public class SecurityUtils {

	public static User getCurrentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth.getPrincipal() instanceof User))
			return null;
		return (User) auth.getPrincipal();
	}

}