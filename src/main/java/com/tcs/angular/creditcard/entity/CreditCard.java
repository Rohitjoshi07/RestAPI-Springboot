package com.tcs.angular.creditcard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@Entity
@Table(name="CreditCard")
public class CreditCard {

	
	@Id
	@Column(name="cardNumber")
	@Lob
	@Type(type = "org.hibernate.type.BinaryType")
	private byte[] cardNumber;
	
	@Column(name ="userpan")
	private String userid;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="cardtype")
	private String type;
	
	@Column(name="billingAddress")
	private String billingAddress;
	
	@Column(name="cvv")
	@Lob
	@Type(type = "org.hibernate.type.BinaryType")
	private byte[] cvv;
	
	@Column(name="expiry")
	private String expiry;
	

	public byte[] getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(byte[] cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public byte[] getCvv() {
		return cvv;
	}

	public void setCvv(byte[] cvv) {
		this.cvv = cvv;
	}

	public String getExpiry() {
		return expiry;
	}

	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}



	public CreditCard(byte[] cardNumber, String userid, String firstname, String lastname, String type,
			String billingAddress, byte[] cvv, String expiry) {
		super();
		this.cardNumber = cardNumber;
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.type = type;
		this.billingAddress = billingAddress;
		this.cvv = cvv;
		this.expiry = expiry;
	}
	
	public CreditCard(byte[] cardNumber, String firstname, String lastname, String type, byte[] cvv, String expiry) {
		super();
		this.cardNumber = cardNumber;
		this.firstname = firstname;
		this.lastname = lastname;
		this.type = type;
		this.cvv = cvv;
		this.expiry = expiry;
	}
	
	public CreditCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
