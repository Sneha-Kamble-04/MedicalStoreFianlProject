package com.mms.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mms.model.BillDTO;
import com.mms.service.BillService;
import jakarta.validation.Valid;

@RestController
@Validated
public class BillController 
{
	
	//It is use to automatic inject dependency
	@Autowired
	BillService billService;
	
	@PostMapping("/api/generateBill")
	public BillDTO generateBill(@Valid @RequestBody BillDTO billDTO)
	{
		return billService.generateBill(billDTO);
	}
	
	@GetMapping("/api/getBills")
	public List<BillDTO> generateBill()
	{
		return billService.getAllBills();
	}

}