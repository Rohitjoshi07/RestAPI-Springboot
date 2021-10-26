package com.tcs.angular.creditcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import com.tcs.angular.creditcard.service.UserService;
import com.tcs.angular.creditcard.entity.UserDetails;
import com.tcs.angular.creditcard.exceptions.UserNotFoundException;


@RestController
public class UserController {
	@Autowired
	UserService service;

	@GetMapping("/user")
	public List<UserDetails> getAllUsers(){
		return service.getAllUsers();
	}

	@GetMapping("/user/{userName}")
	public UserDetails getAnUser(@PathVariable("userName") String userName ) {
		if(userName.equals(null))
			throw new UserNotFoundException();
		return service.getAnUserByUsername(userName);
	}

	@DeleteMapping("/user/{userName}")
	public void deleteAnUser(@PathVariable("userName") String userName) {
		if(userName.equals(null))
			throw new UserNotFoundException();
		service.deleteAnUser(userName);		
	}

	@PostMapping("/user")
	public void addUser(@RequestBody UserDetails user ) {
		service.addAnUser(user);
	}

	@PutMapping("/user")
	public void updateUser(@RequestBody UserDetails user, 
			@PathVariable("userName") String userName ){
		service.updateUser(userName, user);
	}


}
