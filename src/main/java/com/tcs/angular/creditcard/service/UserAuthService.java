package com.tcs.angular.creditcard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.angular.creditcard.entity.*;
import com.tcs.angular.creditcard.exceptions.*;
import com.tcs.angular.creditcard.repository.UserAuthRepo;

@Service
public class UserAuthService {
	
	@Autowired
	private UserAuthRepo userAuthRepo;


	public List<UserAuthentication> getAllUsers() {
		
		//userAuthRepo.save(new UserAuthentication());
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

	public Response verifyAddUser(UserAuthentication user) {
		if(userAuthRepo.existsById(user.getEmail()))
		{
			return new Response("Bad-Request","User Already Exit");
		}
		else {
		userAuthRepo.save(user);
		return new Response("ok","User Added Successfully");
		}
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

	public Response verifyUser(UserAuthentication user) {
		Response response = new Response(null,null);
		if(!userAuthRepo.existsById(user.getEmail()))
		{
			response.setStatus("Bad-Request");
			response.setMessage(user.getEmail() + "Not exist...Register now.");
		}
		else {
			UserAuthentication user2 = userAuthRepo.getById(user.getEmail());
			if(user2.getPassword().equals(user.getPassword()))
			{
				response.setStatus("ok");
				response.setMessage("login successfully");
			}
			else {
				
				response.setStatus("Bad-request");
				response.setMessage("Invalid Password");
			}
			
		}
		
		return response;
	}

}
