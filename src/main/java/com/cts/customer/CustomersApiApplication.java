package com.cts.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CustomersApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomersApiApplication.class, args);
	}

}
