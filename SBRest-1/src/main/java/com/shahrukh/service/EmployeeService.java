package com.shahrukh.service;

import org.springframework.http.ResponseEntity;

import com.shahrukh.request.EmployeeSignupRequest;
import com.shahrukh.request.EmployeeUpdateRequest;

public interface EmployeeService {

	ResponseEntity<?> saveEmployee(EmployeeSignupRequest employeeSignupRequest);

	ResponseEntity<?> getEmployee(Long id);

	ResponseEntity<?> updateEmployee(EmployeeUpdateRequest employeeUpdateRequest);

	ResponseEntity<?> getAllEmployee();

	ResponseEntity<?> getEmployeesByNameContains(String str);
}
