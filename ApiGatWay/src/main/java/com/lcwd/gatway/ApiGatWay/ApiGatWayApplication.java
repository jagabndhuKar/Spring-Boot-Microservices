package com.lcwd.gatway.ApiGatWay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatWayApplication.class, args);
	}

}
