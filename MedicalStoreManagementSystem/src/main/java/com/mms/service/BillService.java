package com.mms.service;

import java.util.List;

import com.mms.model.BillDTO;

public interface BillService 
{
	
	BillDTO generateBill(BillDTO billDTO);
	List<BillDTO> getAllBills();
}
