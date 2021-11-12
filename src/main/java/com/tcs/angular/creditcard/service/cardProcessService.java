package com.tcs.angular.creditcard.service;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public enum cardProcessService{
	ACE{
		@Override
		public String generateNumber(){
			StringBuffer cardNum = new StringBuffer();
			Random rnd = new Random();
			int counter=1;
			cardNum.append(5);
			while(counter<16){
				int generate = rnd.nextInt(9); 
				cardNum.append(Integer.toString(generate));
				counter++;
			}
			return cardNum.toString();
			}

		@Override
		public String generateCVV() {
			// TODO Auto-generated method stub
			StringBuffer cvv = new StringBuffer();
			Random rnd = new Random();
			int counter=1;
			while(counter<4){
			int generate = rnd.nextInt(9); 
			cvv.append(Integer.toString(generate));
			counter++;
			}
			return cvv.toString();
			}
		
		@Override
		public String generateExpiry() {
			// TODO Auto-generated method stub
			LocalDate expdate = LocalDate.now().plusYears(5);
			
			String expiry = expdate.format(DateTimeFormatter.ofPattern("MM/YYYY"));
			return expiry;
		}
		
		
		},
	MAGNUS{
		@Override
		public String generateNumber(){
			StringBuffer cardNum = new StringBuffer();
			Random rnd = new Random();
			int counter=1;
			cardNum.append(6);
			while(counter<16){
			int generate = rnd.nextInt(9); 
			cardNum.append(Integer.toString(generate));
			counter++;
			}
			return cardNum.toString();
			}

		@Override
		public String generateCVV() {
			// TODO Auto-generated method stub
			StringBuffer cvv = new StringBuffer();
			Random rnd = new Random();
			int counter=1;
			while(counter<4){
			int generate = rnd.nextInt(9); 
			cvv.append(Integer.toString(generate));
			counter++;
			}
			return cvv.toString();
			}
		
		@Override
		public String generateExpiry() {
			// TODO Auto-generated method stub
			LocalDate expdate = LocalDate.now().plusYears(5);
			
			String expiry = expdate.format(DateTimeFormatter.ofPattern("MM/YYYY"));
			return expiry;
		}
		},	
		PLATINUM{
			@Override
			public String generateNumber(){
				StringBuffer cardNum = new StringBuffer();
				Random rnd = new Random();
				int counter=1;
				cardNum.append(7);
				while(counter<16){
				int generate = rnd.nextInt(9); 
				cardNum.append(Integer.toString(generate));
				counter++;
				}
				return cardNum.toString();
				}

			@Override
			public String generateCVV() {
				// TODO Auto-generated method stub
				StringBuffer cvv = new StringBuffer();
				Random rnd = new Random();
				int counter=1;
				while(counter<4){
				int generate = rnd.nextInt(9); 
				cvv.append(Integer.toString(generate));
				counter++;
				}
				return cvv.toString();
				}
			
			@Override
			public String generateExpiry() {
				// TODO Auto-generated method stub
				LocalDate expdate = LocalDate.now().plusYears(5);
				
				String expiry = expdate.format(DateTimeFormatter.ofPattern("MM/YYYY"));
				return expiry;
			}
		},
		NEO{
				@Override
				public String generateNumber(){
					StringBuffer cardNum = new StringBuffer();
					Random rnd = new Random();
					int counter=1;
					cardNum.append(8);
					while(counter<16){
					int generate = rnd.nextInt(9); 
					cardNum.append(Integer.toString(generate));
					counter++;
					}
					return cardNum.toString();
					}

				@Override
				public String generateCVV() {
					// TODO Auto-generated method stub
					StringBuffer cvv = new StringBuffer();
					Random rnd = new Random();
					int counter=1;
					while(counter<4){
					int generate = rnd.nextInt(9); 
					cvv.append(Integer.toString(generate));
					counter++;
					}
					return cvv.toString();
					}
				
				@Override
				public String generateExpiry() {
					// TODO Auto-generated method stub
					LocalDate expdate = LocalDate.now().plusYears(5);
					
					String expiry = expdate.format(DateTimeFormatter.ofPattern("MM/YYYY"));
					return expiry;
				}
	};

	public abstract String generateNumber();
	public abstract String generateCVV();
	public abstract String generateExpiry();
}
