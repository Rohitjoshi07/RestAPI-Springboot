package com.tcs.angular.creditcard.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.angular.creditcard.exceptions.*;
import com.tcs.angular.creditcard.repository.UserDetailsRepo;
import com.tcs.angular.creditcard.entity.UserDetails;

@Service
public class UserService {

	@Autowired
	UserDetailsRepo userRepo;

	public List<UserDetails> getAllUsers(){
		userRepo.save(new UserDetails("Avinash","gadekaraavi@gmail.com","06/11/1997", "7040753196" ,"BCDF4325D","123456782345",2,"raje sambhaji nagar"));
		  return userRepo.findAll();
	}
	
	public UserDetails getAnUser(String email) {
		
		if(!userRepo.existsById(email))
		{
			throw new UserNotFound();
		}
		else
		{
			return userRepo.findById(email).get();
		}
	}

	public void deleteAnUser(String email) {
		
		if(!userRepo.existsById(email))
		{
			throw new UserNotFound();
		}
		else
		{   
		    userRepo.deleteById(email);
		}
	}

	public void addAnUser(UserDetails user){
		if(user.getName().isEmpty() || 
				 user.getName().isEmpty() ||
				 user.getEmail().isEmpty() || 
				 user.getAadharNumber().isEmpty() || 
				 user.getDob().isEmpty() ||
				 user.getPanNumber().isEmpty() || 
				 user.getUserAddress().isEmpty())                 
		throw new EmptyInputException();
		if(userRepo.existsById(user.getEmail()))
		{
			throw new UserAlreadyExistException();
		}
		else {
		userRepo.save(user);
		}
	
	}
	
	public void updateUser(UserDetails user) {
		userRepo.save(user);
	}
}
