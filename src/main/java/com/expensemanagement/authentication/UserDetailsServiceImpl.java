package com.expensemanagement.authentication;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.expensemanagement.dao.UserRepository;
import com.expensemanagement.pojo.User;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmailId(username);
		if(user!=null){
			Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
	        /*for (Role role : user.getRoles()){
	            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
	        }*/
			org.springframework.security.core.userdetails.User loggedInUser = 
					new org.springframework.security.core.userdetails.User(user.getEmailId(), user.getPassword(), grantedAuthorities);
			
			return loggedInUser;
		}
		else{
			throw new UsernameNotFoundException("Bad Credentials");
		}
	}

}
