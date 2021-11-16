package com.tcs.angular.creditcard.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.angular.creditcard.entity.*;
import com.tcs.angular.creditcard.service.*;

@RestController()
@CrossOrigin(origins = "*",maxAge=3600)
@RequestMapping("/userAuth")
public class UserAuthController {
   
	@Autowired
	UserAuthService userauthser;
	

  @GetMapping("")
  public List<UserAuthentication> getAllUsers(){
	  
//		String text = "5196544571334130";
//		byte[] enc  = Encryption.encrypt(Encryption.stringToByte(text));
//		byte[] dec =Encryption.decrypt(enc);
//		System.out.println("Encrypted: "+enc+"\nLength:"+enc.length);
//		System.out.println("Decypted: "+Encryption.bytearrayToSting(dec));
	  
		return userauthser.getAllUsers();
	}
 
  @GetMapping("/{email}")
  public UserAuthentication getUser(@PathVariable("email") String email)
  {
	  return userauthser.getUserById(email);
  }
  @PostMapping("/login")
  public Response loginUser( @RequestBody UserAuthentication user)
  {
	  
	  return userauthser.verifyUser(user);
  }
  @PostMapping("/register")
  public Response addUser(@RequestBody UserAuthentication user)
  {
	  return this.userauthser.verifyAddUser(user);
  }
  
  @PutMapping("")
  public UserAuthentication updateUser(@RequestBody UserAuthentication user)
  {
	  return this.userauthser.updateUser(user);
	  
  }
  
  @DeleteMapping("/{email}")
  public UserAuthentication deleteUser(@PathVariable("email") String email)
  {
	  return this.userauthser.deleteUser(email);
  }
  
 
}





