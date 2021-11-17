package com.tcs.angular.creditcard.entity;

public class CardRequest {

	private String cardnum;
	private String expiry;
	private String cvv;
	private String fname;
	private String lname;
	private String cardType;
	
	
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardnum() {
		return cardnum;
	}
	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}

	
	public CardRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CardRequest(String cardnum, String expiry, String cvv, String fname, String lname, String cardTypes) {
		super();
		this.cardnum = cardnum;
		this.expiry = expiry;
		this.cvv = cvv;
		this.fname = fname;
		this.lname = lname;
		this.cardType=cardType;
	}
}
