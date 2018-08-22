package com.expensemanagement.services;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.expensemanagement.dao.UserRepository;
import com.expensemanagement.pojo.User;
import com.expensemanagement.utility.Constants;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private NextSequenceService nextSequenceService;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
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
			User existingUser = userRepository.findByEmailId(user.getEmailId());
			if(existingUser == null){
				String encodedPassword = passwordEncoder.encode(user.getPassword());
				user.setId(nextSequenceService.getNextSequence(Constants.SEQ_KEY_USER_ID));
				user.setPassword(encodedPassword);
				System.out.println(user);
				userRepository.save(user);
				status=1;
				msg = "Registered Successfully";
			}
			else{
				status=0;
				msg = "EmailId already exist";
			}
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

	@Override
	public User findByEmailId(String emailId) {
		return userRepository.findByEmailId(emailId);
	}

	public User getCurrentLoggedInUser(HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
		if(principal!=null){
			UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
			if(userDetails!=null){
				User user = userRepository.findByEmailId(userDetails.getUsername());
				return user;
			}
		}
		return null;
	}

}
