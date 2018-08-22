package com.expensemanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.expensemanagement.authentication.CustomAuthFailureHandler;
import com.expensemanagement.authentication.CustomAuthSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private CustomAuthSuccessHandler customAuthSuccessHandler;
	
	@Autowired
	private CustomAuthFailureHandler customAuthFailureHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/resources/**","/assets/**","/signup","/login").permitAll()
		.anyRequest().permitAll()
		.and()
        //.authenticationProvider(authenticationProvider())
        .exceptionHandling()
        //.authenticationEntryPoint(authenticationEntryPoint)
        .and()
        .formLogin()
        .loginPage("/login.html") //redirect to my project login page instead of spring security login
        .permitAll()
        .loginProcessingUrl("/login")
        .usernameParameter("emailId")
        .passwordParameter("password")
        .successHandler(customAuthSuccessHandler)
        .failureHandler(customAuthFailureHandler)
        .and()
        .logout()
        .permitAll()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        //.logoutSuccessHandler(logoutSuccessHandler)
        .and()
        .sessionManagement()
        .maximumSessions(1);

		//http.authorizeRequests().anyRequest().authenticated();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
				.antMatchers("/static/**")
				.antMatchers("/resources/**");
	}
	
	@Bean(name="passwordEncoder")
	public PasswordEncoder passwordencoder(){
		return  new BCryptPasswordEncoder();
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordencoder());
    }
	
	
	@Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
    	return super.authenticationManagerBean();
    }
}
