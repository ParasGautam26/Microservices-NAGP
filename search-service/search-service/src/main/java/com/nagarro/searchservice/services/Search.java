package com.nagarro.searchservice.services;


import java.util.*;

import com.nagarro.searchservice.modals.Customer;
import com.nagarro.searchservice.modals.Provider;

public class Search {
	private List<Provider> databaseList;
	private List<Provider> serviceProviders;
	
	public Search() {
		this.databaseList = new ArrayList<>();
		this.databaseList.add(new Provider("Raju","Delhi","9453435785","Electrician",500,true));
		this.databaseList.add(new Provider("Lalit","Delhi","9457635785","Electrician",400,true));
		this.databaseList.add(new Provider("Suresh","Delhi","9753435785","Carpenter",700,true));
		this.databaseList.add(new Provider("Suraj","Delhi","9883435785","Carpenter",400,true));
		this.databaseList.add(new Provider("Dhoni","Delhi","95553435785","Salon",900,true));
		this.databaseList.add(new Provider("Giri","Delhi","94348885785","Salon",300,true));
		this.databaseList.add(new Provider("Shyam","Delhi","955435785","Sanitization",700,true));
		this.databaseList.add(new Provider("Rastogi","Delhi","8853435785","Sanitization",200,true));
		this.databaseList.add(new Provider("Anish","Delhi","7753435785","AC service",500,true));
		this.databaseList.add(new Provider("Virat","Delhi","9953435785","AC service",800,true));
		this.databaseList.add(new Provider("Rohit","Delhi","9999435785","Trainer",200,true));
		this.databaseList.add(new Provider("Farhan","Delhi","7777435785","Trainer",700,true));
		this.databaseList.add(new Provider("Rajinder","Delhi","9999995785","Plumber",100,true));
		this.databaseList.add(new Provider("Akshay","Delhi","8778888785","Plumber",700,true));
		
		this.databaseList.add(new Provider("Aman","Mumbai","9453435785","Electrician",200,true));
		this.databaseList.add(new Provider("Naman","Mumbai","8853435785","Electrician",700,true));
		this.databaseList.add(new Provider("Deepak","Mumbai","9453435785","Carpenter",300,true));
		this.databaseList.add(new Provider("Nishant","Mumbai","9999435785","Carpenter",800,true));
		this.databaseList.add(new Provider("Ayush","Mumbai","9453435785","Salon",900,true));
		this.databaseList.add(new Provider("Ramesh","Mumbai","8778888785","Salon",700,true));
		this.databaseList.add(new Provider("Ram","Mumbai","9453435785","Sanitization",900,true));
		this.databaseList.add(new Provider("Shubham","Mumbai","9883435785","Sanitization",300,true));
		this.databaseList.add(new Provider("Vipul","Mumbai","9453435785","Trainer",700,true));
		this.databaseList.add(new Provider("Nakul","Mumbai","9453435785","Trainer",600,true));
		this.databaseList.add(new Provider("Bipul","Mumbai","9453435785","AC service",500,true));
		this.databaseList.add(new Provider("Manik","Mumbai","9453435785","AC service",400,true));
		this.databaseList.add(new Provider("Mithul","Mumbai","9453435785","Plumber",700,true));
		this.databaseList.add(new Provider("Aksh","Mumbai","9453435785","Plumber",500,true));
		
		this.databaseList.add(new Provider("Vivek","Chennai","9453435785","Electrician",200,true));
		this.databaseList.add(new Provider("Nitin","Chennai","9453435785","Electrician",500,true));
		this.databaseList.add(new Provider("Vipin","Chennai","9453435785","Carpenter",400,true));
		this.databaseList.add(new Provider("Dev","Chennai","9453435785","Carpenter",500,true));
		this.databaseList.add(new Provider("Amit","Chennai","9453435785","Salon",300,true));
		this.databaseList.add(new Provider("Raghav","Chennai","9453435785","Salon",700,true));
		this.databaseList.add(new Provider("Rishi","Chennai","9453435785","Sanitization",500,true));
		this.databaseList.add(new Provider("Nitesh","Chennai","9453435785","Sanitization",500,true));
		this.databaseList.add(new Provider("Vishal","Chennai","9453435785","Trainer",500,true));
		this.databaseList.add(new Provider("Rudraksh","Chennai","9453435785","Trainer",900,true));
		this.databaseList.add(new Provider("Piyush","Chennai","9453435785","AC service",500,true));
		this.databaseList.add(new Provider("Virat","Chennai","9453435785","AC service",400,true));
		this.databaseList.add(new Provider("Aksh","Chennai","9453435785","Plumber",700,true));
		this.databaseList.add(new Provider("Mithul","Chennai","9453435785","Plumber",500,true));
		
		this.databaseList.add(new Provider("Amit","Kolkata","9453435785","Electrician",500,true));
		this.databaseList.add(new Provider("Raghav","Kolkata","9453435785","Electrician",800,true));
		this.databaseList.add(new Provider("Vivek","Kolkata","9453435785","Carpenter",500,true));
		this.databaseList.add(new Provider("Nitin","Kolkata","9453435785","Carpenter",880,true));
		this.databaseList.add(new Provider("Bipul","Kolkata","9453435785","Salon",700,true));
		this.databaseList.add(new Provider("Manik","Kolkata","9453435785","Salon",500,true));
		this.databaseList.add(new Provider("Vishal","Kolkata","9453435785","Sanitization",600,true));
		this.databaseList.add(new Provider("Piyush","Kolkata","9453435785","Sanitization",660,true));
		this.databaseList.add(new Provider("Vaibhav","Kolkata","9453435785","Trainer",600,true));
		this.databaseList.add(new Provider("Saurav","Kolkata","9453435785","Trainer",500,true));
		this.databaseList.add(new Provider("Sorabh","Kolkata","9453435785","AC service",900,true));
		this.databaseList.add(new Provider("Dev","Kolkata","9453435785","AC service",770,true));
		this.databaseList.add(new Provider("Manish","Kolkata","9453435785","Plumber",700,true));
		this.databaseList.add(new Provider("Dinesh","Kolkata","9453435785","Plumber",400,true));
	}
	
	//Method to get the service providers as per customer request
	public List<Provider> getAvailableProviders(Customer customer){
		serviceProviders = new ArrayList<>();
		for(int i=0;i<databaseList.size();i++) {
			if(databaseList.get(i).getpLocation().equalsIgnoreCase(customer.getLocation()) 
					&& databaseList.get(i).getServiceType().equalsIgnoreCase(customer.getServiceRequested())){
				serviceProviders.add(databaseList.get(i));
			}
		}
		return serviceProviders;
	}
}
