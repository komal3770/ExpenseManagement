package com.expensemanagement.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value="/findAll")
	private List<User> findAll(){
		return userService.findAll();
	}
	
	@RequestMapping(value="/registration",method = RequestMethod.POST)
	private Map<String, Object> registration(@RequestBody User user){
		return userService.registerUser(user);
	}
}
