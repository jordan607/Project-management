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
import com.jordan.pma.service.EmployeeService;
import com.jordan.pma.service.ProjectService;

@Controller


public class HomeController {
	
	@Autowired
	ProjectService proSer;
	
	@Autowired
	EmployeeService empSer;
	
	@RequestMapping("/")
	public String home(Model model) throws JsonProcessingException {
		Map <String, Object> map = new HashMap<String, Object>();
		
		List<Project> projects = proSer.getAll();
		List<EmployeeProject> employee = empSer.employeeProjects();
		
		model.addAttribute("projects", projects);
		model.addAttribute("employee", employee);
		
		
		List<ProjectChart> chartData = proSer.getProjectCount();
		
		//converting projectchart data into json structure for use in js.
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = objectMapper.writeValueAsString(chartData);
//
		model.addAttribute("projectChart", jsonString);
		
		return "main/home";
	}
}
