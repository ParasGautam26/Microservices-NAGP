package com.nagarro.notificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableEurekaClient
public class NotificationServiceApplication {

	@Bean
	@LoadBalanced
	public WebClient.Builder getWebClientBuilder() {
		return WebClient.builder();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

}
