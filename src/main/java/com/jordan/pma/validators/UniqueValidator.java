package com.jordan.pma.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.jordan.pma.dao.IEmployeeRepository;
import com.jordan.pma.entities.Employee;

public class UniqueValidator implements ConstraintValidator<UniqueValue, String> {

	@Autowired
	IEmployeeRepository empRepo;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		System.out.println("Validator method");
		Employee emp = empRepo.findByEmail(value);
		
		if(emp != null) return false;
		else return true;
		
	}

}
