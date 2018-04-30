package com.acc.cloud.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
@EnableDiscoveryClient
public class DistributedTracingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributedTracingServerApplication.class, args);
	}
}
