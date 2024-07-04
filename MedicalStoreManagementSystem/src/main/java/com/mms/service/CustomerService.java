package com.mms.service;
import java.util.List;

import com.mms.entities.Customer;
import com.mms.model.CustomerDTO;

public interface CustomerService 
{
	CustomerDTO createCustomer(Customer customer);
	
	List<CustomerDTO> getAllCustomer();
	
	CustomerDTO getCustomerById(int id);
	
	String deleteCustomerById(int id);
	
	CustomerDTO updateCustomer(int id,Customer customer);
}

