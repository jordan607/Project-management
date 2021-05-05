package com.jordan.pma.api.controllers;

import java.awt.print.Pageable;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jordan.pma.dao.IEmployeeRepository;
import com.jordan.pma.entities.Employee;

@RestController
@RequestMapping("/app-api/employees/")
public class EmployeeApiController {

	@Autowired
	IEmployeeRepository empRepo;
	
//	@GetMapping(params= {"page", "size"})
//	@ResponseStatus(HttpStatus.OK)
//	public Iterable<Employee> getEmployees(@RequestParam("page") int page,
//											@RequestParam("size") int size ){
//		Pageable pageAndSize = (Pageable) PageRequest.of(page, size);
//		
//		return empRepo.findAll(pageAndSize);
//	}
	
	@GetMapping("{id}")
	public Employee getEmployeeById(@PathVariable("id") Integer id) {
		return empRepo.findById(id).get();
	}
	
	@RequestMapping(value="/api", method = RequestMethod.POST, consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee update(@RequestBody Employee employee) {
		return empRepo.save(employee);
	}
	
}
