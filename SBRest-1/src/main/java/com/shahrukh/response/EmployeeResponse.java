package com.shahrukh.response;

import com.shahrukh.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {

	private Long id;
	
	private String name;
	private String phone;
	
	private String email;

	public EmployeeResponse(Employee employee) {
		super();
		this.id = employee.getId();
		this.name = employee.getName();
		this.phone = employee.getPhone();
		this.email = employee.getEmail();
	}
	
	
	
	
	
}
