package com.shahrukh.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSignupRequest {
	
	@NotBlank
	@Size(min=3,max =8, message ="Name must be between 3 to 5")
    private String name;
	
	@Pattern(regexp="^\\d{10}$", message ="must have 10 digits")
    private String phone;
	
	@Email(message = "invalid email id")
    private String email;
	
	
    private String password;
	
	
}
