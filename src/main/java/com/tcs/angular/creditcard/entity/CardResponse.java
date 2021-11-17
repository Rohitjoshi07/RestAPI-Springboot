package com.tcs.angular.creditcard.entity;

public class CardResponse {
	

	private String status;
	private String message;
	private CardRequest carddata;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public CardRequest getCarddata() {
		return carddata;
	}
	public void setCarddata(CardRequest carddata) {
		this.carddata = carddata;
	}

	public CardResponse(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	public CardResponse(String status, String message, CardRequest carddata) {
		super();
		this.status = status;
		this.message = message;
		this.carddata = carddata;
	}
	public CardResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
