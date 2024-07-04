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

import com.mms.entities.Medicines;
import com.mms.service.MedicineService;
import com.mms.utility.MedicineConverter;
import com.mms.model.MedicineDTO;
import jakarta.validation.Valid;

@RestController
@Validated
public class MedicineController 
{
	@Autowired
	private MedicineService medicineService;
	
	@Autowired
	MedicineConverter converter;
	
	@PostMapping("/api/AddMedicine")
	ResponseEntity<MedicineDTO> createMedicine(@Valid @RequestBody MedicineDTO medicinedto )
	{
		final Medicines medicines=converter.convertToMedicinesEntity(medicinedto);
		return new ResponseEntity<MedicineDTO>(medicineService.createMedicine(medicines),HttpStatus.CREATED);
	}
	
	@GetMapping("/api/getAllMedicines")
	List<MedicineDTO> getAllMedicine()
	{
		return medicineService.getAllMedicine();		
	}
	
	@GetMapping("/api/getMedicineById/{mid}")
	MedicineDTO getMedicineById(@Valid @PathVariable("mid") int id)
	{
		return medicineService.getMedicineById(id);
	}
	
	@DeleteMapping("/api/deleteMedicines/{mid}")
	String deleteMedicineById(@Valid @PathVariable("mid") int id)
	{
		return medicineService.deleteMedicineById(id);
	}
	
	@PutMapping("/api/updateMedicines/{mid}")
	MedicineDTO updateMedicine(@Valid @PathVariable("mid") int id,@RequestBody Medicines medicines)
	{
		return medicineService.updateMedicine(id, medicines);
		
	}

}
