package com.example.messageapp;

import com.example.messageapp.entity.Message;
import com.example.messageapp.repository.MessageRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class H2demoApplication {

	private MessageRepository messageRepository;
	private Message message;

	public static void main(String[] args) {
		var URL = "http://localhost:8080/";
		System.out.println("Running now " + URL);
		SpringApplication.run(H2demoApplication.class, args);

	}
}
