package com.tcs.angular.creditcard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="CreditCardDetails")
public class CreditCardDetails {
	
	@Id
	@Column(name="cardName")	
	private String creditCardName;
	
	@Column(name="salaryRange")
	private String salaryRange;
	
	@Column(name="interestRate")
	private float interestRate;
	
	@Column(name="repaymentTime")
	private int repaymentTime;
	
	@Column(name="cardTitle")	
	private String creditCardTitle;
	
	@Column(name="cardFeature")	
	private String creditCardFeatures;
	
	@Column(name="cardOtherFeature")
	private String creditCardOtherFeatures;
	
	public String getSalaryRange() {
		return salaryRange;
	}

	public void setSalaryRange(String salaryRange) {
		this.salaryRange = salaryRange;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public int getRepaymentTime() {
		return repaymentTime;
	}

	public void setRepaymentTime(int repaymentTime) {
		this.repaymentTime = repaymentTime;
	}
			
	public String getCreditCardName() {
		return creditCardName;
	}
	
	
	
	public CreditCardDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreditCardDetails(String creditCardName, String salaryRange, float interestRate, int repaymentTime,
			String creditCardTitle, String creditCardFeatures, String creditCardOtherFeatures) {
		super();
		this.creditCardName = creditCardName;
		this.salaryRange = salaryRange;
		this.interestRate = interestRate;
		this.repaymentTime = repaymentTime;
		this.creditCardTitle = creditCardTitle;
		this.creditCardFeatures = creditCardFeatures;
		this.creditCardOtherFeatures = creditCardOtherFeatures;
	}

	public void setCreditCardName(String creditCardName) {
		this.creditCardName = creditCardName;
	}
	public String getCreditCardTitle() {
		return creditCardTitle;
	}
	public void setCreditCardTitle(String creditCardTitle) {
		this.creditCardTitle = creditCardTitle;
	}
	public String getCreditCardFeatures() {
		return creditCardFeatures;
	}
	public void setCreditCardFeatures(String creditCardFeatures) {
		this.creditCardFeatures = creditCardFeatures;
	}
	public String getCreditCardOtherFeatures() {
		return creditCardOtherFeatures;
	}
	public void setCreditCardOtherFeatures(String creditCardOtherFeatures) {
		this.creditCardOtherFeatures = creditCardOtherFeatures;
	}	
}
