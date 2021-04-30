package com.jordan.pma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jordan.pma.dao.IProjectRepository;
import com.jordan.pma.dto.ProjectChart;
import com.jordan.pma.entities.Project;

@Service
public class ProjectService {

	@Autowired
	IProjectRepository proRepo;
	
	public Project save(Project project) {
		return proRepo.save(project);
	}
	
	public List<Project> getAll(){
		return proRepo.findAll();
	}
	
	public List<ProjectChart> getProjectCount(){
		return proRepo.projectCount();
		
	}
	
}
