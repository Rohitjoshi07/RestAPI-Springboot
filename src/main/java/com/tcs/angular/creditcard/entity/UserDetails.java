package com.tcs.angular.creditcard.entity;

public class UserDetails {
	private String name;
	private String userName;
	private String email;
	private String password;
	private String mobileNumber;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String username) {
		this.userName = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public UserDetails(String name, String username, String email, String password, String mobileNumber) {
		super();
		this.name = name;
		this.userName = username;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
	}
	public UserDetails() {
		super();
	}
	
	@Override
	public String toString() {
		return "UserDetails [name=" + name + ", username=" + userName + ", email=" + email + ", password=" + password
				+ ", mobileNumber=" + mobileNumber + "]";
	}	
}
