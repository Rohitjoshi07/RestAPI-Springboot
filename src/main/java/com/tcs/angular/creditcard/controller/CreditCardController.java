package com.tcs.angular.creditcard.controller;


                                                                           
                                                                                                   
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;                                         
import org.springframework.web.bind.annotation.PathVariable;                                       
import org.springframework.web.bind.annotation.PostMapping;                                        
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.angular.creditcard.entity.CCHelper;
import com.tcs.angular.creditcard.entity.Response;
import com.tcs.angular.creditcard.service.CreditCardService;                                       
                                                                                                   
@RestController
@CrossOrigin(origins = "*",maxAge=3600)
@RequestMapping("/card")
public class CreditCardController {                                                                
	                                                                                               
	@Autowired                                                                                     
	CreditCardService cardService;                                                                 
	                                                                                               
//	@PostMapping("/card")                                                                          
//	public String saveCardInfo(@RequestBody CreditCard carddata) {                                 
//		return cardService.addCard(carddata);                                                      
//	}
	
	@PostMapping("/generate/")
	public Response generateCard(@RequestBody CCHelper helper) {
		return cardService.generateCardForUser(helper.getUserdetails(), helper.getCardType());
	}
		
	                                                                                               
	@GetMapping("/verify")                                                                  
	public Response verifyCardforCardType(@RequestParam(defaultValue="empty") String id,@RequestParam(defaultValue="empty") String cardType){
			return cardService.verifyUser(id,cardType);                                             
		}
	
	@GetMapping("/check")
	public Response checkUserForCards(@RequestParam(defaultValue="empty") String id) {
		return cardService.checkUserforCards(id);
	}
	                                                                                               
//	                                                                                               
//	@GetMapping("/card")                                                                           
//	public List<CreditCard> getAllCards(){                                                         
//		return cardService.getAll();                                                               
//	}                                                                                              
}                                                                                                  
                                                                                                   
