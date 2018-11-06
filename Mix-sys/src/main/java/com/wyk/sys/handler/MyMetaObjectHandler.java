package com.wyk.sys.handler;

import java.time.LocalDateTime;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.wyk.sys.entity.User;
import com.wyk.sys.utils.SecurityUtils;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyMetaObjectHandler.class);

	private static LocalDateTime currentTime = LocalDateTime.now();
	
	@Autowired
	private HttpSession session;
	
	@Override
	public void insertFill(MetaObject metaObject) {
		
		LOGGER.info("start insert fill ....");
		User currentUser = SecurityUtils.getCurrentUser();
		String changeBy = currentUser!=null?currentUser.getUsername():"self";
		this.setFieldValByName("createDate", currentTime, metaObject);
		this.setFieldValByName("createBy", changeBy, metaObject);

	}
	
	@Override
	public void updateFill(MetaObject metaObject) {
		
		LOGGER.info("start insert fill ....");
		User currentUser = SecurityUtils.getCurrentUser();
		String changeBy = currentUser!=null?currentUser.getUsername():"self";	
		this.setFieldValByName("updateDate", currentTime, metaObject);
		this.setFieldValByName("updateBy", changeBy, metaObject);
	}

}
