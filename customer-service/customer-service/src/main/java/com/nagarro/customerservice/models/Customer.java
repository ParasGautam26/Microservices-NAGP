package com.nagarro.customerservice.models;

public class Customer {
	private int customerId;
	private String cname, clocation, mobile, serviceRequested;
	
	public Customer(int customerId, String cname, String clocation, String mobile, String serviceRequested) {
		this.customerId = customerId;
		this.cname = cname;
		this.clocation = clocation;
		this.mobile = mobile;
		this.serviceRequested = serviceRequested;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getLocation() {
		return clocation;
	}

	public void setLocation(String location) {
		this.clocation = location;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getServiceRequested() {
		return serviceRequested;
	}

	public void setServiceRequested(String serviceRequested) {
		this.serviceRequested = serviceRequested;
	}
	
}
