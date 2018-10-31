package com.wyk.sys.service.impl;

import com.wyk.sys.entity.User;
import com.wyk.sys.mapper.UserMapper;
import com.wyk.sys.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author wyk
 * @since 2018-10-15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

//	@Autowired
//	UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		return getOne(new QueryWrapper<User>()
                .lambda().eq(User::getUsername, arg0),false);
	}

//	@Override
//	public User loadUserByUsernameAndPassword(String username, String password) {
//		return userMapper.confirmUser(username, password);
//	}
	
}
