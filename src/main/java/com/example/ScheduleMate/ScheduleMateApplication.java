package com.example.ScheduleMate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ScheduleMateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduleMateApplication.class, args);
	}

}
