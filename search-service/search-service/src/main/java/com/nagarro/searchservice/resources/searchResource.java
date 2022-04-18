package com.nagarro.searchservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.nagarro.searchservice.modals.Customer;
import com.nagarro.searchservice.modals.Provider;
import com.nagarro.searchservice.modals.ServiceProviders;
import com.nagarro.searchservice.services.Search;

import java.util.*;

@RestController
@RequestMapping("/search")
public class searchResource {
	
	/*
	 * @Autowired private RestTemplate restTemplate;
	 */
	
	@Autowired
	private WebClient.Builder webClientBuilder;
	 
	@RequestMapping("/{customerId}")
	public ServiceProviders getServiceProviders(@PathVariable("customerId") int customerId) {
		
		//Customer customer = restTemplate.getForObject("http://localhost:8081/customer/"+customerId,Customer.class);
		
		Customer customer = webClientBuilder.build().get().uri("http://customer-service/customer/"+customerId).retrieve().bodyToMono(Customer.class).block();
		
		List<Provider> list = new ArrayList<>();
		Search search = new Search();
		list = search.getAvailableProviders(customer);
		ServiceProviders serviceProviders = new ServiceProviders(list);
		
		return serviceProviders;
		
	}

}
