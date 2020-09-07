package com.jp.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class OrderSubmissionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderSubmissionServiceApplication.class, args);
	}

}
