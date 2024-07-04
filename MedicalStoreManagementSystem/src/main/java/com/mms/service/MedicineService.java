package com.mms.service;
import java.util.List;

import com.mms.entities.Medicines;
import com.mms.model.MedicineDTO;

public interface MedicineService 
{
	MedicineDTO createMedicine(Medicines medicines);
	
	List<MedicineDTO> getAllMedicine();
	
	MedicineDTO getMedicineById(int id);
	
	String deleteMedicineById(int id);
	
	MedicineDTO updateMedicine(int id,Medicines medicines);

}
