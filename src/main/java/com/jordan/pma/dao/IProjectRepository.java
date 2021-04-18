package com.jordan.pma.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jordan.pma.entities.Project;

public interface IProjectRepository extends JpaRepository<Project, Long>{
	

}
