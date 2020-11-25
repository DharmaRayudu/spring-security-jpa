package com.learn.org.springsecurityjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learn.org.springsecurityjpa.model.User;
import com.learn.org.springsecurityjpa.repository.UserRepository;

@Service
public class CustomeUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(userName);
		CustomeUserDetails userDetails = null;
		
		if(user !=null) {
			userDetails = new CustomeUserDetails();
			userDetails.setUser(user);
		}else {
			throw new UsernameNotFoundException("User not exit with name:"+ userName);
		}
		return userDetails;
	}

}
