package com.tcs.angular.creditcard.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tcs.angular.creditcard.entity.*;

@Service
public class UserAuthService {
	
	List<UserAuthentication> userAuthList=new ArrayList<>(Arrays.asList(
			new UserAuthentication("gadekaraavi@gmail.com","Avinash","Avinash123"),
			new UserAuthentication("sarthakhejib@gmail.com","Sarthak","Sarthak123"),
			new UserAuthentication("rohitjoshi@gmail.com","Rohit","Rohit1234")
			)
			);

	public List<UserAuthentication> getAllUsers() {
		
		return userAuthList;
	}

	public UserAuthentication getUser(String email) {
		UserAuthentication us = null;
		 for(UserAuthentication userauth : userAuthList)
	 {
			if(userauth.getEmail().equals(email) ) 
	  {
				us = userauth;
				break;
	  }
	}
    return us;
	
	}

	public UserAuthentication addUser(UserAuthentication user) {
		userAuthList.add(user);
		return user;
	}

	public UserAuthentication updateUser(UserAuthentication user) {
		
		UserAuthentication us = null;
		 for(UserAuthentication userauth : userAuthList)
	 {
			if(userauth.getEmail().equals(user.getEmail()) ) 
	  {
			userauth.setName(user.getName());
			userauth.setPassword(user.getPassword());
			us = user;
			break;
	  }
	}
    return us;
	}

}
