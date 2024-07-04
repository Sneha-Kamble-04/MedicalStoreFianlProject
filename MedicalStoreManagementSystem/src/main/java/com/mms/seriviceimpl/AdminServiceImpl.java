package com.mms.seriviceimpl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mms.entities.Admin;
import com.mms.repository.AdminRepository;

import com.mms.service.AdminService;
import com.mms.model.AdminDTO;
import com.mms.utility.AdminConverter;



@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	AdminConverter adminconverter;
	
	@Override
	public AdminDTO createAdmin(Admin admin) 
	{
		Admin ad=adminRepository.save(admin);
		return adminconverter.convertToAdminDTO(ad);
		// TODO Auto-generated method stub
	}
	
	@Override
	public List<AdminDTO> getAdmin() 
	{
		List<Admin> admin=adminRepository.findAll();
		List<AdminDTO> dtos=new ArrayList<>();
		for(Admin a:admin)
		{
			dtos.add(adminconverter.convertToAdminDTO(a));
		}
		
		
		return dtos;
	}

	@Override
	public AdminDTO updateAdmin(int id, Admin admin) {
		// TODO Auto-generated method stub
		
		Admin a1=adminRepository.findById(id).get();
		a1.setName(admin.getName());
		a1.setPhNo(admin.getPhNo());
		a1.setEmail(admin.getEmail());
		a1.setPassword(admin.getPassword());
		 
		Admin ad=adminRepository.save(a1);
		return adminconverter.convertToAdminDTO(ad);
	}

}
