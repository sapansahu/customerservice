package com.mustbuy.customerservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mustbuy.customerservice.entity.Customer;
import com.mustbuy.customerservice.service.CustomerProfileService;
import com.mustbuy.customerservice.util.CustomerException;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	CustomerProfileService customerService;

	@GetMapping("/getCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		ResponseEntity<List<Customer>> response = null ;
		try {
			List<Customer> customers  = customerService.getCustomers();
			response = new ResponseEntity<>(customers,HttpStatus.OK);
		} catch (CustomerException e) {
			logger.error(e.getMessage());
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return response;
	}
	
	
	@PostMapping("/enrollCustomer")
	public ResponseEntity<Customer> enrollNewCustomer(@RequestBody Customer customer){
		ResponseEntity<Customer> response = null;
		
		try {
			Customer addedCustomer = customerService.addNewCustomer(customer);
			response = new ResponseEntity<>(addedCustomer,HttpStatus.OK);
		} catch (CustomerException e) {
			logger.error(e.getMessage());
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
}
