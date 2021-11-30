package com.tcs.angular.creditcard.repository;





import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.angular.creditcard.entity.ImageFile;

public interface CreditCardImageRepo extends JpaRepository<ImageFile, String> {
	
}
