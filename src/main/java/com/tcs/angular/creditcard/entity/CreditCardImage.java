package com.tcs.angular.creditcard.entity;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="cardImage")
public class CreditCardImage {
	
	@Id
	@Column(name="cardType")
	private String cardType;
	
	@Lob
	@Column(name="cardImage")
	private byte[] creditCardImage;
	


	
	public byte[] getCreditCardImage() {
		return creditCardImage;
	}

	public void setCreditCardImage(byte[] creditCardImage) {
		this.creditCardImage = creditCardImage;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public CreditCardImage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreditCardImage(byte[] creditCardImage, String cardType) {
		super();
		
		this.creditCardImage = creditCardImage;
		this.cardType = cardType;
	}
	

		

}
