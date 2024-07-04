package com.mms.utility;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.mms.entities.Bill;
import com.mms.model.BillDTO;

@Component
public class BillConverter 
{
	
	//Convert Bill DTO to Bill
	public Bill convertToBill(BillDTO billDTO) 
	{
		Bill bill=null;
		if(billDTO!=null) 
		{
			bill=new Bill();
			BeanUtils.copyProperties(billDTO, bill);
		}
		return bill;
	}
	
	//Convert Bill to BillDTO 
		public BillDTO convertToBillDTO(Bill bill) 
		{
			BillDTO billDTO=null;
			if(bill!=null) 
			{
				billDTO=new BillDTO();
				BeanUtils.copyProperties(bill, billDTO);
			}
			return billDTO;
		}
}
