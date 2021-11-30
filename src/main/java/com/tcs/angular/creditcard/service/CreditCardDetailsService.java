package com.tcs.angular.creditcard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.angular.creditcard.entity.CreditCardDetails;
import com.tcs.angular.creditcard.entity.Response;
import com.tcs.angular.creditcard.repository.CreditCardDetailsRepo;

@Service
public class CreditCardDetailsService {

	@Autowired
	CreditCardDetailsRepo repo;
		
	public List<CreditCardDetails> cardDescription(){
		repo.save(new CreditCardDetails("Ace","under 50k",(float) 2.2,40,"Step into a exclusive world of premium pleasures and global experiences that are ready for you."
				, "Complimentary Club Marriott membership for first year. Complimentary nights & weekend buffet at participating ITC hotels 5% cashbackon billpayments & recharge on Google Pay, 4% cashback on Swiggy, Zomato & Ola",
				"4 complimentary lounge access at select domestic airports, 1% fuel surcharge waiver"));
		
		repo.save(new CreditCardDetails("Magnus","50k to 1 lac",(float) 4.0,45,"Enjoy a life more rewarding with inspired choices and luxurious indulgences that are ready for you.",
				"Complimentary Dineout Passport Membership. Introducing Airport Concierge Services across 29 cities and unlimited demoestic lounge access. Earn Bonus 15,000 Reward Points on spends of ₹ 8 lakhs in a year",
				"4 Reward Points for every ₹ 150 spent. Complimentary flight ticket, up to 12 priority pass lounge access, 2% forex mark-up"));
		
		repo.save(new CreditCardDetails("Platinum","1lac to 2lac",(float) 6.0,50,"Wherever you choose to spend great times, they are ready for you.",
				"25% off on Movies on BookMyShow. Up to 20% off on dining. 3 Reward Points for every ₹ 150 spent. 10 Reward Points for ₹ 150 spent on weekday dining.",
				"Enjoy 25% cashback on movie tickets.Some quick example text to build on the card title and make up the bulk of the card's content."));
		
		repo.save(new CreditCardDetails("Neo","above 2lac",(float) 6.5,60,"Convert spends into airmiles and take off on exciting new journeys that are ready for you",
				"2.5% 6E Rewards on IndiGo. 2% 6E Rewards on Grocery, Dining & Entertainment. 1% 6E Rewards on all other spends. Up to 10% 6E Rewards on IndiGo featured partners.",
				"Discounted Convenience Fee on IndiGo tickets-Rs.150 per pax (current – Rs.300) 1 point with every Rs. 200 Spent. Discounts on Zomato, Grofers, Myntra, BookMyShow etc"));
		
		return repo.findAll();
		
	}
	
	public Response saveDetails(CreditCardDetails details) {
		if (repo.existsById( details.getCreditCardName())) {
			return new Response("false",details.getCreditCardName()+"details already exists.");
	}
		else {
			repo.save(details);
			return new Response("true","Details saved!");
		}
}

}