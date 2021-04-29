package com.jordan.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jordan.pma.dao.IEmployeeRepository;
import com.jordan.pma.dao.IProjectRepository;
import com.jordan.pma.entities.Employee;
import com.jordan.pma.entities.Project;
import com.jordan.pma.service.EmployeeService;
import com.jordan.pma.service.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectService proSer;
	
	@Autowired
	EmployeeService empSer;
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		
		List<Employee> employees = empSer.getAll();
		//System.out.println(employees.get(0));
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees", employees);
		
		
		
		return "projects/new-project";
		
	}
	@PostMapping("/save")
	public String createProject(Project project,@RequestParam List<Integer> employees ,Model model) {
		//handles saving to db
		proSer.save(project);
		
		
		//projectEmployee.forEach(p->System.out.println(p.getFirstName()));
//		Iterable<Employee>projectEmployee = empRepo.findAllById(employees);	
//		for(Employee emp : projectEmployee) {
//			emp.setTheProject(project);
//			empRepo.save(emp);
//		}
		
		//use a redirect to prevent duplicate submissions
		return "redirect:/projects/new";
	}
}
