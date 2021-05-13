package com.qrcode.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@Configuration
@EnableWebSecurity
@Order(2)
public class WebSecurityConfig2 extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.antMatcher("/admin/**").authorizeRequests().antMatchers("/admin/**","/admin").hasRole("ADMIN")
		.and()
		.formLogin()//
			.loginProcessingUrl("/loginadmin")//
			.loginPage("/login2")//
			.defaultSuccessUrl("/admin/user/admin")//
			.failureUrl("/login2?message=error")//
			.usernameParameter("username")//
			.passwordParameter("password")
			.and().exceptionHandling().accessDeniedPage("/403")
			.and()
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login2?message=logout");
	}

}
