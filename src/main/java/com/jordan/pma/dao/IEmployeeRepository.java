package com.jordan.pma.dao;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jordan.pma.dto.EmployeeProject;
import com.jordan.pma.entities.Employee;

@Repository
public interface IEmployeeRepository extends PagingAndSortingRepository<Employee, Integer>{

	@Query(nativeQuery=true, value= "select e.first_name as firstname, e.last_name as lastName, e.email as email, count(pe.employee_id) as projectCount "
			+ "from employee e left join project_employee pe on pe.employee_id = e.employee_id "
			+ "Group by e.first_name, e.last_name, e.email order by 4 desc"
			)
	public List<EmployeeProject> employeeProjects();

	public Employee findByEmail(String value);


}
