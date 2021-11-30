package com.tcs.angular.creditcard.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.angular.creditcard.entity.CreditCardDetails;
import com.tcs.angular.creditcard.entity.Response;
import com.tcs.angular.creditcard.entity.UserDetails;
import com.tcs.angular.creditcard.service.CreditCardDetailsService;


@RestController
@RequestMapping("/details")
@CrossOrigin(origins = "*",maxAge=3600)
public class CreditCardDetailsController {

	@Autowired
	CreditCardDetailsService service;
	
	@GetMapping("/dashboard")
	public List<CreditCardDetails> getAllUsers() {
		return service.cardDescription();
	}
	
	@PostMapping("")
	public Response saveDetails(@RequestBody CreditCardDetails details) {
		return service.saveDetails(details);
		}
}
