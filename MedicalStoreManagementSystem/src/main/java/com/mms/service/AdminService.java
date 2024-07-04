package com.mms.service;
import java.util.List;

import com.mms.entities.Admin;
import com.mms.model.AdminDTO;


public interface AdminService 
{
	AdminDTO createAdmin(Admin admin);
	
	List<AdminDTO> getAdmin();
	
	AdminDTO updateAdmin(int id,Admin admin);

}
