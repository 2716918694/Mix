package com.wyk.sys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wyk.common.api.ApiController;
import com.wyk.common.api.Result;
import com.wyk.sys.entity.User;
import com.wyk.sys.service.IUserService;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author wyk
 * @since 2018-10-15
 */
@RestController
@RequestMapping("/sys/user")
public class UserController extends ApiController {

	@Autowired
	private SessionRegistry sessionRegistry;

	@Autowired
	private IUserService userService;

	/**
	 * <p>
	 * 测试通用 Api Controller 逻辑
	 * </p>
	 * 测试地址： http://localhost:8088/sys/user/api
	 * http://localhost:8088/sys/user/api?test=mybatisplus
	 */
	@GetMapping("/api")
	public Result<String> testError(String test) {
		User user = new User("test1113", "111222");
		boolean result = userService.saveOrUpdate(user);
		return success(result ? "over" : "no good");
	}

	/**
	 * 对用户进行注册或修改
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("/saveUser")
	public Result<String> update(@ModelAttribute(value = "user") User user) {
		boolean result = userService.saveOrUpdate(user);
		return success(result ? "over" : "no good");

	}

	/**
	 * 根据用户名获取用户
	 * 
	 * @param username
	 * @return
	 */
	@GetMapping("/loadUser")
	public User loadByName(String username) {

		return (User) userService.loadUserByUsername(username);

	}

	/**
	 * 分页查询用户
	 * 
	 * @return
	 */
	@GetMapping("/findAll")
	public IPage<User> listUser(Integer page, Integer pageSize) {

		return userService.page(new Page<User>((page - 1) * pageSize, pageSize), null);

	}

	@GetMapping("/onlineUser")
	public List<Object> online() {
		System.out.println(sessionRegistry.getAllPrincipals().size());
		return sessionRegistry.getAllPrincipals();

	}

	// @Deprecated
	// @PostMapping("/confirm")
	// public boolean loginConfirm(String username, String password) {
	// User authentication = userService.getOne(
	// new QueryWrapper<User>().lambda().eq(User::getUsername,
	// username).eq(User::getPassword, password),
	// false);
	// if (authentication != null) {
	// return true;
	// }
	// return false;
	// }
}
