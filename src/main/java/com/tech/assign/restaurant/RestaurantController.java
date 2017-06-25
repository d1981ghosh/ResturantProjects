package com.tech.assign.restaurant;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {
	final String custName = "Gordon Ramsey";
	@Autowired
	FileReaderService fileReaderServ ;
	@Autowired
	Menu menu ;


	public RestaurantController() {}

	@RequestMapping(value = "/maxSatisfactionLabel")
	public Item getMaxSatisfactionLabel()
	{
		Map<String,String> map = fileReaderServ.readFromFile();
		return new CustomerService(custName,map,menu).findMaxSatisfactionLabel();

	}


	/*@ExceptionHandler(value = ArrayIndexOutOfBoundsException.class)  
    public String aioubHandler(ArrayIndexOutOfBoundsException e){  
        return e.getMessage();  
    }*/
}
