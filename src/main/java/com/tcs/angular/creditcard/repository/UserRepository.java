package com.tcs.angular.creditcard.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.angular.creditcard.entity.UserDao;

public interface UserRepository extends JpaRepository<UserDao,String> {
	public UserDao findByUsername(String username);
}
