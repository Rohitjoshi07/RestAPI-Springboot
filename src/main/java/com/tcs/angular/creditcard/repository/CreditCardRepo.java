package com.tcs.angular.creditcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.angular.creditcard.entity.CreditCard;

public interface CreditCardRepo extends JpaRepository<CreditCard, byte[]>{

	public CreditCard[] findAllByUserid(String userid);

	
}
