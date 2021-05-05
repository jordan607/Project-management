package com.jordan.pma.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jordan.pma.entities.UserAccount;

public interface ISecurityRepository extends PagingAndSortingRepository<UserAccount, Long> {
	
	

}
