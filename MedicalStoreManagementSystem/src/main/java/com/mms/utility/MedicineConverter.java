package com.mms.utility;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.mms.entities.Medicines;
import com.mms.model.MedicineDTO;

@Component
public class MedicineConverter
{
	//convert DTO to Entity
	public Medicines convertToMedicinesEntity(MedicineDTO medicineDTO)
	{
		Medicines medicines=new Medicines();
		if(medicineDTO!=null)
		{
			BeanUtils.copyProperties(medicineDTO, medicines);
		}
		return medicines;
	}
	
	//Convert Entity to DTO
	public MedicineDTO convertToMedicineDTO(Medicines  medicines)
	{
		MedicineDTO medicinesDTO=new MedicineDTO();
		if(medicines!=null)
		{
			BeanUtils.copyProperties(medicines, medicinesDTO);
		}
		return medicinesDTO;
	}

}
