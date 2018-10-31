package com.wyk.sys.service;

import com.wyk.sys.entity.User;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author wyk
 * @since 2018-10-15
 */
public interface IUserService extends IService<User>, UserDetailsService {

}
