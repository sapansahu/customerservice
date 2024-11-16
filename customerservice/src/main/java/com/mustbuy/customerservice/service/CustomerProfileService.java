package com.mustbuy.customerservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mustbuy.customerservice.bean.CustomerSearchCriteria;
import com.mustbuy.customerservice.entity.Customer;
import com.mustbuy.customerservice.util.CustomerException;

public interface CustomerProfileService {
	List<Customer> getCustomers() throws CustomerException;

	Customer findCustomerById(CustomerSearchCriteria criteria) throws CustomerException;

	List<Customer> findCustomerByEmailAddress(CustomerSearchCriteria criteria) throws CustomerException;

	void deleteCustomer(CustomerSearchCriteria criteria) throws CustomerException;

	Customer addNewCustomer(Customer customer) throws CustomerException;
}
