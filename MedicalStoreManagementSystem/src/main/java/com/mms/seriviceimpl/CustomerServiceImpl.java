package com.mms.seriviceimpl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mms.entities.Customer;
import com.mms.repository.CustomerRepository;
import com.mms.service.CustomerService;
import com.mms.model.CustomerDTO;
import com.mms.utility.Converter;




@Service
public class CustomerServiceImpl implements CustomerService
{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	Converter converter;
	
	@Override
	public CustomerDTO createCustomer(Customer customer) 
	{
		// TODO Auto-generated method stub
		Customer cust=customerRepository.save(customer);
		return converter.convertToCustomerDTO(cust);
	}
	

	public List<CustomerDTO> getAllCustomer() 
	{
		List<Customer> customers=customerRepository.findAll();
		List<CustomerDTO> dtos=new ArrayList<>();
		for(Customer c:customers)
		{
			dtos.add(converter.convertToCustomerDTO(c));
		}
		
		
		return dtos;
	}
	
	@Override
	public CustomerDTO getCustomerById(int id) 
	{
		Customer c=customerRepository.findById(id).get();
		return converter.convertToCustomerDTO(c);
		
	}
	
	
	@Override
	public String deleteCustomerById(int id) 
	{
		// TODO Auto-generated method stub
		customerRepository.deleteById(id);
		return "Customer deleted";
	}
	
	
	@Override
	public CustomerDTO updateCustomer(int id, Customer customer)
	{
		// TODO Auto-generated method stub
	
		Customer c1=customerRepository.findById(id).get();
		c1.setName(customer.getName());
		c1.setPhNo(customer.getPhNo());
		c1.setEmail(customer.getEmail());
		c1.setAddress(customer.getAddress());
		
		Customer cust=customerRepository.save(c1);
		return converter.convertToCustomerDTO(cust);
	}

}