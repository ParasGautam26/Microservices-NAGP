package com.nagarro.notificationservice.resources;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.reactive.function.client.WebClient;

import com.nagarro.notificationservice.modals.Customer;
import com.nagarro.notificationservice.modals.Provider;
import com.nagarro.notificationservice.modals.ServiceProviders;
import com.nagarro.notificationservice.services.StatusCheck;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/notification")
public class NotificationResource {
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	public static final String NOTIFICATION_SERVICE = "notificationService";
	
	Logger logger = LoggerFactory.getLogger(NotificationResource.class);
	
	// API Method which return the list of service providers who have accepted the request of the customer after they get the notification
	@RequestMapping("/serviceprovider/{customerId}")
	@CircuitBreaker(name=NOTIFICATION_SERVICE,fallbackMethod="getAllAvailableServiceProviders")
	public ServiceProviders getServiceProviders(@PathVariable("customerId") int customerId) {
		
		ServiceProviders serviceProviders = webClientBuilder.build().get().uri("http://search-service/search/"+customerId).retrieve().bodyToMono(ServiceProviders.class).block();
		List<Provider> list = new ArrayList<>();
		StatusCheck statusCheck = new StatusCheck();
		list = statusCheck.getStatus(serviceProviders);
		if(list.size()==0) {
			logger.warn("There are no service providers who've accepted the request");
		}
		else {
			logger.info("Got the service providers");
		}
		
		ServiceProviders providersAccepted = new ServiceProviders(list); 
				
		return providersAccepted;
	}
	
	// API Method which gives the details of the customer to the service provider
	@RequestMapping("/customer/{customerId}")
	@CircuitBreaker(name=NOTIFICATION_SERVICE,fallbackMethod="getCustomer")
	public Customer getCustomerDetails(@PathVariable("customerId") int customerId) {
		Customer customer = webClientBuilder.build().get().uri("http://customer-service/customer/"+customerId).retrieve().bodyToMono(Customer.class).block();
		return customer;
	}
	
	// Method when the API request to the customer service fails or doesn't responds
	public Customer getCustomer(Exception e) {
		Customer customer = new Customer();
		return customer;
	}
	
	// Method when the API request to the search service fails or doesn't responds
	public ServiceProviders getAllAvailableServiceProviders(Exception e) {
		List<Provider> list = new ArrayList<>();
		ServiceProviders providers = new ServiceProviders(list); 
		return providers;
	}

}
