package com.tcs.angular.creditcard.entity;

public class CreditCard {
	public byte getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(byte cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public byte getCvv() {
		return cvv;
	}
	public void setCvv(byte cvv) {
		this.cvv = cvv;
	}
	public String getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}
	public String getValidTo() {
		return validTo;
	}
	public void setValidTo(String validTo) {
		this.validTo = validTo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	private byte cardNumber;
	private int userid;
	private byte cvv;
	private String validFrom;
	private String validTo;
	private String type;
	private String billingAddress;
	
	
}
