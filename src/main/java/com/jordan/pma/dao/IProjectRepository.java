package com.jordan.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jordan.pma.dto.ProjectChart;
import com.jordan.pma.entities.Project;

@Repository
public interface IProjectRepository extends JpaRepository<Project, Long>{
	
	@Query(nativeQuery = true, value ="SELECT stage, count(stage) as projectChart FROM PROJECT group by stage")
	public List<ProjectChart> projectCount();

}
