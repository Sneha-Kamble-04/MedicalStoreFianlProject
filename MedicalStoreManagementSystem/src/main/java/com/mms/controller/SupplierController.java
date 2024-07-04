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

import com.mms.entities.Supplier;
import com.mms.service.SupplierService;
import com.mms.model.SupplierDTO;
import com.mms.utility.SupplierConverter;
import jakarta.validation.Valid;

@RestController
@Validated
public class SupplierController
{
	@Autowired
	private SupplierService supplierService;
	
	@Autowired
	SupplierConverter converter;
	
	@PostMapping("/api/createSupplier")
	ResponseEntity<SupplierDTO> createSupplier(@Valid @RequestBody SupplierDTO supplierdto)
	{
		final Supplier supplier1=converter.convertToSupplierEntity(supplierdto);
		return new ResponseEntity<SupplierDTO>(supplierService.createSupplier(supplier1),HttpStatus.CREATED);
	}
	
	@GetMapping("/api/getAllSupplier")
	List<SupplierDTO> getAllCustomer()
	{
		return supplierService.getAllSupplier();		
	}
	
	@GetMapping("/api/getSupplierById/{cid}")
	SupplierDTO getSupplierById(@Valid @PathVariable("sid") int id)
	{
		return supplierService.getSupplierById(id);
	}
	
	@DeleteMapping("/api/deleteSupplier/{sid}")
	String deleteSupplierById(@Valid @PathVariable("sid") int id)
	{
		return supplierService.deleteSupplierById(id);
	}
	
	@PutMapping("/api/updateSupplier/{Sid}")
	SupplierDTO updateSupplier(@Valid @PathVariable("Sid") int id,@RequestBody Supplier supplier)
	{
		return supplierService.updateSupplier(id, supplier);
		
	}

}
