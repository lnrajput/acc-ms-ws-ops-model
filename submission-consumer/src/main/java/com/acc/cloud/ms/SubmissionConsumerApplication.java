package com.acc.cloud.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SubmissionConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubmissionConsumerApplication.class, args);
	}
}
