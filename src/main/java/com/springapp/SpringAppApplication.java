package com.springapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@RestController
@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class SpringAppApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringAppApplication.class, args);
	}
	
}
