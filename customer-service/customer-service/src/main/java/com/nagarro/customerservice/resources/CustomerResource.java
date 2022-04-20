package com.nagarro.customerservice.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.customerservice.models.Customer;



@RestController
@RequestMapping("/customer")
public class CustomerResource {
	
	// API Method for customer details 
	@RequestMapping("/{customerId}")
	public Customer getCustomer(@PathVariable("customerId") int customerId) {
		return new Customer(customerId,"Sahil","Delhi","9558343644","Electrician");
	}
}
