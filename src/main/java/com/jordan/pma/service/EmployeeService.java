package com.jordan.pma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jordan.pma.dao.IEmployeeRepository;
import com.jordan.pma.dto.EmployeeProject;
import com.jordan.pma.entities.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	IEmployeeRepository empRepo;
	
	public Employee save(Employee employee) {
		return empRepo.save(employee);
	}
	
	public List<Employee> getAll(){
		return empRepo.findAll();
	}
	
	public List<EmployeeProject> employeeProjects(){
		return empRepo.employeeProjects();
	}
	

}
