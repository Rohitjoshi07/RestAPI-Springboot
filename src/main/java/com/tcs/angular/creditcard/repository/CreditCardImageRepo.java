package com.tcs.angular.creditcard.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.angular.creditcard.entity.CreditCardImage;

public interface CreditCardImageRepo extends JpaRepository<CreditCardImage, String> {

}
