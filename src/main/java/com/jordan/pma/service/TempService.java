package com.jordan.pma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jordan.pma.controllers.EmployeeController;

@Service
public class TempService {
	
//	@Qualifier("className")
	@Autowired
	EmployeeController empCtl; //Feild injection
	
//	TempService(@Qualifier("className")EmployeeController empCtl){
//		super();
//		this.empCtl = empCtl; // constructor injection
//	}

//	
//	@Autowired
//	@Qualifier("className")
//	public void setEmpCtl(EmployeeController empCtl) {
//		this.empCtl = empCtl; // setter injection
//	}
	
	

}
