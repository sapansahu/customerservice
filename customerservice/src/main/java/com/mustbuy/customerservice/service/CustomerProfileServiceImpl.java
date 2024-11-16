package com.mustbuy.customerservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mustbuy.customerservice.bean.CustomerSearchCriteria;
import com.mustbuy.customerservice.dao.CustomerRepository;
import com.mustbuy.customerservice.entity.Customer;
import com.mustbuy.customerservice.util.CustomerException;

@Service
public class CustomerProfileServiceImpl implements CustomerProfileService{
	
	@Autowired
	public CustomerRepository customerRepository;

	@Override
	public List<Customer> getCustomers()  throws CustomerException {
		return customerRepository.findAll();
	}

	@Override
	public Customer findCustomerById(CustomerSearchCriteria criteria) throws CustomerException {
		// TODO Auto-generated method stub
		Optional<Customer> customerOptional =  customerRepository.findById(criteria.getCustomerId());
		if(customerOptional.isEmpty()) {
			throw new CustomerException(new Exception(),"Customer Details were not found for the customer id: "+(criteria.getCustomerId())); 
		}
		
		return customerOptional.get();
	}


	@Override
	public List<Customer> findCustomerByEmailAddress(CustomerSearchCriteria criteria) throws CustomerException {
		return customerRepository.getCustomerByEmailId(criteria.getEmailAddress());
	}

	@Override
	public void deleteCustomer(CustomerSearchCriteria criteria) throws CustomerException {
		Customer customer = findCustomerById(criteria);
		customerRepository.delete(customer);
	}

	@Override
	public Customer addNewCustomer(Customer customer) {
		if(!customer.getAddress().isEmpty()) {
			customer.getAddress().forEach(address -> address.setCustomer(customer));
		}
		return customerRepository.save(customer);
	}

}
