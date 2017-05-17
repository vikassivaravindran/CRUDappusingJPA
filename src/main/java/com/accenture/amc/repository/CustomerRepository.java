package com.accenture.amc.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.accenture.amc.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer,Long> {
	
	public Customer findByCustomerId(Long customerId);
	
	public List<Customer> findByCustomerName(String customerName);
	
;
}