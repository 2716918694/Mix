package com.wyk.sys.mapper;

import com.wyk.sys.entity.User;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author wyk
 * @since 2018-10-15
 */
public interface UserMapper extends BaseMapper<User> {

//	@Select("select id, company_id, office_id, username, password, no, name, email, phone, mobile, user_type, login_ip, login_date, create_by, create_date, update_by, update_date, remarks, del_flag, status from "
//			+ "sys_user where username = #{username} and password = #{password}")
//	User confirmUser(@Param("username") String username,@Param("password") String password);

}
