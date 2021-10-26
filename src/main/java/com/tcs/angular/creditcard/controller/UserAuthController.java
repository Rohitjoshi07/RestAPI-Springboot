package com.tcs.angular.creditcard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.angular.creditcard.entity.*;
import com.tcs.angular.creditcard.service.*;

@RestController
public class UserAuthController {
   
	@Autowired
	UserAuthService userauthser;


  @GetMapping("/userAuth")
  public List<UserAuthentication> getAllUsers(){
		return userauthser.getAllUsers();
	}
 
  @GetMapping("/userAuth/{email}")
  public UserAuthentication getUser(@PathVariable("email") String email)
  {
	  return this.userauthser.getUser(email);
  }
	
  @PostMapping("/userAuth")
  public UserAuthentication addUser(@RequestBody UserAuthentication user)
  {
	  return this.userauthser.addUser(user);
  }
  
  @PutMapping("/userAuth")
  public UserAuthentication updateUser(@RequestBody UserAuthentication user)
  {
	  return this.userauthser.updateUser(user);
	  
  }
	
}





