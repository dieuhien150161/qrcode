package com.qrcode.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@Order(1)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/user/**").hasRole("USER").and()
		.authorizeRequests().antMatchers("/register", "/trangchu").permitAll()
				.antMatchers("/","/home","/user","/user/**").hasRole("CLIENT")
				.and()
				.formLogin()
					.loginPage("/login1")
					.loginProcessingUrl("/login")
					.usernameParameter("email")
					.passwordParameter("password")
					.defaultSuccessUrl("/")
					.failureUrl("/login1?error")
				.and().
				logout()
					.logoutUrl("/logout")
					.logoutSuccessUrl("/login1?message=logout")
				.and()
				.exceptionHandling().accessDeniedPage("/403")
				.and().httpBasic();
	}

}
