package com.mms.service;
import java.util.List;

import com.mms.entities.Supplier;
import com.mms.model.SupplierDTO;

public interface SupplierService 
{
	SupplierDTO createSupplier(Supplier supplier);
	
	List<SupplierDTO> getAllSupplier();
	
	SupplierDTO getSupplierById(int id);
	
	String deleteSupplierById(int id);
	
	SupplierDTO updateSupplier(int id,Supplier supplier);
}

