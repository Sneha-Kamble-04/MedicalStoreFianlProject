package com.mms.utility;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


import com.mms.entities.Supplier;

import com.mms.model.SupplierDTO;

@Component
public class SupplierConverter 
{
	//convert DTO to Entity
			public Supplier convertToSupplierEntity(SupplierDTO supplierDTO)
			{
				Supplier supplier=new Supplier();
				if(supplierDTO!=null)
				{
					BeanUtils.copyProperties(supplierDTO, supplier);
				}
				return supplier;
			}
			
			//Convert Entity to DTO
			public SupplierDTO convertToSupplierDTO(Supplier  supplier)
			{
				SupplierDTO supplierDTO=new SupplierDTO();
				if(supplier!=null)
				{
					BeanUtils.copyProperties(supplier, supplierDTO);
				}
				return supplierDTO;
			}

}
