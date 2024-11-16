package com.mustbuy.customerservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mustbuy.customerservice.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query(value = "select * from customer where emailAddress = :emailAddress", nativeQuery = true)
	public List<Customer> getCustomerByEmailId(String emailAddress);
}
