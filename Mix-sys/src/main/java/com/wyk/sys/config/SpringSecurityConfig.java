package com.wyk.sys.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import com.personal.filter.QQAuthenticationFilter;
//import com.personal.filter.QQAuthenticationManager;
//import com.personal.sys.CustomAuthenticationProvider;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import com.wyk.sys.CustomAuthenticationProvider;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;
	
	@Autowired
	private SessionRegistry sessionRegistry;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 所有请求均可访问
        http.authorizeRequests()
                .antMatchers("/","/vendor/**","/css/**", "/js/**","/img/*","/images/**", "/webjars/**", "**/favicon.ico",
                		"/register","/sys/user/saveUser","/register","/logout","/login","/static/**","/index")
                .permitAll().and()
                .formLogin().loginPage("/login")//.loginProcessingUrl("/sys/user/confirm")
                // 配置登录页面的表单 action 必须是 '/login', 用户名和密码的参数名必须是 'username' 和 'password'，
                // 登录失败的 url 是 '/user/login-error'
                .usernameParameter("username").passwordParameter("password")
                //设置默认登录成功跳转页面
                .defaultSuccessUrl("/sys/user/index").failureUrl("/login?error=true").permitAll()
                .and()
                //开启cookie保存用户数据
                .rememberMe()
                //设置cookie有效期
                .tokenValiditySeconds(60 * 60 * 24 * 7)
                //设置cookie的私钥
                .key("123")
                .and()
                .csrf().disable()
//关闭CSRF
//                .csrf().requireCsrfProtectionMatcher(new RequestMatcher() {
//                    @Override
//                    public boolean matches(HttpServletRequest httpServletRequest) {
//                        String servletPath = httpServletRequest.getServletPath();
//                        if (servletPath.contains("/druid")) {
//                            return false;
//                        }
//                        return true;
//                    }
//                }).and()
                .logout()
                //默认注销行为为logout，可以通过下面的方式来修改
                .logoutUrl("/logout")
                //设置注销成功后跳转页面，默认是跳转到登录页面
                //.logoutSuccessUrl("/login")
                .permitAll()
                .and()
                .sessionManagement().maximumSessions(1).sessionRegistry(sessionRegistry);
                
        // 其余所有请求均需要权限
        http.authorizeRequests()
        		// ROLE_USER的权限才能访问的资源
		        //.antMatchers("/user/**").hasRole("USER")
		        // 任何尚未匹配的URL只需要验证用户即可访问
                .anyRequest()
                .authenticated()
                .and()
                .authorizeRequests()
                .antMatchers("/sys/**")
                .authenticated()
                .antMatchers(HttpMethod.POST)
                .authenticated()
                .antMatchers(HttpMethod.PUT)
                .authenticated()
                .antMatchers(HttpMethod.DELETE)
                .authenticated()
                .antMatchers("/**")
                .permitAll();
        
        // 在 UsernamePasswordAuthenticationFilter 前添加 QQAuthenticationFilter
        //http.addFilterAt(qqAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	
	 @Autowired
     public void configureGlobal(AuthenticationManagerBuilder auth) {
         // 使用自定义的 Authentication Provider
         auth.authenticationProvider(customAuthenticationProvider);
     }
	 
	@Bean
	public SessionRegistry getSessionRegistry(){
	    SessionRegistry sessionRegistry=new SessionRegistryImpl();
	    return sessionRegistry;
	}
	
	@Bean
    public ServletListenerRegistrationBean httpSessionEventPublisher() {
        return new ServletListenerRegistrationBean(new HttpSessionEventPublisher());
    }

	
	 /**
	  * 自定义 QQ登录 过滤器
	  */
//	  private QQAuthenticationFilter qqAuthenticationFilter(){
//		  QQAuthenticationFilter authenticationFilter = new QQAuthenticationFilter("/login/qq");
//		  SimpleUrlAuthenticationSuccessHandler successHandler = new SimpleUrlAuthenticationSuccessHandler();
//		  successHandler.setAlwaysUseDefaultTargetUrl(true);
//		  successHandler.setDefaultTargetUrl("/user/index");
//		  //MyAuthenticationSuccessHandler successHandler = new MyAuthenticationSuccessHandler();
//		  authenticationFilter.setAuthenticationManager(new QQAuthenticationManager());
//		  authenticationFilter.setAuthenticationSuccessHandler(successHandler);
//		  return authenticationFilter;
//	  }
}