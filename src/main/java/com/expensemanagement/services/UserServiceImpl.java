package com.expensemanagement.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.expensemanagement.dao.UserRepository;
import com.expensemanagement.pojo.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Map<String, Object> registerUser(User user) {
		Map<String, Object> resp = new HashMap<>();
		String msg = validateUser(user);
		int status=0;
		if(msg==null){
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			userRepository.save(user);
			status=1;
			msg = "Registered Successfully";
		}
		resp.put("message", msg);
		resp.put("status", status);
		return resp;
	}
	
	public static String validateUser(User user){
		String msg = null;
		if(user!=null){
			if(user.getEmailId()==null){
				msg = "EmailId is empty";
			}
			else if(user.getPassword()==null){
				msg = "Password is empty";
			}
			else if(user.getMobileNo()==null){
				msg = "MobileNo. is empty";
			}
		}
		else{
			msg = "User details are empty";
		}
		return msg;
	}

}
