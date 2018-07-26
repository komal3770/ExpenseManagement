package com.expensemanagement.services;

import java.util.List;
import java.util.Map;

import com.expensemanagement.pojo.User;

public interface UserService {
	List<User> findAll();
	
	Map<String,Object> registerUser(User user);
	
	User findByEmailId(String emailId);
}
