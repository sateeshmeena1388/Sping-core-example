package com.mhb.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Resource(name="jofb")
	private DataSource ds;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception
	{
		System.out.println("SecurityConfig:configAuthentication(-)"+ds.getClass());
		auth.jdbcAuthentication().dataSource(ds).usersByUsernameQuery("select uname,pwd,status from users where uname=?").authoritiesByUsernameQuery("select role_id,role from users_roles where role_id=?");
		
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		System.out.println("SecurityConfig:configure(-)");
		// TODO Auto-generated method stub
		http.authorizeRequests().antMatchers("/home.htm").access("permitAll")
		.antMatchers("/inbox.htm").access("hasRole('ROLE_OWNER') or hasRole('ROLE_ADMIN')")
		.and().formLogin().and().logout().logoutUrl("/home.htm").and().exceptionHandling().
		accessDeniedPage("/error.jsp");
		
	}
}
