package com.myproject.services;

import java.util.List;
import java.util.Map;

import com.myproject.pojo.User;

public interface UserService {
	List<User> findAll();
	
	Map<String,Object> registerUser(User user);
}
