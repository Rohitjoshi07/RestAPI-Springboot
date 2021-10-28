package com.tcs.angular.creditcard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.angular.creditcard.entity.*;
import com.tcs.angular.creditcard.exceptions.UserAlreadyExistException;
import com.tcs.angular.creditcard.exceptions.UserNotFound;
import com.tcs.angular.creditcard.exceptions.UserNotFoundException;
import com.tcs.angular.creditcard.repository.UserAuthRepo;

@Service
public class UserAuthService {
	
	@Autowired
	private UserAuthRepo userAuthRepo;


	public List<UserAuthentication> getAllUsers() {
		
		userAuthRepo.save(new UserAuthentication("abc@gmail.com","xyzabc","abc123"));
		return userAuthRepo.findAll();
	}

	public UserAuthentication getUserById(String email) {
	 
		if(!userAuthRepo.existsById(email))
		{
			throw new UserNotFound();
		}
		else
		{
			return userAuthRepo.findById(email).get();
		}
	}

	public UserAuthentication addUser(UserAuthentication user) {
		if(userAuthRepo.existsById(user.getEmail()))
		{
			throw new UserAlreadyExistException();
		}
		else {
		userAuthRepo.save(user);
		return user;}
	}

	public UserAuthentication updateUser(UserAuthentication user) {
		
	   userAuthRepo.save(user);
	  return user;
	}

	public UserAuthentication deleteUser(String email) {
		UserAuthentication user;
		if(!userAuthRepo.existsById(email))
		{
			throw new UserNotFound();
		}
		else
		{   
			user = userAuthRepo.findById(email).get();
		    userAuthRepo.deleteById(email);
		    return user;
		}
	   
	}

}
