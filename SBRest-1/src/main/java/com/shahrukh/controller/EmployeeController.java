package com.shahrukh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shahrukh.request.EmployeeSignupRequest;
import com.shahrukh.request.EmployeeUpdateRequest;
import com.shahrukh.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v2/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<?> saveEmployee(@Valid  @RequestBody EmployeeSignupRequest employeeSignupRequest) {
		ResponseEntity<?> response = employeeService.saveEmployee(employeeSignupRequest);
		return response;
	}
	

	@GetMapping()
	public ResponseEntity<?> getAllEmployees() {
		ResponseEntity<?> response = employeeService.getAllEmployee();
		return response;
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable Long id) {
		ResponseEntity<?> response = employeeService.getEmployee(id);
		return response;
	}
	
	
	
	@PutMapping()
	public ResponseEntity<?> updateEmployee(@RequestBody EmployeeUpdateRequest employeeUpdateRequest){
		
		ResponseEntity<?> response = employeeService.updateEmployee(employeeUpdateRequest);
		
		return response;
	}
	
	
	@GetMapping("/namecontains/{str}")
	public ResponseEntity<?> getEmployeeByNameContains(@PathVariable String str){
		ResponseEntity<?> response = employeeService.getEmployeesByNameContains(str);
		return response;
		
	}
	
	
}






















