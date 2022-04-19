package com.nagarro.customerservice.resources;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.nagarro.customerservice.models.Customer;
import com.nagarro.customerservice.models.Provider;
import com.nagarro.customerservice.models.ServiceProviders;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
@RequestMapping("/customer")
public class CustomerResource {
	
	Logger logger = LoggerFactory.getLogger(CustomerResource.class);
	
	// API Method for customer details 
	@RequestMapping("/{customerId}")
	public Customer getCustomer(@PathVariable("customerId") int customerId) {
		return new Customer(customerId,"Paras","Mumbai","9758343644","plumber");
	}
}
