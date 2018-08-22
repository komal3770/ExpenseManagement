package com.expensemanagement.controllers;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.expensemanagement.pojo.User;
import com.expensemanagement.services.UserService;

@RequestMapping(value="/users")
@RestController
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@RequestMapping(value="/findAll")
	private List<User> findAll(){
		return userService.findAll();
	}
	
	@RequestMapping(value="/registration",method = RequestMethod.POST)
	private Map<String, Object> registration(@RequestBody User user){
		return userService.registerUser(user);
	}
	
	@RequestMapping(value="/getCurrentlyLoggedInUser",method = RequestMethod.POST)
	private UserDetails getCurrentlyLoggedInUser(Principal principal){
		UserDetails user = userDetailsService.loadUserByUsername(principal.getName());
		return user;
	}
}
