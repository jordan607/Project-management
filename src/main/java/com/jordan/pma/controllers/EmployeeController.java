package com.jordan.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jordan.pma.dao.IEmployeeRepository;
import com.jordan.pma.entities.Employee;
import com.jordan.pma.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService empSer;
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		
		model.addAttribute("employee", new Employee());
		return "employees/new-employee";
	}
	
	@PostMapping("/save")
	public String addEmployee(Employee emp) {
		
		empSer.save(emp);
		
		return "redirect:/employee/new";
	}
}
