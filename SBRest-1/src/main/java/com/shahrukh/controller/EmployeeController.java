package com.shahrukh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.shahrukh.request.EmployeeSignupRequest;
import com.shahrukh.service.EmployeeService;

@RestController
@RequestMapping("/api/v2/employee")
public class EmployeeController {

	
	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping
	public ResponseEntity<?> saveEmployee(@RequestBody EmployeeSignupRequest employeeSignupRequest) {
		
		ResponseEntity<?> response = employeeService.saveEmployee(employeeSignupRequest);
		
		return response;
		
		
	}
}
