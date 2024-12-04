package com.shahrukh.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSignupRequest {
    private String name;
    private String phone;
    private String email;
    private String password;
	
	
}
