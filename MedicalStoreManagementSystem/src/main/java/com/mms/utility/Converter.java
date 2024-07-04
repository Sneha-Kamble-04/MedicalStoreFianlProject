package com.mms.utility;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import com.mms.entities.Customer;
import com.mms.model.CustomerDTO;
@Component
public class Converter
{
	//convert DTO to Entity
		public Customer convertToCustomerEntity(CustomerDTO customerDTO)
		{
			Customer customer=new Customer();
			if(customerDTO!=null)
			{
				BeanUtils.copyProperties(customerDTO, customer);
			}
			return customer;
		}
		
		//Convert Entity to DTO
		public CustomerDTO convertToCustomerDTO(Customer  customer)
		{
			CustomerDTO customerDTO=new CustomerDTO();
			if(customer!=null)
			{
				BeanUtils.copyProperties(customer, customerDTO);
			}
			return customerDTO;
		}

}







