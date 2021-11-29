package com.tcs.angular.creditcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.angular.creditcard.entity.CreditCardDetails;

public interface CreditCardDetailsRepo extends JpaRepository<CreditCardDetails, String> {

}
