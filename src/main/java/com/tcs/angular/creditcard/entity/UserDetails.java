package com.tcs.angular.creditcard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserDetails {
	private String name;
	@Id
	private String email;
//	@Column(name="Date of Birth")
	private String dob;
//	@Column(name="Mobile Number")
	private String mobileNumber;
//	@Column(name="PAN Number")
	private String panNumber;
//	@Column(name="Aadhar Number")
	private String aadharNumber;
//	@Column(name="Salary Range")
	private int salaryRange;
//	@Column(name="User Address")
	private String userAddress;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}		
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public int getSalaryRange() {
		return salaryRange;
	}
	public void setSalaryRange(int salaryRange) {
		this.salaryRange = salaryRange;
	}
	public UserDetails(String name, String email, String dob,String mobileNumber, String panNumber,
			String aadharNumber, int salaryRange, String userAddress) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.mobileNumber = mobileNumber;
		this.panNumber = panNumber;
		this.aadharNumber = aadharNumber;
		this.salaryRange = salaryRange;
		this.userAddress = userAddress;
	}
	public UserDetails() {
		super();
	}
	
}
