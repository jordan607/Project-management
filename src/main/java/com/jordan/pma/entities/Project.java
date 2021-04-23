package com.jordan.pma.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Project {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)  Id creation is handeled by java(JPA/hibernate)
	@GeneratedValue(strategy=GenerationType.IDENTITY) // Id creation is handeled by db --> (con) -> we loose hybernate batching feature
	private long projectId;
	
	private String name;
	public Project(String name, String stage, String description) {
		super();
		this.name = name;
		this.stage = stage;
		this.description = description;
	}

	private String stage;
	private String description;

	//@OneToMany(mappedBy = "theProject")
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}
	, fetch = FetchType.LAZY)
	@JoinTable(name="project_employee",
				joinColumns = @JoinColumn(name = "project_id"),
				inverseJoinColumns = @JoinColumn(name = "employee_id")
	)
	private List<Employee> employees;
	

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public long getProjectId() {
		return projectId;
	}

	public Project() {
		super();
	}





	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void addEmployee(Employee emp1) {
		if(employees==null)
			employees=new ArrayList<>();
		 employees.add(emp1);
	}
	
}
