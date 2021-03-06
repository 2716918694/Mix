package com.wyk.sys;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.wyk.sys.entity.User;
import com.wyk.sys.service.IUserService;
import com.wyk.sys.utils.IpUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private HttpSession session;

	@Autowired
	private IUserService userService;
	
	@Autowired
    private HttpServletRequest request;


	/**
	 * Validate user info is correct form database
	 *
	 * @param authentication
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

		// 检查用户名密码是否正确
		User user = (User) userService.loadUserByUsername(username);
		if (user == null) {
			//Log.logError("{} login failed, username or password is wrong", username);
			throw new BadCredentialsException("Username or password is not correct 用户名或密码不正确");
		}
		// TODO 用户过期判断
		else if (!user.isEnabled()) {
			throw new AccountExpiredException("Account had expired 用户登陆信息已过期");
		}

		// //这里我们还要判断密码是否正确，实际应用中，我们的密码一般都会加密，以Md5加密为例
		// Md5PasswordEncoder md5PasswordEncoder=new Md5PasswordEncoder();
		// //这里第个参数，是salt
		// 就是加点盐的意思，这样的好处就是用户的密码如果都是123456，由于盐的不同，密码也是不一样的，就不用怕相同密码泄漏之后，不会批量被破解。
		// String encodePwd=md5PasswordEncoder.encodePassword(password, userName);
		// //这里判断密码正确与否
		if (!user.getPassword().equals(password)) {
			throw new BadCredentialsException("用户名或密码不正确");
		}
		String loginIp = IpUtil.getIpAddr(request);		
		LocalDateTime currentTime = LocalDateTime.now();
		
		user.setLoginIp(loginIp);
		user.setLoginDate(currentTime);
		userService.saveOrUpdate(user);
		
		// 用户信息有效时将其放入 session 中
		session.setAttribute("user", user);
		Authentication auth = new UsernamePasswordAuthenticationToken(user, password, grantedAuthorities);
		return auth;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
