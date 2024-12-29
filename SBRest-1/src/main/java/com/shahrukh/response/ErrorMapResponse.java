package com.shahrukh.response;

import java.util.HashMap;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMapResponse {
  
	private int code;
	private HttpStatus status;
	private HashMap<String, String> error;
}
