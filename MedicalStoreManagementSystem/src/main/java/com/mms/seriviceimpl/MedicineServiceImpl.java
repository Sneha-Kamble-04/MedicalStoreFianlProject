package com.mms.seriviceimpl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mms.entities.Medicines;
import com.mms.repository.MedicineRepository;
import com.mms.service.MedicineService;
import com.mms.model.MedicineDTO;
import com.mms.utility.MedicineConverter;


@Service
public class MedicineServiceImpl implements MedicineService
{
	@Autowired
	private MedicineRepository medicineRepository;
	
	@Autowired
	MedicineConverter converter;
	
	@Override
	public MedicineDTO createMedicine(Medicines medicines) 
	{
		// TODO Auto-generated method stub
		Medicines medi=medicineRepository.save(medicines);
		return converter.convertToMedicineDTO(medi);
	}
	
	
	@Override
	public List<MedicineDTO> getAllMedicine() 
	{
		// TODO Auto-generated method stub
		List<Medicines> medicines=medicineRepository.findAll();
		List<MedicineDTO> dtos=new ArrayList<>();
		for(Medicines m:medicines)
		{
			dtos.add(converter.convertToMedicineDTO(m));
		}
		
		
		return dtos;
		
	}
	
	
	@Override
	public MedicineDTO getMedicineById(int id) 
	{
		Medicines m=medicineRepository.findById(id).get();
		return converter.convertToMedicineDTO(m);
		
	}
	
	
	@Override
	public String deleteMedicineById(int id)
	{
		// TODO Auto-generated method stub
		medicineRepository.deleteById(id);
		return "Medicine deleted";
	}
	
	@Override
	public MedicineDTO updateMedicine(int id, Medicines medicines) {
		// TODO Auto-generated method stub
		
		Medicines m1=medicineRepository.findById(id).get();
		m1.setName(medicines.getName());
		m1.setPrice(medicines.getPrice());
		m1.setQuantity(medicines.getQuantity());
		m1.setManufacturingdate(medicines.getManufacturingdate());
		m1.setExpirydate(medicines.getExpirydate());
		 
		Medicines medicin=medicineRepository.save(m1);
		return converter.convertToMedicineDTO(medicin);
	}

}
