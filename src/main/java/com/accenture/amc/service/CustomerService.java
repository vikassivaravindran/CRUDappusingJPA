package com.accenture.amc.service;


import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.amc.model.Customer;
import com.accenture.amc.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	public Customer saveCustomer(Customer customer) throws Exception{
		
		Customer insert_customer = customerRepository.save(customer);
		
		return insert_customer;
	}

	public Customer getCustomerById(Long customerId) {
	
		Customer customer = customerRepository.findByCustomerId(customerId);
		return customer;
	}


	public Customer updateCustomer(Customer customer) {
		
	Customer update_customer = customerRepository.save(customer);
		
		return update_customer;
	}

	public String deleteCustomer(Long customerId) {
	
		Customer del_Customer = customerRepository.findByCustomerId(customerId);
		customerRepository.delete(del_Customer);
		
		return "Product Deleted Successfully";
	}

	public List<Customer> getAllCustomers() {
		
		List<Customer> customers =  customerRepository.findAll();
		
		return customers;
		
	}

}
