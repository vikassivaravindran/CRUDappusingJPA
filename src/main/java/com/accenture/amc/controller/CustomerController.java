package com.accenture.amc.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.amc.model.Customer;
import com.accenture.amc.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	private static final Logger logger=LoggerFactory.getLogger(CustomerController.class);
	
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET)
	public Collection<Customer> getAllCustomers(){	
		
		Collection<Customer> customers = customerService.getAllCustomers();
		
		return customers;
	}
	
	
	@RequestMapping(value="/customer/get/{customerId}", method = RequestMethod.GET)
	public Customer getByCustomerId(@PathVariable Long customerId) throws Exception{	
		
		Customer customer= new Customer();
		if(customerId != null)
		{
			if(logger.isInfoEnabled()){
				logger.info("Getting the customer with customer id "+customerId);
			}
			customer = customerService.getCustomerById(customerId);
		}
		else{
			throw new Exception("Customer Details Not Found");
		}
		return customer;
	}
	
	@RequestMapping(value="/customer/save" , method=RequestMethod.POST)
	public Customer insertCustomer(@RequestBody Customer customer) throws Exception{
		
		Customer insert_customer = new Customer();
		
		if(customer !=null){
			if(logger.isInfoEnabled()){
				logger.info("Saving the customer with details "+customer.toString());
			}
		insert_customer = customerService.saveCustomer(customer);
		}else{
			throw new Exception("Cannot insert the Customer , Please check the Syntax");
		}
	
		return insert_customer;
	}
	
	@RequestMapping(value="/customer/update" , method=RequestMethod.PUT)
	public Customer updateCustomer(@RequestBody Customer customer) throws Exception{
		
		Customer update_customer = null;
		Customer temp_customer = getByCustomerId(customer.getCustomerId());
		if(temp_customer != null){
			
			if(logger.isInfoEnabled()){
				logger.info("Saving the customer with details "+customer.toString());
			}
		update_customer = customerService.updateCustomer(customer);
		}
		else{
			throw new Exception("The Customer Details does not exist !");
		}
		return update_customer;
	}
	

	@RequestMapping(value="/customer/delete/{customerId}", method = RequestMethod.DELETE)
	public String deleteCustomer(@PathVariable Long customerId) throws Exception{	
		
		String result_message = null;
		if(customerId != null){
			if(logger.isInfoEnabled()){
				logger.info("Deleting the customer with customer id "+customerId);
			}
			 result_message = customerService.deleteCustomer(customerId);
		}
		else{
			throw new Exception("The Customer Details does not exist for above mentioned ID");
		}
		return result_message;
	
	}
	
	@ExceptionHandler(Exception.class)
	public String ExceptionHandler(Exception ex){
		return ex.getMessage();
	}
	

}
