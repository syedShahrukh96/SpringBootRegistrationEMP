package com.shahrukh.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shahrukh.entity.Employee;
import com.shahrukh.exception.AlreadyExistException;
import com.shahrukh.exception.NoSuchElementException;
import com.shahrukh.repository.EmployeeRespository;
import com.shahrukh.request.EmployeeSignupRequest;
import com.shahrukh.request.EmployeeUpdateRequest;
import com.shahrukh.response.EmployeeResponse;
import com.shahrukh.response.ErrorResponse;
;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRespository employeeRespository;

	@Override
	public ResponseEntity<?> saveEmployee(EmployeeSignupRequest employeeSignupRequest) {

		if (employeeRespository.findByEmail(employeeSignupRequest.getEmail()).isPresent()) {
			throw new AlreadyExistException("The Email is already registered");
		}

		Employee employee = new Employee();
		employee.setName(employeeSignupRequest.getName());
		employee.setPhone(employeeSignupRequest.getPhone());
		employee.setEmail(employeeSignupRequest.getEmail());
		employee.setPassword(employeeSignupRequest.getPassword());

		employeeRespository.save(employee);

		EmployeeResponse response = new EmployeeResponse(employee);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	/*
	 * else {
	 * 
	 * ErrorResponse error = new ErrorResponse();
	 * error.setMessage("The Email Is is already registered");
	 * error.setStatus(HttpStatus.CONFLICT);
	 * error.setCode(HttpStatus.CONFLICT.value());
	 * 
	 * return ResponseEntity.status(HttpStatus.CONFLICT).body(error); }
	 */

	@Override
	public ResponseEntity<?> getEmployee(Long id) {

		Employee employee = employeeRespository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Employee not found " + id));
		return ResponseEntity.ok().body(employee);

	}

	@Override
	public ResponseEntity<?> updateEmployee(EmployeeUpdateRequest employeeUpdateRequest) {

		Employee employee = employeeRespository.findById(employeeUpdateRequest.getId())
				.orElseThrow(() -> new NoSuchElementException("Employee not found " + employeeUpdateRequest.getId()));

		employee.setName(employeeUpdateRequest.getName());
		employee.setPhone(employeeUpdateRequest.getPhone());
		employeeRespository.save(employee);

		EmployeeResponse response = new EmployeeResponse(employee);

		return ResponseEntity.ok().body(response);
	}

	@Override
	public ResponseEntity<?> getAllEmployee() {

		return ResponseEntity.ok(employeeRespository.findAll());
	
	}
	
	public List<Employee> getAll() {

		return employeeRespository.findAll();
		
	
	}
	
	@Override
	public ResponseEntity<?> getEmployeesByNameContains(String str) {
		
		 List<Employee> empList = getAll().stream().filter(emp -> emp.getName().contains(str) )
		.collect(Collectors.toList());
		
		return ResponseEntity.ok(empList);
	}
}
