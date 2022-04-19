package com.nagarro.searchservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.nagarro.searchservice.modals.Customer;
import com.nagarro.searchservice.modals.Provider;
import com.nagarro.searchservice.modals.ServiceProviders;
import com.nagarro.searchservice.services.Search;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/search")
public class searchResource {

	@Autowired
	private WebClient.Builder webClientBuilder;
	
	public static final String SEARCH_SERVICE = "searchService";
	
	Logger logger = LoggerFactory.getLogger(searchResource.class);
	 
	//API Method which returns the list of requested service providers and their details who are at the location of the customer   
	@RequestMapping("/{customerId}")
	@CircuitBreaker(name=SEARCH_SERVICE,fallbackMethod="getAllAvailableServiceProviders")
	public ServiceProviders getServiceProviders(@PathVariable("customerId") int customerId) {
		
		Customer customer = webClientBuilder.build().get().uri("http://customer-service/customer/"+customerId).retrieve().bodyToMono(Customer.class).block();
		
		List<Provider> list = new ArrayList<>();
		Search search = new Search();
		list = search.getAvailableProviders(customer);
		if(list.size()==0) {
			logger.warn("There are no service providers");
		}
		else {
			logger.info("Got the service providers");
		}
		ServiceProviders serviceProviders = new ServiceProviders(list);
		
		return serviceProviders;	
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
