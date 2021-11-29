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
		CreditCard[] data = cardRepo.findAllByUserid(userid);
		
		if (data.length==0) {
			Response res = new Response("true","No cards found!");
			return res;
		}
		else {
			for (CreditCard creditCard : data) {
				
			
			if (creditCard.getType().equals(cardType)) {
				Response res = new Response("false",cardType+" card has already been issued!");
				return res;
				}
			}
		}
			Response res = new Response("true","No "+cardType+" card found!");
			return res;
		}

	
	
	public CardResponse getCardforUserid(String userid) {
		CreditCard[] carddata = cardRepo.findAllByUserid(userid);
		if (carddata.length==0) {
			System.out.println(carddata.length);
			CardResponse res = new CardResponse("false","No cards found!");
			return res;
		}
		else {
			int i=0;
			CardRequest[] cardsdata = new CardRequest[carddata.length];
			for (CreditCard card : carddata) {
				
			
			byte[] cardnum = card.getCardNumber();
			String cardnumdecrypt = Encryption.bytearrayToSting((Encryption.decrypt(cardnum)));
			String cardcvvdecrypt = Encryption.bytearrayToSting(Encryption.decrypt(card.getCvv()));
			String cardType = card.getType();
			
			CardRequest req = new CardRequest(cardnumdecrypt, card.getExpiry(),cardcvvdecrypt, card.getFirstname(), card.getLastname(), cardType );
			cardsdata[i] = req;
			i++;
			
		}
			CardResponse res = new CardResponse("true", "Card sent!",cardsdata);
			return res;
		}
		
	}
	
	
	public Response checkUserforCards(String userid) {
		CreditCard[] data = cardRepo.findAllByUserid(userid);
		
		if (data.length==0) {
			Response res = new Response("true","No cards found!");
			return res;
		}
		else {
			String cardtypes = "";
			for (CreditCard creditCard : data) {
				cardtypes += creditCard.getType();
				cardtypes+= " ";
			}
			
			Response res = new Response("false",cardtypes+" cards has already been issued!");
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
		Response chkres = verifyUser(userid, cardType);
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



