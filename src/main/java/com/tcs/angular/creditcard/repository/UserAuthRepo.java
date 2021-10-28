package com.tcs.angular.creditcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.angular.creditcard.entity.UserAuthentication;

public interface UserAuthRepo extends JpaRepository<UserAuthentication,String> {

}
