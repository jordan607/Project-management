package com.jordan.pma.entities;

import java.util.List;

import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jordan.pma.validators.UniqueValue;


@Entity
public class Employee {
	
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@SequenceGenerator(name="employee_seq", sequenceName="employee_seq", allocationSize=1)
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "employee_seq")
	private int employeeId;
	
	@NotNull
	@Size(min=2, max=50)
	private String firstName;
	

	
	@NotNull
	@Size(min=1, max=50)
	private String lastName;
	
	@NotNull
	@Email
//	@Column(unique = true, nullable = false)
	@UniqueValue
	private String email;
	
	
	//@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.LAZY)
	//@JoinColumn(name = "project_id")
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE}
	, fetch = FetchType.LAZY)
	@JoinTable(name="project_employee",
				joinColumns = @JoinColumn(name = "employee_id"),
				inverseJoinColumns = @JoinColumn(name = "project_id")
			  )
	@JsonIgnore
	private List<Project> theProject;
	
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public Employee() {
		
	}
	public List<Project> getTheProject() {
		return theProject;
	}
	public void setTheProject(List<Project> theProject) {
		this.theProject = theProject;
	}
	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
