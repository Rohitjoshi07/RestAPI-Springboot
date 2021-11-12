package com.tcs.angular.creditcard.entity;

public class CCHelper {

	private UserDetails userdetails;
	private String cardType;
	private String userid;
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
		public UserDetails getUserdetails() {
		return userdetails;
	}
	public void setUserdetails(UserDetails userdetails) {
		this.userdetails = userdetails;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public CCHelper(UserDetails userdetails, String cardType) {
		super();
		this.userdetails = userdetails;
		this.cardType = cardType;
	}
	public CCHelper() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CCHelper(String cardType, String userid) {
		super();
		this.cardType = cardType;
		this.userid = userid;
	}

	
		
	
}
