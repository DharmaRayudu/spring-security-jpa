package com.learn.org.springsecurityjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.org.springsecurityjpa.model.User;
import com.learn.org.springsecurityjpa.repository.UserRepository;

@RestController
@RequestMapping("/secure/rest")
public class AdminController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@PreAuthorize("hasAnyRole('ADMIN')")
	@PostMapping("/admin/add")
	public String addUserByAdmin(@Validated @RequestBody User user) {

		String pwd = user.getPassword();
		String encriptedPassword = passwordEncoder.encode(pwd);
		user.setPassword(encriptedPassword);

		userRepository.save(user);
		return "User added successfully...";
	}

}
