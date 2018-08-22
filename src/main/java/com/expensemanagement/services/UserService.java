package com.expensemanagement.services;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.expensemanagement.pojo.User;

public interface UserService {
	List<User> findAll();
	
	Map<String,Object> registerUser(User user);
	
	User findByEmailId(String emailId);
	
	User getCurrentLoggedInUser(HttpServletRequest request);
}
