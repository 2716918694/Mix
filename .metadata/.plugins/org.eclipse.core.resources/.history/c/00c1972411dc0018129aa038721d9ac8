package com.wyk.sys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.web.bind.annotation.GetMapping;
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
		return success(test);
	}

	/**
	 * <p>
	 * 測試DML語句
	 * </p>
	 * 测试地址： http://localhost:8088/sys/user/test2
	 */

	@GetMapping("/test2")
	public Result<String> test2() {
		User user = new User("test1", "111111");
		System.err.println("插入一条数据：" + userService.save(user));
		System.err.println("删除一条数据：" + userService.removeById(1L));
		boolean result = false;
		for (int i = 0; i < 10; i++) {
			user = new User("test" + i, "11111" + i);
			result = userService.save(user);
			System.err.println(result ? "over" : "no good");
		}

		// 自动回写的ID
		return success(result ? "over" : "no good");

	}

	@GetMapping("/update")
	public Result<String> update() {

		User user = new User("tt", "111222");
		boolean result = userService.saveOrUpdate(user);
		return success(result ? "over" : "no good");

	}

	@GetMapping("/loadUser")
	public User loadByName(String username) {

		return (User) userService.loadUserByUsername(username);

	}

	@GetMapping("/findAll")
	public IPage<User> listUser() {

		return userService.page(new Page<User>(0, 4), null);

	}
	
	@GetMapping("/online")
	public List<Object> online(){
		System.out.println(sessionRegistry.getAllPrincipals().size());
		return sessionRegistry.getAllPrincipals();
		
	}
	
//	@Deprecated
//	@PostMapping("/confirm")
//	public boolean loginConfirm(String username, String password) {
//		User authentication = userService.getOne(
//				new QueryWrapper<User>().lambda().eq(User::getUsername, username).eq(User::getPassword, password),
//				false);
//		if (authentication != null) {
//			return true;
//		}
//		return false;
//	}
}
