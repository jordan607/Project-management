package com.jordan.pma.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jordan.pma.dao.IEmployeeRepository;
import com.jordan.pma.dao.IProjectRepository;
import com.jordan.pma.dto.EmployeeProject;
import com.jordan.pma.dto.ProjectChart;
import com.jordan.pma.entities.Employee;
import com.jordan.pma.entities.Project;

@Controller


public class HomeController {
	
	@Autowired
	IProjectRepository proRepo;
	
	@Autowired
	IEmployeeRepository empRepo;
	
	@RequestMapping("/")
	public String home(Model model) throws JsonProcessingException {
		Map <String, Object> map = new HashMap<String, Object>();
		
		List<Project> projects = proRepo.findAll();
		List<EmployeeProject> employee = empRepo.employeeProjects();
		
		model.addAttribute("projects", projects);
		model.addAttribute("employee", employee);
		
		
		List<ProjectChart> chartData = proRepo.projectCount();
		
		//converting projectchart data into json structure for use in js.
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(chartData);
//
		model.addAttribute("projectChart", jsonString);
		
		return "main/home";
	}
}
