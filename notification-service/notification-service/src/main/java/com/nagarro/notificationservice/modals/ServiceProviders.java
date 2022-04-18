package com.nagarro.notificationservice.modals;

import java.util.List;

public class ServiceProviders {
	private List<Provider> serviceProviders;

	public ServiceProviders(List<Provider> serviceProviders) {
		this.serviceProviders = serviceProviders;
	}
	

	public ServiceProviders() {
	}


	public List<Provider> getServiceProviders() {
		return serviceProviders;
	}

	public void setServiceProviders(List<Provider> serviceProviders) {
		this.serviceProviders = serviceProviders;
	}
}
