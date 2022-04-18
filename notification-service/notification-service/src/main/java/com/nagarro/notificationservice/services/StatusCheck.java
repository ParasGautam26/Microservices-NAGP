package com.nagarro.notificationservice.services;

import com.nagarro.notificationservice.modals.Provider;
import com.nagarro.notificationservice.modals.ServiceProviders;
import java.util.*;
public class StatusCheck {
	private List<Provider> providers;
	
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
		return providers;
	}
}
