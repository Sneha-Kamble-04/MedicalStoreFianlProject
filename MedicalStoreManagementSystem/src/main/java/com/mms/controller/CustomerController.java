package com.mms.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.mms.entities.Customer;
import com.mms.service.CustomerService;
import com.mms.model.CustomerDTO;
import com.mms.utility.Converter;
import jakarta.validation.Valid;



@RestController
@Validated
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	Converter converter;
	
	@PostMapping("/api/addcustomer")
	ResponseEntity<CustomerDTO> createCustomert(@Valid @RequestBody CustomerDTO customerdto )
	{
		final Customer customer=converter.convertToCustomerEntity(customerdto);
		return new ResponseEntity<CustomerDTO>(customerService.createCustomer(customer),HttpStatus.CREATED);
	}
	
	@GetMapping("/api/getAllCustomer")
	List<CustomerDTO> getAllCustomer()
	{
		return customerService.getAllCustomer();		
	}
	
	@GetMapping("/api/getCustomerById/{cid}")
	CustomerDTO getCustomerById(@Valid @PathVariable("cid") int id)
	{
		return customerService.getCustomerById(id);
	}
	
	@DeleteMapping("/api/deleteCustomer/{cid}")
	String deleteCustomerById(@Valid @PathVariable("cid") int id)
	{
		return customerService.deleteCustomerById(id);
	}
	
	@PutMapping("/api/updateCustomer/{cid}")
	CustomerDTO updateCustomer(@Valid @PathVariable("cid") int id,@RequestBody Customer customer)
	{
		return customerService.updateCustomer(id, customer);
		
	}

	
}
