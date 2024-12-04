package com.shahrukh.service;

import org.springframework.http.ResponseEntity;

import com.shahrukh.request.EmployeeSignupRequest;

public interface EmployeeService {

	ResponseEntity<?> saveEmployee(EmployeeSignupRequest employeeSignupRequest);

}
