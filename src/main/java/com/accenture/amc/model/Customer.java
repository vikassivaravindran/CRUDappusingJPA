package com.accenture.amc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name="CUSTOMER")
public class Customer implements Serializable {
 
	public static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="CUSTOMER_ID")
	private Long customerId;
	
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + "]";
	}

	

	public Customer(Long customerId, String customerName) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
	}



	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public Customer() {
		super();
		
	}
	
	 

	
	
}
