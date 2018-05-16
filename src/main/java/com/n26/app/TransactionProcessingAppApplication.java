package com.n26.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.n26")
@SpringBootApplication
public class TransactionProcessingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionProcessingAppApplication.class, args);
	}
}
