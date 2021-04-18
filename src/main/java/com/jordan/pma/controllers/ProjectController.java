package com.jordan.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jordan.pma.dao.IProjectRepository;
import com.jordan.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	IProjectRepository proRepo;
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		
		model.addAttribute("project", aProject);
		return "projects/new-project";
		
	}
	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		//handles saving to db
		proRepo.save(project);
		
		//use a redirect to prevent duplicate submissions
		return "redirect:/projects/new";
	}
}
