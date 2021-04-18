package com.jordan.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jordan.pma.dao.IEmployeeRepository;
import com.jordan.pma.dao.IProjectRepository;
import com.jordan.pma.entities.Employee;
import com.jordan.pma.entities.Project;

@Controller


public class HomeController {
	
	@Autowired
	IProjectRepository proRepo;
	
	@Autowired
	IEmployeeRepository empRepo;
	
	@RequestMapping("/")
	public String home(Model model) {
		List<Project> projects = proRepo.findAll();
		
		List<Employee> employee = empRepo.findAll();
		
		model.addAttribute("projects", projects);
		model.addAttribute("employee", employee);
		return "main/home";
	}
}
