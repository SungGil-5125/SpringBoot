package com.project.apipractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients

@SpringBootApplication
public class ApiPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiPracticeApplication.class, args);
	}

}
