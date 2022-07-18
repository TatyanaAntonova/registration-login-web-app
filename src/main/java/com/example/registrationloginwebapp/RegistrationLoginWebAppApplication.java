package com.example.registrationloginwebapp;

import com.example.registrationloginwebapp.model.Role;
import com.example.registrationloginwebapp.model.User;
import com.example.registrationloginwebapp.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RegistrationLoginWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationLoginWebAppApplication.class, args);
		System.out.println("Start Spring App");

		User user = new User("Ivan", "Petrov", "email", "password", "confirmedPassword", Role.ADMIN);
		System.out.println(user.getEmail());
	}
}
