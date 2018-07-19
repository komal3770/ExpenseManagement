package com.expensemanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		//.antMatchers("/signup")
		.antMatchers(
				"/home","/signup",
                "/users/registration",
                "/js/**",
                "/css/**",
                "/color/**",
                "/fonts/**",
                "/ico/**",
                "/img/**")
		.permitAll()
		.anyRequest().authenticated()
        .and().formLogin().loginPage("/login").permitAll().and()
        .csrf().disable();
	}
	
	@Bean(name="passwordEncoder")
	public PasswordEncoder passwordencoder(){
		return  new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
				.antMatchers("/static/**")
				.antMatchers("/resources/**");
	}
}
