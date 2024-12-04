package com.shahrukh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shahrukh.entity.Employee;
import com.shahrukh.repository.EmployeeRespository;
import com.shahrukh.request.EmployeeSignupRequest;
import com.shahrukh.response.EmployeeResponse;
import com.shahrukh.response.ErrorResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmployeeRespository employeeRespository;
	
	@Override
	public ResponseEntity<?> saveEmployee(EmployeeSignupRequest employeeSignupRequest) {
		
		
		if (employeeRespository.findByEmail(employeeSignupRequest.getEmail()).isEmpty()) {

			Employee employee = new Employee();
			employee.setName(employeeSignupRequest.getName());
			employee.setPhone(employeeSignupRequest.getPhone());
			employee.setEmail(employeeSignupRequest.getEmail());
			employee.setPassword(employeeSignupRequest.getPassword());

			employeeRespository.save(employee);

			EmployeeResponse response = new EmployeeResponse(employee);

			return ResponseEntity.status(HttpStatus.CREATED).body(response);

		}
		
		
		else {
			
			
			ErrorResponse error = new ErrorResponse();
			error.setMessage("The message is already registered");
			error.setStatus(HttpStatus.CONFLICT);
			error.setCode(HttpStatus.CONFLICT.value());
			
			
			
			
			
			
			return ResponseEntity
					.status(HttpStatus.CONFLICT)
					.body(error);
		}
		
	}

}
