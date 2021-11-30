package com.tcs.angular.creditcard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.angular.creditcard.exceptions.*;
import com.tcs.angular.creditcard.repository.UserDetailsRepo;
import com.tcs.angular.creditcard.entity.Response;
import com.tcs.angular.creditcard.entity.UserDetails;

@Service
public class UserService {

	@Autowired
	UserDetailsRepo userRepo;

	public List<UserDetails> getAllUsers() {
		// userRepo.save(new UserDetails("Avinash","gadekaraavi@gmail.com","06/11/1997",
		// "7040753196" ,"BCDF4325D","123456782345",2,"raje sambhaji nagar"));
		userRepo.save(new UserDetails("rohan", "abc@gmail.com", "20/6/1999", "8478561248", "QEREk4789J", "789456781234",
				2, "ambica vihar, phase 2, haldwani", "card1"));
		return userRepo.findAll();
	}

	public UserDetails getAnUser(String email) {

		if (!userRepo.existsById(email)) {
			throw new UserNotFound();
		} else {
			return userRepo.findById(email).get();
		}
	}

	public void deleteAnUser(String email) {

		if (!userRepo.existsById(email)) {
			throw new UserNotFound();
		} else {
			userRepo.deleteById(email);
		}
	}

	public Response addAnUser(UserDetails user) {

		if (userRepo.existsById(user.getEmail()) && userRepo.existsById(user.getCardType())) {
			// throw new UserAlreadyExistException();
			return new Response("Bad-Request", "user already exist with same card, Please apply for different card");
		} 
		else {
			userRepo.save(user);
			return new Response("ok", "Card generated Successfully! Please check on mycards.");
		}

	}

//	public Response updateUser(UserDetails user) {
////		userRepo.save(user);
//		
//		return new Response("Bad-Request","User already exists!");
//
//	}
}
