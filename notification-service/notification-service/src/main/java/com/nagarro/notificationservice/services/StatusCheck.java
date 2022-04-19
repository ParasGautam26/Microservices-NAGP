package com.nagarro.notificationservice.services;

import com.nagarro.notificationservice.modals.Provider;
import com.nagarro.notificationservice.modals.ServiceProviders;


import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class StatusCheck {
	private List<Provider> providers;
	Logger logger = LoggerFactory.getLogger(StatusCheck.class);
	
	// Method which checks and gives the list of service providers who have accepted the customer's request
	public List<Provider> getStatus(ServiceProviders serviceProviders) {
		providers = new ArrayList<>();
		
		List<Provider> list = serviceProviders.getServiceProviders();
		
		for(int i=0;i<list.size();i++) {
			Provider pro = list.get(i);
			int random_int = (int)Math.floor(Math.random()*(1-0+1)+0);
			if(random_int==1) {
				providers.add(pro);
			}
		}
		if(list.size()==0) {
			logger.error("There are no service provider who've accepted the request");
		}
		return providers;
	}
}
