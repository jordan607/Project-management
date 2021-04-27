package com.jordan.pma.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;

import static org.junit.Assert.assertEquals;

import org.junit.Assert.*;

import com.jordan.pma.ProjectManagementApplication;
import com.jordan.pma.dao.IProjectRepository;
import com.jordan.pma.entities.Project;


//@ContextConfiguration(classes = ProjectManagementApplication.class)
@SpringBootTest
//@DataJpaTest
@SqlGroup({@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:schema.sql","classpath:data.sql"}),
	@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:drop.sql")})
class ProjectRepositoryIntegrationTest {
	
	@Autowired
	IProjectRepository proRepo;
	
	@Test
	public void ifNewProjectSaved_thenSuccess() {
		Project newProject = new Project("New Test Project", "COMPLETE", "Test Description");
		proRepo.save(newProject);
		
		assertEquals(5, proRepo.findAll().size());
		
	}

}
