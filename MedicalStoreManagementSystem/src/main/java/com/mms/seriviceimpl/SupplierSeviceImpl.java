package com.mms.seriviceimpl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mms.entities.Supplier;
import com.mms.service.SupplierService;
import com.mms.repository.SupplierRepository;
import com.mms.model.SupplierDTO;
import com.mms.utility.SupplierConverter;

@Service
public class SupplierSeviceImpl implements SupplierService
{
	@Autowired
	private SupplierRepository supplierRepository;
	
	@Autowired
	SupplierConverter supplierconverter;
	
	@Override
	public SupplierDTO createSupplier(Supplier supplier) 
	{
		// TODO Auto-generated method stub 
		Supplier supl=supplierRepository.save(supplier);
		return supplierconverter.convertToSupplierDTO(supl);
	}
	
	@Override
	public List<SupplierDTO> getAllSupplier() 
	{
		// TODO Auto-generated method stub
		List<Supplier> Suppliers=supplierRepository.findAll();
		List<SupplierDTO> dtos=new ArrayList<>();
		for(Supplier s:Suppliers)
		{
			dtos.add(supplierconverter.convertToSupplierDTO(s));
		}
		
		
		return dtos;
	}
	
	@Override
	public SupplierDTO getSupplierById(int id) {
		
		Supplier s=supplierRepository.findById(id).get();
		return supplierconverter.convertToSupplierDTO(s);
	}
	
	@Override
	public String deleteSupplierById(int id) {
		// TODO Auto-generated method stub
		supplierRepository.deleteById(id);
		return "Supplier deleted";
	}
	
	@Override
	public SupplierDTO updateSupplier(int id,Supplier supplier) {
		// TODO Auto-generated method stub
		
		Supplier s1=supplierRepository.findById(id).get();
		s1.setName(supplier.getName());
		s1.setPhNo(supplier.getPhNo());
		s1.setEmail(supplier.getEmail());
		s1.setAddress(supplier.getAddress());
		
		Supplier sup=supplierRepository.save(s1);
		return supplierconverter.convertToSupplierDTO(sup);
	}

}
