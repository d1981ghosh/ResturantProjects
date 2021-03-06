package com.tech.assign.restaurant;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {
	final String custName = "Gordon Ramsey";
	@Autowired
	FileReaderService fileReaderServ = new FileReaderService() ;
	@Autowired
	Menu menu = new Menu() ;


	public RestaurantController() {}

	@RequestMapping(value = "/maxSatisfactionLabel")
	public Integer getMaxSatisfactionLabel()
	{
		Map<String,String> map = fileReaderServ.readFromFile();
		return new CustomerService(map).findMaxSatisfactionLabel();

	}


	/*@ExceptionHandler(value = ArrayIndexOutOfBoundsException.class)  
    public String aioubHandler(ArrayIndexOutOfBoundsException e){  
        return e.getMessage();  
    }*/
}
