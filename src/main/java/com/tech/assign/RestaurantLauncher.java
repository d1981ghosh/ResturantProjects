package com.tech.assign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestaurantLauncher {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantLauncher.class, args);
		System.out.println("This is for test");
	}

}
