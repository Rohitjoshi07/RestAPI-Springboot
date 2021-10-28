package com.tcs.angular.creditcard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="UserAuthentication")
public class UserAuthentication {
	
   @Id
   public String email;
   
   @Column(name="Name")
   public String name;
   @Column(name="Password")
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


public UserAuthentication() {
	super();
	// TODO Auto-generated constructor stub
}
   
   
}
