package com.tcs.angular.creditcard.service;

import java.time.YearMonth;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.angular.creditcard.entity.CreditCard;
import com.tcs.angular.creditcard.exceptions.UserNotFoundException;
import com.tcs.angular.creditcard.repository.CreditCardRepo;

@Service
public class CreditCardService {
	
	@Autowired
	CreditCardRepo cardRepo;
	
	public String addCard(CreditCard carddata) {
		
		cardRepo.save(carddata);
		return "Details Saved";
	}
	
	public List<CreditCard> getAll(){
		Byte b1 = 123;
		Byte b2 = 12;
		YearMonth ym = YearMonth.now();
		cardRepo.save(new CreditCard("BQWPJ1936N", "Rohit Joshi", b1, "VISA", "ambica vihar, haldwani", b2, ym));
		
		List<CreditCard> data = cardRepo.findAll();
		if (data.isEmpty()){
			throw new UserNotFoundException();
		}
		return data;
	}
	public String verifyUserByUserid(String userid) {
		CreditCard id = cardRepo.getById(userid);
		if (id.equals(null)) {
			throw new UserNotFoundException();
		}
		return id.getName();
	}
	
	
}
