package com.jordan.pma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jordan.pma.dao.ISecurityRepository;
import com.jordan.pma.entities.UserAccount;

@Service
public class SecurityService {

	@Autowired
	ISecurityRepository secRepo;
	
	public void savePassword(UserAccount user) {
		secRepo.save(user);
		
	}
}
