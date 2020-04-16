package com.DeliveryService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Collections;

@SpringBootApplication
@EnableScheduling
public class DeliveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DeliveryServiceApplication.class);
		app.run(args);
	}

}
