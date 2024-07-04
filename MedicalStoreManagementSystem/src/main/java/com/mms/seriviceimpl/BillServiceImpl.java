package com.mms.seriviceimpl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mms.entities.Bill;
import com.mms.model.BillDTO;
import com.mms.repository.BillRepository;
import com.mms.service.BillService;
import com.mms.utility.BillConverter;

@Service
public class BillServiceImpl implements BillService
{

	@Autowired
	BillConverter billConverter;
	
	//It is use to automatic inject all the dependency
	@Autowired
	BillRepository billRepository;
	
	@Override
	public BillDTO generateBill(BillDTO billDTO) {
		
		//Convert Bill DTO to bill
		Bill bill=billConverter.convertToBill(billDTO);
		Date d = new Date();
		SimpleDateFormat f;
		f = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
		bill.setBillDate(f.format(d));
		//Save info in database
		Bill saveInfo = billRepository.save(bill);
		
		//Convert to bill dto and return info
		return billConverter.convertToBillDTO(saveInfo);
	}

	@Override
	public List<BillDTO> getAllBills() {
		
		//fetch all info from data base
		List<Bill> allBillInfo=billRepository.findAll();
		
		//Create array list of Bill dto class;
		List<BillDTO> list=new ArrayList<>();
		allBillInfo.forEach(bill->list.add(billConverter.convertToBillDTO(bill)));
		return list;
	}

}
