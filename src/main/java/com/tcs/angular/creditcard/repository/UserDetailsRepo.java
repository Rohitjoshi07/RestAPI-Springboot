package com.tcs.angular.creditcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.angular.creditcard.entity.UserDetails;

public interface UserDetailsRepo extends JpaRepository<UserDetails, String> {

}
