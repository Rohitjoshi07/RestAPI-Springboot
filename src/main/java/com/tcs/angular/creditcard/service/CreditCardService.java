package com.tcs.angular.creditcard.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.angular.creditcard.entity.CardRequest;
import com.tcs.angular.creditcard.entity.CardResponse;
import com.tcs.angular.creditcard.entity.CreditCard;
import com.tcs.angular.creditcard.entity.Response;
import com.tcs.angular.creditcard.entity.UserDetails;
import com.tcs.angular.creditcard.repository.CreditCardRepo;


@Service
public class CreditCardService {
	
	@Autowired
	CreditCardRepo cardRepo;
	
//	public Response addCard(CreditCard carddata) {
//		
//		cardRepo.save(carddata);
//		Response res = new Response("true","card added!");
//		return res;
//
//	}
//	
	
	public Response verifyUser(String userid, String cardType) {
		Optional<CreditCard> data = cardRepo.findById(userid);
		
		if (!data.isPresent()) {
			Response res = new Response("true","No cards found!");
			return res;
		}
		else {
			CreditCard creditCard = data.get();
			if (creditCard.getType().equals(cardType)) {
				Response res = new Response("false",cardType+" card has already been issued!");
				return res;
				}
			}
			Response res = new Response("true","No "+cardType+" cards found!");
			return res;
		}

	
	
	public CardResponse getCardforUserid(String userpan) {
		Optional<CreditCard> cardd = cardRepo.findById(userpan);
		if (!cardd.isPresent()) {
			CardResponse res = new CardResponse("false","No cards found!");
			return res;
		}
		else {
			CreditCard carddata = cardd.get();
			System.out.println(carddata);
			
			byte[] cardnum = carddata.getCardNumber();
			String cardnumdecrypt = Encryption.bytearrayToSting((Encryption.decrypt(cardnum)));
			String cardcvvdecrypt = Encryption.bytearrayToSting(Encryption.decrypt(carddata.getCvv()));
			String cardType = carddata.getType();
			
			CardRequest req = new CardRequest(cardnumdecrypt, carddata.getExpiry(),cardcvvdecrypt, carddata.getFirstname(), carddata.getLastname(), cardType );
			
			CardResponse res = new CardResponse("true", "Card sent!",req);
			return res;
		}
		
	}
	
	
	public Response checkUserforCards(String userid) {
		Optional<CreditCard> data = cardRepo.findById(userid);
		
		
		if (!data.isPresent()) {
			Response res = new Response("true","No cards found!");
			return res;
		}
		else {
			
				CreditCard card = data.get();
				
				Response res = new Response("false",card.getType()+" already created");
				return res;

		}
	}

	public Response generateCardForUser(UserDetails userdetails) {
		
		String cardType = userdetails.getCardType();
		String userid = userdetails.getPanNumber();
		String[] name = userdetails.getName().split(" ");
		String fname= name[0];
		String lname="";
		if (name.length==2) {
			lname =  name[1];
		}
		
		int srange = userdetails.getSalaryRange();
		String baddress = userdetails.getUserAddress();
		
		//validate for given card
		//Response chkres = verifyUser(userid, cardType);
		Response chkres = checkUserforCards(userid);
		if (chkres.getStatus()=="false") {
			return chkres;
		}
		
		//generate card process
		System.out.println(userid+" "+fname +" "+lname+" "+srange+" "+baddress);
		
		if (cardType.equals("ACE") && (srange==1 || srange==3 || srange==2 || srange==4)) {
			
			//generate card
			cardProcessService cardprocess = cardProcessService.ACE;
			String cardno= cardprocess.generateNumber();
			byte[] cardnoEnc = Encryption.encrypt(Encryption.stringToByte(cardno));
			
			String cardexpiry = cardprocess.generateExpiry();
			
			String cardcvv =  cardprocess.generateCVV();
			byte[] cardcvvEnc = Encryption.encrypt(Encryption.stringToByte(cardcvv));
			
			//store card
			CreditCard carddetails = new CreditCard(cardnoEnc, userid, fname, lname, cardType, baddress,cardcvvEnc, cardexpiry);
			
			//add card in db
			cardRepo.save(carddetails);
			Response res = new Response("true","ACE card added!");
			return res;
			
		}
		else if (cardType.equals("MAGNUS") && (srange!=1)) {
			
			//generate card
			cardProcessService cardprocess = cardProcessService.MAGNUS;
			String cardno= cardprocess.generateNumber();
			byte[] cardnoEnc = Encryption.encrypt(Encryption.stringToByte(cardno));
			
			String cardexpiry = cardprocess.generateExpiry();
			
			String cardcvv =  cardprocess.generateCVV();
			byte[] cardcvvEnc = Encryption.encrypt(Encryption.stringToByte(cardcvv));
			
			//dummycheck
			System.out.println("cardno: "+cardno+" cardexpiry: "+cardexpiry+" cardcvv: "+cardcvv);
			//store card
			CreditCard carddetails = new CreditCard(cardnoEnc, userid, fname, lname, cardType, baddress,cardcvvEnc, cardexpiry);
			
			//add card in db
			cardRepo.save(carddetails);
			Response res = new Response("true","MAGNUS card added!");
			return res;
			
		}
		
		else if (cardType.equals("PLATINUM") && (srange==4 || srange==3)) {
			
			//generate card
			cardProcessService cardprocess = cardProcessService.PLATINUM;
			String cardno= cardprocess.generateNumber();
			byte[] cardnoEnc = Encryption.encrypt(Encryption.stringToByte(cardno));
			
			String cardexpiry = cardprocess.generateExpiry();
			
			String cardcvv =  cardprocess.generateCVV();
			byte[] cardcvvEnc = Encryption.encrypt(Encryption.stringToByte(cardcvv));
			
			
			//dummycheck
			System.out.println("cardno: "+cardno+" cardexpiry: "+cardexpiry+" cardcvv: "+cardcvv);
			
			//store card
			CreditCard carddetails = new CreditCard(cardnoEnc, userid, fname, lname, cardType, baddress,cardcvvEnc, cardexpiry);
			
			//add card in db
			cardRepo.save(carddetails);
			Response res = new Response("true","PLATINUM card added!");
			return res;
			
		}
		else if (cardType.equals("NEO") && (srange==4)) {
			
			//generate card
			cardProcessService cardprocess = cardProcessService.NEO;
			String cardno= cardprocess.generateNumber();
			byte[] cardnoEnc = Encryption.encrypt(Encryption.stringToByte(cardno));
			
			String cardexpiry = cardprocess.generateExpiry();
			
			String cardcvv =  cardprocess.generateCVV();
			byte[] cardcvvEnc = Encryption.encrypt(Encryption.stringToByte(cardcvv));
			
			//dummycheck
			System.out.println("cardno: "+cardno+" cardexpiry: "+cardexpiry+" cardcvv: "+cardcvv);
			
			//store card
			CreditCard carddetails = new CreditCard(cardnoEnc, userid, fname, lname, cardType, baddress,cardcvvEnc, cardexpiry);
			
			//add card in db
			cardRepo.save(carddetails);
			Response res = new Response("true","NEO card added!");
			return res;
			
		}
		else {
			
			Response res = new Response("false","This card is not available for user!");
			return res;
		}
	}

}

//	public List<CreditCard> getAll(){
//
//		List<CreditCard> data = cardRepo.findAll();
//		if (data.isEmpty()){
//			throw new UserNotFoundException();
//		}
//		return data;
//	}



