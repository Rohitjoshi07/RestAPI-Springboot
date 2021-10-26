package com.tcs.angular.creditcard.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tcs.angular.creditcard.exceptions.*;
import com.tcs.angular.creditcard.entity.UserDetails;

@Service
public class UserService {

	List<UserDetails> list=new ArrayList<>(Arrays.asList(
			new UserDetails("Sarthak","Sarthak123","Sarthak.hejib@gmail.com","123","121224"),
			new UserDetails("User","User123","demouser@gmail.com","1090923","1112233"),
			new UserDetails("Xyz","xyz23","xyz@gmail.com","678","12090909866"))
			);

	public List<UserDetails> getAllUsers(){
		return list;
	}

	public UserDetails getAnUserByUsername(String username) {
//		UserDetails	user=(UserDetails) list.stream().filter(p->p.getUserName().equals(username)).map(p->p).collect(Collectors.toList());
//		return user;		
		
		UserDetails us = null;
		for(UserDetails user : list)
		{
			if(user.getUserName().equals(username))
				{us = user;
				break;
				}
				
		}
		return us;
	}

	public void deleteAnUser(String username) {
		if(username.equals(null))
			throw new UserNotFoundException();
		list.removeIf(p->p.getUserName().equals(username));
	}

	public void addAnUser(UserDetails user)  {
		//if(user.getName().isBlank() || user.getUserName().isBlank()||	user.getEmail().isBlank() || user.getMobileNumber().isBlank())
	//	throw new EmptyInputException();
		list.add(user);
	}
	
	public void updateUser(String userName, UserDetails user) {
		int count=0;
		for(UserDetails c:list) {
			if(c.getUserName().equals(userName)) {
				list.set(count, user);
			}
			count++;
		}
	}


}
