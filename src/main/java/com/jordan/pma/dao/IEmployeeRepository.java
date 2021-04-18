package com.jordan.pma.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jordan.pma.entities.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{

}
