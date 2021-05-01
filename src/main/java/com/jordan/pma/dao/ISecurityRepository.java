package com.jordan.pma.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jordan.pma.entities.UserAccount;

public interface ISecurityRepository extends JpaRepository<UserAccount, Long> {
	
	

}
