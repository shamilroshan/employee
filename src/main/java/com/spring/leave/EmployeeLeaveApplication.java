package com.spring.leave;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeLeaveApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeLeaveApplication.class, args);
	}

}
