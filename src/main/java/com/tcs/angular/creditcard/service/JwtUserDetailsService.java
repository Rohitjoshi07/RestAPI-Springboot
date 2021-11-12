package com.tcs.angular.creditcard.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tcs.angular.creditcard.entity.Response;
import com.tcs.angular.creditcard.entity.UserDao;
import com.tcs.angular.creditcard.entity.UserDto;
import com.tcs.angular.creditcard.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDao user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}

	public Response save(UserDto user) {
		UserDao newUser = new UserDao();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		userDao.save(newUser);
		return new Response("OK","User registrered successfully");
	}
	
	public Response verifyCheckUser(UserDto user) {
		if (userDao.existsById(user.getUsername())) {
			return new Response("Bad-Request", "User Already Exit");
		} else {
			// userAuthRepo.save(user);
			return new Response("ok", "Allowing to Add new user");
		}
	}
}