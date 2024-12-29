package com.shahrukh.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeUpdateRequest {
	
	private Long id;
	private String name;
	private String phone;

}
