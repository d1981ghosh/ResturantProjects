package com.tech.assign.restaurant;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice  
@RestController  
public class GlobalExceptionHandler {  

	@ResponseStatus(HttpStatus.BAD_REQUEST)  
	@ExceptionHandler(value = ArrayIndexOutOfBoundsException.class)  
	public String handleAIOFBException(ArrayIndexOutOfBoundsException e){  
		return e.getMessage();  
	}  

	@ExceptionHandler(value = NumberFormatException.class) 
	public String handleNFException(NumberFormatException e){  
		return e.getMessage();  
	} 

	@ExceptionHandler(value = Exception.class)  
	public String handleException(Exception e){return e.getMessage();}  


}  
