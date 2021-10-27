package com.tcs.angular.creditcard.entity;

public class UserAuthentication {
   public String email;
   public String name;
   public String password;


public UserAuthentication(String email, String name, String password) {
	super();
	this.email = email;
	this.name = name;
	this.password = password;
}

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

@Override
public String toString() {
	return "UserAuthentication [email=" + email + ", name=" + name + ", password=" + password + "]";
}
public UserAuthentication() {
	super();
	// TODO Auto-generated constructor stub
}
   
   
}
