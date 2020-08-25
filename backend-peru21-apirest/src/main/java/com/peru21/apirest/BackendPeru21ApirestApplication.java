package com.peru21.apirest;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BackendPeru21ApirestApplication implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(BackendPeru21ApirestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UUID uuid;
		for(int i = 0; i < 4; i++) {
			uuid =  UUID.randomUUID();
			System.out.println(uuid.toString());
		}
		
		
		
	}

}
