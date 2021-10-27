package com.tcs.angular.creditcard.controller;


                                         
import java.util.List;                                                                             
                                                                                                   
import org.springframework.beans.factory.annotation.Autowired;                                     
import org.springframework.web.bind.annotation.GetMapping;                                         
import org.springframework.web.bind.annotation.PathVariable;                                       
import org.springframework.web.bind.annotation.PostMapping;                                        
import org.springframework.web.bind.annotation.RequestBody;                                        
import org.springframework.web.bind.annotation.RequestParam;                                       
import org.springframework.web.bind.annotation.RestController;                                     
                                                                                                   
import com.tcs.angular.creditcard.entity.CreditCard;                                                                                     
import com.tcs.angular.creditcard.service.CreditCardService;                                       
                                                                                                   
@RestController                                                                                    
public class CreditCardController {                                                                
	                                                                                               
	@Autowired                                                                                     
	CreditCardService cardService;                                                                 
	                                                                                               
	@PostMapping("/card")                                                                          
	public String saveCardInfo(@RequestBody CreditCard carddata) {                                 
		return cardService.addCard(carddata);                                                      
	}                                                                                              
	                                                                                               
	@GetMapping("/card/{userid}")                                                                  
	public String getUserByUserid(@PathVariable("userid") String id){                              
			return cardService.verifyUserByUserid(id);                                             
		}                                                                                          
	                                                                                               
	                                                                                               
	@GetMapping("/card")                                                                           
	public List<CreditCard> getAllCards(){                                                         
		return cardService.getAll();                                                               
	}                                                                                              
}                                                                                                  
                                                                                                   
