package com.nagarro.notificationservice.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.nagarro.notificationservice.modals.Customer;
import com.nagarro.notificationservice.modals.Provider;
import com.nagarro.notificationservice.modals.ServiceProviders;
import com.nagarro.notificationservice.services.StatusCheck;


@RestController
@RequestMapping("/notification")
public class NotificationResource {
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@RequestMapping("/{customerId}")
	public ServiceProviders getServiceProviders(@PathVariable("customerId") int customerId) {
		/*
		 * RestTemplate restTemplate1 = new RestTemplate(); RestTemplate restTemplate2 =
		 * new RestTemplate();
		 * 
		 * Customer customer =
		 * restTemplate1.getForObject("http://localhost:8081/customer/"+customerId,
		 * Customer.class); ServiceProviders serviceProviders =
		 * restTemplate2.getForObject("http://localhost:8082/search/"+customerId,
		 * ServiceProviders.class);
		 */
		
		Customer customer = webClientBuilder.build().get().uri("http://customer-service/customer/"+customerId).retrieve().bodyToMono(Customer.class).block();
		
		ServiceProviders serviceProviders = webClientBuilder.build().get().uri("http://search-service/search/"+customerId).retrieve().bodyToMono(ServiceProviders.class).block();
		List<Provider> list = new ArrayList<>();
		StatusCheck statusCheck = new StatusCheck();
		list = statusCheck.getStatus(serviceProviders);
		
		ServiceProviders providersAccepted = new ServiceProviders(list); 
				
		return providersAccepted;
	}

}
