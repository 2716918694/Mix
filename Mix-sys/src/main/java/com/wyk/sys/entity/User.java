package com.wyk.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author wyk
 * @since 2018-10-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("sys_user")
public class User extends BaseEntity implements UserDetails {

	private static final long serialVersionUID = 1L;

	/**
	 * 归属公司
	 */
	private Long companyId;

	/**
	 * 归属部门
	 */
	private Long officeId;

	/**
	 * 登录名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 工号
	 */
	private String no;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 电话
	 */
	private String phone;

	/**
	 * 手机
	 */
	private String mobile;

	/**
	 * 用户类型(0.普通 1.系统超级管理员)
	 */
	private String userType;

	/**
	 * 最后登陆IP
	 */
	private String loginIp;

	/**
	 * 最后登陆时间
	 */
	private LocalDateTime loginDate;
	
	/**
	 * 备注信息
	 */
	private String remarks;

	/**
	 * 删除标记
	 */
	private String delFlag;

	private String status;

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public LocalDateTime getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(LocalDateTime loginDate) {
		this.loginDate = loginDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public User() {
		super();
	}

	public User(Long companyId, Long officeId, String username, String password, String no, String name, String email,
			String phone, String mobile, String userType, String loginIp, LocalDateTime loginDate, String createBy,
			LocalDateTime createDate, String updateBy, LocalDateTime updateDate, String remarks, String delFlag,
			String status) {
		super();
		this.companyId = companyId;
		this.officeId = officeId;
		this.username = username;
		this.password = password;
		this.no = no;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.mobile = mobile;
		this.userType = userType;
		this.loginIp = loginIp;
		this.loginDate = loginDate;
		this.remarks = remarks;
		this.delFlag = delFlag;
		this.status = status;
	}

	@Override
	public String toString() {
		return this.username;
	}

	@Override
	public int hashCode() {
		return username.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return this.toString().equals(obj.toString());
	}

}
