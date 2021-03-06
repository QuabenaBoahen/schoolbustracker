package com.rosebrakoh.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@EnableGlobalMethodSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/icons/**", "/jquery-datatables-editable/**",
				"/vendor/**", "/app.css", "/app.js", "/bootbox.min.js", "/favicon.png", "/jquery.validate.js");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/h2-console/**", "/all-students/**","/authenticate/**", 
				"/save-bus-boarding/**", "/get-bus-boarding/**").permitAll()
		.antMatchers("/parents", "/users", "/students").hasAnyRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.permitAll()
		.and()
        .exceptionHandling()
        .accessDeniedPage("/403_error")
        .and()
        .csrf().disable();
        /*.headers().frameOptions().disable();*/
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		/*.inMemoryAuthentication()
		.withUser("rose")
		.password("rose123")
		.roles("ADMIN");*/
		.userDetailsService(userDetailsService);
	}
   

}
