package com.mustbuy.customerservice.bean;

public class CustomerSearchCriteria {
	private int customerId;
	private String emailAddress;
	private String firstName;
	private String lastName;
	
	public CustomerSearchCriteria(int customerId, String emailAddress, String firstName, String lastName) {
		super();
		this.customerId = customerId;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
