package com.nagarro.notificationservice.modals;

public class Provider {
	private String name, mobile, serviceType, pLocation;
	private int price;
	private boolean status;
	
	public Provider(String name, String pLocation, String mobile, String serviceType, int price, boolean status) {
		this.name = name;
		this.pLocation = pLocation;
		this.mobile = mobile;
		this.serviceType = serviceType;
		this.price = price;
		this.status = status;
	}
	
	
	public Provider() {
	}


	public String getpLocation() {
		return pLocation;
	}


	public void setpLocation(String pLocation) {
		this.pLocation = pLocation;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	
}
