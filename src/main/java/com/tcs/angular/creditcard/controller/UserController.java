package com.tcs.angular.creditcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

import com.tcs.angular.creditcard.service.UserService;
import com.tcs.angular.creditcard.entity.Response;
import com.tcs.angular.creditcard.entity.UserDetails;
import com.tcs.angular.creditcard.exceptions.UserNotFoundException;

@RestController()
// @CrossOrigin()
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	@Autowired
	UserService service;

	@GetMapping("/user")
	public List<UserDetails> getAllUsers() {
		return service.getAllUsers();
	}

	@GetMapping("/user/{email}")
	public UserDetails getAnUser(@PathVariable("email") String email) {

		return service.getAnUser(email);
	}

	@DeleteMapping("/user/{email}")
	public void deleteAnUser(@PathVariable("email") String email) {
		if (email.equals(null))
			throw new UserNotFoundException();
		service.deleteAnUser(email);
	}

	@PostMapping("/user")
	public Response addUser(@RequestBody UserDetails user) {
		return service.addAnUser(user);
	}

//	@PutMapping("/user")
//	public Response updateUser(@RequestBody UserDetails user) {
//		return service.updateUser(user);
//	}

}
