package com.tcs.angular.creditcard.entity;

import java.time.YearMonth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="CreditCard")
public class CreditCard {
	
	@Id
	private String userid;
	
	
	@Column(name="name")
	private String name;
	
	@Column(name="cardNumber")
	private Byte cardNumber;
	
	@Column(name="cardtype")
	private String type;
	
	@Column(name="billingAddress")
	private String billingAddress;
	
	@Column(name="cvv")
	private Byte cvv;
	
	@Column(name="expiry")
	private YearMonth expiry;
	
	
	public CreditCard() {
		super();
		// TODO Auto-generated constructor stub
	}


	public CreditCard(String userid, String name, Byte cardNumber, String type, String billingAddress, Byte cvv,
			YearMonth expiry) {
		super();
		this.userid = userid;
		this.name = name;
		this.cardNumber = cardNumber;
		this.type = type;
		this.billingAddress = billingAddress;
		this.cvv = cvv;
		this.expiry = expiry;
	}
	
	
	public Byte getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(Byte cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public Byte getCvv() {
		return cvv;
	}
	public void setCvv(Byte cvv) {
		this.cvv = cvv;
	}
	public YearMonth getExpiry() {
		return expiry;
	}
	public void setExpiry(YearMonth expiry) {
		this.expiry = expiry;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "CreditCard [userid=" + userid + ", name=" + name + ", cardNumber=" + cardNumber + ", type=" + type
				+ ", billingAddress=" + billingAddress + ", cvv=" + cvv + ", expiry=" + expiry + "]";
	}

}
